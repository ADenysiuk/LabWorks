package com.ki232.AndriyDenysiuk

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class Users: RecyclerView.Adapter<Users.UserHolder>() {
    private val users = ArrayList<User>();
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_user, parent, false))
    }
    fun setUsers(u: List<User>){
        users.clear();
        users.addAll(u)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size;

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.render(users.get(position))
    }
    class UserHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idView: TextView? = itemView.findViewById<TextView>(R.id.id)
        private val userNameView: TextView? = itemView.findViewById<TextView>(R.id.username)

        fun render(user: User){
            val color = Color.rgb(Math.round(Math.random() * 100).toInt(), Math.round(Math.random() * 100).toInt(), Math.round(Math.random() * 100).toInt())
            itemView.findViewById<ConstraintLayout>(R.id.item)?.background = ColorDrawable(color)
            idView?.text = user.id.toString()
            userNameView?.text = user.name + " " + user.surname
        }
    }
}