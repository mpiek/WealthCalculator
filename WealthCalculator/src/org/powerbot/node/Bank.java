package org.powerbot.node;

import org.powerbot.script.methods.MethodContext;

public class Bank extends Node {

    public Bank(final MethodContext arg0) {
        super(arg0);
    }

    @Override
    public void execute() {
        ctx.bank.open();
        ctx.bank.depositInventory();
        ctx.bank.depositInventory();
    }

    @Override
    public boolean validate() {
        return !ctx.bank.open();
    }
}
