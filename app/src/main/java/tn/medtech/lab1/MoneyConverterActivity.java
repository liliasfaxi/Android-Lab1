package tn.medtech.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MoneyConverterActivity extends AppCompatActivity {
    private Button bConvert;
    private EditText eEntry;
    private RadioButton rbDinarEuro;
    private TextView tResult;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_converter);

        //Initialisation des éléments graphiques
        bConvert = (Button)findViewById(R.id.b_convert);
        eEntry = (EditText)findViewById(R.id.e_entry);
        rbDinarEuro = (RadioButton) findViewById(R.id.rb_dinarEuro);
        tResult = (TextView)findViewById(R.id.t_result);


    }

    public void convert(View v){
        Intent i = new Intent(this,ResultActivity.class);
        i.putExtra("value",eEntry.getText().toString());
        if (rbDinarEuro.isChecked()){
            i.putExtra("currency","dinar");
        }else{
            i.putExtra("currency","euro");
        }
        startActivityForResult(i, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Toast.makeText(this,"Result is: "+data.getStringExtra("result"), Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Pas de résultat!", Toast.LENGTH_LONG).show();
            }
        }
    }


}
