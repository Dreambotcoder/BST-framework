package com.cronscript.fw.nodes;

import com.cronscript.fw.data.NodeBlock;

import java.util.function.BooleanSupplier;

public class TreePredicate {

    private BooleanSupplier condition;
    private NodeBlock block;
    private String name;

    public TreePredicate(String name, BooleanSupplier condition, NodeBlock block) {
        this.block = block;
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public boolean isValid() {
        return condition.getAsBoolean();
    }

    public NodeBlock getBlock() {
        return block;
    }
}
