package com.adrian.moneyledger.service;

import java.util.ArrayList;
import java.util.List;

import com.adrian.moneyledger.model.Transaction;

public class LedgerService {
  private List<Transaction> transactions = new ArrayList<>();

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public List<Transaction> getHistory() {
    return transactions;
  }

}
