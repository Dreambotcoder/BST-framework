package com.cronscript.fw.controllers.impl;

import com.cronscript.fw.ScriptContext;
import com.cronscript.fw.controllers.AbstractController;
import com.cronscript.fw.data.NodeBlock;
import com.cronscript.fw.nodes.Node;
import com.cronscript.fw.nodes.TreePredicate;
import org.dreambot.api.methods.MethodProvider;

import java.util.ArrayList;
import java.util.List;

public class NodeManager extends AbstractController<ScriptContext,Node> {

    private ScriptContext context;
    private NodeBlock block;
    private List<TreePredicate> predicates;

    public NodeManager(ScriptContext context) {
        super(context);
        this.context = context;
        predicates = new ArrayList<>();
    }

    public void addPredicate(TreePredicate loader) {
        this.predicates.add(loader);
    }


    public void loadBlock(NodeBlock block) {
        block.getRootNode().clear();
        block.accept(getContext());
        this.block = block;
    }

    public void removePredicate(String name) {
        for (TreePredicate loader : predicates) {
            if (loader.getName().equals(name)) {
                predicates.remove(loader);
            }
        }
    }

    public void clearPredicates() {
        this.predicates.clear();
    }

    @Override
    public int traverseEntries(ScriptContext parameter) {
        for (Node node : getEntries()) {
            if (node.isValid()) {
                return node.onLoop(parameter);
            }
        }
        for (TreePredicate predicate : predicates) {
            if (predicate.isValid() && predicate.getBlock() != block) {
                NodeBlock block = predicate.getBlock();
                MethodProvider.log("[TreePredicate] " + predicate.getName() + " predicate popped, loading block: " + block.name());
                loadBlock(block);
            }
        }
        if (block != null) {
            Node root = block.getRootNode();
            return root.onLoop(parameter);
        }
        return 600;
    }



}
