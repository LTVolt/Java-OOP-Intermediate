package RPG.Items;

import RPG.Characters.Character;

public class Potion implements Item{

    private final int amountToHeal;

    public Potion(int amountToHeal) {
        this.amountToHeal = amountToHeal;
    }

    @Override
    public String getName() {
        return "Potion";
    }

    @Override
    public String getDescription() {
        return " - Heals " + amountToHeal + " HP.";
    }

    @Override
    public void use(Character target) {
        int healedAmount = Math.min(amountToHeal, target.getMaxHealth() - target.getCurrentHealth());

        target.setCurrentHealth(target.getCurrentHealth() + healedAmount);
        System.out.println(target.getName() + " restored " + healedAmount + " HP via a Potion!");
    }
}
