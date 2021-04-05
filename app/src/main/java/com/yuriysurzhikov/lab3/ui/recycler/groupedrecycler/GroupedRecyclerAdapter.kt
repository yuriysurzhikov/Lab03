package com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * GroupedRecyclerAdapter made for manage recycler view group
 * 01.04.2021 by Yurii Surzhykov
 * @version 1.0
 */
abstract class GroupedRecyclerAdapter<PVH : RecyclerView.ViewHolder, CVH : RecyclerView.ViewHolder>
constructor(private val mItems: List<GroupContainer<*>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    IGroupRecyclerViewAdapter<PVH, CVH> {

    val items: List<GroupContainer<*>> = mItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            GROUP_VIEW_TYPE -> onCreateGroupViewHolder(parent)
            CHILD_VIEW_TYPE -> onCreateChildViewHolder(parent)
            else -> super.createViewHolder(parent, viewType)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holderTypeWithPosition = getTypeByAbsolutePosition(position)
        when (holderTypeWithPosition?.type) {
            GROUP_VIEW_TYPE -> onBindGroupViewHolder(
                holder as PVH,
                holderTypeWithPosition.absolutePos,
                holderTypeWithPosition.groupPosition,
                mItems[holderTypeWithPosition.groupPosition]
            )
            CHILD_VIEW_TYPE -> onBindChildViewHolder(
                holder as CVH,
                holderTypeWithPosition.absolutePos,
                mItems[holderTypeWithPosition.groupPosition],
                holderTypeWithPosition.childPos
            )
            else -> throw IllegalArgumentException("Holder $holder must be one of provided: PARENT_VIEW_TYPE or CHILD_VIEW_TYPE")
        }
    }

    override fun getItemCount(): Int {
        return mItems.sumBy { return@sumBy it.groupItemsCount }
    }

    override fun getItemViewType(position: Int): Int {
        val itemType = getTypeByAbsolutePosition(position)
        return itemType?.type ?: -1
    }

    protected open fun getTypeByAbsolutePosition(position: Int): HolderTypeWithPosition? {
        var absolutePosition = 0
        mItems.forEachIndexed { parentPosition, item ->
            if (position == absolutePosition) {
                return HolderTypeWithPosition(
                    GROUP_VIEW_TYPE,
                    absolutePosition,
                    parentPosition,
                    item,
                    0,
                    null
                )
            }
            if (absolutePosition + item.groupItemsCount - 1 < position) {
                absolutePosition += item.groupItemsCount
                return@forEachIndexed
            }
            val childPosition = position - absolutePosition - 1
            return HolderTypeWithPosition(
                CHILD_VIEW_TYPE,
                absolutePosition,
                parentPosition,
                item,
                childPosition,
                item.items?.get(childPosition)
            )
        }
        return null
    }

    protected class HolderTypeWithPosition(
        val type: Int,
        val absolutePos: Int,
        val groupPosition: Int,
        val group: GroupContainer<*>,
        val childPos: Int,
        val child: Any?
    )

    companion object {
        const val GROUP_VIEW_TYPE = 0
        const val CHILD_VIEW_TYPE = 1
    }
}