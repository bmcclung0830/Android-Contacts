package com.theironyard.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    ArrayAdapter<String> contacts;

    EditText name;
    EditText number;
    Button addButton;
    ListView list;

    @Override
    public void onClick(View view) {
        String person = name.getText().toString();
        String phone = number.getText().toString();
        String contact = (person + ", (" + phone + ")").toString();
        contacts.add(contact);
        name.setText("Name");
        number.setText("Phone#");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        String contact = contacts.getItem(i);
        contacts.remove(contact);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText);
        number = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);
        list = (ListView) findViewById(R.id.listView);

        list.setOnItemLongClickListener(this);

        contacts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);
    }
}
