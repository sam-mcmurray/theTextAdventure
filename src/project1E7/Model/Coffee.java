package project1E7.Model;

public class Coffee extends Item {
    private int speed;

    public Coffee(String name) {
        super(name);
        speed = 5;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed= speed;
    }
}
