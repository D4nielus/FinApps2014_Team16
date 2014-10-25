package com.entropik.wereabletest;

import java.io.IOException;
import java.io.InputStream;

import android.R.string;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.entropik.wallet.R;
import com.entropik.wereabletest.NotificationActivity;

public class ConfirmSendMoneyActivity extends Activity  {
	Wallets settings_m;
	TextView myPassword = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_send_money);
		
		myPassword = (TextView) findViewById(R.id.TextViewPassword);
		
		myPassword.addTextChangedListener(new TextWatcher() {

			   public void beforeTextChanged(CharSequence s, int start,
			     int count, int after) {
			   }

			   public void onTextChanged(CharSequence s, int start,
			     int before, int count) {
			      if(check_is_pin_correct())
			    	  ejecutar();
			   }

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
			  });

		
		cargar_wallet();
		crear_botones();
	}
	
	private void cargar_wallet()
	{
		settings_m = new Wallets(ConfirmSendMoneyActivity.this.getApplicationContext());
        settings_m.lst_wallets.get(Integer.parseInt(settings_m.ultimo_tipo));

        Wallet my_wallet = new Wallet();
        int tipo = Integer.parseInt(settings_m.ultimo_tipo);


        my_wallet.to = settings_m.lst_wallets.get(tipo-1).to;
        my_wallet.from = settings_m.lst_wallets.get(tipo-1).from;
        my_wallet.total_mount = settings_m.lst_wallets.get(tipo-1).total_mount;
        my_wallet.the_id = settings_m.lst_wallets.get(tipo-1).the_id;
        
        
        ImageView myImageContact = (ImageView) findViewById(R.id.imageContact);
        TextView myTextNameContact = (TextView) findViewById(R.id.TextViewNameAndTotalAmount);
        myTextNameContact.setText(my_wallet.to+" ("+my_wallet.total_mount+")");
     // get input stream
        
        Context context = ConfirmSendMoneyActivity.this.getApplicationContext();
        
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
	
	private void crear_botones()
	{
		
		final Button buttonClear = (Button) findViewById(R.id.buttonClear);         
		buttonClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			        myPassword.setText("");
			}	
		}); 
		
		final Button button00 = (Button) findViewById(R.id.Button00);         
		button00.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					
				show_toast_velocity(button00.getTag().toString());
			        myPassword.setText(myPassword.getText()+"*");
			}	
		}); 

	final Button button01 = (Button) findViewById(R.id.Button01);         
	button01.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button01.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 
	
	final Button button02 = (Button) findViewById(R.id.Button02);         
	button02.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button02.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	});

	final Button button03 = (Button) findViewById(R.id.Button03);         
	button03.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button03.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 
	
	final Button button04 = (Button) findViewById(R.id.Button04);         
	button04.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button04.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 	
	
	final Button button05 = (Button) findViewById(R.id.Button05);         
	button05.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button05.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 
	
	final Button button06 = (Button) findViewById(R.id.Button06);         
	button06.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button06.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 
	
	final Button button07 = (Button) findViewById(R.id.Button07);         
	button07.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button07.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 	
	
	final Button button08 = (Button) findViewById(R.id.Button08);         
	button08.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			show_toast_velocity(button08.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 
	
	final Button button09 = (Button) findViewById(R.id.Button09);         
	button09.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
				show_toast_velocity(button09.getTag().toString());
		        myPassword.setText(myPassword.getText()+"*");
		}	
	}); 	
}

void show_toast_velocity(String texto)
{
	final Toast toast = Toast.makeText(ConfirmSendMoneyActivity.this, texto.toString(), Toast.LENGTH_SHORT);
    toast.show();

    Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               toast.cancel(); 
           }
    }, 50);
}
	
boolean check_is_pin_correct()
{
	if(myPassword.getText().length()<4)
		return false;
	else
		return true;
}

public void ejecutar() {
    Intent i = new Intent(this, NotificationActivity.class);
    startActivity(i);
	super.onBackPressed();
    

		
}
		
}
