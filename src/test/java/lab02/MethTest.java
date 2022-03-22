package lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MethTest {
    @Test
    public void factorialTest() {
        Meth meth = new Meth();
        assertEquals(meth.factorial(3), 6);
        assertEquals(meth.factorial(4), 24);
        assertEquals(meth.factorial(5), 120);
        assertEquals(meth.factorial(6), 720);
    }
}
