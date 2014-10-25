package com.entropik.wereabletest;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.entropik.wallet.R;
import com.entropik.wereabletest.ConfirmSendMoneyActivity;;

public class SelectMoneyActivity extends Activity {
	Wallets settings_m;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_money);
		cargar_wallet();
		
		final Button button20 = (Button) findViewById(R.id.Button20);         
		button20.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
					settings_m = new Wallets(SelectMoneyActivity.this.getApplicationContext());
			        Wallet my_Wallet = settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));
			        
			        int tipo = Integer.parseInt(settings_m.ultimo_tipo);
			        
			        my_Wallet.to = settings_m.lst_wallets.get(tipo-1).to;
			        my_Wallet.from = settings_m.lst_wallets.get(tipo-1).from;
			        my_Wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
			        my_Wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
			        show_toast_velocity("20€");
			        
			        settings_m.set_wallet(tipo,my_Wallet);
			        Toast.makeText(SelectMoneyActivity.this, "20€", Toast.LENGTH_SHORT).show();
			        ejecutar();
			}	
		}); 

		final Button button50 = (Button) findViewById(R.id.Button1);         
		button50.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
					settings_m = new Wallets(SelectMoneyActivity.this.getApplicationContext());
			        Wallet my_Wallet = settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));
			        
			        int tipo = Integer.parseInt(settings_m.ultimo_tipo);
			        
			        my_Wallet.to = settings_m.lst_wallets.get(tipo-1).to;
			        my_Wallet.from = settings_m.lst_wallets.get(tipo-1).from;
			        my_Wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
			        my_Wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
			        my_Wallet.total_mount = "50€";
			        
			        settings_m.set_wallet(tipo,my_Wallet);
			        show_toast_velocity("50€");
			        ejecutar();
			}	
		}); 		

		final Button button100 = (Button) findViewById(R.id.Button100);         
		button100.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
					settings_m = new Wallets(SelectMoneyActivity.this.getApplicationContext());
			        Wallet my_Wallet = settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));

			        int tipo = Integer.parseInt(settings_m.ultimo_tipo);
			        
			        my_Wallet.to = settings_m.lst_wallets.get(tipo-1).to;
			        my_Wallet.from = settings_m.lst_wallets.get(tipo-1).from;
			        my_Wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
			        my_Wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
			        my_Wallet.total_mount = "100€";
			        
			        settings_m.set_wallet(tipo,my_Wallet);
			        show_toast_velocity("100€");
			        ejecutar();
			}	
		}); 
		
		final Button button200 = (Button) findViewById(R.id.button200);         
		button200.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
					settings_m = new Wallets(SelectMoneyActivity.this.getApplicationContext());
			        Wallet my_Wallet = settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));
			        int tipo = Integer.parseInt(settings_m.ultimo_tipo);
			        
			        my_Wallet.to = settings_m.lst_wallets.get(tipo-1).to;
			        my_Wallet.from = settings_m.lst_wallets.get(tipo-1).from;
			        my_Wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
			        my_Wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
			        my_Wallet.total_mount = "200€";
			        
			        settings_m.set_wallet(tipo,my_Wallet);
			        show_toast_velocity("200€");
			        ejecutar();
			}	
		}); 
	}
	
	private void cargar_wallet()
	{
		settings_m = new Wallets(SelectMoneyActivity.this.getApplicationContext());
        settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));

        Wallet my_wallet = new Wallet();
        int tipo = Integer.parseInt(settings_m.ultimo_tipo);


        my_wallet.to = settings_m.lst_wallets.get(tipo-1).to;
        my_wallet.from = settings_m.lst_wallets.get(tipo-1).from;
        my_wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
        my_wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
        
        
        ImageView myImageContact = (ImageView) findViewById(R.id.imageContact);
        TextView myTextNameContact = (TextView) findViewById(R.id.TextViewNameContact);
        myTextNameContact.setText(my_wallet.to);
     // get input stream
        
        Context context = SelectMoneyActivity.this.getApplicationContext();
        
        InputStream ims = null;
        try {
            ims = context.getAssets().open("Contacts/"+my_wallet.the_id+".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // load image as Drawable
        Drawable d = Drawable.createFromStream(ims, null);
        // set image to ImageView
        myImageContact.setImageDrawable(d);
        
	}
	
	public void ejecutar() {
        Intent i = new Intent(this, ConfirmSendMoneyActivity.class);
        startActivity(i);
    }
	
	void show_toast_velocity(String texto)
	{
		final Toast toast = Toast.makeText(SelectMoneyActivity.this, texto.toString(), Toast.LENGTH_SHORT);
	    toast.show();

	    Handler handler = new Handler();
	        handler.postDelayed(new Runnable() {
	           @Override
	           public void run() {
	               toast.cancel(); 
	           }
	    }, 150);
	}
			
}
