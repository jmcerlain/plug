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

    private int help_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        strHelpName = "bestmix";

        switch (strHelpName) {
            case "calculations":
                ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
                stub.setLayoutResource(R.layout.content_help);
                View inflated = stub.inflate();
                break;

            case "bestmix":
                ViewStub stub2 = (ViewStub) findViewById(R.id.layout_stub);
                stub2.setLayoutResource(R.layout.content_help_best);
                View inflated2 = stub2.inflate();
                break;

            default:
                break;
        }

/*

        if (help_id == 0) {
            ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
            stub.setLayoutResource(R.layout.content_help);
            View inflated = stub.inflate();
        }
        else {
            ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);
            stub.setLayoutResource(R.layout.content_help_best);
            View inflated = stub.inflate();
        }

*/



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                finish();
            }
        });
    }
}
