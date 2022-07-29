package com.orbitalsonic.nearbyplacesfoursquare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orbitalsonic.nearbyplacesfoursquare.databinding.ItemNearbyBinding

class AdapterNearby :
    ListAdapter<NearbyPlacesItem, AdapterNearby.NearbyViewHolder>(DATA_COMPARATOR) {

    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemNearbyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_nearby, parent, false
        )
        return NearbyViewHolder(binding, mListener!!)

    }

    override fun onBindViewHolder(holder: NearbyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


    class NearbyViewHolder(binding: ItemNearbyBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        private val mBinding = binding

        init {
            mBinding.itemNearby.setOnClickListener {
                val mPosition = adapterPosition
                if (mPosition>-1){
                    listener.onItemClick(mPosition)
                }

            }

        }

        fun bind(mCurrentItem: NearbyPlacesItem) {
            mBinding.categoryType.text = mCurrentItem.categoryType
            mBinding.nearbyName.text = mCurrentItem.itemName
        }


    }


    companion object {
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<NearbyPlacesItem>() {
            override fun areItemsTheSame(
                oldItem: NearbyPlacesItem,
                newItem: NearbyPlacesItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: NearbyPlacesItem,
                newItem: NearbyPlacesItem
            ): Boolean {
                return oldItem.itemName == newItem.itemName
            }
        }
    }

}