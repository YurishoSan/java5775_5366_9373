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
	
	public Treatment() 
	{
		TreatmentID = 0;
		TreatmentDoctorID = 0;
		TreatmentPatientID = 0;
		TreatmentDate = null;
		TreatmentSummary = "";
	}

	public Treatment(long treatmentID, long treatmentDoctorID,
			long treatmentPatientID, Date treatmentDate, String treatmentSummary) 
	{
		this.TreatmentID = treatmentID;
		this.TreatmentDoctorID = treatmentDoctorID;
		this.TreatmentPatientID = treatmentPatientID;
		this.TreatmentDate = treatmentDate;
		this.TreatmentSummary = treatmentSummary;
	}
}
