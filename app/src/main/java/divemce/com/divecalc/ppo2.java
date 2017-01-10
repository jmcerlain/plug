package divemce.com.divecalc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;
/*
public class ppo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppo2);
    }
}
*/


public class ppo2 extends AppCompatActivity implements OnClickListener {

    private int fo2 = 32;
    private int depth = 60;
    private double results = 0;
    private double atomfactor = 33.0;

    String strResults = new String();
    String strTmp = new String();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppo2);

        // Setup listeners

        View calcButton = findViewById(R.id.calc_button);
        calcButton.setOnClickListener(this);

        Spinner fswffwspinner = (Spinner) findViewById(R.id.fswffwspinner);

        ArrayAdapter<CharSequence> adapterfswffw = ArrayAdapter.createFromResource(
                this, R.array.fswffw_array, android.R.layout.simple_spinner_dropdown_item);


        fswffwspinner.setAdapter(adapterfswffw);
        fswffwspinner.setOnItemSelectedListener(new fswffwOnItemSelectedListener());


        EditText e = (EditText) findViewById(R.id.depth_field);
        e.addTextChangedListener(new CustomTextWatcher(e));

        EditText f = (EditText) findViewById(R.id.fo2_field);
        f.addTextChangedListener(new fo2TextWatcher(f));

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


    private class fo2TextWatcher implements TextWatcher {
        private EditText mEditText;
        public fo2TextWatcher(EditText f) {
            mEditText = f;     }
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





    private void CalcIt() {

        boolean goodInput = true;

        EditText f = (EditText) findViewById(R.id.fo2_field);
        strTmp = "0" + String.valueOf( f.getText());
        fo2 = Integer.parseInt(strTmp);

        EditText e = (EditText) findViewById(R.id.depth_field);
        strTmp = "0" + String.valueOf( e.getText());
        depth = Integer.parseInt(strTmp);


        if ((fo2 < 10) | (fo2 > 100))
        {
            goodInput = false;
            //Pop up Toast warning if fo2 blank
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup) findViewById(R.id.toast_layout_root));

            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("O2 from 10 to 100 only");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 4);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }


        if ((depth == 0) & (goodInput))
        {
            goodInput = false;
            //Pop up Toast warning if depth blank
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup) findViewById(R.id.toast_layout_root));

            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("Please Enter Depth");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 4);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }


        if (goodInput)
        {
            double ata = (depth / atomfactor) + 1 ;
            results = ata * fo2 * 0.01;
            results = calcfns.roundDouble(results, 2);
            strResults = String.valueOf(results);
            TextView t = (TextView) findViewById(R.id.result_field);
            t.setText(strResults);

        }

    }


    private void ClearResults() {
        TextView t = (TextView) findViewById(R.id.result_field);
        t.setText(" ");
    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calc_button:
                CalcIt();
                break;
        }
    }


    public class fswffwOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

            ClearResults();

            if (pos == 0)
            {atomfactor = 33.0; }
            else
            { atomfactor = 34.0; }
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // do nothing
        }
    }



}

