package behaviour;

import com.cronscript.fw.ScriptContext;
import com.cronscript.fw.nodes.Node;
import org.dreambot.api.methods.MethodProvider;

public class RunNode extends Node {
    @Override
    public String getStatus() {
        return "enabling run";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int onLoop(ScriptContext context) {
        if (context.getDB().getWalking().toggleRun()) {
            MethodProvider.sleepUntil(() -> context.getDB().getWalking().isRunEnabled(),600);
        }
        return 1;
    }
}
