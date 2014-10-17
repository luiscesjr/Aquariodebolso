package com.luiscesjr.aquariodebolso.aquariodebolso.ferramentasaqua;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.luiscesjr.aquariodebolso.aquariodebolso.R;

public class ferramentaaquario extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ferramentaaquario);


        final Button btnOpenPopup = (Button) findViewById(R.id.openpopup2);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater
                        = (LayoutInflater) getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popupajuda2, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }
                });

                popupWindow.showAsDropDown(btnOpenPopup, 90, 90);

            }
        });


        Button calc = (Button) findViewById(R.id.btnCalculate);
        calc.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

                EditText number1 = (EditText) findViewById(R.id.num1);
                EditText number2 = (EditText) findViewById(R.id.num2);
                EditText number3 = (EditText) findViewById(R.id.num3);
                TextView display = (TextView) findViewById(R.id.display);

                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());
                double num3 = Double.parseDouble(number3.getText().toString());

                // first option
                num1 = num1 * num2 * num3;

                display.setText(num1 / 1000 + "" + "\nLitros");
            }
        });

        Button calc2 = (Button) findViewById(R.id.btnCalculate2);
        calc2.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {

            EditText number1 = (EditText) findViewById(R.id.num4);
            EditText number2 = (EditText) findViewById(R.id.num5);
            EditText number3 = (EditText) findViewById(R.id.num6);
            EditText number4 = (EditText) findViewById(R.id.num7);
            EditText number5 = (EditText) findViewById(R.id.num8);
            TextView display = (TextView) findViewById(R.id.display2);

            double num4 = Double.parseDouble(number1.getText().toString());
            double num5 = Double.parseDouble(number2.getText().toString());
            double num6 = Double.parseDouble(number3.getText().toString());
            double num7 = Double.parseDouble(number4.getText().toString());
            double num8 = Double.parseDouble(number5.getText().toString());

            num4 = ((num4 / 100 * num5 / 100 * num6 / 100)*2.5) - ((num4 / 100 - num7 * num5 / 100 - num7 * num6 / 100 - num7)*2.5);

            display.setText(num4 + num8 + "" + " \nQuilos");
        }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ferramentaaquario, menu);
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



