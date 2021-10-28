import BAI_2.BAI_2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BAI_2Test {
    @Test
    @DisplayName("Test gmail true")
    void testGmailTrue() {
        boolean actual = BAI_2.checkGmail("oanhmpp@gmail.com");
        boolean expect = true;
        System.out.println(actual);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Test gmail false")
    void testGmailFalse() {
        boolean actual = BAI_2.checkGmail("oanhmpp@@gmail.com");
        boolean expect = false;
        System.out.println(actual);
        Assertions.assertEquals(expect, actual);
    }
}