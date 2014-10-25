package com.entropik.wallet;

import java.io.IOException;
import java.io.InputStream;

import com.entropik.wereabletest.SelectMoneyActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class QrBarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qr_bar);
		
		ImageView myImageContact = (ImageView) findViewById(R.id.imageViewQr);
// get input stream
        
        Context context = QrBarActivity.this.getApplicationContext();
        
        InputStream ims = null;
        try {
            ims = context.getAssets().open("Contacts/qr_img.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // load image as Drawable
        Drawable d = Drawable.createFromStream(ims, null);
        // set image to ImageView
        myImageContact.setImageDrawable(d);
		
	}
}
