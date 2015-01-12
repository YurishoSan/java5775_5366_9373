package control;

import com.example.java5775_5366_9373.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MenuActivity extends ActionBarActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		//set events
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick (View v)
			{
				Intent intent =new Intent(MenuActivity.this,TreatmentActivity.class);
				startActivity(intent);
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
				
				switch(position)
				{
				case 0:
					intent = new Intent(MenuActivity.this, PatientListActivity.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(MenuActivity.this, MedicineListActivity.class);
					intent.putExtra("isAdd", true);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(MenuActivity.this, AllergyListActivity.class);
					startActivity(intent);
					break;
				default:
					Toast.makeText(getApplicationContext(), "הבחירה אינה נתמכת", Toast.LENGTH_LONG).show();
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
