package greenfoxacademy.com.demo.model;

import java.text.DecimalFormat;

public class BankAccount {
    String name;
    Double balance;
    String strDouble;
    String animalType;
    Boolean isKing = false;

    public BankAccount(String name, Double balance, String animalType, Boolean isKing) {
        this.name = name;
        this.balance =balance;
        this.animalType = animalType;
        this.strDouble = String.format("%.2f", balance);
        this.isKing = isKing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getStrDouble() {
        return strDouble;
    }

    public void setStrDouble(String strDouble) {
        this.strDouble = strDouble;
    }

    public Boolean getKing() {
        return isKing;
    }

    public void setKing(Boolean king) {
        isKing = king;
    }
}
