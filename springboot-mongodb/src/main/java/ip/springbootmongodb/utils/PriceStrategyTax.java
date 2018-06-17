package ip.springbootmongodb.utils;

import ip.springbootmongodb.model.ShoppingCartEntry;

import java.util.List;

public class PriceStrategyTax implements PriceStrategy {

    @Override
    public double getTotal(List<ShoppingCartEntry> shoppingCartEntries) {
        double total = 0.0;

        for(ShoppingCartEntry e : shoppingCartEntries) {
            total += e.getProductTotalPrice() * 0.18;
        }

        return total;
    }

}

