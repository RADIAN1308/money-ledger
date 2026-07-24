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
    System.out.println("1. Add Income\n2. Add Expense\n3. View Ledger\n4. Exit");
    System.out.println("Enter your choice:  ");
  }

  private void readChoice() {
    boolean running = true;

    while (running) {
      System.out.println("Waiting for input...");
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("You selected Add Income");
          addTransaction(TransactionType.INCOME);
          break;
        case 2:
          System.out.println("You selected Add Expense");
          addTransaction(TransactionType.EXPENSE);
          break;
        case 3:
          System.out.println("You selected View Ledger");
          break;
        case 4:
          System.out.println("Exiting program....");
          running = false;
          break;
        default:
          System.out.println("Invalid Option Try Again");
      }
      if (running)
        printMenu();
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
      choice = sc.nextInt();
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
      System.out.println("Enter your monthly salary: ");
      amount = sc.nextDouble();
      category = " ";
    } else {
      System.out.println("Choose the category of expenditure");
      System.out.println("1. Food\n2. Travel\n3. Shopping\n4. Entertainment");
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
      sc.nextLine();
      System.out.println("Add a description (Press enter to skip): ");
      description = sc.nextLine();
    }
    Transaction transaction = new Transaction(amount, category, description, type);
    bookKeeper.addTransaction(transaction);

  }

}
