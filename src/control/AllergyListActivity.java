package control;

import java.util.ArrayList;

import model.backend.BackendFactory;
import model.backend.Run;
import model.backend.asyncTask;

import com.example.java5775_5366_9373.R;

import entities.Allergy;
import android.app.Activity;
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

public class AllergyListActivity extends Activity
{
	ListView l1;
	Allergy allergy;
	ProgressDialog progressDialog;
	ArrayList<Allergy> allergies;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allergy_list);
		
		l1 = (ListView) findViewById(R.id.allergyListView);
		
		try
		{
			asyncTask at = new asyncTask(AllergyListActivity.this, progressDialog,
					new Run() 
					{

						@Override
						public void run() throws Exception
						{
							allergies = BackendFactory.getInstance(getApplicationContext()).getAllergyList();
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
					
					//TODO: add show info code here.
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