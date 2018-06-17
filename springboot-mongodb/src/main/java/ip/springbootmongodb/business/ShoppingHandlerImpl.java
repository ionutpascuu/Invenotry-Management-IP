package ip.springbootmongodb.business;

import ip.springbootmongodb.model.ProductNew;
import ip.springbootmongodb.model.ShoppingCartEntry;
import ip.springbootmongodb.model.ShoppingCartMap;
import ip.springbootmongodb.service.ProductNewService;
import ip.springbootmongodb.utils.PriceStrategy;
import ip.springbootmongodb.utils.PriceStrategyRaw;
import ip.springbootmongodb.utils.PriceStrategyTax;
import ip.springbootmongodb.utils.PriceUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingHandlerImpl implements ShoppingHandler {

    @Autowired
    private ProductNewService productNewService;

    private PriceStrategy priceHandler;

    @Override
    public List<ShoppingCartEntry> getShoppingCartEntries(ShoppingCartMap shoppingCartMap) {
        List<ShoppingCartEntry> shoppingCarts = new ArrayList<>();

        for (String productCode : shoppingCartMap.getCartItems().keySet()) {
            ProductNew p = productNewService.findByProductCode(productCode);

            ShoppingCartEntry s = new ShoppingCartEntry();

            int quantity = shoppingCartMap.getQuantity(productCode);

           // s.setImageUrl(p.getImageUrl());
            s.setProductName(p.getProductName());
            //s.setPrice(p.getPrice());
            //s.setProductTotalPrice(p.getPrice() * quantity);
            s.setQuantity(quantity);

            shoppingCarts.add(s);
        }

        return shoppingCarts;
    }

    @Override
    public String getTotalPrice(List<ShoppingCartEntry> shoppingCartEntries) {
        priceHandler = new PriceStrategyRaw();

        return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
    }

    @Override
    public String getTotalTax(List<ShoppingCartEntry> shoppingCartEntries) {
        priceHandler = new PriceStrategyTax();

        return PriceUtilities.roundToTwoDecimalPlaces(priceHandler.getTotal(shoppingCartEntries));
    }
}
