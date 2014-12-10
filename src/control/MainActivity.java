package control;

import model.backend.*;

import com.example.java5775_5366_9373.R;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.dismiss();
		setProgressBarIndeterminateVisibility(false);
		
		try
		{
			asyncTask t1 = new asyncTask(MainActivity.this, progressDialog,
					new Run()
					{
						@Override
						public void run() throws Exception
						{
							Backend test = BackendFactory.getInstance(getApplicationContext());
						}
					},					
					null);
			
			t1.execute();
		}
			
		catch (Exception exp)
		{
			Toast.makeText(getApplicationContext(), "האפליקציה הפסיקה לעבוד", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClickLoginButton(View v)
	{
		 Intent myIntent = new Intent(MainActivity.this ,MenuActivity.class);
		 startActivity(myIntent);  
	}
}