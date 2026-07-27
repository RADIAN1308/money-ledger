package com.adrian.moneyledger.service;

import java.util.ArrayList;
import java.util.List;

import com.adrian.moneyledger.model.Transaction;
import com.adrian.moneyledger.storage.LedgerStorage;

public class LedgerService {
  private List<Transaction> transactions = new ArrayList<>();
  private final LedgerStorage fileManager = new LedgerStorage();

  public LedgerService() {
    transactions = fileManager.loadTransactions();
  }

  public void addTransaction(Transaction transaction) {

    transactions.add(transaction);
    fileManager.saveTransactions(transactions);
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
}
