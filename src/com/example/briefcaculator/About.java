/** Description of Activity About
 * 
 * @author Xiaomou Wang
 * 
 * @version 1.0 Jan 2013
 */
package com.example.briefcaculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	}
	
	/**
	 * 
	 * Exit About Activity.
	 */
	public void OnClickQuit(View view) {
		Intent intent = new Intent(About.this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
