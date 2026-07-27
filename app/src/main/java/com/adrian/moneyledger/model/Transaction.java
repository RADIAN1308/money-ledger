
package com.adrian.moneyledger.model;

import java.time.LocalDate;

public class Transaction {
  private double amount;
  private String category;
  private String description;
  private TransactionType type;
  private LocalDate date;

  public Transaction(double amount, String category, String description, TransactionType type) {
    this.amount = amount;
    this.category = category;
    this.description = description;
    this.type = type;
    this.date = LocalDate.now();
  }

  public double getAmount() {
    return amount;
  }

  public String getCategory() {
    return category;
  }

  public String getDescription() {
    return description;
  }

  public TransactionType getType() {
    return type;
  }

  public LocalDate getDate() {
    return date;
  }
}
