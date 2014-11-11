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
	
	private long MedicineID;
	private String MedicineName;
	private String MedicineIngredients;
	private String MedicineActiveIngredients;
	private String MedicineType; //TODO: make medicine type enum. Type i.e. pill, liquid, etc.
	private Date MedicineExpDate; //Expiration Date
	
	
	public Medicine(long medicineID, String medicineName,
			String medicineIngredients, String medicineActiveIngredients,
			String medicineType, Date medicineExpDate) 
	{
		MedicineID = medicineID;
		MedicineName = medicineName;
		MedicineIngredients = medicineIngredients;
		MedicineActiveIngredients = medicineActiveIngredients;
		MedicineType = medicineType;
		MedicineExpDate = medicineExpDate;
	}
}
