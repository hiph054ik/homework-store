
import Shop.Buy;
import Shop.Catalog;
import Shop.User;


import java.util.*;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) {

        System.out.println(ANSI_CYAN + "Welcome to our online store" + "\"On the couch\"" + ANSI_RESET);
        System.out.println("--------------------");
        firstChoice();
    }


    public static void firstChoice() {

        Scanner in = new Scanner(System.in);


        System.out.println(ANSI_YELLOW + "1.Authorization");
        System.out.println("2.Registration " + ANSI_RESET);
        System.out.println("--------------------");
        System.out.println("Please select one of the items:");
        String userСhoice = in.nextLine();
        System.out.println("--------------------");
        System.out.println();

        if (userСhoice.equals("1")) {    //Авторизация
            if (User.autorization()) {
                mainMenu();
            } else {
                while (!User.notAutorization()) ;
            }
            mainMenu();
        } else if (userСhoice.equals("2")) {//Регестрация
            if (User.registration()) {
                mainMenu();
            } else {
                firstChoice();
            }
        } else {  //Ошибка ввода
            firstChoice();
        }

    }


    static void mainMenu() {

        Scanner in = new Scanner(System.in);

        String userChoice = "";
        while (!userChoice.equals("3")) {
            System.out.println("--------------------");

            System.out.println(ANSI_YELLOW +
                    "1. Catalog\n" +
                    "2. Log out of your account\n" +
                    "3. Finish the program" + ANSI_RESET);
            System.out.println("--------------------");
            System.out.println("Select the menu item you are interested in: ");
            userChoice = in.nextLine();
            if (userChoice.equals("1")) {
                buyMenu();
            } else if (userChoice.equals("2")) {
                firstChoice();
            } else if (userChoice.equals("3")) {
                endProgram();
            }
        }

    }


    static void buyMenu() {

        Scanner in = new Scanner(System.in);
        int userChoice;
        Catalog catalog = new Catalog();
        catalog.addProdukt();

        System.out.println("\nPlease select the product:");

        catalog.notSort();

        do {
            System.out.println("--------------------");
            System.out.println(ANSI_YELLOW + "\n" + (catalog.getSizeList() + 1) + ": " + "Sort by ascending price");
            System.out.println((catalog.getSizeList() + 2) + ": " + "Sort by descending price");
            System.out.println((catalog.getSizeList() + 3) + ": " + "Go to basket");
            System.out.println((catalog.getSizeList() + 4) + ": " + "Back" + ANSI_RESET);
            System.out.println("--------------------");
            System.out.println("Select the menu item you are interested in: ");
            while (!in.hasNextInt()) {
                System.out.println("Please enter an number: ");
                in.next();
            }
            userChoice = in.nextInt();

            if (userChoice >= 0 && userChoice <= catalog.getSizeList()) {
                Buy.addBasket(catalog.getIndexProduct(userChoice - 1));
                catalog.notSort();
            } else if (userChoice == catalog.getSizeList() + 1) {
                catalog.sortUp();
            } else if (userChoice == catalog.getSizeList() + 2) {
                catalog.sortDown();
            } else if (userChoice == catalog.getSizeList() + 3) {
                Buy.buying();
                catalog.notSort();
            }
            System.out.println("\nProducts in the basket:" + Buy.getSizeBasket());

        } while (userChoice != catalog.getSizeList() + 4);

    }

    public static void endProgram() {
        System.out.println("by Sergey Ashmaev");
    }

}




   /*
        1.каталог
        2.сортировка по возростанию цены
        3.сортировка по убыванию цены
        4.покупка
        5.выход из аккаунта
        6.закончить программу

                "2. Sort by ascending price\n" +
                "3. Sort by descending price\n"
       */