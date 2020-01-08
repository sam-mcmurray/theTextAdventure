package project1E7.Model;

public class Heart extends Item {
    private int extraLife;

    public Heart(String name) {
        super(name);
        extraLife = 1;
    }

    public int getExtraLife() {
        return extraLife;
    }

    public void setExtraLife(int extraLife) {
        this.extraLife = extraLife;
    }
}
