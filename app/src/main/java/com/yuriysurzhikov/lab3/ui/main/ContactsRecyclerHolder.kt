package com.yuriysurzhikov.lab3.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yuriysurzhikov.lab3.R
import com.yuriysurzhikov.lab3.model.DataContact
import com.yuriysurzhikov.lab3.ui.list.AbstractRecyclerAdapter
import de.hdodenhof.circleimageview.CircleImageView

class ContactsRecyclerHolder :
    AbstractRecyclerAdapter<DataContact, ContactsRecyclerHolder.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        )
    }

    inner class ContactHolder(view: View) :
        AbstractRecyclerAdapter.AbstractViewHolder<DataContact>(view) {

        private val name: TextView? by lazy { itemView.findViewById<TextView>(R.id.name) }
        private val email: TextView? by lazy { itemView.findViewById<TextView>(R.id.email) }
        private val phone: TextView? by lazy { itemView.findViewById<TextView>(R.id.phone) }
        private val image: ImageView by lazy { itemView.findViewById<CircleImageView>(R.id.contact_image) }

        override fun bind(item: DataContact) {
            super.bind(item)

            name?.text = item.name
            phone?.text = item.phone
            email?.text = item.email

            Glide.with(image)
                .load(item.imageProfile)
                .into(image)
        }
    }
}