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
public class Prescription
{
	
	private long PrescriptionID;
	private long PrescriptionTreatmentID;
	private long PrescriptionMedicineID;
	
	public Prescription() 
	{
		PrescriptionID = 0;
		PrescriptionTreatmentID = 0;
		PrescriptionMedicineID = 0;
	}
	
	public Prescription(long prescriptionID, long prescriptionTreatmentID,
			long prescriptionMedicineID) 
	{
		this.PrescriptionID = prescriptionID;
		this.PrescriptionTreatmentID = prescriptionTreatmentID;
		this.PrescriptionMedicineID = prescriptionMedicineID;
	}
}
