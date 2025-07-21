package RPG.Battle;

import RPG.Characters.Enemy;
import RPG.Characters.Player;
import RPG.Items.Bomb;
import RPG.Items.Potion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BattleEngine {

    static Random randomizer = new Random();
    static Player player = getPlayer();

    public void battle() {
        String filePath = "Enemies.txt";
        ArrayList<String> enemyList = new ArrayList<>();
        getEnemyList(filePath, enemyList);

        Enemy enemy = getEnemy(enemyList);

        setInventory();

        System.out.println("Battle begins between " + player.getName()
        + " and " + enemy.getName() + "!");

        showStats(player, enemy);

        while (!player.isDead() && !enemy.isDead()) {
            int action = player.chooseAction();

            switch (action) {
                case 1 -> player.attackEnemy(enemy);
                case 2 -> player.useItem(player);
                case 3 -> player.useItem(enemy);
                default -> System.out.println("Invalid Action!\n Enemy's Turn!");
            }

            if (!enemy.isDead()) {
                enemy.enemyTurn(player);
                showStats(player,enemy);
            }
        }

        System.out.println();
        System.out.println("******* BATTLE END *******");
        showStats(player, enemy);

        if (player.isDead()) {
            System.out.println("YOU LOSE...");
        } else System.out.println("YOU WIN!!");

        while (player.actionChoice < 1 || player.actionChoice > 2) {
            player.actionChoice = player.chooseAction();
        }
    }

    private static void showStats(Player player, Enemy enemy) {
        System.out.println(player.getName() +
                " HP: " + player.getCurrentHealth() + " / " +
                player.getMaxHealth() + " \nATK: " + player.getAttack()
                + " | DEF: " + player.getDefense());
        System.out.println(enemy.getName() +
                " HP: " + enemy.getCurrentHealth() + " / " +
                enemy.getMaxHealth());
    }

    private static void getEnemyList(String filePath, ArrayList<String> enemyList) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                enemyList.add(line.trim());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Enemy List file not found!");
        } catch (IOException e) {
            System.out.println("UNKNOWN ERROR: Please try again.");
        }
    }

    private static Enemy getEnemy(ArrayList<String> enemyList) {
        return new Enemy(
                enemyList.get(randomizer.nextInt(enemyList.size())),
                randomizer.nextInt(40,60),
                randomizer.nextInt(8,12),
                randomizer.nextInt(4,8));
    }

    private static Player getPlayer() {
        return new Player("Max",
                randomizer.nextInt(80, 121),
                randomizer.nextInt(16, 22),
                randomizer.nextInt(6, 11));
    }

    private static void setInventory() {
        player.addItem(new Potion(randomizer.nextInt(15,41)));
        player.addItem(new Potion(randomizer.nextInt(10,31)));
        player.addItem(new Bomb(randomizer.nextInt(10,31)));

        System.out.println("Inventory Loaded!");
    }
}
