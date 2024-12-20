package org.jhlee.library;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

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

    public static Number applyOperation(Number acc, Number value, BiFunction<Number, Number, Number> operation) {
        if (acc instanceof BigDecimal || value instanceof BigDecimal) {
            BigDecimal accBigDecimal = new BigDecimal(acc.toString());
            BigDecimal valueBigDecimal = new BigDecimal(value.toString());
            return operation.apply(accBigDecimal, valueBigDecimal);
        }

        return operation.apply(acc, value);
    }

    public static <N extends Number> Iterable<N> createIterator(N start, N step) {
        return () -> new Iterator<>() {
            N current = castToType(initialValue(start, step), start);

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public N next() {
                current = castToType(nextValue(current, step), start);
                return current;
            }
        };
    }

    public static Number initialValue(Number start, Number step) {
        if (start instanceof BigDecimal && step instanceof BigDecimal) {
            return ((BigDecimal) start).subtract((BigDecimal) step);
        }
        return start.doubleValue() - step.doubleValue();
    }

    public static Number nextValue(Number current, Number step) {
        if (current instanceof BigDecimal && step instanceof BigDecimal) {
            return ((BigDecimal) current).add((BigDecimal) step);
        }
        return current.doubleValue() + step.doubleValue();
    }

    public static <T> List<List<T>> createErrorList(String errorMessage) {
        List<List<T>> errorList = new ArrayList<>();
        errorList.add((List<T>) Arrays.asList((T) errorMessage));
        return errorList;
    }

    public static int[] initializeIndices(int size) {
        int[] indices = new int[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }
        return indices;
    }

    public static int[] initializeCycles(int r, int n) {
        int[] cycles = new int[r];
        for (int i = 0; i < r; i++) {
            cycles[i] = n - i;
        }
        return cycles;
    }

    public static void rotateLeft(int[] array, int start, int end) {
        int temp = array[start];
        System.arraycopy(array, start + 1, array, start, end - start - 1);
        array[end - 1] = temp;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> void addCurrentPermutation(List<List<T>> result, List<T> list, int[] indices, int r) {
        List<T> element = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            element.add(list.get(indices[i]));
        }
        result.add(element);
    }

    public static <T> void addCurrentCombination(List<List<T>> result, List<T> list, int[] indices) {
        List<T> element = new ArrayList<>();
        for (int index : indices) {
            element.add(list.get(index));
        }
        result.add(element);
    }
}
