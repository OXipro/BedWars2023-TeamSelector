package com.tomkeuper.bedwars.teamselector.api;

import com.tomkeuper.bedwars.api.arena.IArena;
import org.bukkit.entity.Player;

import com.tomkeuper.bedwars.api.arena.team.ITeam;

@SuppressWarnings("unused")
public interface TeamSelectorAPI {

    /**
     * Get player's selected team
     */
    ITeam getSelectedTeam(Player player);

    /**
     * Get player's selected team
     */
    void setTeam(Player player, IArena arena, ITeam iteam);

    /**
     * Get api version
     */
    int getApiVersion();
}
