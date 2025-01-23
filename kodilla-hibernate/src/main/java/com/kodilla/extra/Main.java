package com.kodilla.extra;

public class Main {
    public static void main(String[] args) {
        Dodatkowe16_4 task = new Dodatkowe16_4();
        int[] nums = {3,1,1,5,6,7,9,15,3,4,7,10};

        try {
            System.out.println(task.findSecondMin(nums));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        try {
            System.out.println(task.findSecondMax(nums));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
