package com.example.tm_dotamarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Item;

public class BuyItem extends AppCompatActivity {

    private void getData(String namaItem, int priceItem, int stockItem){
        for(Item item : Item.arrayItem){
            

        }
    }



    TextView itemName, itemStock, itemPrice;
    Button btnSellerLoc, btnCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);

        itemName = findViewById(R.id.tvItemName);
        itemStock = findViewById(R.id.tvItemStock);
        itemPrice = findViewById(R.id.tvItemPrice);

        btnSellerLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyItem.this, Seller_Location.class));
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        class MyAdapter extends BaseAdapter{

            Context context;
            ArrayList<Item> arrayItem;

            public MyAdapter(Context context, ArrayList<Item> arrayItem) {
                this.context = context;
                this.arrayItem = arrayItem;
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

                itemName.setText(temp.getNamaItem());
                itemStock.setText("" + temp.getStockItem());
                itemPrice.setText("Rp." + temp.getPriceItem());
                return convertView;

            }
        }
        
    }

}