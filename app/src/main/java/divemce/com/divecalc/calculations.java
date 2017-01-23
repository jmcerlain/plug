package divemce.com.divecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class calculations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);
    }

    /** Called when the user clicks the Best Mix button */
    public void showBestmix(View view) {
        Intent intent = new Intent(this, bestmix.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Max Operating Depth button */
    public void showMod(View view) {
        Intent intent = new Intent(this, mod.class);
        startActivity(intent);
    }

    //Called when the user clicks the PO2 button */
    public void showPpo2(View view) {
        Intent intent = new Intent(this, ppo2.class);
        startActivity(intent);
    }

    //Called when the user clicks the PO2 button */
    public void showEad(View view) {
        Intent intent = new Intent(this, ead.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calculations_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                //Pop up Toast warning if depth blank

                return true;

            case R.id.action_about:
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
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
