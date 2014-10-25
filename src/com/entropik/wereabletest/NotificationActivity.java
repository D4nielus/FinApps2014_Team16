package com.entropik.wereabletest;

import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.entropik.wallet.R;

public class NotificationActivity extends Activity {

	Wallets settings_m;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		
		cargar_wallet();
		
		final Button buttonGoInici = (Button) findViewById(R.id.buttonGoInici);         
		buttonGoInici.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 ejecutar();
			}	
		}); 
	}
	
	private void cargar_wallet()
	{
		settings_m = new Wallets(NotificationActivity.this.getApplicationContext());
        settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));

        Wallet my_wallet = new Wallet();
        int tipo = Integer.parseInt(settings_m.ultimo_tipo);


        my_wallet.to = settings_m.lst_wallets.get(tipo-1).to;
        my_wallet.from = settings_m.lst_wallets.get(tipo-1).from;
        my_wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
        my_wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
        
        
        ImageView myImageContact = (ImageView) findViewById(R.id.imageContact);
        
        TextView myTextNameContact = (TextView) findViewById(R.id.TextNameContact);
        myTextNameContact.setText(my_wallet.to+" ("+my_wallet.total_mount+")");
        
        TextView myTextTotalAmount = (TextView) findViewById(R.id.TextTotalAmount);
        myTextTotalAmount.setText(my_wallet.total_mount);
        
        
        
     // get input stream
        
        Context context = NotificationActivity.this.getApplicationContext();
        
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
	    //Intent i = new Intent(this, ConfirmSendMoneyActivity.class);
	    //startActivity(i);
		//super.onBackPressed();
	    Intent i=new Intent(this, MainActivity.class);
	    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    startActivity(i);

			
	}	
	
}
