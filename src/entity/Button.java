package entity;

public class Button {
    private boolean isPressed;

    public Button() {
    }

    public Button(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}
