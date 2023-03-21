package Shop;

import java.util.HashMap;
import java.util.Scanner;


public class User {
    private static String userPassword;
    private static String userEmail;
    private static HashMap<String, String> userEmPas = new HashMap<>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static boolean autorization() {
        System.out.println(ANSI_YELLOW + "|Authorization|" + ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Email address:");
        userEmail = scan.nextLine();

        System.out.println("Please enter password:");
        userPassword = scan.nextLine();
        System.out.println("--------------------");
        System.out.println();

        userEmPas.put("1234", "1234");
        if (cheking()) {
            System.out.println(ANSI_GREEN + "You have successfully logged in\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Invalid email or password\n" + ANSI_RESET);
            return false;
        }
        return true;
    }

    public static boolean notAutorization() {

        System.out.println("1.Registration " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "|Authorization|" + ANSI_RESET);

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Email address or register:");
        userEmail = scan.nextLine();
        if (userEmail.equals("1")) {
            registration();
        } else {
            System.out.println("Please enter password:");
            userPassword = scan.nextLine();
            System.out.println("--------------------");
            System.out.println();

            userEmPas.put("1234", "1234");
            if (cheking()) {
                System.out.println(ANSI_GREEN + "You have successfully logged in\n" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Invalid email or password\n" + ANSI_RESET);
                return false;
            }

        }
        return true;
    }

    public static boolean registration() {
        userEmPas.put("1234", "1234");
        System.out.println(ANSI_YELLOW + "|Registration|" + ANSI_RESET);

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter Email address: ");
        userEmail = scan.nextLine();

        System.out.println("Please enter password: ");
        userPassword = scan.nextLine();
        System.out.println("--------------------");
        System.out.println();

        if (!userEmPas.containsKey(userEmail)) {
            userEmPas.put(userEmail, userPassword);
            System.out.println(ANSI_GREEN + "You have successfully registered\n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Such a user already exists\n" + ANSI_RESET);
            registration();
            return false;
        }
        return true;
    }

    public static boolean cheking() {
        if (userEmPas.containsKey(userEmail) && userEmPas.containsValue(userPassword)) {
            return true;
        } else {
            return false;
        }
    }
}


