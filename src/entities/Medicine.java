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
public class Medicine
{
	//region attributes
	
	private long MedicineID;
	private String MedicineName;
	private String MedicineIngredients;
	private String MedicineActiveIngredients;
	private String MedicineType; //TODO: make medicine type enum. Type i.e. pill, liquid, etc.
	private Date MedicineExpDate; //Expiration Date
	
	//endregion
	//region contors
	
	public Medicine()
	{
		super();
	}
	
	public Medicine(long medicineID, String medicineName,
			String medicineIngredients, String medicineActiveIngredients,
			String medicineType, Date medicineExpDate)
	{
		super();
		MedicineID = medicineID;
		MedicineName = medicineName;
		MedicineIngredients = medicineIngredients;
		MedicineActiveIngredients = medicineActiveIngredients;
		MedicineType = medicineType;
		MedicineExpDate = medicineExpDate;
	}
	
	//endregion
	//region getters/setters
	
	public long getMedicineID()
	{
		return MedicineID;
	}

	public void setMedicineID(long medicineID)
	{
		MedicineID = medicineID;
	}

	public String getMedicineName()
	{
		return MedicineName;
	}

	public void setMedicineName(String medicineName)
	{
		MedicineName = medicineName;
	}

	public String getMedicineIngredients()
	{
		return MedicineIngredients;
	}

	public void setMedicineIngredients(String medicineIngredients)
	{
		MedicineIngredients = medicineIngredients;
	}

	public String getMedicineActiveIngredients()
	{
		return MedicineActiveIngredients;
	}

	public void setMedicineActiveIngredients(String medicineActiveIngredients)
	{
		MedicineActiveIngredients = medicineActiveIngredients;
	}

	public String getMedicineType()
	{
		return MedicineType;
	}

	public void setMedicineType(String medicineType)
	{
		MedicineType = medicineType;
	}

	public Date getMedicineExpDate()
	{
		return MedicineExpDate;
	}

	public void setMedicineExpDate(Date medicineExpDate)
	{
		MedicineExpDate = medicineExpDate;
	}
	//endregion
}
