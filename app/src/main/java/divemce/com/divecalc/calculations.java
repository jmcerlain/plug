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

    /** Called when the user clicks the Accept button */
    public void showBestmix(View view) {
        Intent intent = new Intent(this, bestmix.class);
        startActivity(intent);
    }
}
