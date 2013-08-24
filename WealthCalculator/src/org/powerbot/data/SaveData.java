/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.powerbot.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.powerbot.main.WealthCalculator;

/**
 *
 * @author Algathonix
 */
public class SaveData {

    private int showDialog() {
        int reply = JOptionPane.showConfirmDialog(null, "Save results?",
                "Do you want to save your results?",
                JOptionPane.YES_NO_OPTION);
        return reply;
    }

    public void SaveData() {
        String location = "";
        if (showDialog() == JOptionPane.YES_OPTION) {
            BufferedWriter output = null;
            try {
                location = new WealthCalculator().getWealthFile().getPath();
                output = new BufferedWriter(new FileWriter(new WealthCalculator().getWealthFile()));
                output.write("Thank you for using 'Algathonix Wealth Calculator' "
                        + "feel free to "
                        + System.getProperty("line.separator")
                        + System.getProperty("line.separator")
                        + "Item - Value - Amount"
                        + System.getProperty("line.separator")
                        + "Contact me at: Algathonix@gmail.com or on the"
                        + " website for suggestions"
                        + System.getProperty("line.separator")
                        + Data.getAllItems().toString()
                        + "\r\n\r\n____________________\r\n"
                        + "Total Wealth: " + Data.getTotalPrice() + "gp");
                output.close();
                JOptionPane.showMessageDialog(null, "File saved to location: " 
                        + location);
            } catch (IOException ex) {
                Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }
    }
}
