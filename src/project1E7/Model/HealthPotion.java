package project1E7.Model;

public class HealthPotion extends Item {
    private Integer addHealth;

    public HealthPotion(String name) {
        super(name);
        addHealth = 60;
    }

    public Integer getAddHealth() {
        return addHealth;
    }
}
