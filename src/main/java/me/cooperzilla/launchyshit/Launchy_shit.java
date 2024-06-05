package me.cooperzilla.launchyshit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;

public final class Launchy_shit extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("win").setExecutor(new Win());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void launch_block(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.RED_GLAZED_TERRACOTTA) {
            Vector vec = player.getVelocity();
            vec.setY(vec.getY() + 0.25);
            player.setVelocity(vec);
        }
    }

    @EventHandler
    public void dash_block(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LIME_GLAZED_TERRACOTTA) {
            Vector vec = player.getLocation().getDirection();
            vec.multiply(new Vector(1.4, 1, 1.4));
            player.setVelocity(vec);
        }
    }

    @EventHandler
    public void wall_climb(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (checkClimbing(player) && player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isAir()) {
            Vector vec = player.getLocation().getDirection();
            vec.multiply(0.25);
            player.setVelocity(vec);
        }
    }
        public static boolean checkClimbing(Player player) {
            Set<Block> blocks = new HashSet<>(checkBlock(player, -25, 25, 0.8));
            for (Block block : blocks) {
                if (block.getType() == Material.BLUE_GLAZED_TERRACOTTA) {
                    return true;
                }
            }
            return false;
        }


        public static Set<Block> checkBlock(Player player, int min, int max, Double distance) {
            Set<Block> blocks = new HashSet<>();
            double radius = distance;
            Location origin = player.getLocation();
            for (int i = min; i < max; i += 5) {
                double angle = Math.toRadians(player.getLocation().getYaw() + 90 + i);
                double x = origin.getX() + (radius * Math.cos(angle));
                double z = origin.getZ() + (radius * Math.sin(angle));
                blocks.add(new Location(player.getWorld(), x, origin.getY(), z).getBlock());

            }
            return blocks;
        }
}
