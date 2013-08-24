/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.powerbot.data;

/**
 *
 * @author Algathonix
 */
public class Summary {

    private StringBuilder sb = new StringBuilder();
    private int totalValue;

    public void addItem(String name, int price, int amount) {
        sb.append(name).append(" ").append(price).append("gp ").
                append(amount).append("x").
                append(System.getProperty("line.separator"));
        System.out.println(name + " " + price + " " + amount);
        totalValue = totalValue + (price * amount);
        Data.setAllItems(sb);
        Data.setLastItemString(name + " " + price + " " + amount);
        Data.setTotalPrice(totalValue);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
