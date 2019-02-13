public abstract class Character implements Mortal {
    private String name;
    private int health;
    private int armour;

    Character(String name, int health, int armour) {
        this.name = name;
        this.health = health;
        this.armour = armour;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    private int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public abstract boolean isAlive();

    public abstract void attack(Character character);

    void takeDamage(int damage) {
        setHealth(getHealth() - (damage - getArmour()));
        if (isAlive()) {
            System.out.println(getName() + " получил " + damage + " урона!");
            System.out.println("Осталось " + getHealth() + " здоровья!");
        } else {
            System.out.println(getName() + " получил " + damage + " урона!");
            System.out.println(getName() + " мертв!");
        }
    }
}
