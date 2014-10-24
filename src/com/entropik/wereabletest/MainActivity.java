package com.entropik.wereabletest;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String EXTRA_EVENT_ID = "1";
	private int notificationId = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button buttonMsg = (Button) findViewById(R.id.button_click_notification);         
		buttonMsg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				notification_show();
			}
		}); 
		
		final Button buttonEmail = (Button) findViewById(R.id.button_click_email);         
		buttonEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				notification_email();
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
	
}
