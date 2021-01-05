package com.flora.message;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin implements Listener
{
    String keyPlayer = "`PLAYER`";
    String keyReason = "`REASON`";

    boolean isPrintJoinMessage = true;
    boolean isPrintLeftMessage = true;
    boolean isPrintKickMessage = true;

    String messageFirstJoin = "§d`PLAYER` join the game for the first time";
    String messageJoin = "§e`PLAYER` joined the game";
    String messageLeft = "§e`PLAYER` left the game";
    String messageKick = "§f`PLAYER` kicked the game \n&c reason: `REASON`";

    String motdA = "§7A Minecraft Server";
    String motdB = "";



    @Override
    public void onEnable() {
        saveDefaultConfig();
        onConfigDataLoad();

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    private void onConfigDataLoad() {
        isPrintJoinMessage = getConfig().getBoolean("setting.print-JoinMessage");
        isPrintLeftMessage = getConfig().getBoolean("setting.print-LeftMessage");
        isPrintLeftMessage = getConfig().getBoolean("setting.print-KickMessage");

        messageFirstJoin = getColorString(Objects.requireNonNull(getConfig().getString("messages.first-join")));
        messageJoin = getColorString(Objects.requireNonNull(getConfig().getString("messages.join")));
        messageLeft = getColorString(Objects.requireNonNull(getConfig().getString("messages.left")));
        messageKick = getColorString(Objects.requireNonNull(getConfig().getString("messages.kick")));

        motdA = getColorString(Objects.requireNonNull(getConfig().getString("motd.line1")));
        motdB = getColorString(Objects.requireNonNull(getConfig().getString("motd.line2")));
    }

    @EventHandler
    private void onPlayerJoinEvent(PlayerJoinEvent event) {
        if (isPrintJoinMessage) {
            if (event.getPlayer().hasPlayedBefore())
                event.setJoinMessage(getPlayerString(messageJoin, event.getPlayer()));
            else
                event.setJoinMessage(getPlayerString(messageFirstJoin, event.getPlayer()));
        }
        else
            event.setJoinMessage("");
    }

    @EventHandler
    private void onPlayerLeftEvent(PlayerQuitEvent event) {
        if (isPrintLeftMessage)
            event.setQuitMessage(getPlayerString(messageLeft, event.getPlayer()));
        else
            event.setQuitMessage("");
    }

    @EventHandler
    private void onPlayerKickEvent(PlayerKickEvent event) {
        if (isPrintKickMessage)
            event.setLeaveMessage(getKickPlayerString(messageKick, event.getPlayer(), event.getReason()));
    }

    @EventHandler
    private void onServerMotdEvent(ServerListPingEvent event) {
        event.setMotd(motdA + "\n" + motdB);
    }

    private String getColorString(String message) {
        return message.replaceAll("&", "§");
    }

    private String getPlayerString(String message, Player player) {
        return message.replaceAll(keyPlayer, player.getDisplayName());
    }

    private String getKickPlayerString(String message, Player player, String reason) {
        return getPlayerString(message, player).replaceAll(keyReason, reason);
    }
}
