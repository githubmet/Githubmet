package hikmetanil.githubmet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hikmetanil.githubmet.R;
import hikmetanil.githubmet.model.P004Strong;

public class P004ArrayAdapter extends ArrayAdapter<P004Strong> {
    List<P004Strong> p004StrongList;
    Context context;
    public P004ArrayAdapter(Context context, List<P004Strong> p004StrongList ) {
        super(context, R.layout.p004custom_layout,p004StrongList);
        this.context=context;
        this.p004StrongList=p004StrongList;
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p004custom_layout,parent,false);

        TextView textViewCustomP004= view.findViewById(R.id.textViewCustomP004);
        TextView textViewCustom2P004= view.findViewById(R.id.textViewCustom2P004);

        textViewCustomP004.setText("Login="+p004StrongList.get(position).getLogin());
        textViewCustom2P004.setText("Avatar url="+p004StrongList.get(position).getAvatar_url());

        return view;//super.getView(position, convertView, parent);
    }
}
