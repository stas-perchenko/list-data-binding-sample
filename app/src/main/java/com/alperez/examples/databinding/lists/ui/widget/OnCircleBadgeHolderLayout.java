package com.alperez.examples.databinding.lists.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by stanislav.perchenko on 12/16/2016.
 */

public class OnCircleBadgeHolderLayout extends FrameLayout {

    private float containerSizePx = 0;
    private int badgeMarginsPx;
    private float badgeSizePx;


    public OnCircleBadgeHolderLayout(Context context) {
        this(context, null, 0);
    }

    public OnCircleBadgeHolderLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnCircleBadgeHolderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OnCircleBadgeHolderLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public void setContainerAndBadgeSize(float containerSizePx, float badgeSizePx ) {
        this.containerSizePx = containerSizePx;
        this.badgeSizePx = badgeSizePx;
        updateDimensions();
    }


    private void init() {
        //---  Make initial inflation pass easier and faster  ---
        if (getChildCount() > 1) {
            for (int i=0; i<getChildCount(); i++) {
                setViewSquareSizeAndMargins(getChildAt(i), 0, 0);
            }
        }
    }



    private void updateDimensions() {
        if (containerSizePx == 0) {
            badgeSizePx = 0;
        }

        int sz = Math.round(containerSizePx);
        getLayoutParams().width = sz;
        getLayoutParams().height = sz;

        calculateBadgeMargins();

        setChildrenSizeAndMargins();
        invalidate();
    }


    /**
     * This is used to fix too large badge size.
     */
    private float maxPossibleBadgeSize;

    private void calculateBadgeMargins() {
        if (containerSizePx == 0) return;

        double R = containerSizePx / 2.0;
        float maxBadgeRadius = (float)(R *(1 - 1/Math.sqrt(2)));
        maxPossibleBadgeSize = 2f * maxBadgeRadius;

        badgeMarginsPx = (badgeSizePx > 0)
                // Protect margin from negative value when badge size is set too large.
                // The size will be fixed later;
                ? badgeMarginsPx = Math.max(Math.round(maxBadgeRadius - badgeSizePx/2f), 0)
                // A user did not set badge size -> apply maximum possible
                : 0;

    }

    private void setChildrenSizeAndMargins() {
        if (getChildCount() > 1) {
            for (int i=1; i<getChildCount(); i++) {

                if (containerSizePx == 0) {
                    badgeSizePx = 0;
                    badgeMarginsPx = 0;
                } else {
                    //----  If a user didn't set badge size, we apply maximum possible badge size
                    badgeSizePx = (badgeSizePx == 0)
                            ? maxPossibleBadgeSize
                            : Math.min(badgeSizePx, maxPossibleBadgeSize);
                }
                setViewSquareSizeAndMargins(getChildAt(i), (int)Math.floor(badgeSizePx), badgeMarginsPx);
            }
        }
    }


    /**
     * Helper method to set badge children dimensions and margins.
     * The badge children are supposed to be square. And margins are sopposed to be the same
     * on each side.
     * @param child
     * @param size
     * @param margins
     */
    private void setViewSquareSizeAndMargins(View child, int size, int margins) {
        child.getLayoutParams().width = size;
        child.getLayoutParams().height = size;
        ((MarginLayoutParams) child.getLayoutParams()).setMargins(margins, margins, margins, margins);
    }

}
