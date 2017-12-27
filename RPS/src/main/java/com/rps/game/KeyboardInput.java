package com.rps.game;

import java.util.*;

public class KeyboardInput {
    private static final List<String> possibleChoice = new ArrayList<>(Arrays.asList("1", "2", "3", "x", "n"));

    public static String playerChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        while (0 < 1) {
            System.out.println("Co wybierasz?");
            choice = scanner.nextLine();
            if (possibleChoice.contains(choice)) {
                if(choice.equals("n") || choice.equals("x")) {
                    if(confirmChoice(choice).equals("n")) {
                        System.out.println("Spróbuj jeszcze raz");
                        continue;
                    }
                }
                return choice;
            }
            System.out.println("Błędny wybór");
            Instruction.printInstruction();
        }
    }

    public static String computerChoice() {
        Random random = new Random();
        Integer computerChoice = random.nextInt(3) + 1;
        return computerChoice.toString();
    }

    public static String yesOrNo() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        while(0 < 1) {
            choice = scanner.nextLine();
            if(choice.equals("t") || choice.equals("n")) {
                return choice;
            }
            System.out.println("Błędny wybór. Spróbuj jeszcze raz. (t/n)");
        }
    }

    public static String confirmChoice(String choice) {
        if(choice.equals("n")) {
            System.out.println("Czy na pewno zakończyć aktualną grę? (t/n)");
            return KeyboardInput.yesOrNo();
        }
        else if(choice.equals("x")) {
            System.out.println("Czy na pewno zakończyć grę? (t/n)");
            return KeyboardInput.yesOrNo();
        }
        return "";
    }

    public static String playAgain() {
        System.out.println("KONIEC GRY\n" +
                "\nCzy chcesz zagrać jeszcze raz?(t/n)");
        if(yesOrNo().equals("t")) {
            return "n";
        }
        return "x";
    }
}