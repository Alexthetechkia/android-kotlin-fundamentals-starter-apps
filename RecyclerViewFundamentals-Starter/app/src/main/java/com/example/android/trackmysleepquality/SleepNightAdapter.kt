package com.example.android.trackmysleepquality

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<SleepNight>()
        // To tell the RecyclerView when the data that it's displaying has changed,
        // add a custom setter
        set(value){
            field = value
            // to trigger redrawing the list with the new data.
            // redraws the whole list, not just the changed items.
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        //called by RecyclerView to display the data for one list item at the specified position
        // Because these view holders are recycled,
        // make sure onBindViewHolder() sets or resets any customizations
        // that previous items might have set on a view holder.

        val item = data[position]
        holder.textView.text = item.sleepQuality.toString()

        if(item.sleepQuality <=1){
            holder.textView.setTextColor(Color.RED)
        } else {
            holder.textView.setTextColor(Color.BLACK)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        //called when RecycleView need a view holder
        // parent: viewGroup that holds the view holder, is always the RecyclerView
        //viewType is used when there are multiple views in the same RecyclerView
        //e.g. if you put a list of text views, an image, and a video all in the same RecyclerView
        //the function would need to know what type of view to use

        //layout inflater knows how to create views from XML layouts
        val layoutInflater = LayoutInflater.from(parent.context)

        // The third argument is attachToRoot. needs to be false,
        // because RecyclerView adds this item to the view hierarchy for you when it's time.
        val view = layoutInflater.inflate(R.layout.text_item_view,parent, false) as TextView

        return TextItemViewHolder(view)


    }
}