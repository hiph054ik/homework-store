package Shop;

import java.util.*;

public class Catalog {
    static ArrayList<Product> product = new ArrayList<>();
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void addProdukt() {
        product.add(new Product("Slippers", 550));
        product.add (new Product("Jacket", 7000));
        product.add (new Product("Shoes", 2500));
        product.add (new Product("T-shirt", 700));
        product.add (new Product("Dress", 5000));
        product.add (new Product("Pants", 2200));
    }

    public static void notSort() {
        int number = 1;
        for (Product product :
                product) {
            System.out.println(ANSI_YELLOW + number + ": " + product.getName() + ":" + product.getPrice() + ANSI_RESET);
            number++;
        }
    }

    public void sortUp() {
        Collections.sort(product, new SortByPriceUp());
        int number = 1;
        System.out.println("----------");
        for (Product product : product
        ) {
            System.out.println(ANSI_YELLOW + number + ": " + product.getName() + ":" + product.getPrice() );
            number++;
        }
        System.out.println();
        System.out.print("----------");
    }

    public void sortDown() {
        Collections.sort(product, new SortByPriceDown());
        int number = 1;
        System.out.println("----------");
        for (Product product : product
        ) {
            System.out.println(ANSI_YELLOW + number + ": " + product.getName() + ":" + product.getPrice());
            number++;
        }
        System.out.print("----------");
    }

    public int getSizeList() {
        return product.size();
    }

    public Product getIndexProduct(int index) {
        return product.get(index);

    }

    public Product getIndexProduktSortUp(int index) {
        sortUp();
        return product.get(index);

    }

    public Product getIndexProduktSortDown(int index) {

        sortDown();
        return product.get(index);

    }


}

