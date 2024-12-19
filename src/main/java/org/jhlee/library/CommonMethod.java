package org.jhlee.library;

import java.math.BigDecimal;

public class CommonMethod {

    @SuppressWarnings("unchecked")
    public static <N extends Number> N castToType(Number number, N example) {
        if (example instanceof Integer) {
            return (N) Integer.valueOf(number.intValue());
        } else if (example instanceof Double) {
            return (N) Double.valueOf(number.doubleValue());
        } else if (example instanceof Float) {
            return (N) Float.valueOf(number.floatValue());
        } else if (example instanceof Long) {
            return (N) Long.valueOf(number.longValue());
        } else if (example instanceof Byte) {
            return (N) Byte.valueOf(number.byteValue());
        } else if (example instanceof Short) {
            return (N) Short.valueOf(number.shortValue());
        } else if (example instanceof BigDecimal) {
            return (N) new BigDecimal(number.toString());
        } else {
            throw new IllegalArgumentException("Unsupported number type: " + example.getClass().getName());
        }
    }
}
