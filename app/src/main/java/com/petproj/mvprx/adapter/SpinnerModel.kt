package com.petproj.mvprx.adapter

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.airbnb.epoxy.*
import com.petproj.mvprx.R
import com.petproj.mvprx.inter.IOnItemSelected

@EpoxyModelClass(layout = R.layout.item_spinner)
abstract class SpinnerModel(val iOnItemSelected: IOnItemSelected) :
    EpoxyModelWithHolder<SpinnerModel.ViewHolder>() {

    @EpoxyAttribute(hash = false)
    var onItemClickListener: OnItemSelectedListener? = null

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        with(holder) {
            spinner.adapter = ArrayAdapter(
                spinner.context, android.R.layout.simple_spinner_dropdown_item,
                spinner.context.resources.getStringArray(R.array.sort_by)
            )
            spinner.setSelection(0)
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
//                    onItemClickListener?.onItemSelected(position + 1)
                    iOnItemSelected.onChange(position)
                }
            }
        }
    }

    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int {
        return totalSpanCount
    }

    interface OnItemSelectedListener {
        fun onItemSelected(column: Int)
    }

    class ViewHolder : EpoxyHolder() {
        lateinit var spinner: Spinner
        override fun bindView(itemView: View) {
            spinner = itemView.findViewById(R.id.spSortBy)
        }
    }
}