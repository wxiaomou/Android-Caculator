/** Description of Brief Calculator
 * 
 * @author Xiaomou Wang
 * 
 * @version 1.0 Jan 2013
 */
package com.example.briefcaculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private String tmp = "";
	private int oper = -1; 
	private double num1 = 0.0;
	private double num2 = 0.0;
	private Boolean isOper = false;
	
	
	private Button b0 = null;
	private Button b1 = null;
	private Button b2 = null;
	private Button b3 = null;
	private Button b4 = null;
	private Button b5 = null;
	private Button b6 = null;
	private Button b7 = null;
	private Button b8 = null;
	private Button b9 = null;

	private Button c = null;
	private Button PosNeg = null;
	private Button dot = null;
	private Button equ = null;
	
	private Button add = null;
	private Button min = null;
	private Button muli = null;
	private Button div = null;
	
	private EditText editBox = null;
	
	@Override
	/**
	 * 
	 * Android call back function, called when start the activity.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CreateView();
		setListeners();
	}
	
	/**
	 * 
	 * Create the view of the main layout.
	 */
	private void CreateView() {
		b0 = (Button) findViewById(R.id.b0);
		b1 = (Button) findViewById(R.id.b1);
		b2 = (Button) findViewById(R.id.b2);
		b3 = (Button) findViewById(R.id.b3);
		b4 = (Button) findViewById(R.id.b4);
		b5 = (Button) findViewById(R.id.b5);
		b6 = (Button) findViewById(R.id.b6);
		b7 = (Button) findViewById(R.id.b7);
		b8 = (Button) findViewById(R.id.b8);
		b9 = (Button) findViewById(R.id.b9);

		c = (Button)findViewById(R.id.c);
		PosNeg = (Button)findViewById(R.id.pos_neg);
		dot = (Button)findViewById(R.id.dot);
		equ = (Button)findViewById(R.id.equal);
		
		add = (Button)findViewById(R.id.add);
		min = (Button)findViewById(R.id.minus);
		muli = (Button)findViewById(R.id.multi);
		div = (Button)findViewById(R.id.divide);	
		
		editBox = (EditText) findViewById(R.id.input_num);
	}
	
	/**
	 * 
	 * Set listeners to Buttons.
	 */
	private void setListeners() {
		b1.setOnClickListener(new NumListener());
		b2.setOnClickListener(new NumListener());
		b3.setOnClickListener(new NumListener());
		b4.setOnClickListener(new NumListener());
		b5.setOnClickListener(new NumListener());
		b6.setOnClickListener(new NumListener());
		b7.setOnClickListener(new NumListener());
		b8.setOnClickListener(new NumListener());
		b9.setOnClickListener(new NumListener());
		b0.setOnClickListener(new NumListener());
		
		add.setOnClickListener(new OperatorListener());
		min.setOnClickListener(new OperatorListener());
		muli.setOnClickListener(new OperatorListener());
		div.setOnClickListener(new OperatorListener());
		
		PosNeg.setOnClickListener(new PosNegListener());
		
		dot.setOnClickListener(new DotListener());
		
		c.setOnClickListener(new ClearListener());
		
		equ.setOnClickListener(new EqualListener());
	}
	
	/**
	 * 
	 * Compute the result and display the result.
	 */
	private void computeAndShow() {
		switch(oper)
		{
			case 0:
				editBox.setText(num1 + num2 + "");
				break;
			case 1:
				editBox.setText(num1 - num2 + "");
				break;
			case 2:
				editBox.setText(num1 * num2 + "");
				break;
			case 3:
				if(num2 == 0.0)
				{
					ToastShow("invalid divider");
				}
				else
				{
					editBox.setText(num1 / num2 + "");
					break;
				}
		}
	}
	
	/**
	 * 
	 * Display a message.
	 * @param str String to Display.
	 */
	private void ToastShow(String str) {
		Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 *
	 * Fired when About Button clicked.
	 */
	public void OnClickAbout(View view) {
		Intent intent = new Intent(MainActivity.this, About.class);
		startActivity(intent);
	}

	/**
	 *
	 * Fired when Quit Button clicked. 
	 */
	public void OnClickQuit(View view) {
		finish();
	}
	
	/**
	 * 
	 * Listener for number buttons.
	 */
	private class NumListener implements OnClickListener{

		@Override
		public void onClick(View view) {
			if (isOper) {
				editBox.setText("");
				isOper = false;
			}
			tmp = editBox.getText().toString().trim();
			switch (view.getId()) {
			case R.id.b0:
				tmp += "0";
				break;
			case R.id.b1:
				tmp += "1";
				break;
			case R.id.b2:
				tmp += "2";
				break;
			case R.id.b3:
				tmp += "3";
				break;
			case R.id.b4:
				tmp += "4";
				break;
			case R.id.b5:
				tmp += "5";
				break;
			case R.id.b6:
				tmp += "6";
				break;
			case R.id.b7:
				tmp += "7";
				break;
			case R.id.b8:
				tmp += "8";
				break;
			case R.id.b9:
				tmp += "9";
				break;
			}
			editBox.setText(tmp);
		}
		
	}

	/**
	 * 
	 * Listeners for operators.
	 */
	private class OperatorListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (oper != -1) {
				num2 = Double.parseDouble(editBox.getText().toString().trim());
				ToastShow("here");
				computeAndShow();
			}
			
			if ((editBox.getText().toString().trim()).equals("")) {
				ToastShow("Please enter a number");
			} else {
				switch (v.getId()) {
				case R.id.add:
					oper = 0;
					break;
				case R.id.minus:
					oper = 1;
					break;
				case R.id.multi:
					oper = 2;
					break;
				case R.id.divide:
					oper = 3;
					break;
				}
			}
			num1 = Double.parseDouble(editBox.getText().toString().trim());
			isOper = true;
		}

		
	}
	
	/**
	 * 
	 * Listener for equal operator.
	 */
	private class EqualListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			num2 = Double.parseDouble(editBox.getText().toString().trim());
			computeAndShow();
			num1 = Double.parseDouble(editBox.getText().toString().trim());
			isOper = false;
			oper = -1;
		}
		
	}
	
	/**
	 * 
	 * Listener for the button pos neg.
	 */
	private class PosNegListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			String t;
			t = editBox.getText().toString().trim();
			if(!t.equals(""))
			{
				if(t.substring(0, 1).equals("-"))
				{
					t = t.substring(1);
				}
				else
				{
					t = "-"+t;
				}
			}
			editBox.setText(t);
			num1 = 0.0 - num1;
		}
		
	}
	
	/**
	 * 
	 *	Listener for the button dot.
	 */
	private class DotListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			tmp = editBox.getText().toString().trim();
			if (tmp.equals("")) {
				tmp = "0.";
			} else {
				if (!tmp.contains(".")) {
					tmp = tmp + ".";
				}
			}
			editBox.setText(tmp);
		}
	}
	/**
	 * 
	 *	Listener for clear button.
	 */
	private class ClearListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			num1 = 0.0;
			num2 = 0.0;
			editBox.setText("");
		}
	}
	


	
}
