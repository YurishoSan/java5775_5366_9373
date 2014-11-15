/**
 * 
 */
package entities;

/**
 * Class representing pairs of medicines and an allergy it can cause
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see Medicine
 * @see Allergy
 */
public class MedicineAllergy
{
	//region attributes
		private long MedicineAllergyID;
		private long MedicineID;
		private long AllergyID;
		//endregion
		
		//region contors
		/**
		 * 
		 */
		public MedicineAllergy()
		{
			super();
		}
		/**
		 * @param medicineAllergyID
		 * @param medicineID
		 * @param allergyID
		 */
		public MedicineAllergy(long medicineAllergyID, long medicineID, long allergyID)
		{
			super();
			MedicineAllergyID = medicineAllergyID;
			MedicineID = medicineID;
			AllergyID = allergyID;
		}
		//endregion
		
		//region getters/setters
		/**
		 * @return the medicineAllergyID
		 */
		public long getMedicineAllergyID()
		{
			return MedicineAllergyID;
		}
		/**
		 * @param matientAllergyID the matientAllergyID to set
		 */
		public void setMedicineAllergyID(long medicineAllergyID)
		{
			MedicineAllergyID = medicineAllergyID;
		}
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
		 * @return the allergyID
		 */
		public long getAllergyID()
		{
			return AllergyID;
		}
		/**
		 * @param allergyID the allergyID to set
		 */
		public void setAllergyID(long allergyID)
		{
			AllergyID = allergyID;
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
			result = prime * result
					+ (int) (MedicineAllergyID ^ (MedicineAllergyID >>> 32));
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
			MedicineAllergy other = (MedicineAllergy) obj;
			if (MedicineAllergyID != other.MedicineAllergyID)
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
			builder.append("MedicineAllergy [MedicineAllergyID=");
			builder.append(MedicineAllergyID);
			builder.append(", MedicineID=");
			builder.append(MedicineID);
			builder.append(", AllergyID=");
			builder.append(AllergyID);
			builder.append("]");
			return builder.toString();
		}
		
		//endregion
}
