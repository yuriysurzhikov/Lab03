package com.yuriysurzhikov.lab3.ui.list

interface OnItemClickListener<T> {
    fun onItemClick(item: T, position: Int)
}