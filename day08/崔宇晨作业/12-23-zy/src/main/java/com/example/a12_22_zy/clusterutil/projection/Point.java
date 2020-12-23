/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.example.a12_22_zy.clusterutil.projection;

public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                +  ", y=" + y
                + '}';
    }
}
