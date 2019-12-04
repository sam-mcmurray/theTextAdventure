package project1E7.Model;

public class Treasure extends Item {
    private int amount;

    public Treasure(String name,int amount) {
        super(name);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
