package com.orbitalsonic.nearbyplacesfoursquare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orbitalsonic.nearbyplacesfoursquare.databinding.ItemNearbyDetailsBinding

class AdapterNearbyDetails :
    ListAdapter<NearbyDetailItem, AdapterNearbyDetails.NearbyViewHolder>(DATA_COMPARATOR) {

    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemNearbyDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_nearby_details, parent, false
        )
        return NearbyViewHolder(binding, mListener!!)

    }

    override fun onBindViewHolder(holder: NearbyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


    class NearbyViewHolder(binding: ItemNearbyDetailsBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {
        private val mBinding = binding

        init {
            mBinding.itemNbd.setOnClickListener {
                val mPosition = adapterPosition
                if (mPosition>-1){
                    listener.onItemClick(mPosition)
                }
            }

        }

        fun bind(mCurrentItem: NearbyDetailItem) {
            mBinding.nearbyAddress.text = mCurrentItem.address
            mBinding.nearbyDistance.text = mCurrentItem.distance
        }


    }


    companion object {
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<NearbyDetailItem>() {
            override fun areItemsTheSame(
                oldItem: NearbyDetailItem,
                newItem: NearbyDetailItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: NearbyDetailItem,
                newItem: NearbyDetailItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}