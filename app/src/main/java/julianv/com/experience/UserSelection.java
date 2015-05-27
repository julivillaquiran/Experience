package julianv.com.experience;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class UserSelection extends Activity {

    List<UsersRow> rows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);

        rows = new ArrayList<UsersRow>(30);
        UsersRow row = null;
        for (int i = 1; i < 31; i++)
        {
            row = new UsersRow();
            row.setTitle("User " + i);
            row.setSubtitle("Distance " + i);
            rows.add(row);
        }

        ListView lv = (ListView)findViewById(R.id.userList);
        lv.setAdapter(new CustomUserArrayAdapter(this, rows));
        //setListAdapter(new CustomUserArrayAdapter(this, rows));

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UserSelection.this, rows.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_selection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
