package com.cronscript.fw.controllers;

import com.cronscript.fw.ScriptContext;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractController<T, E> {

    private ScriptContext context;
    private List<E> entryList;

    public AbstractController(ScriptContext context) {
        this.context = context;
        this.entryList = new LinkedList<>();
    }

    public void addEntries(E... entries) {
        Collections.addAll(entryList, entries);
    }

    public List<E> getEntries() {
        return entryList;
    }

    public void removeEntries(E... entries) {
        for (E entry : entries) {
            if (entryList.contains(entry)) {
                entryList.remove(entry);
            }
        }
    }

    protected ScriptContext getContext() {
        return context;
    }

    public abstract int traverseEntries(T parameter);
}
