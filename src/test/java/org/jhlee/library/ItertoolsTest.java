package org.jhlee.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItertoolsTest {

    @Test
    @DisplayName("count 함수 int")
    public void countIntTest() {
        int i = 10;
        for (int a : Itertools.count(10, 1)) {
            assertEquals(i, a);
            i += 1;
            if (i > 20) break;
        }
    }

    @Test
    @DisplayName("count 함수 double")
    public void countDoubleTest() {
        double i = 2.5;
        for (double a : Itertools.count(2.5, 0.5)) {
            assertEquals(i, a);
            i += 0.5;
            if (i > 10) break;
        }
    }

    @Test
    @DisplayName("count 함수 Float")
    public void countFloatTest() {
        float i = 2.5F;
        for (double a : Itertools.count(2.5F, 0.5F)) {
            assertEquals(i, a);
            i += 0.5F;
            if (i > 10) break;
        }
    }

    @Test
    @DisplayName("count 함수 Long")
    public void countLongTest() {
        long i = 10;
        for (int a : Itertools.count(10, 1)) {
            assertEquals(i, a);
            i += 1;
            if (i > 20) break;
        }
    }

    @Test
    @DisplayName("permutation 함수")
    public void permutationTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","B","C","D"));
        List<List<String>> result = Itertools.permutations(arr,2);
        List<List<String>> comp = new ArrayList<>();
        comp.add(Arrays.asList("A","B"));
        comp.add(Arrays.asList("A","C"));
        comp.add(Arrays.asList("A","D"));
        comp.add(Arrays.asList("B","A"));
        comp.add(Arrays.asList("B","C"));
        comp.add(Arrays.asList("B","D"));
        comp.add(Arrays.asList("C","A"));
        comp.add(Arrays.asList("C","B"));
        comp.add(Arrays.asList("C","D"));
        comp.add(Arrays.asList("D","A"));
        comp.add(Arrays.asList("D","B"));
        comp.add(Arrays.asList("D","C"));
        assertEquals(comp, result);

        List<Integer> arr2 = new ArrayList<>(Arrays.asList(0,1,2));
        List<List<Integer>> result2 = Itertools.permutations(arr2,3);
        List<List<Integer>> comp2 = new ArrayList<>();
        comp2.add(Arrays.asList(0,1,2));
        comp2.add(Arrays.asList(0,2,1));
        comp2.add(Arrays.asList(1,0,2));
        comp2.add(Arrays.asList(1,2,0));
        comp2.add(Arrays.asList(2,0,1));
        comp2.add(Arrays.asList(2,1,0));
        assertEquals(comp2, result2);
    }

    @Test
    @DisplayName("combination 함수")
    public void combinationTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","B","C","D"));
        List<List<String>> result = Itertools.combinations(arr,2);
        List<List<String>> comp = new ArrayList<>();
        comp.add(Arrays.asList("A","B"));
        comp.add(Arrays.asList("A","C"));
        comp.add(Arrays.asList("A","D"));
        comp.add(Arrays.asList("B","C"));
        comp.add(Arrays.asList("B","D"));
        comp.add(Arrays.asList("C","D"));
        assertEquals(comp, result);

        List<Integer> arr2 = new ArrayList<>(Arrays.asList(0,1,2,3));
        List<List<Integer>> result2 = Itertools.combinations(arr2,3);
        List<List<Integer>> comp2 = new ArrayList<>();
        comp2.add(Arrays.asList(0,1,2));
        comp2.add(Arrays.asList(0,1,3));
        comp2.add(Arrays.asList(0,2,3));
        comp2.add(Arrays.asList(1,2,3));
        assertEquals(comp2, result2);
    }

    @Test
    @DisplayName("accumulatePlus 함수")
    public void accumulatePlusTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result = Itertools.accumulatePlus(arr,0);
        List<Integer> comp = new ArrayList<>(Arrays.asList(0,1,3,6,10,15));
        assertEquals(comp, result);

        List<Float> arr2 = new ArrayList<>(Arrays.asList(1.5F,2.5F,3.5F,4.5F,5.5F));
        List<Float> result2 = Itertools.accumulatePlus(arr2,0F);
        List<Float> comp2 = new ArrayList<>(Arrays.asList(0.0F,1.5F,4.0F,7.5F,12.0F,17.5F));
        assertEquals(comp2, result2);

        List<Long> arr3 = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<Long> result3 = Itertools.accumulatePlus(arr3,0L);
        List<Long> comp3 = new ArrayList<>(Arrays.asList(0L,1L,3L,6L,10L,15L));
        assertEquals(comp3, result3);

        List<Double> arr4 = new ArrayList<>(Arrays.asList(1.5,2.5,3.5,4.5,5.5));
        List<Double> result4 = Itertools.accumulatePlus(arr4, 0.0);
        List<Double> comp4 = new ArrayList<>(Arrays.asList(0.0,1.5,4.0,7.5,12.0,17.5));
        assertEquals(comp4, result4);

        List<Integer> arr5 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result5 = Itertools.accumulatePlus(arr,100);
        List<Integer> comp5 = new ArrayList<>(Arrays.asList(100,101,103,106,110,115));
        assertEquals(comp5, result5);
    }
}
