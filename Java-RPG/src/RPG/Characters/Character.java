package RPG.Characters;

public abstract class Character {

    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected int attack;
    protected int defense;

    public Character(String name, int maxHealth, int attack, int defense){
        this.name = name;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
    }

    public boolean isDead() {
        return this.currentHealth <= 0;
    }

    public void takeDamage(int attack, int basePower) {

        //Damage Formula : (Action Power + Char ATK - Target DEF) / 3
        int finalDamage = Math.max((basePower + attack - this.defense) / 3, 1);
        currentHealth -= finalDamage;

        if (currentHealth <= 0) currentHealth = 0;

        System.out.printf("%s took %d damage! %s's current HP: %d\n",
                this.name, finalDamage, this.name, this.currentHealth);
    }

    // RELEVANT GETTERS

    public String getName(){
        return this.name;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    // RELEVANT SETTERS


    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = Math.min(currentHealth, this.maxHealth); // Clamp between result and MAX HP
    }
}
