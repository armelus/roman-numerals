import fr.lacombedulionvert.test.NumberToRomanConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberToRomanConverterTest {

    NumberToRomanConverter converter = new NumberToRomanConverter();

    @Test
    public void convertOne() {
        Assertions.assertEquals("I", converter.convert(1));
    }

    @Test
    void testConvertTwo() {
        Assertions.assertEquals("II", converter.convert(2));
    }

    @Test
    void testConvertThree() {
        Assertions.assertEquals("III", converter.convert(3));
    }

    @Test
    void testConvertFour() {
        Assertions.assertEquals("IV", converter.convert(4));
    }

    @Test
    void testConvertFive() {
        Assertions.assertEquals("V", converter.convert(5));
    }

    @Test
    void testConvertSix() {
        Assertions.assertEquals("VI", converter.convert(6));
    }

    @Test
    void testConvertSeven() {
        Assertions.assertEquals("VII", converter.convert(7));
    }

    @Test
    void testConvertNine() {
        Assertions.assertEquals("IX", converter.convert(9));
    }

    @Test
    void testConvertTen() {
        Assertions.assertEquals("X", converter.convert(10));
    }

    @Test
    void testConvertSeventeen() {
        Assertions.assertEquals("XVII", converter.convert(17));
    }

    @Test
    void testConvertThirteen() {
        Assertions.assertEquals("XXX", converter.convert(30));
    }

    @Test
    void testConvertThirtyEight() {
        Assertions.assertEquals("XXXVIII", converter.convert(38));
    }

    @Test
    void testConvertForLUnit() {
        Assertions.assertEquals("LXX", converter.convert(70));
    }


    @Test
    void testConvertForLUnit2() {
        Assertions.assertEquals("LXXVIII", converter.convert(78));
    }

    @Test
    void testConvertForLUnit3() {
        Assertions.assertEquals("XLVII", converter.convert(47));
    }

    @Test
    void testConvertForLUnit4() {
        Assertions.assertEquals("XCVII", converter.convert(97));
    }

    @Test
    void testConvertForCUnit() {
        Assertions.assertEquals("CXV", converter.convert(115));
    }

    @Test
    void testConvertForCUnit2() {
        Assertions.assertEquals("CCXLVII", converter.convert(247));
    }

    @Test
    void testConvertForCUnit3() {
        Assertions.assertEquals("CX", converter.convert(110));
    }

    @Test
    void testBigNumberOne() {
        Assertions.assertEquals("CDLXXIX", converter.convert(479));
    }

    @Test
    void test500NumberOne() {
        Assertions.assertEquals("DCCLI", converter.convert(751));
    }

    @Test
    void test500NumberTwo() {
        Assertions.assertEquals("DXCIX", converter.convert(599));
    }

    @Test
    void testConvertBigNumberTwo() {
        Assertions.assertEquals("MMMCMXCIX", converter.convert(3999));
    }

    @Test
    void testConvertBigNumberThree() {
        Assertions.assertEquals("MMDCCLI", converter.convert(2751));
    }

    @Test
    void testConvertBigNumberNth1() {
        Assertions.assertEquals("MMMMDCCLI", converter.convert(4751));
    }
}
