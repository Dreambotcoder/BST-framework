package com.cronscript;

import com.cronscript.fw.ScriptContext;
import org.dreambot.api.script.AbstractScript;

public abstract class CronScript extends AbstractScript {

    private ScriptContext context;

    public void loadContext() {
        this.context = new ScriptContext(this);
    }

    public ScriptContext getContext() {
        return context;
    }
}
