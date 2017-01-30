package divemce.com.divecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class topoff extends AppCompatActivity implements View.OnClickListener {

    private int depth = 60;
    private double results = 33.0;

    String strResults = new String();
    String strTmp = new String();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topoff);

        // Setup listeners

        View calcButton = findViewById(R.id.calc_button);
        calcButton.setOnClickListener(this);

  //      EditText e = (EditText) findViewById(R.id.depth_field);
  //      e.addTextChangedListener(new bestmix.CustomTextWatcher(e));


    }


    // temp dummy CalcIt
    private void CalcIt() {
            strResults = "29.4";
            strResults = strResults + " %";
            TextView t = (TextView) findViewById(R.id.result_field);
            t.setText(strResults);
        }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calc_button:
                CalcIt();
                break;
        }
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calculations_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, about.class);
                this.startActivity(intent);
                return true;

            case R.id.action_help:
                Intent intentHelp = new Intent(this, HelpActivity.class);
                intentHelp.putExtra("help_name","Gas TopOff");
                this.startActivity(intentHelp);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
