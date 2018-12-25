package hikmetanil.githubmet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hikmetanil.githubmet.R;
import hikmetanil.githubmet.model.P005Strong;

public class P005ArrayAdapter extends ArrayAdapter<P005Strong> {
    List<P005Strong> p005StrongList;
    Context context;
    public P005ArrayAdapter(Context context, List<P005Strong> p005StrongList) {
        super(context, R.layout.p005custom_layout, p005StrongList);
        this.context=context;
        this.p005StrongList=p005StrongList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p005custom_layout,parent,false);

        TextView textViewCustomP005= view.findViewById(R.id.textViewCustomP005);
        TextView textViewCustom2P005= view.findViewById(R.id.textViewCustom2P005);

        textViewCustomP005.setText("Login"+p005StrongList.get(position).getLogin());
        textViewCustom2P005.setText("Avatar url="+p005StrongList.get(position).getAvatar_url());
        return view; //super.getView(position, convertView, parent);
    }
}
