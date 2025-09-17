#Project Structure#

```
holiday-expenses-java/
├── src/
│ ├── main/java/com/example/expenses/
│ │ ├── Expenses.java
│ │ └── Main.java
│ └── test/java/com/example/expenses/
│ └── ExpensesTest.java
└── pom.xml
```

##How to Run##

###1. Compile###
`mvn compile`

###2. Run with CLI arguments###
`mvn exec:java -Dexec.mainClass="com.example.expenses.Main" -Dexec.args="Alice 60 Bob 120 Charlie 30"`

Example Output:

Expenses: {Alice=60.0, Bob=120.0, Charlie=30.0}
Alice pays Bob $10.00
Charlie pays Bob $40.00
Number of transactions: 2

###How to Test###

Run the JUnit tests:
`mvn test`

###Usage Notes###
CLI input format: <Name1> <Amount1> <Name2> <Amount2> ...

Number of arguments must be even (name paired with an amount).

Example:

`java com.example.expenses.Main Zack 50 Ali 10 Sarah 40`

###Requirements###
Java 17+
Maven 3.8+
