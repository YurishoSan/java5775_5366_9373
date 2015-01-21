package control;

import java.util.ArrayList;

import model.backend.BackendFactory;
import model.backend.Run;
import model.backend.asyncTask;

import com.example.java5775_5366_9373.R;

import entities.Medicine;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MedicineListActivity extends ActionBarActivity
{
	ListView l1;
	Medicine medicine;
	boolean isAdd;
	ProgressDialog progressDialog;
	ArrayList<Medicine> medicines;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine_list);
		
		isAdd = (boolean) getIntent().getBooleanExtra("isAdd", false);

		l1 = (ListView) findViewById(R.id.medicineListView);
		
		try
		{
			asyncTask at = new asyncTask(MedicineListActivity.this, progressDialog,
					new Run() 
					{

						@Override
						public void run() throws Exception
						{
							medicines = BackendFactory.getInstance(getApplicationContext()).getMedicineList();
						}
						
					},
					
					new Run()
					{

						@Override
						public void run() throws Exception
						{
							l1.setAdapter(new adapter(medicines));
							
						}
						
					});
			at.execute();
		}
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		if(isAdd)
		{
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.medicine_list, menu);
		}
		return super.onCreateOptionsMenu(menu);
	}

	private class adapter extends BaseAdapter
	{
		ArrayList<Medicine> medicines;

		public adapter(ArrayList<Medicine> medicines)
		{
			super();
			this.medicines = medicines;
		}

		@Override
		public int getCount()
		{
			return medicines.size();
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
		public View getView(final int position, View convertView, ViewGroup parent)
		{
			View row;
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			if (isAdd)
				row = inflater.inflate(R.layout.add_medicine_row_item, parent, false);
			else
				row = inflater.inflate(R.layout.medicine_row_item, parent, false);
			
			TextView tv = (TextView) row.findViewById(R.id.NameTextView);
			tv.setText(medicines.get(position).getMedicineName());
			
			tv.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					try
					{
						medicine = (Medicine) medicines.get(position);
					}
					
					catch (Exception exp)
					{
						exp.printStackTrace();
					}
					
					final Dialog dialog = new Dialog(MedicineListActivity.this);
							
					dialog.setContentView(R.layout.medicine_details_dialog);
					dialog.setTitle("פרטי תרופה");
					
					TextView idTextView = (TextView) dialog.findViewById(R.id.medicineIDTextView);
					TextView nameTextView = (TextView) dialog.findViewById(R.id.medicineNameTextView);
					TextView typeTextView = (TextView) dialog.findViewById(R.id.medicineTypeTextView);
					TextView activeIngredientsTextView = (TextView) dialog.findViewById(R.id.medicineActiveIngredientsTextView);
					TextView ingredientsTextView = (TextView) dialog.findViewById(R.id.medicineIngredientsTextView);
					
					idTextView.setText(Long.toString(medicine.getMedicineID()));
					nameTextView.setText(medicine.getMedicineName());
					typeTextView.setText(medicine.getMedicineType().toString());
					activeIngredientsTextView.setText(medicine.getMedicineActiveIngredients());
					ingredientsTextView.setText(medicine.getMedicineIngredients());
					
					Button showAllergies = (Button) dialog.findViewById(R.id.showAllergiesButton);
					showAllergies.setOnClickListener(new OnClickListener()
					{
						
						@Override
						public void onClick(View v)
						{
							Intent intent;
							intent = new Intent(MedicineListActivity.this, AllergyListActivity.class);
							intent.putExtra("medicine", medicine);
							startActivity(intent);
							
						}
					});
					
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
			
			return row;
		}
	}
}
