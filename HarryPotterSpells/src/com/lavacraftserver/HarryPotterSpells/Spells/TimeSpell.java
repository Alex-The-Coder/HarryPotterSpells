package com.lavacraftserver.HarryPotterSpells.Spells;

import org.bukkit.entity.Player;

import com.lavacraftserver.HarryPotterSpells.PM;

public class TimeSpell {

	public static void cast(Player p) {
		int time = PM.hps.getConfig().getInt("time-to-set");
		p.getWorld().setTime(time);
	}
}
