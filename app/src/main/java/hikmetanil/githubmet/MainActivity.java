package hikmetanil.githubmet;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] activityNames=getResources().getStringArray(R.array.activity_names);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(activityNames);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String activityName="hikmetanil.githubmet."+l.getItemAtPosition(position);
        try {
            Class className= Class.forName(activityName);
            Intent intent=new Intent(this,className);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
