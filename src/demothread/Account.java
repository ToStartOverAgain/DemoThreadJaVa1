/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

/**
 *
 * @author Admin
 */
public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public synchronized boolean withdraw ( int amount){
        if (this.balance >= amount){
            this.balance -= amount;
            return true;
        }
        return false;
    }
    public synchronized void deposit ( int amount){
        this.balance+= amount;
    }
}
