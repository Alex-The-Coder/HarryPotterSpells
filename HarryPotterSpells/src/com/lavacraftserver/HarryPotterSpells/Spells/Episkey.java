package com.lavacraftserver.HarryPotterSpells.Spells;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.lavacraftserver.HarryPotterSpells.PM;
import com.lavacraftserver.HarryPotterSpells.Utils.Targeter;

public class Episkey {
	public static void cast(Player p) {
		if(Targeter.getTarget(p, 50) instanceof LivingEntity) {
			LivingEntity livingentity = Targeter.getTarget(p, 50);
			livingentity.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 1));;
			if (PM.hps.getConfig().getBoolean("shout-on-spell-use") == true) {
				p.chat("Episkey!");
			}
			if (PM.hps.getConfig().getBoolean("notify-on-spell-use") == true) {
				p.sendMessage(ChatColor.AQUA + "You have cast Episkey!");
			}
		} else {
			PM.warn(p, "You can only cast this on a player or mob!");
		}
	}
}
