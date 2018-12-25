package hikmetanil.githubmet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hikmetanil.githubmet.R;
import hikmetanil.githubmet.model.P003Strong;

public class P003ArrayAdapter extends ArrayAdapter<P003Strong> {

    Context context;
    List<P003Strong> p003StrongList;
    public P003ArrayAdapter(Context context, List<P003Strong> p003StrongList) {
        super(context, R.layout.p003custom_layout,p003StrongList);
        this.context=context;
        this.p003StrongList=p003StrongList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p003custom_layout,parent,false);

        TextView textViewCustomP003= view.findViewById(R.id.textViewCustomP003);
        TextView textViewCustom2P003= view.findViewById(R.id.textViewCustom2P003);
        TextView textViewCustom3P003= view.findViewById(R.id.textViewCustom3P003);
        TextView textViewCustom4P003= view.findViewById(R.id.textViewCustom4P003);
        TextView textViewCustom5P003= view.findViewById(R.id.textViewCustom5P003);
        TextView textViewCustom6P003= view.findViewById(R.id.textViewCustom6P003);
        TextView textViewCustom7P003= view.findViewById(R.id.textViewCustom7P003);

        textViewCustomP003.setText("Id="+p003StrongList.get(position).getId());
        textViewCustom2P003.setText("Name="+p003StrongList.get(position).getName());
        textViewCustom3P003.setText("Size="+p003StrongList.get(position).getSize());
        textViewCustom4P003.setText("Description="+p003StrongList.get(position).getDescription());
        textViewCustom5P003.setText("Created at="+p003StrongList.get(position).getCreated_at());
        textViewCustom6P003.setText("Starred="+p003StrongList.get(position).getStargazers_count());
        textViewCustom7P003.setText("Watchers="+p003StrongList.get(position).getWatchers_count());

        return view;
    }
}
