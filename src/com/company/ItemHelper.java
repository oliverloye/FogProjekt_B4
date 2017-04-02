package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ItemHelper {
    private final ArrayList<Item> items;

    public ItemHelper() {
        items = new ArrayList<>();
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an item code");
        String itemCode = scanner.nextLine();

        try {
            validateItemCode(itemCode);
        } catch (RuntimeException e) {
            System.out.printf("Item code %s already exists \n", itemCode);
        }

        System.out.printf("Please enter a name for item code %s\n", itemCode);
        String name = scanner.nextLine();

        double rate = -1;
        while (rate != -1) {
            Scanner priceScanner = new Scanner(System.in);
            System.out.printf("Please enter a rate (price) for item code %s with name %s\n", itemCode, name);

            try {
                rate = scanner.nextDouble();
            } catch (InputMismatchException e) {
            }
        }

        System.out.println("Please enter a quantity");


        try {
            validateQuantity();
        } catch (InputMismatchException ignored) {
        }
    }

    private void validateItemCode(String itemCode) {
        long count = items.stream().filter((item) -> item.itemCode.equals(itemCode)).count();

        if (count == 1) {
            throw new RuntimeException(String.format("Item code %s already exists \n", itemCode));
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity was too small");
        }
    }

    public void add(String itemCode, String name, double rate, int quantity) {
        validateItemCode(itemCode);

        validateQuantity(quantity);

        items.add(new Item(itemCode, name, rate, quantity));

        System.out.println("item success fully added");
    }

    public Item get(String itemCode) {
        return items.stream()
            .filter((item) -> item.itemCode.equals(itemCode))
            .findFirst()
            .get();
    }

    public void changePrice(String itemCode, double rate) {
        Item result = items.stream()
            .filter((item) -> item.itemCode.equals(itemCode))
            .findFirst()
            .get();

        result.rate = rate;
    }

    private void validateQuantity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}