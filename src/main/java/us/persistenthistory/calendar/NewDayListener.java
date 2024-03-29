package us.persistenthistory.calendar;

import com.xxmicloxx.NoteBlockAPI.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static us.persistenthistory.PersistentHistory.calendarFiles;
import static us.persistenthistory.calendar.CalendarFiles.newDayAlert;

public class NewDayListener implements Listener {

    @EventHandler
    public void onNewDay(NewDayEvent e) {

        if (calendarFiles.getSetting("new-day-alert") == true) {

            for (Player players : Bukkit.getOnlinePlayers()) {

                if(!NoteBlockPlayerMain.isReceivingSong(players))
                playNewDayAlert(players);
            }
        }

    }



    public void playNewDayAlert(Player p) {

        Song s = NBSDecoder.parse(newDayAlert);

        SongPlayer sp = new RadioSongPlayer(s);

        sp.addPlayer(p);
        sp.setPlaying(true);
        sp.setAutoDestroy(true);


    }

}
