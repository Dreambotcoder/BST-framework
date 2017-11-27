package com.cronscript.fw.nodes;

import com.cronscript.fw.ScriptContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BooleanSupplier;

public abstract class NodeTree extends Node {

    public List<Node> leaves = new ArrayList<>();


    public NodeTree(BooleanSupplier supplier) {
        super.setSupplier(supplier);
    }

    public NodeTree addLeaves(Node... leaves) {
        this.leaves.addAll(Arrays.asList(leaves));
        this.leaves.sort(Comparator.comparingInt(Node::getPriority));
        return this;
    }

    public void removeLeaves(String clazz) {
        for (Node node : leaves) {
            if (node.getClass().getSimpleName().equalsIgnoreCase(clazz)) {
                this.leaves.remove(node);
            }
        }
    }

    public void clear() {
        leaves.clear();
    }

    @Override
    public int onLoop(ScriptContext context) {
        for (Node leave : leaves) {
            if (leave.isValid()) {
                return leave.onLoop(context);
            }
        }
        return 600;
    }
}
