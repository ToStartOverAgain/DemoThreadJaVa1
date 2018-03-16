/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothread;

import static java.lang.Thread.sleep;
import javafx.util.Duration;
import static javafx.util.Duration.millis;

/**
 *
 * @author Admin
 */
public class DemoThread {

    public static void main(String[] args) throws InterruptedException {

        Account acc = new Account();
        acc.setBalance(0);

        Thread guitien = new Thread() {
            @Override
            public synchronized void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                acc.deposit(20000);
                notifyAll();
                System.out.println(this.getName() + " - deposit success.");
            }
        };

        Thread ruttien1 = new Thread() {
            @Override
            public void run() {
                while (!acc.withdraw(7000)) {
                    System.out.println(this.getName() + " - withdraw fails.");
                    try {
                        sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + " - withdraw success.");
                System.out.println(this.getName() + " - account balance: " + acc.getBalance());
            }
        };

        Thread ruttien2 = new Thread() {
            @Override
            public void run() {
                while (!acc.withdraw(7000)) {
                    System.out.println(this.getName() + " - withdraw fails.");
                    try {
                        sleep(2 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + " - withdraw success.");
                System.out.println(this.getName() + " - account balance: " + acc.getBalance());
            }
        };
        ruttien1.setName("RÃºt tiá»�n 1");
        ruttien2.setName("RÃºt tiá»�n 2");
        guitien.setName("Gá»­i tiá»�n");
        ruttien1.start();
        ruttien2.start();
        guitien.start();

        ruttien1.join();
        ruttien2.join();
        guitien.join();

        System.out.println(acc.getBalance());
    }
}
