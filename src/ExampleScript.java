import com.cronscript.CronScript;
import com.cronscript.fw.data.NodeBlock;

import java.awt.*;

public class ExampleScript extends CronScript {

    @Override
    public void onStart() {
        loadContext();
        getContext().getNodeManager().loadBlock(NodeBlock.LOAD_SCRIPT);
    }

    @Override
    public int onLoop() {
        return getContext().getNodeManager().traverseEntries(getContext());
    }

    @Override
    public void onPaint(Graphics graphics) {
        getContext().getPaintManager().traverseEntries((Graphics2D) graphics);
    }
}
