public class Zombie extends Character{
    private int counterResurrection = 0;

    Zombie(){
        super("Zombie", 100, -1);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            if(counterResurrection == 0){
                counterResurrection++;
                setHealth(50);
                System.out.println("Zombie resurrected!");
                return alive;
            }
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
