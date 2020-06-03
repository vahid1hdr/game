package entity;

public class Lamp {
    private boolean isOn;
    private Button button;

    public Lamp() {

    }

    public Lamp(Button button) {
        this.button = button;
    }

    public Lamp(boolean isOn, Button button) {
        this.isOn = isOn;
        this.button = button;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
