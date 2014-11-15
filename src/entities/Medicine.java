/**
 * 
 */
package entities;

import java.util.Date;

import enums.MedicineType;

/**
 * Class representing medicines the doctors can prescribe to patients.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see enums.MedicineType
 */
public class Medicine
{
	//region attributes
	
	private long MedicineID;
	private String MedicineName;
	private String MedicineIngredients;
	private String MedicineActiveIngredients;
	private MedicineType MedicineType;
	private Date MedicineExpDate; //Expiration Date
	
	//endregion

	//region contors
	
	/**
	 * 
	 */
	public Medicine()
	{
		super();
	}
	
	/**
	 * @param medicineID
	 * @param medicineName
	 * @param medicineIngredients
	 * @param medicineActiveIngredients
	 * @param medicineType
	 * @param medicineExpDate
	 */
	public Medicine(long medicineID, String medicineName,
			String medicineIngredients, String medicineActiveIngredients,
			enums.MedicineType medicineType, Date medicineExpDate)
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
	/**
	 * @return the medicineID
	 */
	public long getMedicineID()
	{
		return MedicineID;
	}

	/**
	 * @param medicineID the medicineID to set
	 */
	public void setMedicineID(long medicineID)
	{
		MedicineID = medicineID;
	}

	/**
	 * @return the medicineName
	 */
	public String getMedicineName()
	{
		return MedicineName;
	}

	/**
	 * @param medicineName the medicineName to set
	 */
	public void setMedicineName(String medicineName)
	{
		MedicineName = medicineName;
	}

	/**
	 * @return the medicineIngredients
	 */
	public String getMedicineIngredients()
	{
		return MedicineIngredients;
	}

	/**
	 * @param medicineIngredients the medicineIngredients to set
	 */
	public void setMedicineIngredients(String medicineIngredients)
	{
		MedicineIngredients = medicineIngredients;
	}

	/**
	 * @return the medicineActiveIngredients
	 */
	public String getMedicineActiveIngredients()
	{
		return MedicineActiveIngredients;
	}

	/**
	 * @param medicineActiveIngredients the medicineActiveIngredients to set
	 */
	public void setMedicineActiveIngredients(String medicineActiveIngredients)
	{
		MedicineActiveIngredients = medicineActiveIngredients;
	}

	/**
	 * @return the medicineType
	 */
	public MedicineType getMedicineType()
	{
		return MedicineType;
	}

	/**
	 * @param medicineType the medicineType to set
	 */
	public void setMedicineType(MedicineType medicineType)
	{
		MedicineType = medicineType;
	}

	/**
	 * @return the medicineExpDate
	 */
	public Date getMedicineExpDate()
	{
		return MedicineExpDate;
	}

	/**
	 * @param medicineExpDate the medicineExpDate to set
	 */
	public void setMedicineExpDate(Date medicineExpDate)
	{
		MedicineExpDate = medicineExpDate;
	}
	//endregion

	//region overrideMethods

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (MedicineID ^ (MedicineID >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
