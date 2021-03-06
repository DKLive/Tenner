package cmput301w18t22.com.tenner.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cmput301w18t22.com.tenner.R;
import cmput301w18t22.com.tenner.classes.Bid;
import cmput301w18t22.com.tenner.classes.Task;

/**
 * Custom Adapter provides the adapter for an array of my bids on others' tasks
 *
 * Needs to define all 4 overidden methods to function properly, as well as have layout defined in XML
 *
 *
 * Based on https://guides.codepath.com/android/Using-a-BaseAdapter-with-ListView
 * Retrieved 2018-02-05
 */
public class OtherBidAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Bid> bidList;

    //public constructor
    public OtherBidAdapter(Context context, ArrayList<Bid> bidList) {
        this.context = context;
        this.bidList = bidList;
    }

    @Override
    public int getCount() {
        return bidList.size(); //returns number of tasks in taskList
    }

    @Override
    public Bid getItem(int position) {
        return bidList.get(position); //returns subscription at specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    } // This needs a better approach -- what's our plan for primary keys from ElasticSearch??

    /**
     * Get the view for the listView object.
     *
     * @param position integer representing position in ListView
     * @param convertView current View
     * @param parent parent ViewGroup
     * @return View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.mybidadapter_item, parent, false);
        }

        // get current item to be displayed
        Bid currentBid = getItem(position);

        // get TextView objects
        TextView taskTitleTextView = (TextView) convertView.findViewById(R.id.task_title);
        TextView bidderNameTextView = (TextView) convertView.findViewById(R.id.bidder_name);
        TextView bidAmtTextView = (TextView) convertView.findViewById(R.id.bid_amt);
        View coloredBar = (View) convertView.findViewById(R.id.colored_bar);

        // get Subscription information and display in textViews
        taskTitleTextView.setText(currentBid.getTask().getTitle());
        String bidderString ="Bidder: " + currentBid.getOwner().toDisplayName();
        bidderNameTextView.setText(bidderString);
        bidAmtTextView.setText(currentBid.toString());
        // TODO: set photo


        // Set correct colored bar color based on task status
        Task.Status taskStatus = currentBid.getTask().getStatus();
        switch (taskStatus) {
            case requested: coloredBar.setBackgroundResource(R.color.yellow);
                break;
            case bidded: coloredBar.setBackgroundResource(R.color.orange);
                break;
            case assigned: coloredBar.setBackgroundResource(R.color.green);
                break;
            case done: coloredBar.setBackgroundResource(R.color.black);
                break;
        }

        // returns the view for the current row
        return convertView;
    }
}



