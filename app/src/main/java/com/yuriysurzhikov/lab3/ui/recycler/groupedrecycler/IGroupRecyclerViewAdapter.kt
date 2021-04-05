package com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface IGroupRecyclerViewAdapter<PVH : RecyclerView.ViewHolder, CVH : RecyclerView.ViewHolder> {
    fun onCreateGroupViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onCreateChildViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindGroupViewHolder(holder: PVH, absolutePos: Int, groupPosition: Int, group: GroupContainer<*>)
    fun onBindChildViewHolder(holder: CVH, flatPosition: Int, group: GroupContainer<*>, childIndex: Int)
}