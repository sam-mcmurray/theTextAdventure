package project1E7.Model;

public class Door {
    private boolean lock;
    private String nameOfKey;
    private String description;

    public Door(boolean lock, String nameOfKey, String description) {
        this.lock = lock;
        this.nameOfKey = nameOfKey;
        this.description = description;
    }

    public boolean isUnlocked() {
        return lock;
    }

    public String getNameOfKey() {
        return nameOfKey;
    }

    public String getDescription() {
        return description;
    }
}
