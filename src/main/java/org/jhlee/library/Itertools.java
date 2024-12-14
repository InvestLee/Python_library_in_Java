package org.jhlee.library;

import java.math.BigDecimal;
import java.util.*;


public class Itertools {

    public static Iterable<String> chain(List<String> list){
        int size = 0;
        for(String word : list){
            size += word.length();
        }
        int totalSize = size;
        return () -> new Iterator() {
            int count = -1;
            int listIdx = 0;
            int wordIdx = -1;
            @Override
            public boolean hasNext() {
                count++;
                return count < totalSize;
            }

            @Override
            public String next() {
                wordIdx++;
                if(wordIdx >= list.get(listIdx).length()){
                    wordIdx = 0;
                    listIdx++;
                }
                return Character.toString(list.get(listIdx).charAt(wordIdx));
            }
        };
    }

    public static<N> List<N> accumulatePlus(List<N> list, N initial){
        if(!(initial instanceof  Number)){
            throw new IllegalArgumentException("The initial value must be a number.");
        }
        List<N> result = new ArrayList<>(list.size()+1);
        result.add(initial);
        Number acc = (Number) initial;
        for(Object value : list) {
            if(!(value instanceof  Number)){
                throw new IllegalArgumentException("The list value must be a number.");
            }
            if(value instanceof Integer) {
                acc = acc.intValue() + (Integer) value;
            } else if(value instanceof Double) {
                acc = acc.doubleValue() + (Double) value;
            } else if(value instanceof Float) {
                acc = acc.floatValue() + (Float) value;
            } else if(value instanceof Long) {
                acc = acc.longValue() + (Long) value;
            } else if(value instanceof Byte) {
                acc = acc.byteValue() + (Byte) value;
            } else if(value instanceof Short) {
                acc = acc.shortValue() + (Short) value;
            } else if(value instanceof BigDecimal) {
                acc = new BigDecimal(acc.toString()).add((BigDecimal) value);
            }
            result.add((N) acc);
        }
        return result;
    }

    public static<N> List<N> accumulateMultiply(List<N> list, N initial){
        if(!(initial instanceof  Number)){
            throw new IllegalArgumentException("The initial value must be a number.");
        }
        List<N> result = new ArrayList<>(list.size()+1);
        result.add(initial);
        Number acc = (Number) initial;
        for(Object value : list) {
            if(!(value instanceof  Number)){
                throw new IllegalArgumentException("The list value must be a number.");
            }
            if(value instanceof Integer) {
                acc = acc.intValue() * (Integer) value;
            } else if(value instanceof Double) {
                acc = acc.doubleValue() * (Double) value;
            } else if(value instanceof Float) {
                acc = acc.floatValue() * (Float) value;
            } else if(value instanceof Long) {
                acc = acc.longValue() * (Long) value;
            } else if(value instanceof Byte) {
                acc = acc.byteValue() * (Byte) value;
            } else if(value instanceof Short) {
                acc = acc.shortValue() * (Short) value;
            } else if(value instanceof BigDecimal) {
                acc = new BigDecimal(acc.toString()).multiply((BigDecimal) value);
            }
            result.add((N) acc);
        }
        return result;
    }

    public static<N> List<N> accumulateMinus(List<N> list, N initial){
        if(!(initial instanceof  Number)){
            throw new IllegalArgumentException("The initial value must be a number.");
        }
        List<N> result = new ArrayList<>(list.size()+1);
        result.add(initial);
        Number acc = (Number) initial;
        for(Object value : list) {
            if(!(value instanceof  Number)){
                throw new IllegalArgumentException("The list value must be a number.");
            }
            if(value instanceof Integer) {
                acc = acc.intValue() - (Integer) value;
            } else if(value instanceof Double) {
                acc = acc.doubleValue() - (Double) value;
            } else if(value instanceof Float) {
                acc = acc.floatValue() - (Float) value;
            } else if(value instanceof Long) {
                acc = acc.longValue() - (Long) value;
            } else if(value instanceof Byte) {
                acc = acc.byteValue() - (Byte) value;
            } else if(value instanceof Short) {
                acc = acc.shortValue() - (Short) value;
            } else if(value instanceof BigDecimal) {
                acc = new BigDecimal(acc.toString()).subtract((BigDecimal) value);
            }
            result.add((N) acc);
        }
        return result;
    }

