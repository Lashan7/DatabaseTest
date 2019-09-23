package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button , button2, button3;
    ListView listView;
    List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        listView = findViewById(R.id.list);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.addItem(editText.getText().toString(),"Description Test");
                updateList();
            }

        });

        updateList();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RecycleView.class).putExtra("Item",new Item("Item 01","Test Item Description")));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(editText.getText().toString());
                //Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),list.get(position).getName(),Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this,RecycleView.class).putExtra("Name",list.get(position).getName()));
            }
        });
    }

    public void updateList(){
        DBHelper helper = new DBHelper(MainActivity.this);
        list = helper.readAll();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
    }

    public void search(String name){

        DBHelper helper = new DBHelper(MainActivity.this);
        List<Item> listS = helper.search(name);

        if(listS.isEmpty() == true){
            Toast.makeText(getApplicationContext(),"Dataset Is Empty!",Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter search = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listS);
        listView.setAdapter(search);
        search.notifyDataSetChanged();
    }
}
