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
	//region attributes
	
	private long PrescriptionID;
	private long PrescriptionTreatmentID;
	private long PrescriptionMedicineID;
	
	//endregion
	//region contors
	
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

	//endregion
	//region getters/setters
	
	public long getPrescriptionID()
	{
		return PrescriptionID;
	}

	public void setPrescriptionID(long prescriptionID)
	{
		PrescriptionID = prescriptionID;
	}

	public long getPrescriptionTreatmentID()
	{
		return PrescriptionTreatmentID;
	}

	public void setPrescriptionTreatmentID(long prescriptionTreatmentID)
	{
		PrescriptionTreatmentID = prescriptionTreatmentID;
	}

	public long getPrescriptionMedicineID()
	{
		return PrescriptionMedicineID;
	}

	public void setPrescriptionMedicineID(long prescriptionMedicineID)
	{
		PrescriptionMedicineID = prescriptionMedicineID;
	}
	//endregion
}
