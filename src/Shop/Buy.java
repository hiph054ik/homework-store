package Shop;
import java.util.ArrayList;
import java.util.Scanner;

public class Buy {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    static ArrayList<Product> basket = new ArrayList<>();

    public static void addBasket(Product product) {
        basket.add(product);
    }

    public static int getSizeBasket() {
        return basket.size();
    }

    public static int getSum() {
        int sum = 0;
        if (!basket.contains(null)) {
            for (int i = 0; i < basket.size(); i++) {
                sum = sum + basket.get(i).getPrice();
            }
            return sum;
        }
        return 0;

    }

    public static void buying() {
        Scanner in = new Scanner(System.in);

        showBasket();


        System.out.println(ANSI_YELLOW + "\n" + "1: Buy");
        System.out.println("2: Delete an item");
        System.out.println("3: Delete all");
        System.out.println("4: Back"+ ANSI_RESET);
        System.out.println("--------------------\n");

        System.out.println("Please enter an number: " );
        String userChoice = in.nextLine();

        if (userChoice.equals("1")) {
            if (basket.size() == 0) {
                System.out.println("The basket is empty");
                return;
            }
            System.out.println(ANSI_CYAN + "Thanks for the purchase!\n" + ANSI_RESET);

            basket.removeAll(basket);
        } else if (userChoice.equals("2")) {
            removeOneElement();
            buying();
        } else if (userChoice.equals("3")) {
            basket.removeAll(basket);
            buying();
        } else if (userChoice.equals("4")) {
            return;
        }else{
            buying();
        }

    }

    public static void removeOneElement() {
        Scanner in = new Scanner(System.in);
        boolean flag = false;


        int userChoice;

        do {

            showBasket();
            System.out.println(basket.size() + 1 + " :Back");
            while (!in.hasNextInt()) {
                System.out.println("Please enter an number: ");
                in.next();
            }
            System.out.println("Select the product number");
            userChoice = in.nextInt();

            if (userChoice == basket.size()) {
                flag = false;
            } else if (basket.size() == 0 && userChoice == 1) {
                flag = true;
            } else if (basket.size() != 0 && userChoice > basket.size()) {
                flag = true;
            }
            if (basket.size() != 0 && userChoice <= basket.size()) {
                basket.remove(userChoice - 1);
            }
        } while (!flag);
    }

    public static void showBasket() {
        System.out.println("Your basket: ");
        int number = 1;
        System.out.println("Amount to be paid" + ": " + getSum());
        for (Product product1 :
                basket) {

            System.out.println(ANSI_YELLOW + number + ": " + product1.getName() + ":" + product1.getPrice() + ANSI_RESET);
            number++;
        }

    }
}

