package red.civ.slimerider;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RiderTask implements Runnable{

    @Override
    public void run(){

        for (Player player : Bukkit.getOnlinePlayers()) {


            String s_puid = player.getUniqueId().toString();
            //Logger.Info(s_puid);
            String s_euid = DataSaver.getDatapointFromIdentifier(s_puid);
            if(s_euid.equals("NULL")){
                //Logger.Info("SEUID is null ");
                return;
            }
            //Logger.Info(s_euid);

            //Logger.Info("SEUID Not null " + s_euid);
            UUID euid = UUID.fromString(s_euid);
            Logger.Info("EUID Not null");

            if(DataSaver.getDatapointFromIdentifier(player.getUniqueId().toString()).equals("NULL")){
                return;
            }

            Logger.Info("Datapoint not null");

            if(Bukkit.getServer().getEntity(euid) != null){
                DataSaver.saveGenericData(String.valueOf(player.getUniqueId()),null);
                return;
            }
            Entity slime = Bukkit.getServer().getEntity(euid);
            player.teleport(slime.getLocation());
            player.sendMessage("You have been teleported to the slime!");

        }
        return;
    }



}
