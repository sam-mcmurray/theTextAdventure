package project1E7.Model;

public class Weapon extends Item {
    private Integer strength;

    public Weapon(String name) {
        super(name);
        strength = 2;
    }

    public Integer getStrength() {
        return strength;
    }
}

