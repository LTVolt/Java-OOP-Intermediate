package RPG.Characters;

import RPG.Items.Item;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player extends Character{

    private final Scanner scanner = new Scanner(System.in);
    private final List<Item> inventory = new ArrayList<>();

    public int actionChoice = 0;

    public Player(String name, int maxHealth, int attack, int defense) {
        super(name, maxHealth, attack, defense);
    }

    public void attackEnemy(Character enemy){
        System.out.println(name + " Attacks!");
        enemy.takeDamage(attack, 40);
    }

    /*
    Deprecated method, staying around to show how update was made.

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
     */

    //INVENTORY START

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void useItem(Character target) {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty! You took too long and passed your turn!");
        }

        System.out.println("********* INVENTORY *********");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getName() + inventory.get(i).getDescription());
        }

        System.out.print("What item would you like to use? (Choose with numbers): ");
        int itemChoice = scanner.nextInt();
        scanner.nextLine();

        if (itemChoice >= 1 && itemChoice <= inventory.size()) {

            Item item = inventory.get(itemChoice - 1);
            item.use(target);

            inventory.remove(item);

        } else {
            System.out.println("Invalid selection... No action done!");
        }
    }

    //INVENTORY END

    public int chooseAction() {

        try {
            System.out.println("1. Attack");
            System.out.println("2. Use Item (Self)");
            System.out.println("3. Use Item (Enemy)");
            System.out.print("Choose your action: ");
            actionChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERROR");
            throw new RuntimeException();
        }
        return actionChoice;
        }
}
