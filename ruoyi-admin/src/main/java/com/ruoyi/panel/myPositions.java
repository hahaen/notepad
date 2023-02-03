package com.ruoyi.panel;


import net.coobird.thumbnailator.geometry.Position;

import java.awt.*;


public enum myPositions implements Position {
    ppp {
        public Point calculate(int enclosingWidth, int enclosingHeight, int width, int height, int insetLeft, int insetRight, int insetTop, int insetBottom) {
            int var9 = enclosingWidth - enclosingWidth / 3;
            int var10 = enclosingHeight - enclosingHeight / 3;

            return new Point(var9, var10);
        }
    }
}
