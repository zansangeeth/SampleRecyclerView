package com.zasa.samplerecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person.view.*

private const val TAG = "ContactsAdapter"
class ContactsAdapter(val context: Context, val contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    //Creating a new view - EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG,"onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent,false)
        return ViewHolder(view)
    }

    // return how many items are in the dataset - INEXPENSIVE
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG,"onBindViewHolder $position")
        val contact = contacts[position]
        holder.bind(contact)
    }

    // bind the data at the position into the ViewHolder
    override fun getItemCount() = contacts.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.tvName
        val tvAge = itemView.tvAge

        fun bind(contact: Person) {
            tvName.text = contact.name
            tvAge.text = "Age : ${contact.age}"
        }
    }


}
