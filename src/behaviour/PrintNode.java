package behaviour;

import com.cronscript.fw.ScriptContext;
import com.cronscript.fw.nodes.Node;
import org.dreambot.api.methods.MethodProvider;

public class PrintNode extends Node {
    @Override
    public String getStatus() {
        return "Printing shit";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int onLoop(ScriptContext context) {
        MethodProvider.log("spam");
        return 0;
    }
}
