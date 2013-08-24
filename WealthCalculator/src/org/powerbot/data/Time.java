/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.powerbot.data;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Algathonix
 */
public class Time {

    private final long startTime = System.currentTimeMillis();

    public String getTimeRan() {
        final long currentTime = System.currentTimeMillis() - startTime;
        String format = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(currentTime),
                TimeUnit.MILLISECONDS.toMinutes(currentTime)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(currentTime)),
                TimeUnit.MILLISECONDS.toSeconds(currentTime)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentTime)));
        return format;
    }
}
