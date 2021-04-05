package com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler

interface IMutableAdapter<T> {
    fun applyItems(list: List<T>)
    fun clear()
}