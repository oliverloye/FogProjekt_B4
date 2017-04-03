package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Itemshop {

    public static void main(String[] args) {
        ItemHelper itemHelper = new ItemHelper();

        int input = menu();
        while (input != 0) {
            switch (input) {
                case 1: {
                    addItem();
                }
                case 2: {

                }
                case 3: {

                }
               System.exit(0);
            }
        }

        itemHelper.add("111", "name", 343,1);
        itemHelper.add("111", "nae", 34,5);
        itemHelper.add("131", "name", 34,0);

        Item someItem = itemHelper.get("111");

        System.out.println(someItem.itemCode + "\t" + someItem.name + "\t" + someItem.quantity + "\t" + someItem.rate);

        itemHelper.changePrice("111", 34908);

        someItem = itemHelper.get("111");

        System.out.println(someItem.itemCode + "\t" + someItem.name + "\t" + someItem.quantity + "\t" + someItem.rate);
    }

    private static void addItem() {
    }

    public static int menu() {
        int input = -1;

        System.out.println("Enter one of the following options \n" +
                "\t1) Add item\n" +
                "\t2) Get item\n" +
                "\t3) Update item name" +
                "\t0) Exit");

        Scanner scanner = new Scanner(System.in);

        try {
            input = scanner.nextInt();
        } catch (InputMismatchException ignored) {
        }

        return input;
    }

}