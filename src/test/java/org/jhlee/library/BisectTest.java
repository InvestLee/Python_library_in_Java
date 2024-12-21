package org.jhlee.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BisectTest {

    @Test
    @DisplayName("bisectLeft test")
    public void bisectLeftTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        assertEquals(0, Bisect.bisectLeft(arr,0));
        assertEquals(2, Bisect.bisectLeft(arr,25));
        assertEquals(4, Bisect.bisectLeft(arr,50));
        assertEquals(7, Bisect.bisectLeft(arr,75));
        assertEquals(9, Bisect.bisectLeft(arr,100));
        assertEquals(10, Bisect.bisectLeft(arr,125));

        assertEquals(2, Bisect.bisectLeft(arr,0,2,8));
        assertEquals(4, Bisect.bisectLeft(arr,50,2,8));
        assertEquals(8, Bisect.bisectLeft(arr,100,2,8));

        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,-1,8));
        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,2,11));
    }

    @Test
    @DisplayName("bisectRight test")
    public void bisectRightTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        assertEquals(0, Bisect.bisectRight(arr,0));
        assertEquals(2, Bisect.bisectRight(arr,25));
        assertEquals(5, Bisect.bisectRight(arr,50));
        assertEquals(7, Bisect.bisectRight(arr,75));
        assertEquals(10, Bisect.bisectRight(arr,100));
        assertEquals(10, Bisect.bisectRight(arr,125));

        assertEquals(2, Bisect.bisectRight(arr,0,2,8));
        assertEquals(5, Bisect.bisectRight(arr,50,2,8));
        assertEquals(8, Bisect.bisectRight(arr,100,2,8));

        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,-1,8));
        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,2,11));
    }

    @Test
    @DisplayName("insortLeft test")
    public void insortLeftTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        assertEquals(Arrays.asList(0, 10, 20, 30, 40, 50), Bisect.insortLeft(arr,0));
        assertEquals(Arrays.asList(10, 15, 20, 30, 40, 50), Bisect.insortLeft(arr,15));
        assertEquals(Arrays.asList(10, 20, 30, 30, 40, 50), Bisect.insortLeft(arr,30));
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 50), Bisect.insortLeft(arr,50));
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 100), Bisect.insortLeft(arr,100));

        assertEquals(Arrays.asList(10, 0, 20, 30, 40, 50), Bisect.insortLeft(arr,0,1,4));
        assertEquals(Arrays.asList(10, 15, 20, 30, 40, 50), Bisect.insortLeft(arr,15,1,4));
        assertEquals(Arrays.asList(10, 20, 30, 30, 40, 50), Bisect.insortLeft(arr,30,1,4));
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 50), Bisect.insortLeft(arr,50,1,4));
        assertEquals(Arrays.asList(10, 20, 30, 40, 100, 50), Bisect.insortLeft(arr,100,1,4));

        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,-1,4));
        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,2,6));
    }

    @Test
    @DisplayName("insortRight test")
    public void insortRightTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        assertEquals(Arrays.asList(0, 10, 20, 30, 40, 50), Bisect.insortRight(arr,0));
        assertEquals(Arrays.asList(10, 15, 20, 30, 40, 50), Bisect.insortRight(arr,15));
        assertEquals(Arrays.asList(10, 20, 30, 30, 40, 50), Bisect.insortRight(arr,30));
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 50), Bisect.insortRight(arr,50));
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 100), Bisect.insortRight(arr,100));

        assertEquals(Arrays.asList(10, 0, 20, 30, 40, 50), Bisect.insortRight(arr,0,1,4));
        assertEquals(Arrays.asList(10, 15, 20, 30, 40, 50), Bisect.insortRight(arr,15,1,4));
        assertEquals(Arrays.asList(10, 20, 30, 30, 40, 50), Bisect.insortRight(arr,30,1,4));
        assertEquals(Arrays.asList(10, 20, 30, 40, 50, 50), Bisect.insortRight(arr,50,1,4));
        assertEquals(Arrays.asList(10, 20, 30, 40, 100, 50), Bisect.insortRight(arr,100,1,4));

        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,-1,4));
        assertThrows(IllegalArgumentException.class, () -> Bisect.bisectLeft(arr,0,2,6));
    }
}
