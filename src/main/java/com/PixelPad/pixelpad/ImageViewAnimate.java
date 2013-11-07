package com.PixelPad.pixelpad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Mickey on 07/11/13.
 */

public class ImageViewAnimate extends ImageView {

    private static final int STEP = 1;

    private static final int VIEW_WIDTH = 10;


    Bitmap original;
    int current;

    public ImageViewAnimate(Context context) {
        super(context);
        original = null; // The bitmap would be set later
        current = 0;
    }

    public ImageViewAnimate(Context context, AttributeSet attrs) {
        super(context, attrs);
        original = null; // The bitmap would be set later
        current = 0;
    }

    public ImageViewAnimate(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        original = null; // The bitmap would be set later
        current = 0;
    }

    public void setOriginal(Bitmap original) {
        this.original = original;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (original != null) {
            Matrix transform = new Matrix();
            transform.postScale(VIEW_WIDTH, 1);
            Bitmap crop = Bitmap.createBitmap(original, current, 0, 1, original.getHeight(),
                    transform, false);
            this.setImageBitmap(crop);
            current = Math.min(current + STEP, original.getWidth() - STEP);
        }

        invalidate();
    }
}
