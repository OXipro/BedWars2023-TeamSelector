package com.tomkeuper.bedwars.teamselector.PlaceholderAPI;


import com.tomkeuper.bedwars.api.BedWars;
import com.tomkeuper.bedwars.api.arena.IArena;
import com.tomkeuper.bedwars.api.arena.team.ITeam;
import com.tomkeuper.bedwars.teamselector.Main;
import com.tomkeuper.bedwars.teamselector.api.TeamSelector;
import com.tomkeuper.bedwars.teamselector.teamselector.TeamManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;


public class PlaceholderAPI extends PlaceholderExpansion{

    public void hook() {
        this.register();
    }

    @Override
    public @NotNull String getIdentifier() {
        return "bwteamselector";
    }

    @Override
    public @NotNull String getAuthor() {
        return Main.plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return Main.plugin.getDescription().getVersion();
    }

    public String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.equalsIgnoreCase("teamcolorcode")) {
            IArena arena = Main.bw.getArenaUtil().getArenaByPlayer(player.getPlayer());
            ITeam team = TeamManager.getInstance().getPlayerTeam(player.getPlayer(),arena);
            if (team != null) {
                return String.valueOf(team.getColor().chat());
            } else {
                return "&r";
            }
        }
        if (params.equalsIgnoreCase("teamflag")) {
            IArena arena = Main.bw.getArenaUtil().getArenaByPlayer(player.getPlayer());
            ITeam team = TeamManager.getInstance().getPlayerTeam(player.getPlayer(),arena);

            if (team != null) {
                return String.valueOf(team.getColor().chat() + "&l" + "⚑ ");
            } else {
                return "&r";
            }
        }

        return null; //
    }
}
