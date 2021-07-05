package com.company;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        Port port = new Port(4, 5000, 1000);

        List<Ship> ships = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            ships.add(new Ship("Ship " + i, 260, 0, port));
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 4; i < 8; i++) {
            ships.add(new Ship("Ship " + i, 0, 300, port));
        }

        for (Ship ship : ships){
            try {
                ship.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все корабли выполнили свою задачу");
    }
}
