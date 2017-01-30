package divemce.com.divecalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;

public class HelpActivity extends AppCompatActivity {

    String strHelpName = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        strHelpName = this.getIntent().getStringExtra("help_name");
        this.setTitle("Help " + strHelpName);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        switch (strHelpName) {
            case "Calculations":
                ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
                stub.setLayoutResource(R.layout.content_help_calc);
                View inflated = stub.inflate();
                break;

            case "BestMix":
                ViewStub stub2 = (ViewStub) findViewById(R.id.layout_stub);
                stub2.setLayoutResource(R.layout.content_help_best);
                View inflated2 = stub2.inflate();
                break;

            case "MOD":
                ViewStub stub3 = (ViewStub) findViewById(R.id.layout_stub);
                stub3.setLayoutResource(R.layout.content_help_mod);
                View inflated3 = stub3.inflate();
                break;

            case "PO2":
                ViewStub stub4 = (ViewStub) findViewById(R.id.layout_stub);
                stub4.setLayoutResource(R.layout.content_help_po2);
                View inflated4 = stub4.inflate();
                break;

            case "EAD":
                ViewStub stub5 = (ViewStub) findViewById(R.id.layout_stub);
                stub5.setLayoutResource(R.layout.content_help_ead);
                View inflated5 = stub5.inflate();
                break;

            case "Gas TopOff":
                ViewStub stub6 = (ViewStub) findViewById(R.id.layout_stub);
                stub6.setLayoutResource(R.layout.content_help_topoff);
                View inflated6 = stub6.inflate();
                break;

            default:
                break;
        }






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
