package com.cronscript.fw.data;

import behaviour.PrintNode;
import com.cronscript.fw.ScriptContext;
import com.cronscript.fw.nodes.NodeRoot;
import com.cronscript.fw.nodes.NodeTree;
import org.dreambot.api.methods.MethodProvider;

import java.util.function.Consumer;

public enum NodeBlock implements Consumer<ScriptContext> {

    LOAD_SCRIPT(new NodeRoot()) {
        /**
         * Validating nodes upon conditions before adding them to the root of the tree
         */
        @Override
        public void accept(ScriptContext scriptContext) {

            if (scriptContext.getDB().getWalking().isRunEnabled()) {

                getRootNode().addLeaves(
                        new PrintNode().when(
                                () -> true
                        )
                );
            } else {
                MethodProvider.log("Run is not enabled, not adding printNode");
            }
        }
    },

    SOME_STATE(new NodeRoot()) {
        @Override
        public void accept(ScriptContext scriptContext) {
            //validation code here
        }
    };

    NodeBlock(NodeTree rootNode) {
        this.rootNode = rootNode;
    }

    private NodeTree rootNode;

    public NodeTree getRootNode() {
        return rootNode;
    }

}
