package project1E7;

public class Door {
    private boolean unlocked;
    private String nameOfKey;
    private String description;

    public Door(boolean unlocked, String nameOfKey, String description) {
        this.unlocked = unlocked;
        this.nameOfKey = nameOfKey;
        this.description = description;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public String getNameOfKey() {
        return nameOfKey;
    }

    public String getDescription() {
        return description;
    }
}
