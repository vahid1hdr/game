package business;

import entity.Button;
import entity.Lamp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameBusiness {
    private List<Lamp> lamps;

    public GameBusiness() {
    }

    public GameBusiness(List<Lamp> lamps) {
        this.lamps = lamps;
    }

    public List<Lamp> getLamps() {
        return lamps;
    }

    public void setLamps(List<Lamp> lamps) {
        this.lamps = lamps;
    }

    public boolean pressButtonByIndex(int buttonIndex) {
        lamps.get(buttonIndex).getButton().setPressed(true);
        for (int i = 0; i < buttonIndex; i++) {
            if (!lamps.get(i).isOn()) {
                return false;
            }
        }
        if (!lamps.get(buttonIndex).isOn()) {
            lamps.get(buttonIndex).setOn(true);
            for (int i = buttonIndex + 1; i < lamps.size(); i++) {
                if (!lamps.get(i).getButton().isPressed()) {
                    return true;
                }
                lamps.get(i).setOn(true);
            }
            return true;
        }
        return false;
    }

    public int countLightNumbers(String userInput) {
        String[] numbers = userInput.split(",");
        int result = 0;
        for (String lampNumber : numbers) {
            if (pressButtonByIndex(Integer.valueOf(lampNumber) - 1)) {
                result++;
            }
        }
        return result;
    }

    public void setCountOfLamps(int countOfLamps) {
        for (int i = 0; i < countOfLamps; i++) {
            Button button = new Button();
            this.lamps.add(new Lamp(button));
        }
    }

    public void printUserGuide() {
        System.out.println("-----------User guide-----------");
        System.out.println("You should enter a text contained of seven numbers splited by \",\" like: 2,1,5,4,3,7,6");
        System.out.println("to quit game type: \"q\"");
        System.out.println("to see this message again type: \"help\"");
        System.out.println("Now start game...");
    }

    public void printError() {
        System.out.println("you have entered invalid input!\nfor help type: \"help\"");
    }

    public int runGame(String userInput) {
        Pattern p = Pattern.compile("[1-7],[1-7],[1-7],[1-7],[1-7],[1-7],[1-7]");
        if (userInput.toLowerCase().equals("help")) {
            printUserGuide();
            return 0;
        } else if (p.matcher(userInput.toLowerCase()).matches()) {
            List<Lamp> lamps = new ArrayList<>();
            this.setLamps(lamps);
            this.setCountOfLamps(7);
            return countLightNumbers(userInput);
        } else {
            printError();
            return 0;
        }
    }
}
