package com.flora.message;

import org.bukkit.Bukkit;
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
    boolean isPrintJoinMessage = true;
    boolean isPrintLeftMessage = true;
    boolean isPrintKickMessage = true;

    String messageFirstJoin = "";
    String messageJoin = "";
    String messageLeft = "";
    String messageKick = "";

    String motdA = "";
    String motdB = "";


    @Override
    public void onEnable() {
        saveDefaultConfig();
        onConfigDataLoad();

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    private void onConfigDataLoad()
    {
        isPrintJoinMessage = getConfig().getBoolean("setting.print-JoinMessage");
        isPrintLeftMessage = getConfig().getBoolean("setting.print-LeftMessage");
        isPrintLeftMessage = getConfig().getBoolean("setting.print-KickMessage");

        messageFirstJoin = Objects.requireNonNull(getConfig().getString("messages.first-join")).replaceAll("&", "§");
        messageJoin = Objects.requireNonNull(getConfig().getString("messages.join")).replaceAll("&", "§");
        messageLeft = Objects.requireNonNull(getConfig().getString("messages.left")).replaceAll("&", "§");
        messageKick = Objects.requireNonNull(getConfig().getString("messages.kick")).replaceAll("&", "§");

        motdA = Objects.requireNonNull(getConfig().getString("motd.line1")).replaceAll("&", "§");
        motdB = Objects.requireNonNull(getConfig().getString("motd.line2")).replaceAll("&", "§");
    }

    @EventHandler
    private void onPlayerJoinEvent(PlayerJoinEvent event)
    {
        if (isPrintJoinMessage) {
            if (event.getPlayer().hasPlayedBefore())
                event.setJoinMessage(messageJoin
                        .replaceAll("%player%", event.getPlayer().getDisplayName()));
            else
                event.setJoinMessage(messageFirstJoin
                        .replaceAll("%player%", event.getPlayer().getDisplayName()));
        }
        else
            event.setJoinMessage("");
    }

    @EventHandler
    private void onPlayerLeftEvent(PlayerQuitEvent event)
    {
        if (isPrintLeftMessage)
            event.setQuitMessage(messageLeft
                    .replaceAll("%player%", event.getPlayer().getDisplayName()));
        else
            event.setQuitMessage("");
    }

    @EventHandler
    private void onPlayerKickEvent(PlayerKickEvent event)
    {
        if (isPrintKickMessage)
            event.setLeaveMessage(messageKick
                    .replaceAll("%player%", event.getPlayer().getDisplayName()
                    .replaceAll("%reason%", event.getReason())));
    }

    @EventHandler
    private void onServerMotdEvent(ServerListPingEvent event)
    {
        event.setMotd(motdA + "\n" + motdB);
    }
}
