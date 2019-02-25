class Warrior extends Character {
    Warrior(){
       super("Warrior", 150, 5);
    }

    private int randomDamage() {
        return 10 + (int) (Math.random() * 30);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            alive = false;
        }
        return alive;
    }

    public void attack(Character character){
        System.out.println(getName() + " beats the enemy with an ax!");
        character.takeDamage(randomDamage());
    }
}
