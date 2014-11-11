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
	private long PatientHistoryID; // ID of patient's treatment history.
	private String PatientFirstName;
	private String PatientLastName;
	private String PatientServiceClass; // TODO: make service class enum.
	private Date PatientDoB; // Date of birth
	
	
	public Patient(long patientID, long patientHistoryID,
			String patientFirstName, String patientLastName,
			String patientServiceClass, Date patientDoB) 
	{
		PatientID = patientID;
		PatientHistoryID = patientHistoryID;
		PatientFirstName = patientFirstName;
		PatientLastName = patientLastName;
		PatientServiceClass = patientServiceClass;
		PatientDoB = patientDoB;
	}
}
