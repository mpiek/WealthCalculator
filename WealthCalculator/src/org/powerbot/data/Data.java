/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.powerbot.data;

/**
 *
 * @author Algathonix
 */
public class Data {
    
    public static long TotalPrice = 0;
    public static String LastItemString = "";
    public static StringBuilder AllItems = null;

    public static long getTotalPrice() {
        return TotalPrice;
    }

    public static void setTotalPrice(long TotalPrice) {
        Data.TotalPrice = TotalPrice;
    }

    public static String getLastItemString() {
        return LastItemString;
    }

    public static void setLastItemString(String LastItemString) {
        Data.LastItemString = LastItemString;
    }

    public static StringBuilder getAllItems() {
        return AllItems;
    }

    public static void setAllItems(StringBuilder AllItems) {
        Data.AllItems = AllItems;
    }
    
    
    
}
