package processTests;

import org.junit.jupiter.api.Test;
import shop.*;
import storage.NoItemInStorage;

import static org.junit.jupiter.api.Assertions.*;

public class EShopControllerTest {

    @Test
    public void testNotEnoughItems() {

        EShopController.startEShop();
        StandardItem standardItem = new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5);

        EShopController.getStorage().insertItems(standardItem, 10);
        assertEquals(10, EShopController.getStorage().getItemCount(standardItem));

        assertDoesNotThrow(() -> EShopController.getStorage().removeItems(standardItem, 5));

        assertEquals(5, EShopController.getStorage().getItemCount(standardItem));

        ShoppingCart newCart = EShopController.newCart();
        for (int i = 0; i < 6; i++) {
            newCart.addItem(standardItem);
        }

        assertEquals(6, newCart.getCartItems().size());

        assertThrows(NoItemInStorage.class, () ->
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova","Kosmonautu 25, Praha 8")
        );
    }

    @Test
    public void testEnoughItems() {

        EShopController.startEShop();
        StandardItem standardItem = new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5);

        EShopController.getStorage().insertItems(standardItem, 5);
        assertEquals(5, EShopController.getStorage().getItemCount(standardItem));

        ShoppingCart newCart = EShopController.newCart();
        for (int i = 0; i < 6; i++) {
            newCart.addItem(standardItem);
        }

        assertEquals(6, newCart.getCartItems().size());

        for (int i = 0; i < 2; i++) {
            newCart.removeItem(standardItem.getID());
        }

        assertEquals(4, newCart.getCartItems().size());

        assertDoesNotThrow(() ->
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova","Kosmonautu 25, Praha 8")
        );
    }

    @Test
    public void testEmptyCartItems() {

        EShopController.startEShop();
        StandardItem standardItem = new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5);

        EShopController.getStorage().insertItems(standardItem, 5);
        assertEquals(5, EShopController.getStorage().getItemCount(standardItem));

        ShoppingCart newCart = EShopController.newCart();
        for (int i = 0; i < 6; i++) {
            newCart.addItem(standardItem);
        }

        assertEquals(6, newCart.getCartItems().size());

        for (int i = 0; i < 6; i++) {
            newCart.removeItem(standardItem.getID());
        }

        assertEquals(0, newCart.getCartItems().size());

        assertThrows(EmptyShoppingCart.class, () ->
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova","Kosmonautu 25, Praha 8")
        );
    }
}
