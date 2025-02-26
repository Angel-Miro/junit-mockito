package com.debuggeandoideas.airdnd.utils;

public class CurrencyConverter {

    private static final Double USD_TO_MX = 17.09;

    public static double toMx(final Double amount) {
        return amount * USD_TO_MX;
    }
}
