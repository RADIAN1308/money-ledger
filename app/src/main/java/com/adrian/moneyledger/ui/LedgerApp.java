package com.adrian.moneyledger.ui;

import java.util.Scanner;

import com.adrian.moneyledger.model.TransactionType;
import com.adrian.moneyledger.service.LedgerService;

import com.adrian.moneyledger.model.Transaction;

public class LedgerApp {

  private int choice;
  private final Scanner sc = new Scanner(System.in);
  private final LedgerService bookKeeper = new LedgerService();

  public void run() {
    printBanner();
    printMenu();
    readChoice();
  }

  private void printBanner() {

    System.out.println("====================");
    System.out.println("    MONEY LEDGER  ");
    System.out.println("====================");
  }

  private void printMenu() {
    System.out.println("1. Add Income\n2. Add Expense\n3. View Ledger\n4. Exit\n");
    System.out.println("Enter your choice:  ");
  }

  private void readChoice() {
    boolean running = true;

    while (running) {
      System.out.println("\nWaiting for input...\n\n");
      choice = sc.nextInt();
      System.out.println();
      switch (choice) {
        case 1:
          System.out.println("You selected Add Income");
          addTransaction(TransactionType.INCOME);
          System.out.println();
          break;
        case 2:
          System.out.println("You selected Add Expense");
          addTransaction(TransactionType.EXPENSE);
          System.out.println();
          break;
        case 3:
          System.out.println("You selected View Ledger");
          viewLedger();
          System.out.println();
          break;
        case 4:
          System.out.println("Exiting program....");
          running = false;
          System.out.println();
          break;
        default:
          System.out.println("Invalid Option Try Again");
          System.out.println();
      }
      if (running)
        System.out.println();
      printMenu();
      System.out.println();
    }
  }

  private void addTransaction(TransactionType type) {
    double amount = 0;
    String description = "";
    String category = "";
    int choice = 0;

    if (type == TransactionType.INCOME) {

      System.out.println("Choose source of income: ");
      System.out.println("1. Salary\n2. Freelance\n3. Internship\n4. Allowance");
      System.out.println();
      choice = sc.nextInt();
      System.out.println();
      switch (choice) {
        case 1:
          category = "Salary";
          break;
        case 2:
          category = "Freelance";
          break;
        case 3:
          category = "Internship";
          break;
        case 4:
          category = "Allowance";
          break;
        default:
          throw new IllegalArgumentException("Invalid category");
      }
      System.out.println();
      System.out.println("Enter amount: ");
      System.out.println();
      amount = sc.nextDouble();
    } else {
      System.out.println();
      System.out.println("Choose the category of expenditure");
      System.out.println("1. Food\n2. Travel\n3. Shopping\n4. Entertainment");
      System.out.println();
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          category = "Food";
          break;
        case 2:
          category = "Travel";
          break;
        case 3:
          category = "Shopping";
          break;
        case 4:
          category = "Entertainment";
          break;
        default:
          throw new IllegalArgumentException("Invalid category");
      }
      System.out.println();
      System.out.println("Enter amount: ");
      System.out.println();
      amount = sc.nextDouble();
      sc.nextLine();
      System.out.println();
      System.out.println("Add a description (Press enter to skip): ");
      System.out.println();
      description = sc.nextLine();
    }
    Transaction transaction = new Transaction(amount, category, description, type);
    bookKeeper.addTransaction(transaction);

  }

  private void viewLedger() {
    System.out.println();
    if (bookKeeper.getTransactions().isEmpty()) {
      System.out.println("No transactions found");
      System.out.println();
      return;

    }
    System.out.println();
    for (Transaction transaction : bookKeeper.getTransactions()) {
      System.out.println();
      System.out.println("----------------------------");
      System.out.println("Type       : " + transaction.getType());
      System.out.println("Amount     : ₹" + transaction.getAmount());
      System.out.println("Category   : " + transaction.getCategory());
      System.out.println("Description: " + transaction.getDescription());
      System.out.println("Date       : " + transaction.getDate());
      System.out.println("----------------------------");
      System.out.println();
    }
    System.out.println();
  }
}
