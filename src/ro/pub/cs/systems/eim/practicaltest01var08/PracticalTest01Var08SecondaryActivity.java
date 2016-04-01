package ro.pub.cs.systems.eim.practicaltest01var08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var08SecondaryActivity  extends Activity {
	
	private Button verifyButton, cancelButton;
	
	private TextView outputView;
	
	  private ButtonClickListener buttonClickListener = new ButtonClickListener();
	    private class ButtonClickListener implements View.OnClickListener {

	        @Override
	        public void onClick(View view) {
	            switch(view.getId()) { 
	            
	            case R.id.verify_button:
	            //nbsuceeded ++;
	            setResult(RESULT_OK, null);
	            break;
	            
	            case R.id.cancel_button:
	            setResult(RESULT_CANCELED, null);
		            break;
	            
	            }
	         }
	            
	            
	        }

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondary_activity_practical_test01_var08_main);
		
		outputView = (TextView) findViewById(R.id.output_text_view);
		
		verifyButton =  (Button) findViewById(R.id.verify_button);
		verifyButton.setOnClickListener(buttonClickListener);
		
		cancelButton =  (Button) findViewById(R.id.cancel_button);
		cancelButton.setOnClickListener(buttonClickListener);
		
		Intent intent = getIntent();
		if (intent != null && intent.getExtras().containsKey("outputView")) {
			String output = intent.getStringExtra("outputView");
			outputView.setText(String.valueOf(output));
//	        int result = 0;
//			intent.putExtra("result", result);
	       // setResult(Activity.RESULT_OK, intent);
	       //finish();
		}
	
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var08_secondary_main, menu);
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
