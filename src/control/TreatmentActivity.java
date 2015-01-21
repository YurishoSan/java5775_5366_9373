package control;

import model.backend.BackendFactory;

import com.example.java5775_5366_9373.R;

import entities.Treatment;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.View;

public class TreatmentActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_treatment);
		
		Button button3 = (Button) findViewById(R.id.button3);
		
		button3.setOnClickListener(new OnClickListener()
		{
			public void onClick (View v)
			{
				try
				{
			    
               
					Intent	intent = new Intent(TreatmentActivity.this, MedicineListActivity.class);
					intent.putExtra("isAdd", true);
					startActivity(intent);
				}
				catch(Exception exp)
				{
	                
				}
				
			}
		});
		
		
		Button button2 = (Button) findViewById(R.id.button2);
	
		button2.setOnClickListener(new OnClickListener()
		{
			public void onClick (View v)
			{
				try
				{
			    EditText patieId =(EditText)findViewById(R.id.patieIdText);
			    EditText addres =(EditText)findViewById(R.id.addresText);
			    EditText summary =(EditText)findViewById(R.id.sumaryText);
			  //  CustomDatePicker date = (CustomDatePicker)findViewById(R.id.sumaryText);
			    
			   
			    Treatment NewTreat =new Treatment();
			    NewTreat.setTreatmentPatientID(Long.parseLong(patieId.getText().toString()));
                NewTreat.setTreatmentLocation(addres.getText().toString());
                NewTreat.setTreatmentSummary(summary.getText().toString());
                 //   NewTreat.setTreatmentDate(Date.parse(date.getText().toString()));
                BackendFactory.getInstance(getApplicationContext()).addTreatment(NewTreat);
                Toast.makeText(getApplicationContext(), "הטיפול נוסף בהצלחה", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(TreatmentActivity.this, MenuActivity.class ); 
				startActivity(intent);
				}
				catch(Exception exp)
				{
	                Toast.makeText(getApplicationContext(), exp.getMessage(), Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		
		
		
		
		
	}

	
	
}
