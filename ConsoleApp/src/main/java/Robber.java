class Robber extends Character{
    Robber(){
        super("Robber", 100,4);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            alive = false;
        }
        return alive;
    }

    private int randomDamage() {
        return 10 + (int) (Math.random() * 30);
    }

    public void attack(Character character) {
        System.out.println(getName() + " beats the enemy!");
        character.takeDamage(randomDamage());
    }
}
