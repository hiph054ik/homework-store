package Shop;

import java.util.Comparator;

public class SortByPriceDown implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getPrice() == product2.getPrice()){
            return 0;
        }
        if (product1.getPrice() < product2.getPrice()){
            return 1;
        }
        return -1;
    }
}
