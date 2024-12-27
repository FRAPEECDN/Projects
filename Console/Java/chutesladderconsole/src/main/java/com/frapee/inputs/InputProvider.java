package com.frapee.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Input from consoler - providing what was selected
 */
public class InputProvider {
    
    private static BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Allow Integer to be provided
     * @return Integer entered via keyboard
     */
    public static int provideInteger() {
        int intInput = 0;
        do {
            try {
                System.out.println("Please provide a integer");
                intInput = Integer.parseInt(bfn.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error");
            }
        } while (intInput == 0);
        return intInput;
    }

    /**
     * Allow String to be provided
     * @return string entered via keyboard
     */
    public static String provideString() {
        String strInput = "";
        Pattern pattern = Pattern.compile("^[a-z]+$");
        boolean result = false;        
        do {
            try {
                System.out.println("Please provide a small character string");
                strInput = bfn.readLine();
                result = pattern.matcher(strInput).find();
            } catch (IOException e) {
                System.out.println("Error");
            }
        } while (!result);
        return strInput;        
    }    
}
