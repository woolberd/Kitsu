package com.example.kitsu.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsu.databinding.AnimeItemBinding
import com.example.kitsu.model.DataItem

// класс Адаптер - отвечает за логику item в списке recyclerView
// ListAdapter - это адаптер со встроенным листом, в отличии от обычного Адаптера
class AnimeAdapter : ListAdapter<DataItem, AnimeAdapter.ViewHolder>(diffUtil) {

    // в классе viewHolder происходит привязка дизайна нашего item с данными из модели, так же
    // во ViewHolder проптсывается логика самих item (по типу при нажатии на like сердечко должно окрашиваться)
    class ViewHolder(private val binding: AnimeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(dataItem: DataItem?) {
            Log.e("aua", "setupSubscribes: $dataItem", )

            Glide.with(binding.imageKitsu).load(dataItem?.attributes?.posterImage?.original)
                .into(binding.imageKitsu)
            binding.tvKitsu.text = dataItem?.attributes?.titles?.enJp
        }
    }

    // переопределенные функции класса Адаптер
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    // переопределенные функции класса Адаптер
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // в данной функции создается функция onBind для класса ViewHolder, и так же в этом коде
        // отслеживается позиция каждой item
        holder.onBind(getItem(position))
    }

    // diffUtil - регулярно обновляет данные в списке, смотря обновились ли они на сервере
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(
                oldItem: DataItem,
                newItem: DataItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DataItem,
                newItem: DataItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}