class Mage extends Character {
    Mage() {
        super("Mage", 70, 0);
    }

    private int randomDamage() {
        return 20 + (int) (Math.random() * 50);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            alive = false;
        }
        return alive;
    }

    public void attack(Character character) {
        System.out.println(getName() + " sends a fireball to the enemy!");
        character.takeDamage(randomDamage());
    }
}
