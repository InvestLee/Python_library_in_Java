package org.jhlee.library;

import java.util.ArrayList;
import java.util.List;

public class Bisect {
    public static <T extends Comparable<T>> int bisectLeft(List<T> arr, T x, int low, int high) {
        if (low < 0) {
            throw new IllegalArgumentException("The low value must be greater than or equal to 0.");
        }
        if (high > arr.size()) {
            throw new IllegalArgumentException("The high value must be less than or equal to the array length.");
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            T midValue = arr.get(mid);

            if (midValue.compareTo(x) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static<T extends Comparable<T>>int bisectLeft(List<T> arr, T x){
        int low = 0;
        int high = arr.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            T midValue = arr.get(mid);

            if (midValue.compareTo(x) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static<T extends Comparable<T>> int bisectRight(List<T> arr, T x, int low, int high){
        if(low < 0){
            throw new IllegalArgumentException("The low value must be greater than or equal to 0.");
        }
        if(high > arr.size()){
            throw new IllegalArgumentException("The high value must be less than or equal to the arr length.");
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            T midValue = arr.get(mid);

            if (midValue.compareTo(x) > 0) {
                high = mid;
            } else {
                low = mid +1;
            }
        }

        return low;
    }

    public static<T extends Comparable<T>> int bisectRight(List<T> arr, T x){
        int low = 0;
        int high = arr.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            T midValue = arr.get(mid);

            if (midValue.compareTo(x) > 0) {
                high = mid;
            } else {
                low = mid +1;
            }
        }

        return low;
    }

    public static<T extends Comparable<T>> List<T> insortLeft(List<T> arr, T x, int low, int high){
        if(low < 0){
            throw new IllegalArgumentException("The low value must be greater than or equal to 0.");
        }
        if(high > arr.size()){
            throw new IllegalArgumentException("The high value must be less than or equal to the arr length.");
        }
        List<T> result = new ArrayList<>();
        int insertIndex = bisectLeft(arr,x,low,high);
        for(int i = 0; i < insertIndex; i++){
            result.add(arr.get(i));
        }
        result.add(x);
        for(int i = insertIndex; i < arr.size(); i++){
            result.add(arr.get(i));
        }
        return result;
    }

    public static<T extends Comparable<T>> List<T> insortLeft(List<T> arr, T x){
        int low = 0;
        int high = arr.size();
        List<T> result = new ArrayList<>();
        int insertIndex = bisectLeft(arr,x);
        for(int i = 0; i < insertIndex; i++){
            result.add(arr.get(i));
        }
        result.add(x);
        for(int i = insertIndex; i < arr.size(); i++){
            result.add(arr.get(i));
        }
        return result;
    }

    public static<T extends Comparable<T>> List<T> insortRight(List<T> arr, T x, int low, int high){
        if(low < 0){
            throw new IllegalArgumentException("The low value must be greater than or equal to 0.");
        }
        if(high > arr.size()){
            throw new IllegalArgumentException("The high value must be less than or equal to the arr length.");
        }
        List<T> result = new ArrayList<>();
        int insertIndex = bisectRight(arr,x,low,high);
        for(int i = 0; i < insertIndex; i++){
            result.add(arr.get(i));
        }
        result.add(x);
        for(int i = insertIndex; i < arr.size(); i++){
            result.add(arr.get(i));
        }
        return result;
    }

    public static<T extends Comparable<T>> List<T> insortRight(List<T> arr, T x){
        int low = 0;
        int high = arr.size();
        List<T> result = new ArrayList<>();
        int insertIndex = bisectRight(arr,x);
        for(int i = 0; i < insertIndex; i++){
            result.add(arr.get(i));
        }
        result.add(x);
        for(int i = insertIndex; i < arr.size(); i++){
            result.add(arr.get(i));
        }
        return result;
    }
}
