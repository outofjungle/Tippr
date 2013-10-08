package com.example.tippr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipperActivity extends Activity {

	public EditText etSubTotal;
	public TextView tvTip;
	public TextView tvTotal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipper);
		
		etSubTotal = (EditText) findViewById(R.id.etSubTotal);
		tvTip = (TextView) findViewById(R.id.tvTip);
		tvTotal = (TextView) findViewById(R.id.tvTotal);
		
		etSubTotal.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	String entered_sub_total = etSubTotal.getText().toString();
		        if("0.00".equals(entered_sub_total)) {
		            etSubTotal.setText("");
		        }
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tipper, menu);
		return true;
	}
	
	protected void calculateTip(float percent) {
		
		String entered_sub_total = etSubTotal.getText().toString();
		if (entered_sub_total == null || "".equals(entered_sub_total)) {
			entered_sub_total = "0";
		}
		
		float sub_total = Float.parseFloat(entered_sub_total);
		Log.d("DEBUG", String.format("Sub Total = %f, Percent = %f", sub_total, percent));
		
		float tip_amount = sub_total * (percent/100f); 
		float total = sub_total + tip_amount;
		Log.d("DEBUG", String.format("Tip = %f, Total = %f", tip_amount, total));
		
		etSubTotal.setText(String.format("%.2f", sub_total));
		tvTip.setText(String.format("$ %.2f", tip_amount));
		tvTotal.setText(String.format("Total: $ %.2f", total));	
	}
	
	public void submit10Percent(View v) {
		calculateTip(10.0f);
	}

	public void submit15Percent(View v) {
		calculateTip(15.0f);
	}
	
	public void submit20Percent(View v) {
		calculateTip(20.0f);
	}
}
