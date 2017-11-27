package com.cronscript.fw.nodes;


public class NodeRoot extends NodeTree {

    public NodeRoot() {
        super(() -> true);
    }

    @Override
    public String getStatus() {
        return "Root node";
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
