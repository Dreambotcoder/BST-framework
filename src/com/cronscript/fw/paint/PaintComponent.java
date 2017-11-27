package com.cronscript.fw.paint;

import com.cronscript.fw.ScriptContext;

import java.awt.*;

public interface PaintComponent {

    void onPaint(Graphics2D g);
    boolean isValid(ScriptContext context);
    int getZ();
    int getX();
    int getY();
}
