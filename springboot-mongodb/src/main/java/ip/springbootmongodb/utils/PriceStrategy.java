package ip.springbootmongodb.utils;

import ip.springbootmongodb.model.ShoppingCartEntry;

import java.util.List;

public interface PriceStrategy {

    public double getTotal(List<ShoppingCartEntry> shoppingCartEntries);

}
