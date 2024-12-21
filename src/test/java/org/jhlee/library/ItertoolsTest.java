package org.jhlee.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItertoolsTest {

    @Test
    @DisplayName("count test")
    public void countTest() {
        int i = 10;
        for (int a : Itertools.count(10, 1)) {
            assertEquals(i, a);
            i += 1;
            if (i > 20) break;
        }

        double j = 2.5;
        for (double a : Itertools.count(2.5, 0.5)) {
            assertEquals(j, a);
            j += 0.5;
            if (j > 10) break;
        }

        float k = 2.5F;
        for (double a : Itertools.count(2.5F, 0.5F)) {
            assertEquals(k, a);
            k += 0.5F;
            if (k > 10) break;
        }

        long l = 10;
        for (int a : Itertools.count(10, 1)) {
            assertEquals(l, a);
            l += 1;
            if (l > 20) break;
        }

        BigDecimal b = new BigDecimal("10");
        for (BigDecimal a : Itertools.count(new BigDecimal("10"), new BigDecimal("1"))) {
            assertEquals(b, a);
            b = b.add(new BigDecimal("1"));
            if (b.compareTo(new BigDecimal("20")) > 0) break;
        }
    }

    @Test
    @DisplayName("permutation test")
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

        assertThrows(IllegalArgumentException.class, () -> Itertools.permutations(arr,5));
    }

    @Test
    @DisplayName("combination test")
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

        assertThrows(IllegalArgumentException.class, () -> Itertools.combinations(arr,5));
    }

    @Test
    @DisplayName("combinationsWithReplacement test")
    public void combinationsWithReplacementTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","B","C"));
        List<List<String>> result = Itertools.combinationsWithReplacement(arr,2);
        List<List<String>> comp = new ArrayList<>();
        comp.add(Arrays.asList("A","A"));
        comp.add(Arrays.asList("A","B"));
        comp.add(Arrays.asList("A","C"));
        comp.add(Arrays.asList("B","B"));
        comp.add(Arrays.asList("B","C"));
        comp.add(Arrays.asList("C","C"));
        assertEquals(comp, result);

        List<String> arr3 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.combinationsWithReplacement(arr,0));
        assertThrows(IllegalArgumentException.class, () -> Itertools.combinationsWithReplacement(arr3,2));
    }

    @Test
    @DisplayName("accumulatePlus test")
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
        List<Integer> result5 = Itertools.accumulatePlus(arr5,100);
        List<Integer> comp5 = new ArrayList<>(Arrays.asList(100,101,103,106,110,115));
        assertEquals(comp5, result5);
    }

    @Test
    @DisplayName("accumulateMultiply test")
    public void accumulateMultiplyTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result = Itertools.accumulateMultiply(arr,1);
        List<Integer> comp = new ArrayList<>(Arrays.asList(1,1,2,6,24,120));
        assertEquals(comp, result);

        List<Float> arr2 = new ArrayList<>(Arrays.asList(1.0F,2.0F,3.0F,4.0F,5.0F));
        List<Float> result2 = Itertools.accumulateMultiply(arr2,1F);
        List<Float> comp2 = new ArrayList<>(Arrays.asList(1.0F,1.0F,2.0F,6.0F,24.0F,120.0F));
        assertEquals(comp2, result2);

        List<Long> arr3 = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<Long> result3 = Itertools.accumulateMultiply(arr3,1L);
        List<Long> comp3 = new ArrayList<>(Arrays.asList(1L,1L,2L,6L,24L,120L));
        assertEquals(comp3, result3);

        List<Double> arr4 = new ArrayList<>(Arrays.asList(1.0,2.0,3.0,4.0,5.0));
        List<Double> result4 = Itertools.accumulateMultiply(arr4, 1.0);
        List<Double> comp4 = new ArrayList<>(Arrays.asList(1.0,1.0,2.0,6.0,24.0,120.0));
        assertEquals(comp4, result4);

        List<Integer> arr5 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result5 = Itertools.accumulateMultiply(arr5,100);
        List<Integer> comp5 = new ArrayList<>(Arrays.asList(100,100,200,600,2400,12000));
        assertEquals(comp5, result5);
    }

    @Test
    @DisplayName("accumulateMinus test")
    public void accumulateMinusTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result = Itertools.accumulateMinus(arr,0);
        List<Integer> comp = new ArrayList<>(Arrays.asList(0,-1,-3,-6,-10,-15));
        assertEquals(comp, result);

        List<Float> arr2 = new ArrayList<>(Arrays.asList(1.5F,2.5F,3.5F,4.5F,5.5F));
        List<Float> result2 = Itertools.accumulateMinus(arr2,0F);
        List<Float> comp2 = new ArrayList<>(Arrays.asList(0.0F,-1.5F,-4.0F,-7.5F,-12.0F,-17.5F));
        assertEquals(comp2, result2);

        List<Long> arr3 = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<Long> result3 = Itertools.accumulateMinus(arr3,0L);
        List<Long> comp3 = new ArrayList<>(Arrays.asList(0L,-1L,-3L,-6L,-10L,-15L));
        assertEquals(comp3, result3);

        List<Double> arr4 = new ArrayList<>(Arrays.asList(1.5,2.5,3.5,4.5,5.5));
        List<Double> result4 = Itertools.accumulateMinus(arr4, 0.0);
        List<Double> comp4 = new ArrayList<>(Arrays.asList(0.0,-1.5,-4.0,-7.5,-12.0,-17.5));
        assertEquals(comp4, result4);

        List<Integer> arr5 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result5 = Itertools.accumulateMinus(arr5,100);
        List<Integer> comp5 = new ArrayList<>(Arrays.asList(100,99,97,94,90,85));
        assertEquals(comp5, result5);
    }

    @Test
    @DisplayName("accumulateDivide test")
    public void accumulateDivideTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        List<Integer> result = Itertools.accumulateDivide(arr,120);
        List<Integer> comp = new ArrayList<>(Arrays.asList(120,24,6,2,1,1));
        assertEquals(comp, result);

        List<Float> arr2 = new ArrayList<>(Arrays.asList(5.0F,4.0F,3.0F,2.0F,1.0F));
        List<Float> result2 = Itertools.accumulateDivide(arr2,120F);
        List<Float> comp2 = new ArrayList<>(Arrays.asList(120.0F,24.0F,6.0F,2.0F,1.0F,1.0F));
        assertEquals(comp2, result2);

        List<Long> arr3 = new ArrayList<>(Arrays.asList(5L,4L,3L,2L,1L));
        List<Long> result3 = Itertools.accumulateDivide(arr3,120L);
        List<Long> comp3 = new ArrayList<>(Arrays.asList(120L,24L,6L,2L,1L,1L));
        assertEquals(comp3, result3);

        List<Double> arr4 = new ArrayList<>(Arrays.asList(5.0,4.0,3.0,2.0,1.0));
        List<Double> result4 = Itertools.accumulateDivide(arr4, 120.0);
        List<Double> comp4 = new ArrayList<>(Arrays.asList(120.0,24.0,6.0,2.0,1.0,1.0));
        assertEquals(comp4, result4);
    }

    @Test
    @DisplayName("accumulateRemain test")
    public void accumulateRemainTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        List<Integer> result = Itertools.accumulateRemain(arr,120);
        List<Integer> comp = new ArrayList<>(Arrays.asList(120,0,0,0,0,0));
        assertEquals(comp, result);

        List<Float> arr2 = new ArrayList<>(Arrays.asList(5.0F,4.0F,3.0F,2.0F,1.0F));
        List<Float> result2 = Itertools.accumulateRemain(arr2,120F);
        List<Float> comp2 = new ArrayList<>(Arrays.asList(120.0F,0.0F,0.0F,0.0F,0.0F,0.0F));
        assertEquals(comp2, result2);

        List<Long> arr3 = new ArrayList<>(Arrays.asList(5L,4L,3L,2L,1L));
        List<Long> result3 = Itertools.accumulateRemain(arr3,120L);
        List<Long> comp3 = new ArrayList<>(Arrays.asList(120L,0L,0L,0L,0L,0L));
        assertEquals(comp3, result3);

        List<Double> arr4 = new ArrayList<>(Arrays.asList(5.0,4.0,3.0,2.0,1.0));
        List<Double> result4 = Itertools.accumulateRemain(arr4, 120.0);
        List<Double> comp4 = new ArrayList<>(Arrays.asList(120.0,0.0,0.0,0.0,0.0,0.0));
        assertEquals(comp4, result4);

        List<Integer> arr5 = new ArrayList<>(Arrays.asList(100,10,1));
        List<Integer> result5 = Itertools.accumulateRemain(arr5,123);
        List<Integer> comp5 = new ArrayList<>(Arrays.asList(123,23,3,0));
        assertEquals(comp5, result5);
    }

    @Test
    @DisplayName("chain test")
    public void chainTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("ABC","DEFG"));
        char comp = 'A';
        for (String result : Itertools.chain(arr)) {
            assertEquals(Character.toString(comp), result);
            comp++;
        }
    }

    @Test
    @DisplayName("compress test")
    public void compressTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        boolean[] selectors = {true,false,true,false,true,true};
        List<String> result = Itertools.compress(arr,selectors);
        List<String> comp = new ArrayList<>(Arrays.asList("A","C","E","F"));
        assertEquals(comp, result);

        List<String> arr2 = new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        boolean[] selectors2 = {true,false,true,false,true};
        assertThrows(IllegalArgumentException.class, () -> Itertools.compress(arr2,selectors2));
    }

    @Test
    @DisplayName("cycle test")
    public void cycleTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","B","C","D"));
        int count = 0;
        for (String result : Itertools.cycle(arr)) {
            assertEquals(arr.get(count % 4), result);
            count++;
            if(count > 10) break;
        }

        List<String> arr2 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.cycle(arr2));
    }

    @Test
    @DisplayName("dropWhile test")
    public void dropWhileTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,4,6,4,1));
        int[] comp = {6,4,1};
        int idx = 0;
        for (Integer result : Itertools.dropWhile(integer -> (integer < 5),arr)) {
            assertEquals(comp[idx], result);
            idx++;
        }

        List<Integer> arr2 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.dropWhile(integer -> (integer < 5),arr2));
    }

    @Test
    @DisplayName("filterFalse test")
    public void filterFalseTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        int[] comp = {0,2,4,6,8};
        int idx = 0;
        for (Integer result : Itertools.filterFalse(integer -> (integer % 2 == 0),arr)) {
            assertEquals(comp[idx], result);
            idx++;
        }

        List<Integer> arr2 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.filterFalse(integer -> (integer % 2 == 0),arr2));
    }

    @Test
    @DisplayName("groupBy test")
    public void groupByTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","A","A","A","B","B","B","C","C","D","B"));
        List<String> result = Itertools.groupBy(arr);
        List<String> comp = new ArrayList<>(Arrays.asList("A","B","C","D","B"));
        assertEquals(comp, result);

        List<Integer> arr2 = new ArrayList<>(Arrays.asList(0,0,1,1,1,2,2,3,3,1));
        List<Integer> result2 = Itertools.groupBy(arr2);
        List<Integer> comp2 = new ArrayList<>(Arrays.asList(0,1,2,3,1));
        assertEquals(comp2, result2);

        List<Integer> arr3 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.groupBy(arr3));
    }

    @Test
    @DisplayName("iSlice test")
    public void iSliceTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G"));
        List<String> result = Itertools.iSlice(arr,0,2,1);
        List<String> comp = new ArrayList<>(Arrays.asList("A","B"));
        assertEquals(comp, result);

        result = Itertools.iSlice(arr,2,4,1);
        comp = new ArrayList<>(Arrays.asList("C","D"));
        assertEquals(comp, result);

        result = Itertools.iSlice(arr,2,arr.size(),1);
        comp = new ArrayList<>(Arrays.asList("C","D","E","F","G"));
        assertEquals(comp, result);

        result = Itertools.iSlice(arr,0,arr.size(),2);
        comp = new ArrayList<>(Arrays.asList("A","C","E","G"));
        assertEquals(comp, result);

        List<String> arr2 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.iSlice(arr2, 0, arr.size(), 1));
    }

    @Test
    @DisplayName("product test")
    public void productTest() {
        List<String> result = Itertools.product(Arrays.asList("A","B","C","D"), Arrays.asList("x","y"));
        List<String> comp = new ArrayList<>(Arrays.asList("Ax", "Ay", "Bx", "By", "Cx", "Cy", "Dx", "Dy"));
        assertEquals(comp, result);

        List<String> result2 = Itertools.product(Arrays.asList("0","1"), 3);
        List<String> comp2 = new ArrayList<>(Arrays.asList("000", "001", "010", "011", "100", "101", "110", "111"));
        assertEquals(comp2, result2);

        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        List<String> arr3 = new ArrayList<>(Arrays.asList("A","B","C","D"));
        assertThrows(IllegalArgumentException.class, () -> Itertools.product(arr1, 3));
        assertThrows(IllegalArgumentException.class, () -> Itertools.product(arr1, arr2));
        assertThrows(IllegalArgumentException.class, () -> Itertools.product(arr3, arr2));
        assertThrows(IllegalArgumentException.class, () -> Itertools.product(arr1, arr3));
    }

    @Test
    @DisplayName("repeat test")
    public void repeatTest() {
        int  comp= 10;
        for (int result : Itertools.repeat(10, 3)) {
            assertEquals(comp, result);
        }
    }

    @Test
    @DisplayName("takeWhile test")
    public void takeWhileTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,4,6,4,1));
        int[] comp = {1,4};
        int idx = 0;
        for (Integer result : Itertools.takeWhile(integer -> (integer < 5),arr)) {
            assertEquals(comp[idx], result);
            idx++;
        }

        List<Integer> arr2 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Itertools.takeWhile(integer -> (integer < 5),arr2));
    }

    @Test
    @DisplayName("tee test")
    public void teeTest() {
        List<String> arr = new ArrayList<>(Arrays.asList("ABC","DEFG"));
        char comp = 'A';
        for (String result : Itertools.tee(arr,3)) {
            assertEquals(Character.toString(comp), result);
            comp++;
            if(comp == 'H') comp = 'A';
        }
    }

    @Test
    @DisplayName("zipLongest test")
    public void zipLongestTest() {
        List<String> result = Itertools.zipLongest(Arrays.asList("A","B","C","D"), Arrays.asList("x","y"), "-");
        List<String> comp = new ArrayList<>(Arrays.asList("Ax", "By", "C-", "D-"));
        assertEquals(comp, result);

        List<String> result2 = Itertools.zipLongest(Arrays.asList("A","B","C","D"), "-");
        List<String> comp2 = new ArrayList<>(Arrays.asList("A-", "B-", "C-", "D-"));
        assertEquals(comp2, result2);

        List<String> arr = new ArrayList<>();
        List<String> arr2 = new ArrayList<>(Arrays.asList("A","B","C","D"));
        List<String> arr3 = new ArrayList<>(Arrays.asList("x","y"));
        assertThrows(IllegalArgumentException.class, () -> Itertools.zipLongest(arr, "-"));
        assertThrows(IllegalArgumentException.class, () -> Itertools.zipLongest(arr, arr2,"-"));
        assertThrows(IllegalArgumentException.class, () -> Itertools.zipLongest(arr3, arr2, "-"));
    }
}
