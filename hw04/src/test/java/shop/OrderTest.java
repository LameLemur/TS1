package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    ShoppingCart cart = new ShoppingCart();
    String customerName = "name";
    String customerAddress = "address";
    int state = 1;

    Order orderThreeParams;
    Order orderFourParams;

    @BeforeEach
    public void prepOrders() {

        orderFourParams = new Order(cart, customerName, customerAddress, state);
        orderThreeParams = new Order(cart, customerName, customerAddress);
    }

    @Test
    public void fourParameterConstructorTestCartItems() {

        assertEquals(orderFourParams.getItems(), cart.getCartItems());
    }

    @Test
    public void fourParameterConstructorTestCustomerName() {

        assertEquals(customerName, orderFourParams.getCustomerName());
    }

    @Test
    public void fourParameterConstructorTestCustomerAddress() {

        assertEquals(customerAddress, orderFourParams.getCustomerAddress());
    }

    @Test
    public void fourParameterConstructorTestState() {

        assertEquals(state, orderFourParams.getState());
    }

    @Test
    public void treeParameterConstructorTestCartItems() {

        assertEquals(cart.getCartItems(), orderThreeParams.getItems());
    }

    @Test
    public void treeParameterConstructorTestCustomerName() {

        assertEquals(customerName, orderThreeParams.getCustomerName());
    }

    @Test
    public void treeParameterConstructorTestCustomerAddress() {

        assertEquals(customerAddress, orderThreeParams.getCustomerAddress());
    }

    @Test
    public void treeParameterConstructorTestState() {

        assertEquals(0, orderThreeParams.getState());
    }

}
