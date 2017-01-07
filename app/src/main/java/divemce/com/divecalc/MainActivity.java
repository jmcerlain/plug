package divemce.com.divecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Accept button */
    public void openCalculations(View view) {
        Intent intent = new Intent(this, calculations.class);
     /*   EditText editText = (EditText) findViewById(R.id.edit_message); */
     /*   String message = editText.getText().toString(); */
     /*   String message = "funny msg"; */
     /*   intent.putExtra(EXTRA_MESSAGE, message); */
        startActivity(intent);

    }

    /** Called when the user clicks the Quit button */
    public void quit(View view) {
        finish();
    }


}
