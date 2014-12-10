package control;

import java.util.ArrayList;

import model.backend.BackendFactory;
import model.backend.Run;
import model.backend.asyncTask;

import com.example.java5775_5366_9373.R;

import entities.Medicine;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MedicineListActivity extends Activity
{
	ListView l1;
	Medicine medicine;
	ProgressDialog progressDialog;
	ArrayList<Medicine> medicines;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine_list);

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
		
		l1.setOnItemClickListener(new OnItemClickListener()
			{

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id)
				{
					try
					{
						medicine = (Medicine) medicines.get(position);
					}
					
					catch (Exception exp)
					{
						exp.printStackTrace();
					}
					
					//TODO: add show info code here.
				}
			});
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
		public View getView(int position, View convertView, ViewGroup parent)
		{
			LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row = inflater.inflate(R.layout.medicine_row_item, parent, false);
			TextView tv = (TextView) row.findViewById(R.id.NameTextView);
			tv.setText(medicines.get(position).getMedicineName());
			return row;
		}
	}
}
