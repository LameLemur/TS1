package shop;

public class EmptyShoppingCart extends Exception {
    public EmptyShoppingCart() {
        super("No items in cart");
    }
}
