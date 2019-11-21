package project1E7;

public class Hero extends Character{
    private int endurance;
    private Key [] keyRing;
    private Item [] backPack;


    public Hero(int health, int strength, int speed, String description, String name, int endurance) {
        super(health, strength, speed, description, name);
        this.endurance = endurance;
    }

    public Key[] getKeyRing() {
        return keyRing;
    }

    public void setKeyRing(Key[] keyRing) {
        this.keyRing = keyRing;
    }

    public Item[] getBackPack() {
        return backPack;
    }

    public void setBackPack(Item[] backPack) {
        this.backPack = backPack;
    }

    public int getEndurance() {
        return endurance;
    }

}