    public static<N> List<N> accumulateDivide(List<N> list, N initial){
        if(!(initial instanceof  Number)){
            throw new IllegalArgumentException("The initial value must be a number.");
        }
        List<N> result = new ArrayList<>(list.size()+1);
        result.add(initial);
        Number acc = (Number) initial;
        for(Object value : list) {
            if(!(value instanceof  Number)){
                throw new IllegalArgumentException("The list value must be a number.");
            }
            if(value instanceof Integer) {
                acc = acc.intValue() / (Integer) value;
            } else if(value instanceof Double) {
                acc = acc.doubleValue() / (Double) value;
            } else if(value instanceof Float) {
                acc = acc.floatValue() / (Float) value;
            } else if(value instanceof Long) {
                acc = acc.longValue() / (Long) value;
            } else if(value instanceof Byte) {
                acc = acc.byteValue() / (Byte) value;
            } else if(value instanceof Short) {
                acc = acc.shortValue() / (Short) value;
            } else if(value instanceof BigDecimal) {
                acc = new BigDecimal(acc.toString()).divide((BigDecimal) value);
            }
            result.add((N) acc);
        }
        return result;
    }

    public static<N> List<N> accumulateRemain(List<N> list, N initial){
        if(!(initial instanceof  Number)){
            throw new IllegalArgumentException("The initial value must be a number.");
        }
        List<N> result = new ArrayList<>(list.size()+1);
        result.add(initial);
        Number acc = (Number) initial;
        for(Object value : list) {
            if(!(value instanceof  Number)){
                throw new IllegalArgumentException("The list value must be a number.");
            }
            if(value instanceof Integer) {
                acc = acc.intValue() % (Integer) value;
            } else if(value instanceof Double) {
                acc = acc.doubleValue() % (Double) value;
            } else if(value instanceof Float) {
                acc = acc.floatValue() % (Float) value;
            } else if(value instanceof Long) {
                acc = acc.longValue() % (Long) value;
            } else if(value instanceof Byte) {
                acc = acc.byteValue() % (Byte) value;
            } else if(value instanceof Short) {
                acc = acc.shortValue() % (Short) value;
            } else if(value instanceof BigDecimal) {
                acc = new BigDecimal(acc.toString()).remainder((BigDecimal) value);
            }
            result.add((N) acc);
        }
        return result;
    }

    public static<T> List<List<T>> permutations(List<T> list, int r){
        int n = list.size();
        if(r > n){
            List<List<T>> mistake = new ArrayList<>();
            mistake.add((List<T>) new ArrayList<>(Arrays.asList("The list size must be greater than r.")));
            return mistake;
        }
        int[] indices = new int[n];
        for(int i = 0; i < n; i++) indices[i] = i;
        int[] cycles = new int[r];
        for(int i = 0; i < r; i++) cycles[i] = n - i;
        List<List<T>> result = new ArrayList<>();
        List<T> element = new ArrayList<>();
        for(int i = 0; i < r; i++)  element.add(list.get(indices[i]));
        result.add(element);
        boolean flag = true;
        while(flag){
            for(int i = r-1; i >= 0; i--){
                cycles[i]--;
                if(cycles[i] == 0){
                    int[] indicesTemp = indices.clone();
                    int idx = i;
                    for(int j = i+1; j < n; j++){
                        indices[idx] = indicesTemp[j];
                        idx++;
                    }
                    for(int j = i; j < i+1; j++){
                        indices[idx] = indicesTemp[j];
                        idx++;
                    }
                    cycles[i] = n - i;
                    if(i==0) flag = false;
                }
                else {
                    int temp = indices[i];
                    indices[i] = indices[n-cycles[i]];
                    indices[n-cycles[i]] = temp;
                    element = new ArrayList<>();
                    for(int j = 0; j < r; j++)  element.add(list.get(indices[j]));
                    result.add(element);
                    break;
                }
            }
        }
        return result;
    }

