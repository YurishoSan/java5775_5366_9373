package control;

import java.util.ArrayList;
import model.backend.BackendFactory;
import model.backend.Run;
import model.backend.asyncTask;
import com.example.java5775_5366_9373.R;
import entities.Allergy;
import entities.Medicine;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class AllergyListActivity extends ActionBarActivity
{
	ListView l1;
	Allergy allergy;
	Medicine medicine; //medicine this list was called from, null if request all allergies.
	ProgressDialog progressDialog;
	ArrayList<Allergy> allergies;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allergy_list);
		
		medicine = (Medicine) getIntent().getSerializableExtra("medicine");
		
		l1 = (ListView) findViewById(R.id.allergyListView);
		
		try
		{
			asyncTask at = new asyncTask(AllergyListActivity.this, progressDialog,
					new Run() 
					{

						@Override
						public void run() throws Exception
						{
							if (medicine == null)
								allergies = BackendFactory.getInstance(getApplicationContext()).getAllergyList();
							else
								allergies = BackendFactory.getInstance(getApplicationContext()).getAllergyByMedicineList(medicine.getMedicineID());
						}
						
					},
					
					new Run()
					{

						@Override
						public void run() throws Exception
						{
							l1.setAdapter(new adapter(allergies));
							
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
						allergy = (Allergy) allergies.get(position);
					}
					
					catch (Exception exp)
					{
						exp.printStackTrace();
					}
					
					final Dialog dialog = new Dialog(AllergyListActivity.this);
					dialog.setContentView(R.layout.allergy_details_dialog);
					dialog.setTitle("פרטי אלרגיה");
					
					TextView idTextView = (TextView) dialog.findViewById(R.id.allergyIDTextView);
					TextView nameTextView = (TextView) dialog.findViewById(R.id.allergyNameTextView);
					TextView detailsTextView = (TextView) dialog.findViewById(R.id.allergyDetailsTextView);
					
					idTextView.setText(Long.toString(allergy.getAllergyID()));
					nameTextView.setText(allergy.getAllergyName());
					detailsTextView.setText(allergy.getAllergyNotes());
					
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
		ArrayList<Allergy> allergies;

		public adapter(ArrayList<Allergy> allergies)
		{
			super();
			this.allergies = allergies;
		}

		@Override
		public int getCount()
		{
			return allergies.size();
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

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.patient_row_item, parent, false);
			TextView tv = (TextView) row.findViewById(R.id.NameTextView);
			tv.setText(allergies.get(position).getAllergyName());
			return row;
		}
	}
}