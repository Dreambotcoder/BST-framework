import behaviour.RunNode;
import com.cronscript.CronScript;
import com.cronscript.fw.data.NodeBlock;
import com.cronscript.fw.nodes.TreePredicate;

import java.awt.*;

public class ExampleScript extends CronScript {

    @Override
    public void onStart() {
        /**
         * load the context first
         */
        loadContext();

        /**
         * Setting the initial nodeblock to run off
         */
        getContext().getNodeManager().loadBlock(NodeBlock.LOAD_SCRIPT);

        /**
         * Adding predicate to switch the tree when the tree predicate is valid
         * In Short: SOME_STATE will be loaded whenever the user is logged out
         */
        getContext().getNodeManager().addPredicate(new TreePredicate("logout",
                    () -> !getContext().getDB().getClient().isLoggedIn(), NodeBlock.SOME_STATE));

        /**
         * Adding entries is independent from nodeblocks, these entries will be loaded regardless of the active tree
         */
        getContext().getNodeManager().addEntries(
                new RunNode().when(
                        () -> !getContext().getDB().getWalking().isRunEnabled() //valid conditions are declared with suppliers
        ));

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
