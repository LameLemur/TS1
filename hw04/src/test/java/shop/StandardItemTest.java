package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StandardItemTest {
    int id = 1;
    String name = "name";
    Float price = 110.5f;
    String category = "itemCategory";
    int loyaltyPoints = 0;
    StandardItem standardItem;

    @BeforeEach
    public void prepStandardItem() {

        standardItem = new StandardItem(id, name, price, category, loyaltyPoints);
    }

    @Test
    public void constructorTestID() {

        assertEquals(id, standardItem.getID());
    }

    @Test
    public void constructorTestName() {

        assertEquals(name, standardItem.getName());
    }

    @Test
    public void constructorTestPrice() {

        assertEquals(price, standardItem.getPrice());
    }

    @Test
    public void constructorTestCategory() {

        assertEquals(category, standardItem.getCategory());
    }

    @Test
    public void constructorTestLoyaltyPoints() {

        assertEquals(loyaltyPoints, standardItem.getLoyaltyPoints());
    }

    @Test
    public void copyTest() {

        StandardItem copy = standardItem.copy();

        assertEquals(standardItem, copy);
    }

    @ParameterizedTest
    @CsvSource({"0,name,15.5f,category,2,0,name,15.5f,category,2,true","0,name2,151.5f,category2,10,0,name2,151.5f,category2,8,false"})
    public void equalsTest(int id, String name, Float price, String category, int loyaltyPoints, int id2, String name2, Float price2, String category2, int loyaltyPoints2, boolean same) {

        StandardItem item1 = new StandardItem(id, name, price, category, loyaltyPoints);
        StandardItem item2 = new StandardItem(id2, name2, price2, category2, loyaltyPoints2);

        assertEquals(same, item1.equals(item2));
    }
}
