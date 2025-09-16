package com.example.expenses;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExpensesTest {

    @Test
    void testThreePeople() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Alice", 60.0);
        expenses.put("Bob", 120.0);
        expenses.put("Charlie", 30.0);

        List<String> result = Expenses.minimizeTransactions(expenses);
        assertEquals(2, result.size());
        assertTrue(result.contains("Alice pays Bob $10.00"));
        assertTrue(result.contains("Charlie pays Bob $40.00"));
    }

    @Test
    void testTwoPeople() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Ali", 10.0);
        expenses.put("Zack", 30.0);

        List<String> result = Expenses.minimizeTransactions(expenses);
        assertEquals(1, result.size());
        assertTrue(result.contains("Ali pays Zack $10.00"));
    }

    @Test
    void testEqualPayments() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("A", 50.0);
        expenses.put("B", 50.0);
        expenses.put("C", 50.0);

        List<String> result = Expenses.minimizeTransactions(expenses);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSinglePerson() {
        Map<String, Double> expenses = new HashMap<>();
        expenses.put("Solo", 100.0);

        List<String> result = Expenses.minimizeTransactions(expenses);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNoExpenses() {
        Map<String, Double> expenses = new HashMap<>();

        List<String> result = Expenses.minimizeTransactions(expenses);
        assertTrue(result.isEmpty());
    }
}
