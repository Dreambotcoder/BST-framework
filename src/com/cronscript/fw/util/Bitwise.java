package com.cronscript.fw.util;

public class Bitwise {
    private Bitwise(){}

    public static int getMask(int begin, int endExclusive){
        return Integer.MAX_VALUE << begin & Integer.MAX_VALUE >> 31-endExclusive;
    }
}
