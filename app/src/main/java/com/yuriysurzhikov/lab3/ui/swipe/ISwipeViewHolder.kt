package com.yuriysurzhikov.lab3.ui.swipe

import android.view.View

interface ISwipeViewHolder {
    fun onItemDismissed(position: Int)
    fun getForegroundView(): View
}