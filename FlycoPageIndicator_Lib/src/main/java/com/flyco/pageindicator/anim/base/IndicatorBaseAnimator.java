package com.flyco.pageindicator.anim.base;

import android.view.View;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.view.ViewHelper;

public abstract class IndicatorBaseAnimator {
    //动画的时间长度
    protected long duration = 200;
    //动画的集合
    protected AnimatorSet animatorSet = new AnimatorSet();
    //动画的速度控制器
    private Interpolator interpolator;
    //延迟
    private long delay;
    //动画的观察者
    private AnimatorListener listener;

    //给指定的View设置动画
    public abstract void setAnimation(View view);

    //指定的View启动动画
    protected void start(final View view) {
        //动画进行重置
        reset(view);
        //给指定的View设置动画
        setAnimation(view);

        //动画集合设置动画的时间的长度
        animatorSet.setDuration(duration);
        if (interpolator != null) {
            //动画集合设置速度控制器
            animatorSet.setInterpolator(interpolator);
        }

        if (delay > 0) {
            //设置动画的延迟的时间
            animatorSet.setStartDelay(delay);
        }

        if (listener != null) {
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    //回调开始
                    listener.onAnimationStart(animator);
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                    //回调重复
                    listener.onAnimationRepeat(animator);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    listener.onAnimationEnd(animator);
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    //回调取消
                    listener.onAnimationCancel(animator);
                }
            });
        }

        animatorSet.setTarget(view);
        animatorSet.start();
    }

    //透明度  缩放 平移 旋转
    public static void reset(View view) {
        ViewHelper.setAlpha(view, 1);
        ViewHelper.setScaleX(view, 1);
        ViewHelper.setScaleY(view, 1);
        ViewHelper.setTranslationX(view, 0);
        ViewHelper.setTranslationY(view, 0);
        ViewHelper.setRotation(view, 0);
        ViewHelper.setRotationY(view, 0);
        ViewHelper.setRotationX(view, 0);
    }

    //设置延迟以及持续的时间后  返回对象
    public IndicatorBaseAnimator duration(long duration) {
        this.duration = duration;
        return this;
    }

    public IndicatorBaseAnimator delay(long delay) {
        this.delay = delay;
        return this;
    }

    public IndicatorBaseAnimator interpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    public IndicatorBaseAnimator listener(AnimatorListener listener) {
        this.listener = listener;
        return this;
    }

    //启动动画
    public void playOn(View view) {
        start(view);
    }

    //自定义的动画的回调
    public interface AnimatorListener {
        void onAnimationStart(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationCancel(Animator animator);
    }
}
