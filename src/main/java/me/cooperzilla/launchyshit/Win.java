package me.cooperzilla.launchyshit;

import com.destroystokyo.paper.Title;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Win implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
            List<String> players = new ArrayList<String>();

            Color c1 = null;
            Color c2 = null;
            Color c3 = null;
            ChatColor c4 = null;

            switch (args[0]) {
                case "netherite" -> {
                    players.add("Winds_of_Plague");
                    players.add("Cyvanox");
                    players.add("Dexbot2");
                    c1 = Color.fromRGB(22, 20, 26);
                    c2 = Color.fromRGB(15, 15, 15);
                    c3 = Color.fromRGB(31, 28, 29);
                    c4 = ChatColor.BLACK;
                }
                case "diamond" -> {
                    players.add("GeneralPaxton10");
                    players.add("MineLefa");
                    players.add("Olivershine2327");
                    c1 = Color.fromRGB(0, 251, 255);
                    c2 = Color.fromRGB(106, 245, 247);
                    c3 = Color.fromRGB(3, 112, 94);
                    c4 = ChatColor.AQUA;
                }
                case "gold" -> {
                    players.add("Cooperzilla");
                    players.add("vczq");
                    players.add("Pancake_83");
                    c1 = Color.fromRGB(255, 242, 0);
                    c2 = Color.fromRGB(252, 215, 50);
                    c3 = Color.fromRGB(184, 141, 13);
                    c4 = ChatColor.YELLOW;
                }
                case "redstone" -> {
                    players.add("Zxynn");
                    players.add("Tri3angle");
                    players.add("Lehfries");
                    c1 = Color.fromRGB(217, 33, 20);
                    c2 = Color.fromRGB(250, 59, 45);
                    c3 = Color.fromRGB(99, 10, 4);
                    c4 = ChatColor.RED;
                }
                case "lapis" -> {
                    players.add("Bumpino");
                    players.add("Jeff_is_I");
                    players.add("phisc");
                    c1 = Color.fromRGB(4, 29, 219);
                    c2 = Color.fromRGB(38, 60, 235);
                    c3 = Color.fromRGB(4, 15, 99);
                    c4 = ChatColor.DARK_BLUE;
                }
                case "amethyst" -> {
                    players.add("MintySync");
                    players.add("__pirate__");
                    players.add("cronixy");
                    c1 = Color.fromRGB(104, 13, 209);
                    c2 = Color.fromRGB(139, 64, 245);
                    c3 = Color.fromRGB(45, 3, 130);
                    c4 = ChatColor.DARK_PURPLE;
                }
                case "emerald" -> {
                    players.add("MIKAEL0808");
                    players.add("Nico_El_Gato_");
                    players.add("NotJoqco");
                    c1 = Color.fromRGB(0, 255, 51);
                    c2 = Color.fromRGB(80, 242, 112);
                    c3 = Color.fromRGB(3, 112, 49);
                    c4 = ChatColor.GREEN;
                }
                case "quartz" -> {
                    players.add("Minidrew0408xD");
                    players.add("KingKors11");
                    players.add("JZalaOz");
                    c1 = Color.fromRGB(255, 255, 255);
                    c2 = Color.fromRGB(110, 93, 93);
                    c3 = Color.fromRGB(184, 158, 158);
                    c4 = ChatColor.WHITE;
                }
                case "iron" -> {
                    players.add("Tuvil");
                    players.add("Nexilius");
                    players.add("Hi237271");
                    c1 = Color.fromRGB(255, 255, 255);
                    c2 = Color.fromRGB(54, 54, 54);
                    c3 = Color.fromRGB(199, 199, 199);
                    c4 = ChatColor.WHITE;
                }
                case "copper" -> {
                    players.add("ThatGuyBest");
                    players.add("VisionVODS");
                    players.add("thexXAntonXx");
                    c1 = Color.fromRGB(255, 159, 5);
                    c2 = Color.fromRGB(171, 99, 10);
                    c3 = Color.fromRGB(242, 158, 53);
                    c4 = ChatColor.GOLD;
                }
            }



            Random rand = new Random();

            if (sender instanceof Player player) {
                for (Player i : player.getWorld().getPlayers()) {
                    i.sendTitle(new Title(c4 + "Team " + args[0] + " Wins"));

                    for (String ss : players) {
                        if (i.getName().equals(ss)) {
                            for (int p = 0; p < 20; p++) {
                                Firework fw = (Firework) i.getWorld().spawnEntity(i.getLocation().add(0, 1 + rand.nextInt(6), 0), EntityType.FIREWORK);

                                FireworkMeta fwm = fw.getFireworkMeta();

                                fwm.setPower(2);
                                fwm.addEffect(FireworkEffect.builder().withColor(
                                    switch (rand.nextInt(3)) {
                                        case 1 -> {
                                            assert c2 != null;
                                            yield c2;
                                        }
                                        case 2 -> {
                                            assert c3 != null;
                                            yield c3;
                                        }
                                        default -> {
                                            assert c1 != null;
                                            yield c1;
                                        }
                                    }
                                ).flicker(true).build());

                                fw.setFireworkMeta(fwm);
                                fw.detonate();
                            }
                        }
                    }
                }
            }


        return true;
    }
}
