public class Human extends Character {
    Human(String name) {
        super(name, 80, 1);
    }

    private int randomDamage() {
        return 21 + (int) (Math.random() * 65);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            alive = false;
        }
        return alive;
    }

    public void attack(Character character) {
        System.out.println(getName() + " beats the enemy!");
        character.takeDamage(randomDamage());
    }
}
