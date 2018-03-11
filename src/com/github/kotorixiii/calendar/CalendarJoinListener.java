package com.github.kotorixiii.calendar;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.github.kotorixiii.PersistentHistory.calendarFiles;

public class CalendarJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (calendarFiles.getSetting("auto-show")) {
            Player p = e.getPlayer();
            CalendarCommand.showCalendar(p);
        }
    }

}
