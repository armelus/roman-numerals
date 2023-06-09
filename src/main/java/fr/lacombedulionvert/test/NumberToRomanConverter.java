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
            return decomposeForMUnit(n);
        }
        if (isCMUnit(n)) {
            return decomposeForCMUnit(n);
        }
        if (isDUnit(n)) {
            return decomposeForDUnit(n);
        }
        if (isCDUnit(n)) {
            return decomposeForCDUnit(n);
        }
        if (isCUnit(n)) {
            return decomposeForCUnit(n);
        }
        if (isXCUnit(n)) {
            return decomposeForXCUnit(n);
        }
        if (isLUnit(n)) {
            return decomposeForLUnit(n);
        }
        if (isXLUnit(n)) {
            return decomposeForXLUnit(n);
        }
        if (isXUnit(n)) {
            return decomposeForXUnit(n);
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
     * Convert a number of ten unit.<br/>
     * Ex: n = 16, result = "XVI".
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForXUnit(int n) {
        StringBuilder sb = new StringBuilder();
        int r = n % 10;
        int d = n / 10;
        for (int i = 0; i < d; i++) {
            sb.append(numberMaps.get(10));
        }
        sb.append(convert(r));
        return sb.toString();
    }

    /**
     * Convert a number between 40 and 49.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForXLUnit(int n) {
        return numberMaps.get(40) + convert(n - 40);
    }

    /**
     * Convert a number between 90 and 99.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForXCUnit(int n) {
        return numberMaps.get(90) + convert(n - 90);
    }

    /**
     * Convert a number between 50 and 89.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForLUnit(int n) {
        return numberMaps.get(50) + convert(n - 50);
    }

    /**
     * Convert a number between 100 and 400.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForCUnit(int n) {
        StringBuilder sb = new StringBuilder();
        int r = n % 100;
        int d = n / 100;
        for (int i = 0; i < d; i++) {
            sb.append(numberMaps.get(100));
        }
        sb.append(convert(r));
        return sb.toString();
    }

    /**
     * Convert a number between 400 and 499.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForCDUnit(int n) {
        return numberMaps.get(400) + convert(n - 400);
    }

    /**
     * Convert a number between 500 and 899.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForDUnit(int n) {
        return numberMaps.get(500) + convert(n - 500);
    }

    /**
     * Convert a number between 900 and 999.
     * @param n int number to convert
     * @return String result of conversion
     */
    private String decomposeForCMUnit(int n) {
        return numberMaps.get(900) + convert(n - 900);
    }

    /**
     * Convert number of thousand unit.<br/>
     *  Ex: n = 2751, result = "MMDCCLI".
     * @param n number to convert
     * @return converted integer number into roman number
     */
    private String decomposeForMUnit(int n) {
        StringBuilder sb = new StringBuilder();
        int r = n % 1000;
        int d = n / 1000;
        for (int i = 0; i < d; i++) {
            sb.append(numberMaps.get(1000));
        }
        sb.append(convert(r));
        return sb.toString();
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
