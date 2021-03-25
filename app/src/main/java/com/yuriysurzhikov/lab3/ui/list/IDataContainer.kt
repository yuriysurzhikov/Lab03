package com.yuriysurzhikov.lab3.ui.list

interface IDataContainer<T> {
    fun setOnItemClickListener(listener: OnItemClickListener<T>)
    fun setItems(list: List<T>?)
    fun getItems(): List<T>
}