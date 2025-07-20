package RPG.Characters;

import java.util.Random;

public class Enemy extends Character{

    Random randomizer = new Random();

    public Enemy(String name, int maxHealth, int attack, int defense) {
        super(name, maxHealth, attack, defense);
    }

    public void enemyTurn(Character player) {

        int enemyChoice = randomizer.nextInt(EnemyAI.values().length);

        switch (enemyChoice) {
            case 0 -> {
                System.out.println(name + " attacks!");
                player.takeDamage(attack, 40);
            }
            case 1 -> {
                System.out.println(name + " performs Double Slash!");
                player.takeDamage(attack, 100);
            }
            case 2 -> System.out.println(name + " is hesitating...");
        }
    }

}
