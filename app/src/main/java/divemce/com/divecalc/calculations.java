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
            case R.id.action_about:
                Intent intent = new Intent(this, about.class);
                this.startActivity(intent);
                return true;

            /*
            case R.id.action_help:
                Intent intentHelp = new Intent(this, HelpActivity.class);
                intentHelp.putExtra("help_name","calculations");
                this.startActivity(intentHelp);
                return true;
            */
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}
