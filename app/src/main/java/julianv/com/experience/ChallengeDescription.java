package julianv.com.experience;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ChallengeDescription extends ActionBarActivity {

    String[] descriptions;
    int challengeSelected;
    TypedArray icons;
    Button playBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        descriptions = getResources().getStringArray(R.array.descriptionsArray);
        setContentView(R.layout.activity_challenge_description);
        Intent intent = getIntent();
        challengeSelected = intent.getIntExtra("ChallengeSelected", 0);

        ImageView challengeIcon = (ImageView) findViewById(R.id.challengeDescriptionIcon);
        icons = getResources().obtainTypedArray(R.array.challengesArray);
        challengeIcon.setImageResource(icons.getResourceId(challengeSelected,0));

        icons.recycle();

        TextView challengeDescriptor = (TextView) findViewById(R.id.challengeDescriptionText);
        challengeDescriptor.setText(descriptions[challengeSelected]);

        playBtn = (Button) findViewById(R.id.playBtn);

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChallengeDescription.this, Home.class));

            }
        };

        playBtn.setOnClickListener(oclBtn);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge_description, menu);
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
    }
}
