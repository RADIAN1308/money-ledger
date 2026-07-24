
package com.adrian.moneyledger.model;

import java.time.LocalDate;

public class Transaction {
  private double amount;
  private String category;
  private String description;
  private TransactionType type;
  private LocalDate time;

  public Transaction(double amount, String category, String description, TransactionType type) {
    this.amount = amount;
    this.category = category;
    this.description = description;
    this.type = type;
    this.time = LocalDate.now();
  }
}
