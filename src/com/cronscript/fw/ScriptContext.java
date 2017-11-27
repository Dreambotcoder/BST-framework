package com.cronscript.fw;

import com.cronscript.CronScript;
import com.cronscript.fw.controllers.impl.NodeManager;
import com.cronscript.fw.controllers.impl.PaintManager;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Timer;
//import org.dreambot.artibarrows.util.BarrowsContext;

public class ScriptContext {

    private CronScript script;
    private Timer timer;
    private NodeManager nodeManager;
    private PaintManager paintManager;
    //private BarrowsContext barrowsContext;

    public ScriptContext(CronScript script) {
        this.script = script;
        this.timer = new Timer();
        this.nodeManager = new NodeManager(this);
        this.paintManager = new PaintManager(this);
       // this.barrowsContext = new BarrowsContext(this);
    }

    public MethodContext getDB() {
        return script;
    }

    public ScriptManifest getManifest() {
        return script.getManifest();
    }

    public NodeManager getNodeManager() {
        return nodeManager;
    }

    public PaintManager getPaintManager() {
        return paintManager;
    }

    /*public BarrowsContext getBarrows() {
        return barrowsContext;
    }**/
}
