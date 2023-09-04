package com.omao.worldcupapplication

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(private var activity: Activity, private var items: ArrayList<CountryModel>) : BaseAdapter() {
    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    override fun getCount(): Int {
        return items.size
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     * data set.
     * @return The data at the specified position.
     */
    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * [android.view.LayoutInflater.inflate]
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position The position of the item within the adapter's data set of the item whose view
     * we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     * is non-null and of an appropriate type before using. If it is not possible to convert
     * this view to display the correct data, this method can create a new view.
     * Heterogeneous lists can specify their number of view types, so that this View is
     * always of the right type (see [.getViewTypeCount] and
     * [.getItemViewType]).
     * @param parent The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null) {

            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_layout, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var countries = items[position]
        viewHolder.tvName?.text = countries.name
        viewHolder.tvCupTimes?.text = countries.cupWins
        viewHolder.flagImage?.setImageResource(countries.flagImage)

        view?.setOnClickListener() {
            Toast.makeText(activity,
                "You chose: ${countries.name}",
                Toast.LENGTH_LONG,
                ).show()
        }

        return view as View

    }

    private class ViewHolder(row: View?) {
        var tvName: TextView? = null
        var tvCupTimes: TextView? = null
        var flagImage: ImageView? = null

        init {
            this.tvName = row?.findViewById(R.id.country_name)
            this.tvCupTimes = row?.findViewById(R.id.number_of_cups)
            this.flagImage = row?.findViewById(R.id.country_flag)
        }

    }

}