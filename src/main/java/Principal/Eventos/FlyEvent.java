package Principal.Eventos;

import static Principal.Comandos.fly.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FlyEvent implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("fly.use")) {
            fly.add(p);
            p.setAllowFlight(true);
        }
    }

}
