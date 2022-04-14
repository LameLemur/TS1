package archive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import shop.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PurchasesArchiveTest {

    PurchasesArchive archive;
    ArrayList<Order> mockOrderArchive = Mockito.mock(ArrayList.class);
    HashMap<Integer, ItemPurchaseArchiveEntry> itemPurchaseArchive = new HashMap<Integer, ItemPurchaseArchiveEntry>();
    Order order;
    Item item;
    int count = 5;

    public Order createOrder(int count) {
        ShoppingCart cart = new ShoppingCart();
        item = new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5);
        for (int i = 0; i < count; i++) {
            cart.addItem(item);
        }
        Order order = new Order(cart, "Customer name", "Customer address");
        return order;
    }

    @BeforeEach
    public void prepareVariables() {

        mockOrderArchive = Mockito.mock(ArrayList.class);
        itemPurchaseArchive = new HashMap<Integer, ItemPurchaseArchiveEntry>();
        archive = new PurchasesArchive(itemPurchaseArchive, mockOrderArchive);
        order = createOrder(count);
    }

    @Test
    public void testPutOrderToPurchasesArchive() {

        archive.putOrderToPurchasesArchive(order);
        Mockito.verify(mockOrderArchive).add(order);
        assertEquals(count, itemPurchaseArchive.get(1).getCountHowManyTimesHasBeenSold());
    }

    @Test
    public void testGetHowManyTimesHasBeenItemSold() {

        archive.putOrderToPurchasesArchive(order);
        assertEquals(count, archive.getHowManyTimesHasBeenItemSold(item));
    }

    @Test
    public void testPrintItemPurchaseStatistics() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));

        String expected = "ITEM PURCHASE STATISTICS:\n" +
                "ITEM  Item   ID 1   NAME Dancing Panda v.2   CATEGORY GADGETS   PRICE 5000.0   LOYALTY POINTS 5   HAS BEEN SOLD 5 TIMES\n";

        archive.putOrderToPurchasesArchive(order);
        archive.printItemPurchaseStatistics();

        assertEquals(expected, outContent.toString());

        System.setOut(originalOut);
    }
}
