package com.yuriysurzhikov.lab3.ui.main

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yuriysurzhikov.lab3.R
import com.yuriysurzhikov.lab3.model.DataContact
import com.yuriysurzhikov.lab3.ui.list.AbstractRecyclerAdapter
import com.yuriysurzhikov.lab3.ui.swipe.ISwipeViewHolder
import com.yuriysurzhikov.lab3.ui.swipe.OnDismissListener
import de.hdodenhof.circleimageview.CircleImageView

class ContactsRecyclerAdapter :
    AbstractRecyclerAdapter<DataContact, ContactsRecyclerAdapter.ContactViewHolder>() {

    var onDismissListener: OnDismissListener<DataContact>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        )
    }

    inner class ContactViewHolder(view: View) :
        AbstractRecyclerAdapter.AbstractViewHolder<DataContact>(view),
        ISwipeViewHolder {

        private val name: TextView? by lazy { itemView.findViewById<TextView>(R.id.name) }
        private val email: TextView? by lazy { itemView.findViewById<TextView>(R.id.email) }
        private val phone: TextView? by lazy { itemView.findViewById<TextView>(R.id.phone) }
        private val image: ImageView by lazy { itemView.findViewById<CircleImageView>(R.id.contact_image) }
        private val foreground: View by lazy { itemView.findViewById<View>(R.id.foreground) }

        override fun bind(item: DataContact) {
            super.bind(item)

            name?.text = item.name
            phone?.text = item.phone
            email?.text = item.email

            Glide.with(image)
                .load(item.imageProfile)
                .into(image)
        }

        override fun onItemDismissed(position: Int) {
            Handler(Looper.getMainLooper()).postDelayed({
                notifyItemRemoved(position)
                onDismissListener?.onDismiss(getItem())
            }, 1500)
        }

        override fun getForegroundView() = foreground
    }
}