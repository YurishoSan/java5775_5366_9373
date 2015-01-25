package control;

import java.util.ArrayList;

import model.backend.BackendFactory;
import model.backend.Run;
import model.backend.asyncTask;

import com.example.java5775_5366_9373.R;

import entities.Patient;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PatientListActivity extends ActionBarActivity
{
	ListView l1;
	Patient patient;
	ProgressDialog progressDialog;
	ArrayList<Patient> patients;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_list);
		
		l1 = (ListView) findViewById(R.id.patientListView);
		
		try
		{
			asyncTask at = new asyncTask(PatientListActivity.this, progressDialog,
					new Run() 
					{

						@Override
						public void run() throws Exception
						{
							patients = BackendFactory.getInstance(getApplicationContext()).getPatientList();
						}
						
					},
					
					new Run()
					{

						@Override
						public void run() throws Exception
						{
							l1.setAdapter(new adapter(patients));
							
						}
						
					});
			at.execute();
		}
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		l1.setOnItemClickListener(new OnItemClickListener()
			{

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id)
				{
					try
					{
						patient = (Patient) patients.get(position);
					}
					
					catch (Exception exp)
					{
						exp.printStackTrace();
					}
					
					//show patient details dialog.
					
					final Dialog dialog = new Dialog(PatientListActivity.this);
					
					dialog.setContentView(R.layout.patient_details_dialog);
					dialog.setTitle("פרטי פציינט");
					
					TextView patientIDTextView = (TextView) dialog.findViewById(R.id.patientIDTextView);
					TextView patientFirstNameTextView = (TextView) dialog.findViewById(R.id.patientFirstNameTextView);
					TextView patientLastNameTextView = (TextView) dialog.findViewById(R.id.patientLastNameTextView);
					TextView patientServiceClassTextView = (TextView) dialog.findViewById(R.id.patientServiceClassTextView);
					TextView patientSexTextView = (TextView) dialog.findViewById(R.id.patientSexTextView);
					TextView patientDoBTextView = (TextView) dialog.findViewById(R.id.patientDoBTextView);
					TextView patientPhoneTextView = (TextView) dialog.findViewById(R.id.patientPhoneTextView);
					TextView patientEmailTextView = (TextView) dialog.findViewById(R.id.patientEmailTextView);
					
					patientIDTextView.setText(Long.toString(patient.getPatientID()));
					patientFirstNameTextView.setText(patient.getPatientFirstName());
					patientLastNameTextView.setText(patient.getPatientLastName());
					patientServiceClassTextView.setText(patient.getPatientServiceClass().toString());
					patientSexTextView.setText(patient.getPatientGender().toString());
					patientDoBTextView.setText(patient.getPatientDoB().toString());
					patientPhoneTextView.setText(patient.getPatientPhoneNumber());
					patientEmailTextView.setText(patient.getPatientEmailAdress());
					
					/*Button showTreatments = (Button) dialog.findViewById(R.id.showTreatmentsButton);
					showTreatments.setOnClickListener(new OnClickListener()
					{
						
						@Override
						public void onClick(View v)
						{
							Intent intent;
							intent = new Intent(PatientListActivity.this, TreatmentListActivity.class);
							intent.putExtra("patient", patient);
							startActivity(intent);
							
						}
					});*/
					
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
	}

	private class adapter extends BaseAdapter
	{
		ArrayList<Patient> patients;

		public adapter(ArrayList<Patient> patients)
		{
			super();
			this.patients = patients;
		}

		@Override
		public int getCount()
		{
			return patients.size();
		}

		@Override
		public Object getItem(int position)
		{
			return null;
		}

		@Override
		public long getItemId(int position)
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.patient_row_item, parent, false);
			TextView tv = (TextView) row.findViewById(R.id.NameTextView);
			tv.setText(patients.get(position).getPatientFirstName() + " "
					 + patients.get(position).getPatientLastName());
			
			tv = (TextView) row.findViewById(R.id.IdTextView);
			tv.setText((Long.toString(patients.get(position).getPatientID())));
			return row;
		}
	}
}