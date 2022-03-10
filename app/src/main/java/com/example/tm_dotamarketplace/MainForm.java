package com.example.tm_dotamarketplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Item;

public class MainForm extends AppCompatActivity {
    ArrayList<Item> arrayItem;

    private void masukinData(){

        arrayItem = new ArrayList<>();
        arrayItem.add(new Item("Fall Forrest", 1000, 1));
        arrayItem.add(new Item("Sand Casle", 2000, 1));
        arrayItem.add(new Item("Snow Highland", 3000, 3));
        arrayItem.add(new Item("Mount Snow", 6000, 2));
        arrayItem.add(new Item("Santopany", 4000, 5));
        arrayItem.add(new Item("Redwood", 5000, 3));
        arrayItem.add(new Item("St. Rona", 5000, 5));
        arrayItem.add(new Item("Levin", 9000, 2));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        masukinData();

        ListView lv = findViewById(R.id.lvItem);
        TextView tvUsername = findViewById(R.id.tvTitle);
        TextView tvBalance = findViewById(R.id.tvBalance);
        MyAdapter adapter = new MyAdapter(this, arrayItem);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_logout){
            startActivity(new Intent(MainForm.this, MainActivity.class));
            finish();
        }else if (item.getItemId() == R.id.menu_topup){
            startActivity(new Intent(MainForm.this, Topup.class));
            finish();
        }
        return super.onContextItemSelected(item);
    }

    class MyAdapter extends BaseAdapter{

        Context context;
        ArrayList<Item> arrayItem;

        public MyAdapter(Context context, ArrayList<Item> arrayItem) {
            this.context = context;
            this.arrayItem = arrayItem;

            masukinData();
        }

        @Override
        public int getCount() {
            return arrayItem.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayItem.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.listview_layout, parent, false);
            }

            Item temp = (Item) getItem(position);

            TextView tvItem = convertView.findViewById(R.id.etItemName);
            TextView tvStock = convertView.findViewById(R.id.etItemStock);
            TextView tvPrice = convertView.findViewById(R.id.etItemPrice);

            tvItem.setText(temp.getNamaItem());
            tvStock.setText("" + temp.getStockItem());
            tvPrice.setText("Rp." + temp.getPriceItem());
            return convertView;
        }
    }
}