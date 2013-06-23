package com.lavacraftserver.HarryPotterSpells.API;

import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;

import com.lavacraftserver.HarryPotterSpells.HPS;
import com.lavacraftserver.HarryPotterSpells.Spells.Spell;
import com.lavacraftserver.HarryPotterSpells.Utils.MiscUtilities;

/**
 * Represents the recipe for a spell book.<br>
 * This is a basic version of {@link ShapedRecipe} with less features.
 */
public class SpellBookRecipe implements Recipe {
    public static final String[] RANDOM_AUTHORS = new String[]{"Merwyn the Malicious", "Delfina Crimp", "Felix Summerbee", "Jarleth Hobart", "Mnemone Radford", "Urquhart Rackharrow", "Orabella Nuttley", "Levina Monkstanley", "Elliot Smethwyck", "Basil Horton", "Randolph Keitch", "Miranda Goshawk", "Tom Riddle", "Severus Snape", "Fred Weasley", "George Weasley", "Unknown"};

    private ShapedRecipe recipe;
    private HPS HPS;

    /**
     * Constructs a new {@link SpellBookRecipe}
     * @param spell the {@link Spell} that this recipe will create a book for
     * @param if {@code true} the recipe will be shapeless
     */
    public SpellBookRecipe(HPS instance, Spell spell) {
        this.HPS = instance;

        ItemStack stack = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) Bukkit.getItemFactory().getItemMeta(Material.WRITTEN_BOOK);
        meta.setTitle(spell.getName());
        meta.addPage(spell.getDescription());
        meta.setAuthor(getRandomAuthor());
        stack.setItemMeta(meta);

        try {
            stack = MiscUtilities.makeGlow(stack);
        } catch (Exception e) {
            HPS.PM.log(Level.WARNING, HPS.Localisation.getTranslation("errEnchantmentEffect"));
            HPS.PM.debug(e);
        }

        recipe = new ShapedRecipe(stack);
    }

    /**
     * {@inheritDoc ShapedRecipe#shape(String...)}
     */
    public void shape(String... rows) {
        recipe.shape(rows);
    }

    /**
     * {@inheritDoc ShapedRecipe#setIngredient(char, Material)}
     */
    public void setIngredient(char key, Material ingredient) {
        recipe.setIngredient(key, ingredient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ItemStack getResult() {
        return recipe.getResult();
    }

    /**
     * Gets a random spell author from {@link SpellBookRecipe#RANDOM_AUTHORS}
     * @return a random spell author
     */
    public static String getRandomAuthor() {
        return RANDOM_AUTHORS[new Random().nextInt(RANDOM_AUTHORS.length)];
    }

}
