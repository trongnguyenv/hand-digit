package com.bpo.exec.utils;

import org.bytedeco.javacpp.opencv_core;

import java.util.Comparator;

public class RectComparator implements Comparator<opencv_core.Rect> {
    @Override
    public int compare(opencv_core.Rect t1, opencv_core.Rect t2) {
        return Integer.valueOf(t1.x()).compareTo(t2.x());
    }
}
