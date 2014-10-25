package com.entropik.wereabletest;

import com.entropik.wallet.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.entropik.wereabletest.SelectMoneyActivity;

public class ListActivity extends Activity {

    ListView listView;
    Wallets settings_m;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Model.LoadModel();
        listView = (ListView) findViewById(R.id.listView);
        String[] ids = new String[Model.Items.size()];
        for (int i= 0; i < ids.length; i++){

            ids[i] = Integer.toString(i+1);
        }

        ItemAdapter adapter = new ItemAdapter(this,R.layout.row, ids);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {


                final Item children = (Item) Model.get_menu(position);
                //Toast.makeText(ListActivity.this, "Id imagen "+ children.IconFile.toString() +"Has seleccionado " + children.Name.toString(), Toast.LENGTH_SHORT).show();
                Wallet item_wallet = new Wallet(children.Id, "0€", "Me", children.Name, "OK");
                
                MenuSelecciona(item_wallet);
            }
        });
    }

    private void MenuSelecciona(Wallet item_wallet) {
        
        settings_m = new Wallets(ListActivity.this.getApplicationContext());
        //settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo)).to = item_wallet.to;

        Wallet my_wallet = new Wallet();
        int tipo = Integer.parseInt(settings_m.ultimo_tipo);


        my_wallet.to = item_wallet.to;
        my_wallet.from = item_wallet.from;
        my_wallet.total_mount = item_wallet.total_mount;
        my_wallet.the_id = item_wallet.the_id;

        settings_m.set_wallet(tipo,my_wallet);
        
        //cargamos la 2ª vista para añadir cantidad
        ejecutar();
        //super.onBackPressed();
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }
    
    public void ejecutar() {
        Intent i = new Intent(this, SelectMoneyActivity.class);
        startActivity(i);
    }

    
}
