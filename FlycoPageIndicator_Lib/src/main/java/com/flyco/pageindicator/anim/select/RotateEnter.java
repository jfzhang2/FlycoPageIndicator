package com.flyco.pageindicator.anim.select;

import android.view.View;

import com.flyco.pageindicator.anim.base.IndicatorBaseAnimator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class RotateEnter extends IndicatorBaseAnimator {
    //设置旋转的默认的长度是250
    public RotateEnter() {
        this.duration = 250;
    }

    public void setAnimation(View view) {
        //对应的是180的旋转
        this.animatorSet.playTogether(new Animator[]{
                ObjectAnimator.ofFloat(view, "rotation", 0, 180)});
    }
}
