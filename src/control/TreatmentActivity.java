package control;

import model.backend.BackendFactory;

import com.example.java5775_5366_9373.R;

import entities.Treatment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.view.View;

public class TreatmentActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_treatment);
		Button button = (Button) findViewById(R.id.button2);
	
		button.setOnClickListener(new OnClickListener()
		{
			public void onClick (View v)
			{
				try
				{
			    EditText patieId =(EditText)findViewById(R.id.patieIdText);
			    EditText addres =(EditText)findViewById(R.id.addresText);
			    EditText summary =(EditText)findViewById(R.id.sumaryText);
			    
			    Treatment NewTreat =new Treatment();
			    NewTreat.setTreatmentPatientID(Long.parseLong(patieId.getText().toString()));
                NewTreat.setTreatmentLocation(addres.getText().toString());
                NewTreat.setTreatmentSummary(summary.getText().toString());
                BackendFactory.getInstance(getApplicationContext()).addTreatment(NewTreat);
					
				}
				catch(Exception exp)
				{
					
				}
				
			}
		});
		
		
		
		
		
		
	}

	
	
}
