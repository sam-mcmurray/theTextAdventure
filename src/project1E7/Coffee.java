package project1E7;

public class Coffee extends Item {
    private Integer speed;

    public Coffee(String name) {
        super(name);
        speed = 3;
    }

    public Integer getSpeed() {
        return speed;
    }
}
