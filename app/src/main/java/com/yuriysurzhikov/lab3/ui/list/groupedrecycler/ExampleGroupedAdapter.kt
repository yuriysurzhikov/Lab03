package com.yuriysurzhikov.lab3.ui.list.groupedrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yuriysurzhikov.lab3.R
import com.yuriysurzhikov.lab3.model.DataContact
import com.yuriysurzhikov.lab3.ui.list.AbstractRecyclerAdapter
import com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler.ExpandableRecyclerViewAdapter
import com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler.GroupContainer
import com.yuriysurzhikov.lab3.ui.recycler.groupedrecycler.IMutableAdapter
import de.hdodenhof.circleimageview.CircleImageView

class ExampleGroupedAdapter(items: ArrayList<DataGroup>) :
    ExpandableRecyclerViewAdapter<
            ExampleGroupedAdapter.TitleHolder,
            ExampleGroupedAdapter.DataHolder>(items) {

    class TitleHolder(view: View) : GroupViewHolder<DataGroup>(view) {
        val titleText: TextView by lazy { itemView.findViewById<TextView>(android.R.id.title) }
        override fun expand() {
        }

        override fun collapse() {
        }
    }

    class DataHolder(view: View) : AbstractRecyclerAdapter.AbstractViewHolder<DataContact>(view) {
        private val name: TextView? by lazy { itemView.findViewById<TextView>(R.id.name) }
        private val email: TextView? by lazy { itemView.findViewById<TextView>(R.id.email) }
        private val phone: TextView? by lazy { itemView.findViewById<TextView>(R.id.phone) }
        private val image: ImageView by lazy { itemView.findViewById<CircleImageView>(R.id.contact_image) }

        override fun bind(item: DataContact?) {
            super.bind(item)
            name?.text = item?.name
            phone?.text = item?.phone
            email?.text = item?.email
            Glide.with(image)
                .load(item?.imageProfile)
                .into(image)
        }
    }

    class DataGroup(title: String?, items: ArrayList<DataContact>) :
        GroupContainer<DataContact>(title, items)

    override fun onCreateChildViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return DataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        )
    }

    override fun onBindGroupViewHolder(
        holder: TitleHolder,
        absolutePos: Int,
        groupPosition: Int,
        group: GroupContainer<*>
    ) {
        super.onBindGroupViewHolder(holder, absolutePos, groupPosition, group)
        holder.titleText.text = items[groupPosition].title
    }

    override fun onBindChildViewHolder(
        holder: DataHolder,
        flatPosition: Int,
        group: GroupContainer<*>,
        childIndex: Int
    ) {
        holder.bind(group.get(childIndex) as DataContact?)
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TitleHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_title, parent, false)
        )
    }
}