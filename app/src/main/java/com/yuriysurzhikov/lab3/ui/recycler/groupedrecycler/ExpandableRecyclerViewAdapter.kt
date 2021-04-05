package com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler

import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

/**
 *
 */
abstract class ExpandableRecyclerViewAdapter<GVH : ExpandableRecyclerViewAdapter.GroupViewHolder<*>, CVH : RecyclerView.ViewHolder>
constructor(items: List<GroupContainer<*>>) : MultiTypeGroupedRecyclerAdapter<GVH, CVH>(items) {

    /**
     *
     */
    var canExpandCollapse: Boolean = true
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private val expandableItems = items.map { ExpandableGroupContainer(it.title, it.items) }.toMutableList()

    override fun getItemCount(): Int {
        return if (canExpandCollapse) {
            expandableItems.sumBy {
                if (it.isExpanded) it.groupItemsCount else 1
            }
        } else {
            super.getItemCount()
        }
    }

    override fun getTypeByAbsolutePosition(position: Int): HolderTypeWithPosition? {
        if (canExpandCollapse) {
            var absolutePosition = 0
            expandableItems.forEachIndexed { parentPosition, item ->
                if (position == absolutePosition) {
                    return HolderTypeWithPosition(
                        GROUP_VIEW_TYPE, absolutePosition,
                        parentPosition,
                        item,
                        0,
                        null
                    )
                }
                if (!item.isExpanded) {
                    absolutePosition++
                    return@forEachIndexed
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
        } else {
            return super.getTypeByAbsolutePosition(position)
        }
    }

    @CallSuper
    override fun onBindGroupViewHolder(
        holder: GVH,
        absolutePos: Int,
        groupPosition: Int,
        group: GroupContainer<*>
    ) {
        if (canExpandCollapse) {
            holder.itemView.setOnClickListener {
                if (expandableItems[groupPosition].isExpanded) {
                    expandableItems[groupPosition].isExpanded = false
                    onGroupCollapsed(absolutePos, groupPosition, group)
                    holder.collapse()
                } else {
                    expandableItems[groupPosition].isExpanded = true
                    onGroupExpanded(absolutePos, groupPosition, group)
                    holder.expand()
                }
            }
        }
    }

    open fun onGroupExpanded(flatPosition: Int, groupPosition: Int, group: GroupContainer<*>) {
        notifyItemRangeInserted(
            flatPosition + 1,
            expandableItems[groupPosition].itemCount
        )
    }

    open fun onGroupCollapsed(flatPosition: Int, groupPosition: Int, group: GroupContainer<*>) {
        notifyItemRangeRemoved(
            flatPosition + 1,
            expandableItems[groupPosition].itemCount
        )
    }

    abstract class GroupViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun expand()
        abstract fun collapse()
    }

    private fun View.getRecycler(): RecyclerView? {
        return if (this is ViewGroup)
            this.children.find { it is RecyclerView }?.toRecycler()
        else null
    }

    private fun View?.toRecycler(): RecyclerView? {
        return if (this is RecyclerView) this else null
    }

    private fun View?.setGone() {
        if (this != null && this.visibility != View.GONE) {
            this.visibility = View.GONE
        }
    }

    private fun View?.setVisible() {
        if (this != null && this.visibility != View.VISIBLE) {
            this.visibility = View.VISIBLE
        }
    }
}
