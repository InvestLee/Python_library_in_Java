package org.jhlee.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Itertools {

    public static List<Integer> accumulatePlus(List<Integer> list, Integer initial){
        Integer[] result = new Integer[list.size()+1];
        result[0] = initial;
        for(int i = 1; i < result.length; i++){
            result[i] = list.get(i-1);
            result[i] += result[i-1];
        }
        return Arrays.asList(result);
    }

    public static List<Float> accumulatePlus(List<Float> list, Float initial){
        Float[] result = new Float[list.size()+1];
        result[0] = initial;
        for(int i = 1; i < result.length; i++){
            result[i] = list.get(i-1);
            result[i] += result[i-1];
        }
        return Arrays.asList(result);
    }

    public static List<Long> accumulatePlus(List<Long> list, Long initial){
        Long[] result = new Long[list.size()+1];
        result[0] = initial;
        for(int i = 1; i < result.length; i++){
            result[i] = list.get(i-1);
            result[i] += result[i-1];
        }
        return Arrays.asList(result);
    }

    public static List<Double> accumulatePlus(List<Double> list, Double initial){
        Double[] result = new Double[list.size()+1];
        result[0] = initial;
        for(int i = 1; i < result.length; i++){
            result[i] = list.get(i-1);
            result[i] += result[i-1];
        }
        return Arrays.asList(result);
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

    public static Iterable<Integer> count(int start, int step){
        return () -> new Iterator<>() {
            int result = start - step;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                result += step;
                return result;
            }
        };
    }

    public static Iterable<Float> count(float start, float step){
        return () -> new Iterator<>() {
            float result = start - step;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Float next() {
                result += step;
                return result;
            }
        };
    }

    public static Iterable<Long> count(long start, long step){
        return () -> new Iterator<>() {
            long result = start - step;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Long next() {
                result += step;
                return result;
            }
        };
    }

    public static Iterable<Double> count(double start, double step){
        return () -> new Iterator<>() {
            double result = start - step;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Double next() {
                result += step;
                return result;
            }
        };
    }
}
