/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.powerbot.main;

import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import org.powerbot.data.Data;
import org.powerbot.data.Time;
import org.powerbot.event.PaintListener;
import org.powerbot.node.Bank;
import org.powerbot.script.util.Random;
import org.powerbot.node.Node;
import org.powerbot.node.PriceChecker;
import org.powerbot.paint.PaintUtilities;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

/**
 *
 * @author Algathonix
 */
@Manifest(authors = {"Algathonix"}, name = "Wealth Checker",
        description = "Measures the total value of your bank")
public class WealthCalculator extends PollingScript implements PaintListener {

    private final ArrayList<Node> nodes = new ArrayList<>();
    private final PaintUtilities pu = new PaintUtilities();
    private final Time t = new Time();
    private final File wealthFile = new File(this.getStorageDirectory(), "AlgathonixTotalWealth.txt");

    public File getWealthFile() {
        return wealthFile;
    }
    
    

    public WealthCalculator() {
        Collections.addAll(nodes, new Bank(ctx), new PriceChecker(ctx));
    }

    @Override
    public int poll() {
        for (final Node node : nodes) {
            if (node.validate()) {
                node.execute();
                return Random.nextInt(250, 375);
            }
        }
        return 0;
    }

    @Override
    public void repaint(Graphics grphcs) {
        grphcs.drawImage(pu.getImage(), 566, 100, null);
        grphcs.drawString(Long.toString(Data.getTotalPrice()), 610, 123);
        grphcs.drawString(t.getTimeRan(), 610, 155);
    }
}
