package com.example.expenses;

import java.util.*;

public class Expenses {

    public static List<String> minimizeTransactions(Map<String, Double> expenses) {
        List<String> transactions = new ArrayList<>();
        int n = expenses.size();

        if (n == 0) {
            return transactions;
        }

        double total = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        double fairShare = total / n;

        // Calculate balances
        Map<String, Double> balances = new HashMap<>();
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            balances.put(entry.getKey(), entry.getValue() - fairShare);
        }

        // Separate debtors and creditors
        List<Map.Entry<String, Double>> debtors = new ArrayList<>();
        List<Map.Entry<String, Double>> creditors = new ArrayList<>();

        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            if (entry.getValue() < 0) {
                debtors.add(entry);
            } else if (entry.getValue() > 0) {
                creditors.add(entry);
            }
        }

        // Sort: most negative debtor first, most positive creditor first
        debtors.sort(Comparator.comparingDouble(Map.Entry::getValue));
        creditors.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        int i = 0, j = 0;

        while (i < debtors.size() && j < creditors.size()) {
            Map.Entry<String, Double> debtor = debtors.get(i);
            Map.Entry<String, Double> creditor = creditors.get(j);

            double debtAmt = debtor.getValue();
            double credAmt = creditor.getValue();

            double settle = Math.min(-debtAmt, credAmt);
            transactions.add(String.format("%s pays %s $%.2f", debtor.getKey(), creditor.getKey(), settle));

            debtor.setValue(debtAmt + settle);
            creditor.setValue(credAmt - settle);

            if (Math.abs(debtor.getValue()) < 1e-9) i++;
            if (Math.abs(creditor.getValue()) < 1e-9) j++;
        }

        return transactions;
    }
}
