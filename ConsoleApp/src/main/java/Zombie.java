public class Zombie extends Character{
    private int counterResuraction = 0;

    Zombie(){
        super("Зомби", 100, -1);
    }

    public boolean isAlive() {
        boolean alive = true;
        if (getHealth() <= 0) {
            if(counterResuraction == 0){
                counterResuraction++;
                setHealth(50);
                System.out.println("Zombie воскрес!");
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
        System.out.println(getName() + " бьёт противника!");
        character.takeDamage(randomDamage());
    }
}
