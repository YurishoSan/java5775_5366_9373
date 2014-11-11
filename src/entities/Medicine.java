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
	
	public Medicine() 
	{
		MedicineID = 0;
		MedicineName = "";
		MedicineIngredients = "";
		MedicineActiveIngredients = "";
		MedicineType = "";
		MedicineExpDate = null;
	}
	
	public Medicine(long medicineID, String medicineName,
			String medicineIngredients, String medicineActiveIngredients,
			String medicineType, Date medicineExpDate) 
	{
		this.MedicineID = medicineID;
		this.MedicineName = medicineName;
		this.MedicineIngredients = medicineIngredients;
		this.MedicineActiveIngredients = medicineActiveIngredients;
		this.MedicineType = medicineType;
		this.MedicineExpDate = medicineExpDate;
	}
}
