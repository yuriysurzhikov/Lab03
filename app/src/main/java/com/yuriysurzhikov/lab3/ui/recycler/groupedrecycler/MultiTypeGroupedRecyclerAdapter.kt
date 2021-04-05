package com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

abstract class MultiTypeGroupedRecyclerAdapter<GVH : RecyclerView.ViewHolder, CVH : RecyclerView.ViewHolder>
constructor(items: List<GroupContainer<*>>) : GroupedRecyclerAdapter<GVH, CVH>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when {
            isGroup(viewType) -> onCreateGroupViewHolder(parent)
            isChild(viewType) -> onCreateChildViewHolder(parent)
            else -> super.onCreateViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getTypeByAbsolutePosition(position)
        return when {
            viewType != null && isGroup(viewType.type) -> onBindGroupViewHolder(
                holder as GVH,
                viewType.absolutePos,
                viewType.groupPosition,
                viewType.group
            )
            viewType != null && isChild(viewType.type) -> onBindChildViewHolder(
                holder as CVH,
                viewType.absolutePos,
                viewType.group,
                viewType.childPos
            )
            viewType == null -> throw IllegalArgumentException("Not found any holder at position $position!")
            else -> throw IllegalStateException("Holder type does not match any of the types!")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val itemType = getTypeByAbsolutePosition(position)
        return when (itemType?.type) {
            GROUP_VIEW_TYPE -> {
                getParentViewType(itemType.absolutePos, itemType.groupPosition, itemType.group)
            }
            CHILD_VIEW_TYPE -> {
                getChildViewType(
                    itemType.absolutePos,
                    itemType.groupPosition,
                    itemType.childPos,
                    itemType.child
                )
            }
            else -> itemType?.type ?: -1
        }
    }

    fun isGroup(viewType: Int): Boolean {
        return viewType == GROUP_VIEW_TYPE
    }

    fun isChild(viewType: Int): Boolean {
        return viewType == CHILD_VIEW_TYPE
    }

    fun getParentViewType(absolutePos: Int, groupPos: Int, group: GroupContainer<*>): Int {
        return GROUP_VIEW_TYPE
    }

    fun getChildViewType(absolutePos: Int, groupPos: Int, childPos: Int, child: Any?): Int {
        return CHILD_VIEW_TYPE
    }
}