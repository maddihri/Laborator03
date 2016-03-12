package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PhoneDialerActivity extends Activity {
	
	public static final int CONTACTS_MANAGER_REQUEST_CODE = 1234;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		MyListener listener = new MyListener();
		Button btn = (Button) findViewById(R.id.button0);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button2);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button3);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button4);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button5);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button6);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button7);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button8);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button9);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button10);
		btn.setOnClickListener(listener);
		btn = (Button) findViewById(R.id.button11);
		btn.setOnClickListener(listener);
		
		ImageButton btn2 = (ImageButton) findViewById(R.id.call);
		btn2.setOnClickListener(listener);
		btn2 = (ImageButton) findViewById(R.id.hangup);
		btn2.setOnClickListener(listener);
		btn2 = (ImageButton) findViewById(R.id.backspace);
		btn2.setOnClickListener(listener);
		
		btn2 = (ImageButton) findViewById(R.id.add);
		btn2.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class MyListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			EditText number = (EditText) findViewById(R.id.phone_nr);
			switch(v.getId()) {
		        case R.id.call:
		        	Intent intent = new Intent(Intent.ACTION_CALL);
		        	intent.setData(Uri.parse("tel:" + number.getText().toString()));
		        	startActivity(intent);
		          break;
		        case R.id.hangup:
		        	finish();
		          break;
		        case R.id.backspace:
		        	String text = number.getText().toString();
		        	if (text.length() > 0)
		        		number.setText(text.substring(0, text.length() - 1));
			      break;
		        case R.id.add:
		        	if (number.getText().toString().length() > 0) {
		        		Intent intent2 = new Intent("ro.pub.cs.systems.pdsd.lab04.contactsmanager.intent.action.ContactsManagerActivity");
		        		intent2.putExtra("ro.pub.cs.systems.pdsd.lab04.contactsmanager.PHONE_NUMBER_KEY", number.getText().toString());
		        		startActivityForResult(intent2, CONTACTS_MANAGER_REQUEST_CODE);
		        	} else {
		        		Toast.makeText(getApplication(), getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
		        	}
		        	break;
			    default:
			    	Button btn = (Button) findViewById(v.getId());
			    	number.setText(number.getText().toString() + btn.getText().toString());
			    	break;
	      }
			
		}
		
	}
	
}
