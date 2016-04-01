package ro.pub.cs.systems.eim.practicaltest01var08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends Activity {
	
	private Button button1, button2, button3, button4, button5, navigateButton;
	
	private TextView textview;
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	
	 private int nboftries =0;
	 private int nbsuceeded =0;
	 private int nboffailers =0;
	 
	 private boolean isDirty = false;
	
	
	
	  private ButtonClickListener buttonClickListener = new ButtonClickListener();
	    private class ButtonClickListener implements View.OnClickListener {

	        @Override
	        public void onClick(View view) {
	            switch(view.getId()) { 
	            
	            case R.id.button1:
	            	textview.setText("Top Left");
	            break;
	            
	            case R.id.button2:
	            	textview.setText("Top Right");
		            break;
	            case R.id.button3:
	            	textview.setText("Center");
		            break;
	            case R.id.button4:
	            	textview.setText("Bottom Left");
		            break;
	            case R.id.button5:
	            	textview.setText("Bottom Right");
		            break;
		            
	            case R.id.navigate_to_secondary_activity_button:
	            	
	            	Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
					intent.putExtra("outputView",textview.getText().toString());
					startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
					break;
	            	
	            }
	         }
	            
	        }
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var08_main);
		
		textview = (TextView) findViewById(R.id.name_text_view);
		
		button1 =  (Button) findViewById(R.id.button1);
		button1.setOnClickListener(buttonClickListener);
		
		button2 =  (Button) findViewById(R.id.button2);
		button2.setOnClickListener(buttonClickListener);
		
		button3 =  (Button) findViewById(R.id.button3);
		button3.setOnClickListener(buttonClickListener);
		
		button4 =  (Button) findViewById(R.id.button4);
		button4.setOnClickListener(buttonClickListener);
		
		button5 =  (Button) findViewById(R.id.button5);
		button5.setOnClickListener(buttonClickListener);
		
		navigateButton =  (Button) findViewById(R.id.navigate_to_secondary_activity_button);
		navigateButton.setOnClickListener(buttonClickListener);
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		  //int result = intent.getIntExtra("result", -1);
	 
		if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
			Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	    savedInstanceState.putString("textAll", textview.getText().toString());
	    
	    savedInstanceState.putInt("nboftries", nboftries);
	    savedInstanceState.putInt("nbsuceeded", nbsuceeded);
	    savedInstanceState.putInt("nboffailers", nboffailers);
	   
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey("textAll")) {
			textview.setText(savedInstanceState.getString("textAll"));
		} else {
			textview.setText(String.valueOf(""));
		}
		
		nboftries = savedInstanceState.getInt("nboftries");
	        Toast.makeText(getApplicationContext(), "nboftries is restored: " + nboftries, Toast.LENGTH_LONG).show();
		
	        nbsuceeded = savedInstanceState.getInt("nbsuceeded");
	        Toast.makeText(getApplicationContext(), "nbsuceeded is restored: " + nbsuceeded, Toast.LENGTH_LONG).show();
		
	        nboffailers = savedInstanceState.getInt("nboffailers");
	        Toast.makeText(getApplicationContext(), "nboffailers is restored: " + nboffailers, Toast.LENGTH_LONG).show();
		
	}
	

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		Intent intent = new Intent(this, PracticalTest01Var08MainActivity.class);
		//stopService(intent);
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var08_main, menu);
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
}
