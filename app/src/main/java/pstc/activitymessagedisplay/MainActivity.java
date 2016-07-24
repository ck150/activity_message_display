package pstc.activitymessagedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private EditText edit1;
    private TextView text1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Activity 1");
        edit1 = (EditText) findViewById(R.id.editText1);
        text1 = (TextView) findViewById(R.id.textView1);

        i = getIntent();
        if(i.getAction()==Intent.ACTION_MAIN){
            text1.setText("");
        }else{
            String s2 = i.getStringExtra(getString(R.string.message_id));
            text1.setText(s2);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void OnClickNext(View v){
        String s  = edit1.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra(getString(R.string.message_id),s);

        startActivity(i);
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
