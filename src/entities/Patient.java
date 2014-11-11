/**
 * 
 */
package entities;

import java.util.Date;

/**
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 */
public class Patient
{
	
	private long PatientID;
	private String PatientFirstName;
	private String PatientLastName;
	private String PatientServiceClass; // TODO: make service class enum.
	private String PatientPhoneNumber;
	private Date PatientDoB; // Date of birth
	
	public Patient()
	{
		super();
	}

	public Patient(long patientID, String patientFirstName,
			String patientLastName, String patientServiceClass,
			String patientPhoneNumber, Date patientDoB)
	{
		super();
		PatientID = patientID;
		PatientFirstName = patientFirstName;
		PatientLastName = patientLastName;
		PatientServiceClass = patientServiceClass;
		PatientPhoneNumber = patientPhoneNumber;
		PatientDoB = patientDoB;
	}
	
	
}
