package RPG.Items;

import RPG.Characters.Character;

public class Bomb implements Item{

    private final int damageToDeal;

    public Bomb(int damageToDeal) {
        this.damageToDeal = damageToDeal;
    }
    @Override
    public String getName() {
        return "Bomb";
    }

    @Override
    public String getDescription() {
        return " - Deals " + damageToDeal + " damage." ;
    }

    @Override
    public void use(Character target) {
        target.takeDamage(damageToDeal, 0);
        System.out.println("Kaboom! " + target.getName() + " took " + damageToDeal + " damage from a bomb!");
    }
}
