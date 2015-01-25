package control;

import java.util.ArrayList;

import model.backend.BackendFactory;
import model.backend.Run;
import model.backend.asyncTask;

import com.example.java5775_5366_9373.R;

import entities.Allergy;
import entities.Doctor;
import entities.Medicine;
import entities.ObjectSerializer;
import entities.Patient;
import entities.Prescription;
import entities.Treatment;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ViewHolder")
public class TreatmentActivity extends ActionBarActivity
{
	Doctor doctor;
	Patient patient;
	Spinner patientIdSpinner;
	ArrayList<Medicine> medicines;
	ArrayList<Patient> patients;
	ArrayList<Allergy> patientAllergies;
	ArrayList<Allergy> medicineAllergies;
	ProgressDialog progressDialog;
	boolean success = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_treatment);
		medicines = new ArrayList<Medicine>();

		try
		{
			// retrive doctor loged in to system.

			String serial = getIntent().getStringExtra("doctorDetails");
			if (serial != null)
				doctor = (Doctor) ObjectSerializer.deserialize(serial);
		}

		catch (Exception exp)
		{
			Toast.makeText(getApplicationContext(), exp.getMessage(),
					Toast.LENGTH_SHORT).show();
		}

		patientIdSpinner = (Spinner) findViewById(R.id.patientIdSpinner); // choose
																			// patient
																			// spinner

		try
		{
			asyncTask at = new asyncTask(TreatmentActivity.this,
					progressDialog, new Run()
					{

						@Override
						public void run() throws Exception
						{
							patients = BackendFactory.getInstance(
									getApplicationContext()).getPatientList();
						}

					},

					new Run()
					{

						@Override
						public void run() throws Exception
						{
							patientIdSpinner.setAdapter(new adapter(patients));

						}

					});
			at.execute();
		}

		catch (Exception exp)
		{
			exp.printStackTrace();
		}

		patientIdSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
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

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
				// TODO Auto-generated method stub

			}
		});

		Button addMedicineTreatment = (Button) findViewById(R.id.addMedicineTreatment);

		addMedicineTreatment.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				try
				{
					// send to medicine selection activity.
					Intent intent = new Intent(TreatmentActivity.this,
							MedicineListActivity.class);
					intent.putExtra("isAdd", true);
					startActivityForResult(intent, 1);
				}
				catch (Exception exp)
				{

				}

			}
		});

		Button addButton = (Button) findViewById(R.id.addButton);

		addButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				try
				{
					// add the treatment
					EditText addressText = (EditText) findViewById(R.id.addressText);
					EditText summeryText = (EditText) findViewById(R.id.summaryText);
					final CustomDatePicker dateDatePicker = (CustomDatePicker) findViewById(R.id.dateDatePicker);

					final Treatment treatment = new Treatment(0, doctor
							.getDoctorID(), patient.getPatientID(),
							dateDatePicker.calendar.getTime(), addressText
									.getText().toString(), summeryText
									.getText().toString(), false);

					try
					{
						asyncTask at = new asyncTask(TreatmentActivity.this,
								progressDialog, new Run()
								{

									@Override
									public void run() throws Exception
									{
										// check allergies of patient and
										// medicine.
										patientAllergies = BackendFactory
												.getInstance(
														getApplicationContext())
												.getAllergyByPatientList(
														patient.getPatientID());
										for (Medicine medicine : medicines)
										{
											medicineAllergies = BackendFactory
													.getInstance(
															getApplicationContext())
													.getAllergyByMedicineList(
															medicine.getMedicineID());

											// keep allergies that appear in
											// both.
											medicineAllergies
													.retainAll(patientAllergies);

											// there is an intersection, abort
											// adding meds
											if (!medicineAllergies.isEmpty())
											{
												success = false;
												return;
											}
										}

										// add treatments
										long id = BackendFactory.getInstance(
												getApplicationContext())
												.addTreatment(treatment);

										// then add prescriptions
										for (Medicine medicine : medicines)
										{
											Prescription prescription = new Prescription(
													id, medicine
															.getMedicineID(),
													dateDatePicker.calendar
															.getTime());
											BackendFactory.getInstance(
													getApplicationContext())
													.addPrescription(
															prescription);
										}

										success = true;
									}

								},

								new Run()
								{

									@Override
									public void run() throws Exception
									{
										if (success)
										{
											Toast.makeText(
													getApplicationContext(),
													"הטיפול נוסף בהצלחה",
													Toast.LENGTH_SHORT).show();
											finish();
										}
										else
										{
											String allergies = "";
											AlertDialog ad = new AlertDialog.Builder(
													TreatmentActivity.this)
													.create();
											for (Allergy allergy : medicineAllergies)
												allergies += allergy
														.getAllergyName()
														+ "\n";
											ad.setTitle("Problem!");
											ad.setMessage("Patient allergic to medicine, due to allergies:\n"
													+ allergies);
											ad.show();
										}
									}
								});
						at.execute();
					}

					catch (Exception exp)
					{
						exp.printStackTrace();
					}
				}
				catch (Exception exp)
				{

					Toast.makeText(getApplicationContext(), exp.getMessage(),
							Toast.LENGTH_SHORT).show();
				}

			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{

		if (requestCode == 1) // when medicine activity return
		{
			if (resultCode == RESULT_OK) // if medicines return well
			{
				try
				{
					// Retrieve medicines list
					String serial = data.getStringExtra("medicines");
					if (serial != null)
						medicines = (ArrayList<Medicine>) ObjectSerializer
								.deserialize(serial);
				}
				catch (Exception exp)
				{
					Toast.makeText(getApplicationContext(), exp.getMessage(),
							Toast.LENGTH_SHORT).show();
				}
			}
			if (resultCode == RESULT_CANCELED)
			{
				// Write your code if there's no result
			}
		}
	}// onActivityResult

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
			View row = inflater.inflate(R.layout.patient_row_item, parent,
					false);
			TextView tv = (TextView) row.findViewById(R.id.NameTextView);
			tv.setText(patients.get(position).getPatientFirstName() + " "
					+ patients.get(position).getPatientLastName());

			tv = (TextView) row.findViewById(R.id.IdTextView);
			tv.setText((Long.toString(patients.get(position).getPatientID())));
			return row;
		}
	}
}
