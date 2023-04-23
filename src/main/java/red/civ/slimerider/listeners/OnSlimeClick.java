package red.civ.slimerider.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import red.civ.slimerider.DataSaver;
import red.civ.slimerider.Logger;

public class OnSlimeClick implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Logger.Info("POSSIBLE Slime right click event");
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();

        String puid = player.getUniqueId().toString();
        String euid = entity.getUniqueId().toString();

        Logger.Info("PLAYER: " + puid   );
        Logger.Info("ENTITY: " + euid);

        if (entity.getType() == EntityType.SLIME) {
            Logger.Info("YES Slime right click event");

            DataSaver.saveGenericData(puid, euid);

            player.sendMessage("Exit your slime with /dismount");
        }
    }

}
