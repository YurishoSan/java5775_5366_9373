package control;

import com.example.java5775_5366_9373.R;

import entities.Doctor;
import entities.ObjectSerializer;
import android.support.v7.app.ActionBarActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MenuActivity extends ActionBarActivity
{
	Doctor doctor; // doctor loged in to system.

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		try
		{
			//Retrieve doctor.
			String serial = getIntent().getStringExtra("doctorDetails");
			if (serial != null)
				doctor = (Doctor) ObjectSerializer.deserialize(serial);
		}

		catch (Exception exp)
		{
			Toast.makeText(getApplicationContext(), exp.getMessage(),
					Toast.LENGTH_SHORT).show();
			finish();
		}

		// set events
		Button startTreatmentButton = (Button) findViewById(R.id.start_treatment_button);
		startTreatmentButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				try
				{
					Intent intent = new Intent(MenuActivity.this,
							TreatmentActivity.class);
					String doctorSerialization = ObjectSerializer
							.serialize(doctor);
					intent.putExtra("doctorDetails", doctorSerialization);
					startActivity(intent);
				}

				catch (Exception exp)
				{
					Toast.makeText(getApplicationContext(), exp.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		Button doctorDetailsButton = (Button) findViewById(R.id.doctor_details_button);
		doctorDetailsButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				//show doctor details dialog.
				final Dialog dialog = new Dialog(MenuActivity.this);

				dialog.setContentView(R.layout.doctor_details_dialog);
				dialog.setTitle("פרטי רופא");

				TextView doctorIDTextView = (TextView) dialog
						.findViewById(R.id.doctorIDTextView);
				TextView doctorFirstNameTextView = (TextView) dialog
						.findViewById(R.id.doctorFirstNameTextView);
				TextView doctorLastNameTextView = (TextView) dialog
						.findViewById(R.id.doctorLastNameTextView);
				TextView doctorGenderTextView = (TextView) dialog
						.findViewById(R.id.doctorGenderTextView);
				TextView DoctorDoBTextView = (TextView) dialog
						.findViewById(R.id.DoctorDoBTextView);
				TextView DoctorDoJTextView = (TextView) dialog
						.findViewById(R.id.DoctorDoJTextView);
				TextView doctorPhoneTextView = (TextView) dialog
						.findViewById(R.id.doctorPhoneTextView);
				TextView DoctorEmailAdressTextView = (TextView) dialog
						.findViewById(R.id.DoctorEmailAdressTextView);
				TextView DoctorSalaryTextView = (TextView) dialog
						.findViewById(R.id.DoctorSalaryTextView);
				TextView DoctorSpecializationTextView = (TextView) dialog
						.findViewById(R.id.DoctorSpecializationTextView);

				doctorIDTextView.setText(Long.toString(doctor.getDoctorID()));
				doctorFirstNameTextView.setText(doctor.getDoctorFirstName());
				doctorLastNameTextView.setText(doctor.getDoctorLastName());
				doctorGenderTextView.setText(doctor.getDoctorGender()
						.toString());
				DoctorDoBTextView.setText(doctor.getDoctorDoB().toString());
				DoctorDoJTextView.setText(doctor.getDoctorDoJ().toString());
				doctorPhoneTextView.setText(doctor.getDoctorPhoneNumber());
				DoctorEmailAdressTextView.setText(doctor.getDoctorEmailAdress());
				DoctorSalaryTextView.setText(Float.toString(doctor
						.getDoctorSalary()));
				DoctorSpecializationTextView.setText(doctor
						.getDoctorSpecialization().toString());

				Button okButton = (Button) dialog.findViewById(R.id.backButton);
				okButton.setOnClickListener(new OnClickListener()
				{

					@Override
					public void onClick(View v)
					{
						dialog.dismiss();

					}
				});

				dialog.show();
			}
		});

		ListView listview = (ListView) findViewById(R.id.content);
		listview.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				Intent intent;

				switch (position) // which list to show
				{
				case 0:
					intent = new Intent(MenuActivity.this,
							PatientListActivity.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(MenuActivity.this,
							MedicineListActivity.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(MenuActivity.this,
							AllergyListActivity.class);
					startActivity(intent);
					break;
				default:
					Toast.makeText(getApplicationContext(),
							"הבחירה אינה נתמכת", Toast.LENGTH_LONG).show();
				}

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
}
