package tn.medtech.lab1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lilia on 18/04/2017.
 */

public class ResultActivity extends AppCompatActivity{
    TextView tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tResult = (TextView) findViewById(R.id.t_result);

        String value = getIntent().getStringExtra("value");
        String currency = getIntent().getStringExtra("currency");
        double doubleVal = Double.valueOf(value);
        if (currency.equals("dinar")){
            doubleVal = doubleVal / 2.2216;
        }else{
            doubleVal = doubleVal * 2.2216;
        }
        tResult.setText(String.valueOf(doubleVal));
    }

    public void back(View v){
        Intent returnIntent = new Intent();
        if (!tResult.getText().toString().isEmpty()){
            String result = tResult.getText().toString();
            returnIntent.putExtra("result",result);
            setResult(RESULT_OK, returnIntent);
        }else{
            setResult(RESULT_CANCELED, returnIntent);
        }
        finish();
    }

    public void call(View v){
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123"));
        if (callIntent.resolveActivity(getPackageManager()) != null){
            startActivity(callIntent);
            finish();
        }else{
            Toast.makeText(this,"The send action could not be performed!",Toast.LENGTH_LONG).show();
        }
    }




}
