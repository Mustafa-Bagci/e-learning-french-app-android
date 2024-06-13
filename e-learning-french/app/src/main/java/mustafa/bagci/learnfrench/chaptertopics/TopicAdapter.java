package mustafa.bagci.learnfrench.chaptertopics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import mustafa.bagci.learnfrench.R;

public class TopicAdapter extends BaseAdapter {

    private String[] topicName;
    private String[] subHeading;
    private Context context;
    private LayoutInflater inflater;

    public TopicAdapter(String[] topicName, String[] subHeading, Context context) {
        this.topicName = topicName;
        this.subHeading = subHeading;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return topicName.length;
    }

    @Override
    public Object getItem(int position) {
        return topicName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder pattern for efficient view recycling
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_topic_item_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.mainText = convertView.findViewById(R.id.mainText);
            viewHolder.subText = convertView.findViewById(R.id.subText);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mainText.setText(topicName[position]);
        viewHolder.subText.setText(subHeading[position]);

        return convertView;
    }

    private static class ViewHolder {
        TextView mainText;
        TextView subText;
    }
}
