package com.palarran.kitesizer.ui;

import java.util.Scanner;

import com.palarran.kitesizer.BelowMinimumWindSpeedException;
import com.palarran.kitesizer.KiteSizeService;

/**
 * Console based user interace.
 */
public class ConsoleUI {

    /**
     * Entry point method. Very simple console based UI.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight in pounds: ");
        int weight = scanner.nextInt();

        System.out.print("Enter your typical wind speed in knots:");
        int windSpeed = scanner.nextInt();

        KiteSizeService service = new KiteSizeService();

        try {
            int kiteSize = service.calculateKiteSize(weight, windSpeed);
            System.out.println(String.format("Your recommended kite size is %d square meters.", kiteSize));
        } catch (BelowMinimumWindSpeedException e) {
            System.out.println("The wind speed is too low to kite board.");
        } finally {
            scanner.close();
        }

    }

}
