/*
 * Copyright (C) 2011 Patrik Akerfeldt
 * Copyright (C) 2011 Jake Wharton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flyco.pageindicator.indicator.base;

import android.support.v4.view.ViewPager;
//重新定义ViewPager的观察者 是对以前的系统的接口的派生
public interface PageIndicator extends ViewPager.OnPageChangeListener {

    /** for special viewpager,such as LooperViewPager */
    //这一块的代码需要优化 要传递策略  而不要把不必要的功能对其他的
    //对象进行暴露
    void setViewPager(ViewPager vp, int realCount, PageIndicatorEnum pageIndicatorEnum);
    //设置当前的ViewPager的选中项
    void setCurrentItem(int item);
}
