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
		super();
	}

	public Prescription(long prescriptionID, long prescriptionTreatmentID,
			long prescriptionMedicineID)
	{
		super();
		PrescriptionID = prescriptionID;
		PrescriptionTreatmentID = prescriptionTreatmentID;
		PrescriptionMedicineID = prescriptionMedicineID;
	}
}
