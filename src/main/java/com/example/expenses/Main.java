package com.example.expenses;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || args.length % 2 != 0) {
            System.out.println("Usage: java com.example.expenses.Main <Name1> <Amount1> <Name2> <Amount2> ...");
            return;
        }

        Map<String, Double> expenses = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            String name = args[i];
            double amount;
            try {
                amount = Double.parseDouble(args[i + 1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount for " + name + ": " + args[i + 1]);
                return;
            }

            expenses.put(name, expenses.getOrDefault(name, 0.0) + amount);
        }

        System.out.println("Expenses: " + expenses);

        List<String> transactions = Expenses.minimizeTransactions(expenses);
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("Number of transactions: " + transactions.size());
    }
}
