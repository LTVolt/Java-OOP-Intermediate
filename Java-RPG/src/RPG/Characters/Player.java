package RPG.Characters;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Character{

    Scanner scanner = new Scanner(System.in);

    public int choice = 0;
    private int potions = 3;

    public Player(String name, int maxHealth, int attack, int defense) {
        super(name, maxHealth, attack, defense);
    }

    public void attackEnemy(Character enemy){
        System.out.println(name + " Attacks!");
        enemy.takeDamage(attack, 40);
    }

    public void heal() {
        if (potions > 0) {
            currentHealth += 30;
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth;
            }
            potions--;
            System.out.printf("%s used a potion! Potions left: %d\n", name, potions);
            System.out.printf("HP: %d / %d\n", currentHealth, maxHealth);
        } else {
            System.out.println("Not enough potions!");
        }
    }

    public int chooseAction() {

        try {
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.print("Choose your action: ");
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR");
            throw new RuntimeException();
        }
        return choice;
        }
}
