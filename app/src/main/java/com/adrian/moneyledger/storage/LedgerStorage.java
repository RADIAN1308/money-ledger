package com.adrian.moneyledger.storage;

import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import com.adrian.moneyledger.model.Transaction;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LedgerStorage {
  private static final String FILE_NAME = "ledger.dat";

  public void saveTransactions(List<Transaction> transactions) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
      out.writeObject(transactions);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public List<Transaction> loadTransactions() {
    File file = new File(FILE_NAME);
    if (!file.exists()) {
      return new ArrayList<>();
    }
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
      return (List<Transaction>) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }

  }

}
