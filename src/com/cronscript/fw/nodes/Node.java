package com.cronscript.fw.nodes;

import com.cronscript.fw.ScriptContext;

import java.util.function.BooleanSupplier;

public abstract class Node {

    private BooleanSupplier when;

    public Node when(BooleanSupplier supplier) {
        this.when = supplier;
        return this;
    }

    public boolean isValid() {
        return when.getAsBoolean();
    }

    protected void setSupplier(BooleanSupplier supplier) {
        this.when = supplier;
    }


    public abstract String getStatus();
    public abstract int getPriority();

    public abstract int onLoop(ScriptContext context);

}
