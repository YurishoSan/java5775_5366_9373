package control;

import java.util.ArrayList;

import model.backend.*;

import com.example.java5775_5366_9373.R;

import entities.Doctor;
import entities.ObjectSerializer;
import entities.enums.Permit;
import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{
	ProgressDialog progressDialog;
	Permit permit;
	Doctor user;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressDialog = new ProgressDialog(this);
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
							Backend test = BackendFactory
									.getInstance(getApplicationContext());
							if(test.isEmpty())
								test.setLists();
						}
					}, null);

			t1.execute();
		}

		catch (Exception exp)
		{
			Toast.makeText(getApplicationContext(), "האפליקציה הפסיקה לעבוד",
					Toast.LENGTH_LONG).show();
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
		final long id;
		final String pass;

		String temp = ((EditText) findViewById(R.id.docNum)).getText()
				.toString().trim();
		
		if (temp.equals(""))
		{
			Toast.makeText(getApplicationContext(), "נא הכנס מספר משתמש", Toast.LENGTH_SHORT).show();
			return;
		}
		id = Long.valueOf(temp);
		pass = ((EditText) findViewById(R.id.password)).getText().toString().trim();

		progressDialog = new ProgressDialog(this);
		progressDialog.dismiss();

		try
		{

			asyncTask t1 = new asyncTask(MainActivity.this, progressDialog,
					new Run()
					{
						@Override
						public void run() throws Exception
						{
							ArrayList<Doctor> doctors;
							user = null;
							permit = Permit.DENIED;
							
							doctors = BackendFactory.getInstance(
									getApplicationContext()).getDoctorList();
							for(Doctor doctorItem : doctors)
								if (doctorItem.getDoctorID() == id)
								{
									user = doctorItem;
									
									permit = BackendFactory.getInstance(
											getApplicationContext()).checkPassword(id,
											pass);
									break;
								}
							if (user == null) // no doctor with this id found.
								permit = Permit.DENIED;
						}
					},

					new Run()
					{

						@Override
						public void run() throws Exception
						{
							if (permit == Permit.DOCTOR)
							{
								Intent myIntent = new Intent(MainActivity.this,
										MenuActivity.class);
								String doctorSerialization = ObjectSerializer.serialize(user); 
								myIntent.putExtra("doctorDetails",doctorSerialization);
								myIntent.putExtra("Permit", permit);
								startActivity(myIntent);
							}
							else if (permit == Permit.DENIED)
								Toast.makeText(getApplicationContext(),
										"שם משתמש או סיסמה שגויה.",
										Toast.LENGTH_SHORT).show();
							else // other permit i.e. ADMIN, COMPANY, PATIENT, etc.
								Toast.makeText(getApplicationContext(),
										"האפליקציה לשימוש רופאים בלבד.",
										Toast.LENGTH_SHORT).show();
						}

					});

			t1.execute();
		}

		catch (Exception exp)
		{
			Toast.makeText(getApplicationContext(), "אין גישה לבסיס הנתונים",
					Toast.LENGTH_LONG).show();
		}
	}
}