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

	//region overrideMethods
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (MedicineID ^ (MedicineID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicine other = (Medicine) obj;
		if (MedicineID != other.MedicineID)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Medicine [MedicineID=");
		builder.append(MedicineID);
		builder.append(", MedicineName=");
		builder.append(MedicineName);
		builder.append(", MedicineIngredients=");
		builder.append(MedicineIngredients);
		builder.append(", MedicineActiveIngredients=");
		builder.append(MedicineActiveIngredients);
		builder.append(", MedicineType=");
		builder.append(MedicineType);
		builder.append(", MedicineExpDate=");
		builder.append(MedicineExpDate);
		builder.append("]");
		return builder.toString();
	}
	//endregion
}
