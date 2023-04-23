package red.civ.slimerider;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import red.civ.slimerider.listeners.OnSlimeClick;

public final class SlimeRider extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getServer().getPluginManager().registerEvents(new OnSlimeClick(),this);
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this,new RiderTask(),0L,20L);
        DataSaver.saveGenericData("TEST","YES");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
