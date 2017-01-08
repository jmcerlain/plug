package divemce.com.divecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

}
