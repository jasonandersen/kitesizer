package com.palarran.kitesizer.ui;

import java.util.Scanner;

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
        String weight = scanner.next();
        System.out.print("Enter your typical wind speed in knots:");
        String windSpeed = scanner.next();

        KiteSizeRequest request = new KiteSizeRequest(weight, windSpeed);
        System.out.println(request.getResponseText());

        scanner.close();

    }

}
