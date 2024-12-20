package org.jhlee.library;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static org.jhlee.library.CommonMethod.*;


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

    public static <N extends Number> List<N> accumulate(List<N> list, N initial, BiFunction<Number, Number, Number> operation) {
        if (!(initial instanceof Number)) {
            throw new IllegalArgumentException("The initial value must be a number.");
        }

        List<N> result = new ArrayList<>(list.size() + 1);
        result.add(initial);

        Number acc = initial;

        for (Number value : list) {
            if (!(value instanceof Number)) {
                throw new IllegalArgumentException("The list value must be a number.");
            }

            acc = applyOperation(acc, value, operation);
            result.add(castToType(acc, initial));
        }

        return result;
    }

    public static <N extends Number> List<N> accumulatePlus(List<N> list, N initial) {
        return accumulate(list, initial, (a, b) -> {
            if (a instanceof BigDecimal && b instanceof BigDecimal) {
                return ((BigDecimal) a).add((BigDecimal) b);
            }
            return a.doubleValue() + b.doubleValue();
        });
    }

    public static <N extends Number> List<N> accumulateMinus(List<N> list, N initial) {
        return accumulate(list, initial, (a, b) -> {
            if (a instanceof BigDecimal && b instanceof BigDecimal) {
                return ((BigDecimal) a).subtract((BigDecimal) b);
            }
            return a.doubleValue() - b.doubleValue();
        });
    }

    public static <N extends Number> List<N> accumulateMultiply(List<N> list, N initial) {
        return accumulate(list, initial, (a, b) -> {
            if (a instanceof BigDecimal && b instanceof BigDecimal) {
                return ((BigDecimal) a).multiply((BigDecimal) b);
            }
            return a.doubleValue() * b.doubleValue();
        });
    }

    public static <N extends Number> List<N> accumulateDivide(List<N> list, N initial) {
        return accumulate(list, initial, (a, b) -> {
            if (a instanceof BigDecimal && b instanceof BigDecimal) {
                return ((BigDecimal) a).divide((BigDecimal) b);
            }
            return a.doubleValue() / b.doubleValue();
        });
    }

    public static <N extends Number> List<N> accumulateRemain(List<N> list, N initial) {
        return accumulate(list, initial, (a, b) -> {
            if (a instanceof BigDecimal && b instanceof BigDecimal) {
                return ((BigDecimal) a).remainder((BigDecimal) b);
            }
            return a.doubleValue() % b.doubleValue();
        });
    }

    public static <T> List<List<T>> permutations(List<T> list, int r) {
        if (r > list.size()) {
            return createErrorList("The list size must be greater than or equal to r.");
        }

        int n = list.size();
        int[] indices = initializeIndices(n);
        int[] cycles = initializeCycles(r, n);

        List<List<T>> result = new ArrayList<>();
        addCurrentPermutation(result, list, indices, r);

        while (true) {
            boolean done = true;
            for (int i = r - 1; i >= 0; i--) {
                cycles[i]--;
                if (cycles[i] == 0) {
                    rotateLeft(indices, i, n);
                    cycles[i] = n - i;
                } else {
                    swap(indices, i, n - cycles[i]);
                    addCurrentPermutation(result, list, indices, r);
                    done = false;
                    break;
                }
            }
            if (done) break;
        }

        return result;
    }

    public static <T> List<List<T>> combinations(List<T> list, int r) {
        if (r > list.size()) {
            return createErrorList("The list size must be greater than or equal to r.");
        }

        int[] indices = initializeIndices(r);
        List<List<T>> result = new ArrayList<>();
        addCurrentCombination(result, list, indices);

        while (true) {
            boolean done = true;
            for (int i = r - 1; i >= 0; i--) {
                if (indices[i] < i + list.size() - r) {
                    indices[i]++;
                    for (int j = i + 1; j < r; j++) {
                        indices[j] = indices[j - 1] + 1;
                    }
                    addCurrentCombination(result, list, indices);
                    done = false;
                    break;
                }
            }
            if (done) break;
        }

        return result;
    }

    public static <T> List<List<T>> combinationsWithReplacement(List<T> list, int r) {
        if (r < 1 || list.isEmpty()) {
            return createErrorList("The list size and r must be greater than 0.");
        }

        int[] indices = new int[r];
        List<List<T>> result = new ArrayList<>();
        addCurrentCombination(result, list, indices);

        while (true) {
            boolean done = true;
            for (int i = r - 1; i >= 0; i--) {
                if (indices[i] < list.size() - 1) {
                    int next = indices[i] + 1;
                    for (int j = i; j < r; j++) {
                        indices[j] = next;
                    }
                    addCurrentCombination(result, list, indices);
                    done = false;
                    break;
                }
            }
            if (done) break;
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

    public static <N extends Number> Iterable<N> count(N start, N step) {
        if (start == null || step == null) {
            throw new IllegalArgumentException("Start and step values must not be null.");
        }

        Class<?> clazz = start.getClass();

        if (clazz == Integer.class || clazz == Double.class || clazz == Float.class || clazz == Long.class || clazz == Byte.class || clazz == Short.class || clazz == BigDecimal.class) {
            return createIterator(start, step);
        }

        throw new IllegalArgumentException("Unsupported number type: " + clazz.getName());
    }

    public static<T> Iterable<T> cycle(List<T> list){
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        return () -> new Iterator() {
            int idx = -1;
            @Override
            public boolean hasNext() {
                idx++;
                if(idx > list.size() - 1) idx = 0;
                return true;
            }

            @Override
            public T next() {
                return list.get(idx);
            }
        };
    }

    public static <T> Iterable<T> dropWhile(Predicate<T> condition, List<T> list) {
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        return () -> new Iterator<T>() {
            int idx = -1;
            boolean flag = false;

            @Override
            public boolean hasNext() {
                idx++;
                while (!flag && idx < list.size() && condition.test(list.get(idx))) {
                    idx++;
                }
                flag = true;
                return idx < list.size();
            }

            @Override
            public T next() {
                return list.get(idx);
            }
        };
    }

    public static <T> Iterable<T> filterFalse(Predicate<T> condition, List<T> list) {
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        return () -> new Iterator<T>() {
            int idx = -1;

            @Override
            public boolean hasNext() {
                idx++;
                while (idx < list.size() && !condition.test(list.get(idx))) {
                    idx++;
                }
                return idx < list.size();
            }

            @Override
            public T next() {
                return list.get(idx);
            }
        };
    }

    public static<T> List<T> groupBy(List<T> list){
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        List<T> result = new ArrayList<>();
        result.add(list.get(0));
        for(int i = 1; i < list.size(); i++){
            if(!list.get(i).equals(list.get(i-1))){
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static<T> List<T> iSlice(List<T> list, int start, int end, int step){
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        List<T> result = new ArrayList<>();
        for(int i = start; i < end; i += step){
            result.add(list.get(i));
        }
        return result;
    }

    public static List<String> product(List<String> listA, List<String> listB){
        if(listA.size() == 0 || listB.size() == 0){
            throw new IllegalArgumentException("The listA and listB size must be greater than 0.");
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < listA.size(); i++){
            for(int j = 0; j < listB.size(); j++){
                result.add(listA.get(i)+listB.get(j));
            }
        }
        return result;
    }

    public static List<String> product(List<String> list, int repeat){
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        List<String> result = list;
        for(int i = 1; i < repeat; i++){
            result = product(result, list);
        }
        return result;
    }

    public static<T> Iterable<T> repeat(T obj, int times){
        return () -> new Iterator() {
            int count = -1;
            @Override
            public boolean hasNext() {
                count++;
                return count < times;
            }

            @Override
            public T next() {
                return obj;
            }
        };
    }

    public static <T> Iterable<T> takeWhile(Predicate<T> condition, List<T> list) {
        if(list.size() == 0){
            throw new IllegalArgumentException("The list size must be greater than 0.");
        }

        return () -> new Iterator<T>() {
            int idx = -1;

            @Override
            public boolean hasNext() {
                idx++;
                if (condition.test(list.get(idx))) {
                    idx = list.size();
                }
                return idx < list.size();
            }

            @Override
            public T next() {
                return list.get(idx);
            }
        };
    }

    public static<T> Iterable<T> tee(List<T> list, int n){
        int size = 0;
        for(T word : list){
            size += word.toString().length();
        }
        int totalSize = size;
        return () -> new Iterator() {
            int count = -1;
            int listIdx = 0;
            int wordIdx = -1;
            @Override
            public boolean hasNext() {
                count++;
                if(count % totalSize == 0){
                    listIdx = 0;
                    wordIdx = -1;
                }
                return count < n * totalSize;
            }

            @Override
            public String next() {
                wordIdx++;
                if(wordIdx >= list.get(listIdx).toString().length()){
                    wordIdx = 0;
                    listIdx++;
                }
                return Character.toString(list.get(listIdx).toString().charAt(wordIdx));
            }
        };
    }

    public static List<String> zipLongest(List<String> listA, List<String> listB, String fillValue){
        if(listA.size() == 0){
            throw new IllegalArgumentException("The listA size must be greater than 0.");
        }

        if(listA.size() < listB.size()){
            throw new IllegalArgumentException("The listA size must be greater than listB size.");
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < listA.size(); i++){
            if(i < listB.size()){
                result.add(listA.get(i)+listB.get(i));
            } else {
                result.add(listA.get(i)+fillValue);
            }
        }
        return result;
    }

    public static List<String> zipLongest(List<String> listA, String fillValue){
        if(listA.size() == 0){
            throw new IllegalArgumentException("The listA size must be greater than 0.");
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < listA.size(); i++){
            result.add(listA.get(i)+fillValue);
        }
        return result;
    }
}
