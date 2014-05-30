package com.luiscesjr.aquariodebolso.aquariodebolso;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ferramentas extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ferramentas);

        Button calc = (Button)findViewById(R.id.btnCalculate);
        calc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText number = (EditText)findViewById(R.id.num);
                TextView display = (TextView)findViewById(R.id.display);

                double num = Double.parseDouble(number.getText().toString());

                // first option
                num = num * 5;

                // second option (using static method)
                num = Double.parseDouble(samplecalc.multNum(num));

                // third option (using instance method)
                samplecalc x = new samplecalc(num);
                num = x.multNum2();

                display.setText(num + "");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ferramentas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
