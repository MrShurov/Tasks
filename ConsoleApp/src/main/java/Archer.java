public class Archer extends Character {
    Archer() {
        super("Archer", 80, 1);
    }

    private int randomDamage() {
        return 15 + (int) (Math.random() * 45);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            alive = false;
        }
        return alive;
    }

    public void attack(Character character) {
        System.out.println(getName() + " shoots at the enemy!");
        character.takeDamage(randomDamage());
    }
}
