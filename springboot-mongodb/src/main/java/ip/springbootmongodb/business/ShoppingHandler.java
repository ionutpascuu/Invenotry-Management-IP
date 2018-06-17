package ip.springbootmongodb.business;


import ip.springbootmongodb.model.ShoppingCartEntry;
import ip.springbootmongodb.model.ShoppingCartMap;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Additional top layer for business logic
 * Call Service Layers
 */
@Service
public interface ShoppingHandler {

    public List<ShoppingCartEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap);
    public String getTotalPrice(List<ShoppingCartEntry> shoppingCartEntries);
    public String getTotalTax(List<ShoppingCartEntry> shoppingCartEntries);

}
