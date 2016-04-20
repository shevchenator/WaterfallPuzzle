package ru.shevchenko.waterfallpuzzle.puzzle;

import android.graphics.Bitmap;
import android.graphics.Point;

import ru.shevchenko.waterfallpuzzle.cutter.PieceCurveSet;

/**
 * @author Vladimir Shevchenko vladimir@pantrylabs.com 05/04/16.
 */
public class PuzzlePiece {

    private final Bitmap image;
    private final Point anchorPoint;
    private final Point centerPoint;
    private final PieceCurveSet pieceCurveSet;
    private final int width;
    private final int height;

    public PuzzlePiece(Bitmap image, Point anchorPoint, Point centerPoint, PieceCurveSet pieceCurveSet, int width, int height) {
        this.image = image;
        this.anchorPoint = anchorPoint;
        this.centerPoint = centerPoint;
        this.pieceCurveSet = pieceCurveSet;
        this.width = width;
        this.height = height;
    }

    public Bitmap getImage() {
        return image;
    }

    public Point getAnchorPoint() {
        return anchorPoint;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public PieceCurveSet getPieceCurveSet() {
        return pieceCurveSet;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
