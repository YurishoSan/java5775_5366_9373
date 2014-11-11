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
		PatientID = 0;
		PatientFirstName = "";
		PatientLastName = "";
		PatientServiceClass = "";
		PatientPhoneNumber = "";
		PatientDoB = null;
		
	}
	
	public Patient(long patientID,
			String patientFirstName, String patientLastName,
			String patientServiceClass, String PatientPhoneNumber, Date patientDoB) 
	{
		this.PatientID = patientID;
		this.PatientFirstName = patientFirstName;
		this.PatientLastName = patientLastName;
		this.PatientServiceClass = patientServiceClass;
		this.PatientPhoneNumber = PatientPhoneNumber;
		this.PatientDoB = patientDoB;
	}
}
