package com.example.ex1106;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Demo project for ListView & Spinner
 *
 * @author      Albert Levy <albert.school2015@gmail.com>
 * @version     2.0 (Basic demo)
 * @since       9/14/2020
 */

public class SpinDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tV;
    Spinner spin;
    String [] town={"Tel-Aviv","Haifa","Jerusalem","Beer-Sheva"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_demo);
/**
 * Init parameters
 */
        tV = (TextView) findViewById(R.id.tV);
        spin = (Spinner) findViewById(R.id.spin);

        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,town);
        spin.setAdapter(adp);
    }

    /**
     * onItemSelected method: Display on the TextView the position in the adapter,
     * the row id of the data that was pressed & the data.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long rowid) {
        tV.setText("position: "+pos+" row id: "+rowid+"\n- "+town[pos]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * back method: Return to the listview demo activity
     */
    public void back(View view) {
        finish();
    }
}