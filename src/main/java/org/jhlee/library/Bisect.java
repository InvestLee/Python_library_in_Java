package org.jhlee.library;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bisect {
    public static<T> int bisectLeft(List<T> arr, T x, int low, int high){
        if(low < 0){
            throw new IllegalArgumentException("The low value must be greater than or equal to 0.");
        }
        if(high > arr.size()){
            throw new IllegalArgumentException("The high value must be less than or equal to the arr length.");
        }

        boolean flag = false;
        while(low < high){
            int mid = (low + high) / 2;
            if(x instanceof Integer) {
                flag = (Integer) arr.get(mid) < (Integer) x;
            } else if(x instanceof Double) {
                flag = (Double) arr.get(mid) < (Double) x;
            } else if(x instanceof Float) {
                flag = (Float) arr.get(mid) < (Float) x;
            } else if(x instanceof Long) {
                flag = (Long) arr.get(mid) < (Long) x;
            } else if(x instanceof Byte) {
                flag = (Byte) arr.get(mid) < (Byte) x;
            } else if(x instanceof Short) {
                flag = (Short) arr.get(mid) < (Short) x;
            } else if(x instanceof BigDecimal) {
                flag = new BigDecimal(arr.get(mid).toString()).compareTo((BigDecimal) x) < 0;
            } else if(x instanceof String){
                flag = arr.get(mid).toString().compareTo(x.toString()) < 0;
            } else if(x instanceof Character) {
                flag = (Character) arr.get(mid) < (Character) x;
            }

            if(flag){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }

        return low;
    }

    public static<T> int bisectLeft(List<T> arr, T x){
        int low = 0;
        int high = arr.size();

        boolean flag = false;
        while(low < high){
            int mid = (low + high) / 2;
            if(x instanceof Integer) {
                flag = (Integer) arr.get(mid) < (Integer) x;
            } else if(x instanceof Double) {
                flag = (Double) arr.get(mid) < (Double) x;
            } else if(x instanceof Float) {
                flag = (Float) arr.get(mid) < (Float) x;
            } else if(x instanceof Long) {
                flag = (Long) arr.get(mid) < (Long) x;
            } else if(x instanceof Byte) {
                flag = (Byte) arr.get(mid) < (Byte) x;
            } else if(x instanceof Short) {
                flag = (Short) arr.get(mid) < (Short) x;
            } else if(x instanceof BigDecimal) {
                flag = new BigDecimal(arr.get(mid).toString()).compareTo((BigDecimal) x) < 0;
            } else if(x instanceof String){
                flag = arr.get(mid).toString().compareTo(x.toString()) < 0;
            } else if(x instanceof Character) {
                flag = (Character) arr.get(mid) < (Character) x;
            }

            if(flag){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }

        return low;
    }

    public static<T> int bisectRight(List<T> arr, T x, int low, int high){
        if(low < 0){
            throw new IllegalArgumentException("The low value must be greater than or equal to 0.");
        }
        if(high > arr.size()){
            throw new IllegalArgumentException("The high value must be less than or equal to the arr length.");
        }

        boolean flag = false;
        while(low < high){
            int mid = (low + high) / 2;
            if(x instanceof Integer) {
                flag = (Integer) arr.get(mid) > (Integer) x;
            } else if(x instanceof Double) {
                flag = (Double) arr.get(mid) > (Double) x;
            } else if(x instanceof Float) {
                flag = (Float) arr.get(mid) > (Float) x;
            } else if(x instanceof Long) {
                flag = (Long) arr.get(mid) > (Long) x;
            } else if(x instanceof Byte) {
                flag = (Byte) arr.get(mid) > (Byte) x;
            } else if(x instanceof Short) {
                flag = (Short) arr.get(mid) > (Short) x;
            } else if(x instanceof BigDecimal) {
                flag = new BigDecimal(arr.get(mid).toString()).compareTo((BigDecimal) x) > 0;
            } else if(x instanceof String){
                flag = arr.get(mid).toString().compareTo(x.toString()) > 0;
            } else if(x instanceof Character) {
                flag = (Character) arr.get(mid) > (Character) x;
            }

            if(flag){
                high = mid;
            }
            else{
                low = mid +1;
            }
        }

        return low;
    }

    public static<T> int bisectRight(List<T> arr, T x){
        int low = 0;
        int high = arr.size();

        boolean flag = false;
        while(low < high){
            int mid = (low + high) / 2;
            if(x instanceof Integer) {
                flag = (Integer) arr.get(mid) > (Integer) x;
            } else if(x instanceof Double) {
                flag = (Double) arr.get(mid) > (Double) x;
            } else if(x instanceof Float) {
                flag = (Float) arr.get(mid) > (Float) x;
            } else if(x instanceof Long) {
                flag = (Long) arr.get(mid) > (Long) x;
            } else if(x instanceof Byte) {
                flag = (Byte) arr.get(mid) > (Byte) x;
            } else if(x instanceof Short) {
                flag = (Short) arr.get(mid) > (Short) x;
            } else if(x instanceof BigDecimal) {
                flag = new BigDecimal(arr.get(mid).toString()).compareTo((BigDecimal) x) > 0;
            } else if(x instanceof String){
                flag = arr.get(mid).toString().compareTo(x.toString()) > 0;
            } else if(x instanceof Character) {
                flag = (Character) arr.get(mid) > (Character) x;
            }

            if(flag){
                high = mid;
            }
            else{
                low = mid +1;
            }
        }

        return low;
    }

    public static<T> List<T> insortLeft(List<T> arr, T x, int low, int high){
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

    public static<T> List<T> insortLeft(List<T> arr, T x){
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

    public static<T> List<T> insortRight(List<T> arr, T x, int low, int high){
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

    public static<T> List<T> insortRight(List<T> arr, T x){
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
