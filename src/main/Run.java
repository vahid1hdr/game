package main;

import business.GameBusiness;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        GameBusiness gameBusiness = new GameBusiness();
        gameBusiness.printUserGuide();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        while (!userInput.toLowerCase().equals("q")) {
            gameBusiness.runGame(userInput);
            userInput = scanner.nextLine();
        }
    }
}
