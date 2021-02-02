package com.mob.bamrepos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mob.bamrepos.R
import com.mob.bamrepos.models.response.Repo
import kotlinx.android.synthetic.main.repo_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.RepoViewHolder>() {

    private var data = mutableListOf<Repo?>()


    fun updateData(newData: List<Repo?>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repo: Repo?) {
            itemView.tvName.text = "Name : ${repo?.name}"
            itemView.tvDescription.text = "Description : ${repo?.description}"
            itemView.tvUrl.text = "Url : ${repo?.html_url}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.repo_item,
            parent,
            false
        )

        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}