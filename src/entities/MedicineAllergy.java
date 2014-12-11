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
		private long MedicineID;
		private long AllergyID;
		//endregion
		
		//region contors
		/**
		 * @param medicineID
		 * @param allergyID
		 * 
		 */
		public MedicineAllergy(long medicineID, long allergyID)
		{
			super();
			MedicineID = medicineID;
			AllergyID = allergyID;
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
			result = prime * result + (int) (AllergyID ^ (AllergyID >>> 32));
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
			MedicineAllergy other = (MedicineAllergy) obj;
			if (AllergyID != other.AllergyID)
				return false;
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
			builder.append("MedicineAllergy [MedicineID=");
			builder.append(MedicineID);
			builder.append(", AllergyID=");
			builder.append(AllergyID);
			builder.append("]");
			return builder.toString();
		}
		
		//endregion
}
