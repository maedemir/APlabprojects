package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ClockDisplay myclock = new ClockDisplay();
        myclock.timeTick();
        for (int i = 0; i < 3650; i++) {
            System.out.println(myclock.getTime());
            myclock.timeTick();
        }

    }
}
