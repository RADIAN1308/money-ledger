package com.adrian.moneyledger.ui;

import java.util.Scanner;

public class LedgerApp {

  private int choice;
  private final Scanner sc = new Scanner(System.in);

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
          break;
        case 2:
          System.out.println("You selected Add Expense");
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
    }
  }

}
