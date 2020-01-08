package project1E7.Model;

public class HealthPotion extends Item {
    private int addHealth;

    public HealthPotion(String name) {
        super(name);
        addHealth = 60;
    }

    public int getAddHealth() {
        return addHealth;
    }

    public void setAddHealth(int addHealth) {this.addHealth = addHealth;}
}
