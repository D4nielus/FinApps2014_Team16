package com.entropik.wereabletest;

import com.entropik.wereabletest.Item;
import com.entropik.wereabletest.ItemAdapter;
import com.entropik.wereabletest.ListActivity;
import com.entropik.wereabletest.MainActivity;
import com.entropik.wereabletest.Model;
import com.entropik.wallet.QrBarActivity;
import com.entropik.wallet.R;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView listView;
	public int request_code = 1;
	public Wallets settings_m;
	
	private static final String EXTRA_EVENT_ID = "1";
	private int notificationId = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button buttonSendMoney = (Button) findViewById(R.id.button_click_enviar_money);         
		buttonSendMoney.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
					//Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
	            	
					preparar_layout("1");
					
					lanzar();

				//notification_show();
			}
		}); 
		
		final Button buttonEmail = (Button) findViewById(R.id.button_click_email);         
		buttonEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				abrir_qr();
				//notification_email();
			}
		}); 
	}
	
	void notification_show()
	{
		
		// Build intent for notification content
		Intent viewIntent = new Intent(this, MainActivity.class);
		String eventId="";
		viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
		PendingIntent viewPendingIntent =
		        PendingIntent.getActivity(this, 0, viewIntent, 0);

		NotificationCompat.Builder notificationBuilder =
		        new NotificationCompat.Builder(this)
		        .setSmallIcon(R.drawable.ic_launcher)
		        .setContentTitle("Notification")
		        .setContentText("Hello this is a notification num" + notificationId +" example")
		        .setContentIntent(viewPendingIntent);
		notificationId++;
		// Get an instance of the NotificationManager service
		NotificationManagerCompat notificationManager =
		        NotificationManagerCompat.from(this);

		// Build the notification and issues it with notification manager.
		notificationManager.notify(notificationId, notificationBuilder.build());
		
		
	}
	
	void notification_email()
	{
		
		Bitmap d = BitmapFactory.decodeResource(getResources(),
                R.drawable.markets);
		
		// Create a WearableExtender to add functionality for wearables
		NotificationCompat.WearableExtender wearableExtender =
		        new NotificationCompat.WearableExtender()
		        .setHintHideIcon(true)
		        .setBackground(d);

		// Create a NotificationCompat.Builder to build a standard notification
		// then extend it with the WearableExtender
		Notification notif = new NotificationCompat.Builder(this)
		        .setContentTitle("New mail from @NASDAQ_spider")
		        .setContentText("Intel +(0.3) \n\r Samsung +(1.0)")
		        .setSmallIcon(R.drawable.ic_launcher)
		        .extend(wearableExtender)
		        .build();
		
		// Get an instance of the NotificationManager service
		NotificationManagerCompat notificationManager =  NotificationManagerCompat.from(this);

		// Issue the notification with notification manager.
		notificationManager.notify(notificationId, notif);
		
	}
	
public void lanzar() {
    	
    	
    	
        if(((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE) && (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE))
        {
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
                    Toast.makeText(MainActivity.this, "Id imagen "+ children.IconFile.toString() +"has seleccionado " + children.Name.toString(), Toast.LENGTH_SHORT).show();
                    
                    //final TextView txt_provincia = (TextView) findViewById(R.id.txt_provincia);
                    //txt_provincia.setText(children.Name.toString());
                    

                }
            });
        }else
        {

        Intent intent = new Intent(MainActivity.this, ListActivity.class );
        startActivityForResult(intent, request_code );

        /** Fading Transition Effect */
        MainActivity.this.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
        }
    }	

private void preparar_layout(String tipo)
{
    settings_m = new Wallets(MainActivity.this.getApplicationContext());
    settings_m.ultimo_tipo = tipo;
    settings_m.set_tipo(tipo);
}

void abrir_qr()
{
	Intent i = new Intent(this, QrBarActivity.class);
    startActivity(i);
}

}