    public static<T> List<List<T>> combinations(List<T> list, int r){
        int n = list.size();
        if(r > n){
            List<List<T>> mistake = new ArrayList<>();
            mistake.add((List<T>) new ArrayList<>(Arrays.asList("The list size must be greater than r.")));
            return mistake;
        }
        int[] indices = new int[r];
        for(int i = 0; i < r; i++) indices[i] = i;
        List<List<T>> result = new ArrayList<>();
        List<T> element = new ArrayList<>();
        for(int i = 0; i < r; i++)  element.add(list.get(indices[i]));
        result.add(element);
        boolean flag = true;
        while(flag){
            for(int i = r-1; i >= 0; i--){
                if(indices[i] != i + n - r){
                    indices[i]++;
                    for(int j = i+1; j < r; j++){
                        indices[j] = indices[j-1] + 1;
                    }
                    element = new ArrayList<>();
                    for(int j = 0; j < r; j++)  element.add(list.get(indices[j]));
                    result.add(element);
                    break;
                }
                if(i == 0) flag = false;
            }
        }
        return result;
    }

    public static<T> List<List<T>> combinationsWithReplacement(List<T> list, int r){
        int n = list.size();
        if(r < 1 || n < 1){
            List<List<T>> mistake = new ArrayList<>();
            mistake.add((List<T>) new ArrayList<>(Arrays.asList("list size and r must be greater than 0.")));
            return mistake;
        }
        int[] indices = new int[r];
        List<List<T>> result = new ArrayList<>();
        List<T> element = new ArrayList<>();
        for(int i = 0; i < r; i++)  element.add(list.get(indices[i]));
        result.add(element);
        boolean flag = true;
        while(flag){
            for(int i = r-1; i >= 0; i--){
                if(indices[i] != n - 1){
                    int next = indices[i]+1;
                    for(int j = i; j < r; j++){
                        indices[j] = next;
                    }
                    element = new ArrayList<>();
                    for(int j = 0; j < r; j++)  element.add(list.get(indices[j]));
                    result.add(element);
                    break;
                }
                if(i == 0) flag = false;
            }
        }
        return result;
    }

    public static<T> List<T> compress(List<T> list, boolean[] selectors){
        if(list.size() != selectors.length){
            throw new IllegalArgumentException("The sizes of list and selectors must be the same.");
        }
        List<T> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(selectors[i]){
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static<N> Iterable<N> count(N start, N step){
        if(!(start instanceof  Number)){
            throw new IllegalArgumentException("The start value must be a number.");
        }
        if(!(step instanceof  Number)){
            throw new IllegalArgumentException("The step value must be a number.");
        }

        if(start instanceof Integer && step instanceof Integer) {
            return () -> new Iterator() {
                int result = (Integer) start - (Integer) step;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    result += (Integer) step;
                    return result;
                }
            };
        } else if(start instanceof Double && step instanceof Double) {
            return () -> new Iterator() {
                double result = (Double) start - (Double) step;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Double next() {
                    result += (Double) step;
                    return result;
                }
            };
        } else if(start instanceof Float && step instanceof Float) {
            return () -> new Iterator() {
                float result = (Float) start - (Float) step;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Float next() {
                    result += (Float) step;
                    return result;
                }
            };
        } else if(start instanceof Long && step instanceof Long) {
            return () -> new Iterator() {
                long result = (Long) start - (Long) step;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Long next() {
                    result += (Long) step;
                    return result;
                }
            };
        } else if(start instanceof Byte && step instanceof Byte) {
            return () -> new Iterator() {
                byte result = (byte) ((Byte) start - (Byte) step);

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Byte next() {
                    result += (Byte) step;
                    return result;
                }
            };
        } else if(start instanceof Short && step instanceof Short) {
            return () -> new Iterator() {
                short result = (short) ((Short) start - (Short) step);

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Short next() {
                    result += (Short) step;
                    return result;
                }
            };
        } else if(start instanceof BigDecimal && step instanceof BigDecimal) {
            return () -> new Iterator() {
                BigDecimal result = new BigDecimal(start.toString()).subtract((BigDecimal) step);

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public BigDecimal next() {
                    result = result.add((BigDecimal) step);
                    return result;
                }
            };
        }

        return () -> new Iterator() {
            String result = "The start & step value must be a number.";

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                return result;
            }
        };
    }

    public static<T> Iterable<T> cycle(List<T> list){
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        return () -> new Iterator() {
            int count = -1;
            @Override
            public boolean hasNext() {
                count++;
                if(count > list.size() - 1) count = 0;
                return true;
            }

            @Override
            public T next() {
                return list.get(count);
            }
        };
    }
}
