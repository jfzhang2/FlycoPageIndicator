package com.flyco.pageindicator.anim.select;

import android.view.View;

import com.flyco.pageindicator.anim.base.IndicatorBaseAnimator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class ZoomInEnter extends IndicatorBaseAnimator {
    //默认缩放的时间是200
    public ZoomInEnter() {
        this.duration = 200;
    }
    //x与y轴分别是从1 缩放到 1.5
    public void setAnimation(View view) {
        this.animatorSet.playTogether(new Animator[]{
                ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0F, 1.5F}),
                ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0F, 1.5F})});
    }
}
