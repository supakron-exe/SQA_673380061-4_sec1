import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.ShiftCipher;

class ShiftCipherTest {

    @Test
    void TC01() {
        ShiftCipher cipher = new ShiftCipher();

        String actual = cipher.shift("SOFTWARE", 3);

        assertEquals("ZVMADHYL", actual);
    }
    
    @Test
    void TC02() {
    	ShiftCipher cipher = new ShiftCipher();
    	
        String actual = cipher.shift("software", 3);

        assertEquals("zvmadhyl", actual);
    }
    
    @Test
    void TC03() {
    	ShiftCipher cipher = new ShiftCipher();
    	
        String actual = cipher.shift("AOMSIN", 3);

        assertEquals("DRPVLQ", actual);
    }
    
    @Test
    void TC04() {
    	ShiftCipher cipher = new ShiftCipher();
    	
        String actual = cipher.shift("teamza", 3);

        assertEquals("qbxjwX", actual);
    }
}