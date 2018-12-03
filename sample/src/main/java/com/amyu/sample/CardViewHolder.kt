package com.amyu.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.amyu.sample.databinding.ItemCardBinding


class CardViewHolder private constructor(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup,
                attachToRoot: Boolean
        ): CardViewHolder = CardViewHolder(ItemCardBinding.inflate(inflater, parent, attachToRoot))
    }

    fun bind(
            cardViewModel: CardViewModel,
            onItemClickListener: ((cardView: CardView, cardViewModel: CardViewModel) -> Unit)?
    ) {
        binding.viewModel = cardViewModel
        binding.cardView.setOnClickListener {
            onItemClickListener?.invoke(binding.cardView, cardViewModel)
        }
    }
}