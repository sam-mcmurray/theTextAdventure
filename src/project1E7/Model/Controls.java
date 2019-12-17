package project1E7.Model;

public class Controls {

    public String moveUp;
    public String moveDown;
    public String moveRight;
    public String moveLeft;

    public Controls(String moveUp, String moveDown, String moveRight, String moveLeft) {

        this.moveUp = moveUp;
        this.moveDown = moveDown;
        this.moveRight = moveRight;
        this.moveLeft = moveLeft;
    }

    public String getMoveUp() {
        return moveUp;
    }

    public String getMoveDown() {
        return moveDown;
    }

    public String getMoveRight() {
        return moveRight;
    }

    public String getMoveLeft() {
        return moveLeft;
    }

    public void setMoveUp(String moveUp) {
        this.moveUp = moveUp;
    }

    public void setMoveDown(String moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveRight(String moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(String moveLeft) {
        this.moveLeft = moveLeft;
    }

}
