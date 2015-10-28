package com.flyco.pageindicator.indicator.base;

import android.support.v4.view.ViewPager;

/**
 * This Enum is useful when there are many different
 * ViewPager which has different strategy on getting
 * counter
 * Created by apple on 15/10/28.
 */
public enum PageIndicatorEnum {
    NORMAL_VIEWPAGE {
        @Override
        public int getViewPagerCounter(ViewPager viewPager, int counter) {
            return viewPager.getAdapter().getCount();
        }
    },
    LOOPER_VIEWPAGER {
        @Override
        public int getViewPagerCounter(ViewPager viewPager, int counter) {
            return counter;
        }
    };
    public abstract int getViewPagerCounter(ViewPager viewPager, int counter);
}
