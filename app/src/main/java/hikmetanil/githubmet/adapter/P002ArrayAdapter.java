package hikmetanil.githubmet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hikmetanil.githubmet.R;
import hikmetanil.githubmet.model.P002Strong;

public class P002ArrayAdapter extends ArrayAdapter<P002Strong> {
    List<P002Strong> p002StrongList;
    Context context;
    public P002ArrayAdapter(Context context, List<P002Strong> p002StrongList) {
        super(context, R.layout.p002custom_layout,p002StrongList);
        this.context=context;
        this.p002StrongList=p002StrongList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p002custom_layout,parent,false);

        TextView textViewCustomP002= view.findViewById(R.id.textViewCustomP002);
        TextView textViewCustom2P002= view.findViewById(R.id.textViewCustom2P002);
        TextView textViewCustom3P002= view.findViewById(R.id.textViewCustom3P002);
        TextView textViewCustom4P002= view.findViewById(R.id.textViewCustom4P002);
        TextView textViewCustom5P002= view.findViewById(R.id.textViewCustom5P002);
        TextView textViewCustom6P002= view.findViewById(R.id.textViewCustom6P002);

        textViewCustomP002.setText("Id="+p002StrongList.get(position).getId());
        textViewCustom2P002.setText("Name="+p002StrongList.get(position).getName());
        textViewCustom3P002.setText("Url="+p002StrongList.get(position).getHtml_url());
        textViewCustom4P002.setText("Created at="+p002StrongList.get(position).getCreated_at());
        textViewCustom5P002.setText("Size"+p002StrongList.get(position).getSize());
        textViewCustom6P002.setText("Language="+p002StrongList.get(position).getLanguage());

        return view;
    }
}
