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

            /*
            case "bestmix":
                ViewStub stub2 = (ViewStub) findViewById(R.id.layout_stub);
                stub2.setLayoutResource(R.layout.content_help_best);
                View inflated2 = stub2.inflate();
                break;
            */


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
