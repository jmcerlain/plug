package divemce.com.divecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


//float f = Float.parseFloat("25");
//String s = Float.toString(25.0f);


public class topoff extends AppCompatActivity implements View.OnClickListener {

    private double cur_mix_pct = 0;
    private double results = 0;

    String strResults = new String();
    String strTmp = new String();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topoff);



        // Setup listeners

        View calcButton = findViewById(R.id.calc_button);
        calcButton.setOnClickListener(this);

        EditText e = (EditText) findViewById(R.id.cur_o2_field);
        e.addTextChangedListener(new topoff.CustomTextWatcher(e));


    }
    private class CustomTextWatcher implements TextWatcher {
        private EditText mEditText;
        public CustomTextWatcher(EditText e) {
            mEditText = e;     }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //ShowMsg();
        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            ClearResults();
        }
        public void afterTextChanged(Editable s) {
            //ShowMsg();
        }
    }

    private void ClearResults() {
        TextView t = (TextView) findViewById(R.id.result_field);
        t.setText(" ");
    }

    // temp dummy CalcIt
    private void CalcIt() {
        EditText e = (EditText) findViewById(R.id.cur_o2_field);

        strTmp = "0" + String.valueOf( e.getText());
        //cur_mix_pct = Integer.parseInt(strTmp);

        //NumberFormat nf = NumberFormat.getInstance();

        //cur_mix_pct = nf.parse(strTmp);

        cur_mix_pct = Float.parseFloat(strTmp);

        results = cur_mix_pct + 11.1;


        strResults= String.valueOf(results);

       // strResults = "29.4";
        //    strResults = strResults + " %";


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
