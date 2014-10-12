package com.shz.gascalc;

import java.util.HashMap;

/**
 * Created by shz on 09.10.14.
 */
public class Constants {

    public static final Double[] temp_minus_30 = {
            0.011,
            0.023,
            0.0358,
            0.0482,
            0.0642,
            0.081,
            0.1,
            0.129,
            0.1526,
            0.1754,
            0.1964,
            0.2182,
            0.2408,
            0.25,
            0.2632,
            0.2758,
            0.2786,
            0.2858,
            0.2924,
            0.2986
    };
    public static final Double[] temp_minus_20 = {
            0.011,
            0.0224,
            0.034,
            0.0466,
            0.061,
            0.075,
            0.0922,
            0.1142,
            0.1344,
            0.1538,
            0.1718,
            0.1876,
            0.2032,
            0.2222,
            0.238,
            0.25,
            0.2656,
            0.2728,
            0.2836,
            0.2858
    };

    public static final Double[] temp_minus_10 = {
            0.0108,
            0.022,
            0.034,
            0.046,
            0.0596,
            0.0732,
            0.0886,
            0.1066,
            0.125,
            0.1448,
            0.1594,
            0.179,
            0.197,
            0.2154,
            0.2272,
            0.2424,
            0.2538,
            0.2648,
            0.2714,
            0.2762
    };
    public static final Double[] temp_0 = {
            0.0106,
            0.022,
            0.0338,
            0.0454,
            0.0588,
            0.0714,
            0.0864,
            0.104,
            0.1184,
            0.1352,
            0.1506,
            0.169,
            0.1858,
            0.2028,
            0.2174,
            0.2286,
            0.2362,
            0.25,
            0.2568,
            0.2598
    };
    public static final Double[] temp_plus_10 = {
            0.0106,
            0.0218,
            0.033,
            0.0444,
            0.0568,
            0.0706,
            0.0834,
            0.0976,
            0.1126,
            0.1298,
            0.1448,
            0.16,
            0.1756,
            0.1918,
            0.2054,
            0.2222,
            0.2298,
            0.24,
            0.25,
            0.2532,
    };
    public static final Double[] temp_plus_20 = {
            0.0106,
            0.0214,
            0.0326,
            0.0434,
            0.0562,
            0.069,
            0.0814,
            0.0952,
            0.1098,
            0.125,
            0.1392,
            0.1558,
            0.1666,
            0.1818,
            0.1948,
            0.2078,
            0.218,
            0.2308,
            0.2406,
            0.25
    };
    public static final Double[] temp_plus_30 = {
            0.0104,
            0.0212,
            0.0322,
            0.043,
            0.055,
            0.0682,
            0.0804,
            0.093,
            0.1058,
            0.119,
            0.1326,
            0.1464,
            0.1604,
            0.175,
            0.1876,
            0.2026,
            0.2126,
            0.225,
            0.2318,
            0.2438
    };
    public static final Double[] temp_plus_40 = {
            0.0104,
            0.0208,
            0.0314,
            0.0426,
            0.0544,
            0.0654,
            0.0778,
            0.091,
            0.1034,
            0.1162,
            0.1294,
            0.1428,
            0.1566,
            0.1708,
            0.183,
            0.1952,
            0.2074,
            0.2196,
            0.2236,
            0.2326
    };
    public static final HashMap<String, Double[]> TEMPERATURE_MAP = new HashMap<String, Double[]>();

    public static final String TEMP_MINUS_30 = "-30";

    public static final String TEMP_MINUS_20 = "-20";

    public static final String TEMP_MINUS_10 = "-10";

    public static final String TEMP_ZERO = "0";

    public static final String TEMP_PLUS_10 = "10";

    public static final String TEMP_PLUS_20 = "20";

    public static final String TEMP_PLUS_30 = "30";

    public static final String TEMP_PLUS_40 = "40";
    public static final String[] TEMP_MAP = {TEMP_MINUS_30, TEMP_MINUS_20, TEMP_MINUS_10, TEMP_ZERO, TEMP_PLUS_10, TEMP_PLUS_20, TEMP_PLUS_30, TEMP_PLUS_40};
    public static final String[] OST_VALUE_MAP = {"10","20","30","40","50","60","70","80","90","100","110","120","130","140","150","160","170","180","190","200"};
    static {
        TEMPERATURE_MAP.put(TEMP_MINUS_30, temp_minus_30);
        TEMPERATURE_MAP.put(TEMP_MINUS_20, temp_minus_20);
        TEMPERATURE_MAP.put(TEMP_MINUS_10, temp_minus_10);
        TEMPERATURE_MAP.put(TEMP_ZERO, temp_0);
        TEMPERATURE_MAP.put(TEMP_PLUS_10, temp_plus_10);
        TEMPERATURE_MAP.put(TEMP_PLUS_20, temp_plus_20);
        TEMPERATURE_MAP.put(TEMP_PLUS_30, temp_plus_30);
        TEMPERATURE_MAP.put(TEMP_PLUS_40, temp_plus_40);
    }
}
