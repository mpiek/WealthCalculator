package org.powerbot.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.powerbot.data.SaveData;
import org.powerbot.data.Summary;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.GeItem;
import org.powerbot.script.wrappers.Item;

/**
 *
 * @author Algathonix
 */
public class PriceChecker extends Node {

    private int itemLocation = 0;
    private boolean hasFinished = false;
    private URL URL;
    Summary sm = new Summary();
    SaveData sd = new SaveData();

    public PriceChecker(final MethodContext arg0) {
        super(arg0);
    }

    @Override
    public void execute() {
        checkItem();
    }

    @Override
    public boolean validate() {
        return ctx.bank.open() && !hasFinished;
    }

    private void checkItem() {
        Item itemAt = ctx.bank.getItemAt(itemLocation);
        if (itemAt != null) {
            String item = itemAt.getName();
            int amount = itemAt.getStackSize();
            int price = GeItem.getProfile(itemAt.getId())
                    .getPrice(GeItem.PriceType.CURRENT).getPrice();
            sm.addItem(item, price, amount);
            itemLocation++;
        } else {
            hasFinished = true;
            sd.SaveData();
        }
    }

    /**
     * 
     * @param id item id
     * @return price
     * @deprecated 5015
     * FIXME Streams stay alive
     */
    private int getPrice(int id) {
        try {
            URL = new URL("http://services.runescape.com/"
                    + "m=itemdb_rs/Raw_bass/viewitem.ws?obj=" + id);
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(URL.openStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("guide price")) {
                        int n = 0;
                        Pattern p = Pattern.compile("-?\\d+");
                        java.util.regex.Matcher m = p.matcher(in.readLine());
                        while (m.find()) {
                            n = Integer.parseInt(m.group());
                        }
                        in.close();
                        return n;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PriceChecker.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}
