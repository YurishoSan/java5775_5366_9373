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
public class Treatment
{
	private long TreatmentID;
	private long TreatmentDoctorID;
	private long TreatmentPatientID;
	private Date TreatmentDate;
	private String TreatmentSummary;
	

	public Treatment(long treatmentID, long treatmentDoctorID,
			long treatmentPatientID, Date treatmentDate, String treatmentSummary) 
	{
		TreatmentID = treatmentID;
		TreatmentDoctorID = treatmentDoctorID;
		TreatmentPatientID = treatmentPatientID;
		TreatmentDate = treatmentDate;
		TreatmentSummary = treatmentSummary;
	}
}
