package com.teozcommunity.teozfrank.ranklist.threads;

import com.teozcommunity.teozfrank.ranklist.main.RankList;
import com.teozcommunity.teozfrank.ranklist.util.UpdateChecker;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by frank on 24/07/2014.
 */
public class UpdateCheckThread extends BukkitRunnable {

    private RankList plugin;

    public UpdateCheckThread(RankList plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        new UpdateChecker(plugin, 48781);
    }
}
