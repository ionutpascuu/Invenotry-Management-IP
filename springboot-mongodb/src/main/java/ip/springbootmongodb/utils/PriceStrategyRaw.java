package ip.springbootmongodb.utils;

import ip.springbootmongodb.model.ShoppingCartEntry;

import java.util.List;

public class PriceStrategyRaw implements PriceStrategy {

    @Override
    public double getTotal(List<ShoppingCartEntry> shoppingCartEntries) {
        double total = 0.0;

        for(ShoppingCartEntry e : shoppingCartEntries) {
            total += e.getProductTotalPrice();
        }

        return total;
    }

}