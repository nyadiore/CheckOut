import java.util.Scanner;

public class SafeInput {

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0.0;
        boolean validInput = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                if (retDouble >= low && retDouble <= high) {
                    validInput = true;
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a number.");
                pipe.next(); // clear invalid input
            }
        } while (!validInput);
        pipe.nextLine(); // clear the newline character
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " (Y/N): ");
            response = pipe.nextLine().trim().toLowerCase();
        } while (!response.equals("y") && !response.equals("n"));
        return response.equals("y");
    }
}
