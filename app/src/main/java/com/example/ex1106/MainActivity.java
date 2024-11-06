package com.example.ex1106;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
 * @since       9/9/2019
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView tV;
    ListView lV;
    String [] town={"Tel-Aviv","Haifa","Jerusalem","Beer-Sheva"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/**
 * Init parameters
 */
        tV = (TextView) findViewById(R.id.tV);
        lV = (ListView) findViewById(R.id.lV);

        lV.setOnItemClickListener(this);
        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,town);
        lV.setAdapter(adp);
    }

    /**
     * onItemClick method: Display on the TextView the position in the adapter,
     * the row id of the data that was pressed & the data.
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long rowid) {
        tV.setText("position: "+pos+" row id: "+rowid+"\n- "+town[pos]);
    }

    /**
     * next method: Pass to the spinner demo activity
     */
    public void next(View view) {
        Intent si = new Intent(this,SpinDemo.class);
        startActivity(si);
    }
}