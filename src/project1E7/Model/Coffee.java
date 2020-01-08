package project1E7.Model;

public class Coffee extends Item {
    private Integer speed;

    public Coffee(String name) {
        super(name);
        speed = 5;
    }

    public Integer getSpeed() {
        return speed;
    }
}
