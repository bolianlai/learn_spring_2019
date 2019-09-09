package cn.bolianlai.test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        test(list1);
        test(list2);
    }

    public static void test(ArrayList<?> list) {
        System.out.println();
    }
}
