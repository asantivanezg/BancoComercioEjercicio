package com.banco.comercio.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.banco.comercio.databinding.ItemUserBinding
import com.banco.comercio.domain.model.User

class UserAdapter(private val listener: UserAdapterListener) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val oldList = mutableListOf<User>()

    interface UserAdapterListener {
        fun onCLickUserItem(user: User)
    }

    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = oldList[position]
        holder.setIsRecyclable(false)

        with(holder.binding) {
            tvName.text = item.nombre

            root.setOnClickListener {
                listener.onCLickUserItem(item)
            }
        }
    }

    override fun getItemCount(): Int = oldList.size

    fun updateList(newList: List<User>) {
        val callback = UserDiffUtil(oldList.toList(), newList)
        val diffResult = DiffUtil.calculateDiff(callback)
        oldList.clear()
        oldList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}