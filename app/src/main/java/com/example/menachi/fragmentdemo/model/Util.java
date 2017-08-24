package com.example.menachi.fragmentdemo.model;

/**
 * Created by Aviv Gold on 8/22/2017.
 */

public class Util {
    public static int[] strToArr(String str) {
        int[] arr = new int[96];
        String[] strs = str.split(" ");
        for (int i = 0; i < 96; i++)
            arr[i]+=(Integer.parseInt(strs[i]));
        return arr;
    }

}
