package com.cronscript.fw.controllers.impl;

import com.cronscript.fw.ScriptContext;
import com.cronscript.fw.controllers.AbstractController;
import com.cronscript.fw.paint.PaintComponent;

import java.awt.*;

public class PaintManager extends AbstractController<Graphics2D, PaintComponent> {


    public PaintManager(ScriptContext context) {
        super(context);
    }

    @Override
    public int traverseEntries(Graphics2D parameter) {
        getEntries().forEach((e)-> {
            if (e.isValid(getContext())) {
                e.onPaint(parameter);
            }
        });
        return 0;
    }
}
