package divemce.com.divecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//float f = Float.parseFloat("25");
//String s = Float.toString(25.0f);


public class topoff extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {
	 
	// need for casting integer into double so we don't do integer division
	private double multiplier = 1.0;

	// new calculations
	private int xtra_psi = 0;
	private double cur_02_pounds = 0;
	private double new_o2_pounds = 0;
	private double total_o2_pounds = 0;
    private double results = 0;

	// from edit fields
    private double cur_mix_pct = 0;
    private double top_mix_pct = 0;
    private int cur_mix_psi = 0;
    private int top_mix_psi = 0;	


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
        e.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(4,1)});
        e.setOnEditorActionListener(this);

        EditText f = (EditText) findViewById(R.id.top_o2_field);
        f.addTextChangedListener(new topoff.TopTextWatcher(f));
		f.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(4,1)});
        f.setOnEditorActionListener(this);

        EditText g = (EditText) findViewById(R.id.cur_psi_field);
        g.addTextChangedListener(new topoff.CurPsiTextWatcher(g));
        g.setOnEditorActionListener(this);

        EditText h = (EditText) findViewById(R.id.top_psi_field);
        h.addTextChangedListener(new topoff.TopPsiTextWatcher(h));
        h.setOnEditorActionListener(this);




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

    private class TopTextWatcher implements TextWatcher {
        private EditText mEditText;
        public TopTextWatcher(EditText f) {
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

    private class CurPsiTextWatcher implements TextWatcher {
        private EditText mEditText;
        public CurPsiTextWatcher(EditText g) {
            mEditText = g;     }
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


    private class TopPsiTextWatcher implements TextWatcher {
        private EditText mEditText;
        public TopPsiTextWatcher(EditText h) {
            mEditText = h;     }
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
	
	
	 @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_GO) {
             CalcIt();
             return true;
         }

     //    if (actionId == EditorInfo.IME_ACTION_DONE) {
     //        CalcIt();
     //        return true;
     //    }

    //     if (actionId == EditorInfo.IME_ACTION_NEXT) {
     //        CalcIt();
      //       return true;
      //   }

     //    if (actionId == EditorInfo.IME_ACTION_SEND) {
      //       CalcIt();
       //      return true;
      //   }

     //    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
     //        CalcIt();
     //        return true;
      //   }

     //    if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
     //        CalcIt();
     //        return true;
     //    }

     //    if (actionId == EditorInfo.IME_ACTION_NONE) {
      //       CalcIt();
      //       return true;
      //   }



        return false;
    }

	
	
	
	
	

    private void WarnMsg(String wmsg)
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(wmsg);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 4);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    private void ClearResults() {
        TextView t = (TextView) findViewById(R.id.result_field);
        t.setText(" ");
    }


    private void CalcIt() {
		boolean goodInput = true;
		
		// get values from fields
        EditText e = (EditText) findViewById(R.id.cur_o2_field);
        strTmp = "0" + String.valueOf( e.getText());
        cur_mix_pct = calcfns.str_to_double(strTmp);

        EditText f = (EditText) findViewById(R.id.top_o2_field);
        strTmp = "0" + String.valueOf( f.getText());
        top_mix_pct = calcfns.str_to_double(strTmp);

        EditText g = (EditText) findViewById(R.id.cur_psi_field);
        strTmp = String.valueOf( g.getText());
        cur_mix_psi = calcfns.str_to_int(strTmp);

        EditText h = (EditText) findViewById(R.id.top_psi_field);
        strTmp = String.valueOf( h.getText());
        top_mix_psi = calcfns.str_to_int(strTmp);


        // validate values

		if (cur_mix_psi < 0) {
            goodInput = false;
			WarnMsg(getString(R.string.warn_msg_cur_psi));
        }

        if ((top_mix_psi < 0) & (goodInput)) {
            goodInput = false;
			WarnMsg(getString(R.string.warn_msg_top_psi));
        }
		
		if ((top_mix_psi <= cur_mix_psi) & (goodInput)) {
            goodInput = false;
			WarnMsg(getString(R.string.warn_msg_cur_top_psi));
        }
				
		if (((cur_mix_pct < 10) | (cur_mix_pct > 100)) & (goodInput)) {
            goodInput = false;
			WarnMsg(getString(R.string.warn_msg_cur_o2_pct));
        }
		
		
		if (((top_mix_pct < 10) | (top_mix_pct > 100)) & (goodInput)) {
            goodInput = false;
			WarnMsg(getString(R.string.warn_msg_top_o2_pct));
        }

		

		 if (goodInput) {
			
            xtra_psi = top_mix_psi - cur_mix_psi;
            cur_02_pounds = cur_mix_psi * cur_mix_pct;
            new_o2_pounds = xtra_psi * top_mix_pct;
            total_o2_pounds = cur_02_pounds + new_o2_pounds;			
			results = total_o2_pounds / top_mix_psi;
			results = calcfns.roundDouble(results, 1);
	
			strResults= String.valueOf(results);
			strResults = strResults + "%";

			TextView t = (TextView) findViewById(R.id.result_field);
			t.setText(strResults);			
		}
        
    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calc_button:
                CalcIt();
                break;
        }
    }


    // Menu Code Begin

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

    // Menu Code End



    public class DecimalDigitsInputFilter implements InputFilter {

        Pattern mPattern;

        public DecimalDigitsInputFilter(int digitsBeforeZero,int digitsAfterZero) {
            mPattern=Pattern.compile("[0-9]{0," + (digitsBeforeZero-1) + "}+((\\.[0-9]{0," + (digitsAfterZero-1) + "})?)||(\\.)?");
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            Matcher matcher=mPattern.matcher(dest);
            if(!matcher.matches())
                return "";
            return null;
        }

    }



}
