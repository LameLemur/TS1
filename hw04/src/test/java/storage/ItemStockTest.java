package storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.Item;
import shop.StandardItem;

import static org.junit.jupiter.api.Assertions.*;

public class ItemStockTest {

    int id = 1;
    String name = "name";
    Float price = 110.5f;
    String category = "itemCategory";
    int loyaltyPoints = 0;
    Item standardItem = new StandardItem(id, name, price, category, loyaltyPoints);;
    ItemStock itemStock;

    @BeforeEach
    public void prepStandardItem() {

        itemStock = new ItemStock(standardItem);
    }

    @Test
    public void constructorTest() {

        assertEquals(standardItem, itemStock.getItem());
    }

    @ParameterizedTest(name = "Increase of {0}, should be {1}")
    @CsvSource({"5,2,7", "5,4,9"})
    public void increaseTest(int a, int b, int c) {

        itemStock.IncreaseItemCount(a);
        itemStock.IncreaseItemCount(b);
        assertEquals(c, itemStock.getCount());
    }

    @ParameterizedTest(name = "Decrease of {0}, should be {1}")
    @CsvSource({"5,2,3", "5,4,1"})
    public void decreaseTest(int a, int b, int c) {

        itemStock.IncreaseItemCount(a);
        itemStock.decreaseItemCount(b);
        assertEquals(c, itemStock.getCount());
    }
}
