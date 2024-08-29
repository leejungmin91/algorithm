package hackerrank;

import java.util.Arrays;

public class ElectronicsShop {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int price = Integer.MIN_VALUE;

        for(int keyboard : keyboards) {
            for(int drive : drives) {
                if(keyboard+drive <= b) {
                    price = Math.max(price, keyboard+drive);
                }
            }
        }

        return price == Integer.MIN_VALUE ? -1 : price;
    }

}
