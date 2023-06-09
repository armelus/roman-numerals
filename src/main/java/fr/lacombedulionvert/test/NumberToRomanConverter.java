package fr.lacombedulionvert.test;

import java.util.HashMap;
import java.util.Map;

public class NumberToRomanConverter {

    private final Map<Integer, String> numberMaps;

    public NumberToRomanConverter() {
        this.numberMaps = new HashMap<>();
        this.numberMaps.put(1, "I");
        this.numberMaps.put(2, "II");
        this.numberMaps.put(3, "III");
        this.numberMaps.put(4, "IV");
        this.numberMaps.put(5, "V");
        this.numberMaps.put(9, "IX");
        this.numberMaps.put(10, "X");
        this.numberMaps.put(40, "XL");
        this.numberMaps.put(50, "L");
        this.numberMaps.put(90, "XC");
        this.numberMaps.put(100, "C");
        this.numberMaps.put(400, "CD");
        this.numberMaps.put(500, "D");
        this.numberMaps.put(900, "CM");
        this.numberMaps.put(1000, "M");
    }

    /**
     * Convert a number into a roman numeral
     * @param n Integer number to convert
     * @return String result of conversion
     */
    public String convert(int n) {
        if (isMUnit(n)) {
            return decomposeForStaticUnit(n, 1000);
        }
        if (isCMUnit(n)) {
            return decomposeForUnitRange(n, 900);
        }
        if (isDUnit(n)) {
            return decomposeForUnitRange(n, 500);
        }
        if (isCDUnit(n)) {
            return decomposeForUnitRange(n, 400);
        }
        if (isCUnit(n)) {
            return decomposeForStaticUnit(n, 100);
        }
        if (isXCUnit(n)) {
            return decomposeForUnitRange(n, 90);
        }
        if (isLUnit(n)) {
            return decomposeForUnitRange(n, 50);
        }
        if (isXLUnit(n)) {
            return decomposeForUnitRange(n, 40);
        }
        if (isXUnit(n)) {
            return decomposeForStaticUnit(n, 10);
        }
        if (n == 0) {
            return "";
        }
        if (n <= 5 || n == 9) {
            return numberMaps.get(n);
        }
        return convertLowerThanNine(n);
    }

    /**
     * Convert a number lower than 9 but greater than 5
     * @param n int number to convert
     * @return String result of conversion
     */
    private String convertLowerThanNine(int n) {
        return numberMaps.get(5) + numberMaps.get(n - 5);
    }

    /**
     * Convert a number of known unit.<br/>
     *  Used units are: 10, 100 and 1000. <br/>
     *  Examples: <br/>
     *  &nbsp; n = 16, result = "XVI". <br/>
     *  &nbsp; n = 247, result = "CCXLVII". <br/>
     *  &nbsp; n = 2751, result = "MMDCCLI".
     * @param n int number to convert
     * @param unit int represent unit of value.
     * @return String result of conversion
     */
    private String decomposeForStaticUnit(int n, int unit) {
        StringBuilder sb = new StringBuilder();
        int r = n % unit;
        int d = n / unit;
        for (int i = 0; i < d; i++) {
            sb.append(numberMaps.get(unit));
        }
        sb.append(convert(r));
        return sb.toString();
    }

    /**
     * Convert a number between a range of values.<br/>
     * Ex: [50, 89], [900, 999], [500, 899], [400, 499]
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForUnitRange(int n, int baseRange) {
        return numberMaps.get(baseRange) + convert(n - baseRange);
    }

    private boolean isMUnit(int n) {
        return n >= 1000;
    }

    private boolean isCMUnit(int n) {
        return n >= 900 && n < 1000;
    }

    private boolean isDUnit(int n) {
        return n >= 500 && n < 900;
    }

    private boolean isCDUnit(int n) {
        return n >= 400 && n < 500;
    }

    private boolean isCUnit(int n) {
        return n >= 100 && n <= 400;
    }
    private boolean isXCUnit(int n) {
        return n >= 90 && n < 100;
    }
    private boolean isLUnit(int n) {
        return n >= 50 && n < 90;
    }

    private boolean isXLUnit(int n) {
        return n >= 40 && n < 50;
    }

    private boolean isXUnit(int n) {
        return n >= 10 && n < 40;
    }

}
