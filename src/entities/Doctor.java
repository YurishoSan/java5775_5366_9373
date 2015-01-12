/**
 * 
 */
package entities;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

import entities.enums.Gender;
import entities.enums.Specialization;

/**
 * Class representing a doctor working for the medical company
 *  
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see entities.enums.Specialization
 */
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Doctor implements Serializable
{
	private static final long serialVersionUID = -7038844231655101070L;
	
	//region attributes
	private long DoctorID;
	private String DoctorFirstName;
	private String DoctorLastName;
	private Gender DoctorGender;
	private Date DoctorDoB; //Date of birth
	private String DoctorEmailAdress;
	private Date DoctorDoJ; //Date of joining company
	private float DoctorSalary;
	private String DoctorPhoneNumber;
	private Specialization DoctorSpecialization;
	//endregion
	
	//region contor
	/**
	 * 
	 */
	/**
	 * 
	 */
	public Doctor()
	{
		super();
	}
	
	/**
	 * @param doctorID
	 * @param doctorFirstName
	 * @param doctorLastName
	 * @param doctorGender
	 * @param doctorDoB
	 * @param doctorEmailAdress
	 * @param doctorDoJ
	 * @param doctorSalary
	 * @param doctorPhoneNumber
	 * @param doctorSpecialization
	 */
	public Doctor(long doctorID, String doctorFirstName, String doctorLastName,
			Gender doctorGender, Date doctorDoB, Date doctorDoJ, 
			String doctorEmailAdress, float doctorSalary, String doctorPhoneNumber,
			Specialization doctorSpecialization)
	{
		super();
		DoctorID = doctorID;
		DoctorFirstName = doctorFirstName;
		DoctorLastName = doctorLastName;
		DoctorGender = doctorGender;
		DoctorDoB = doctorDoB;
		DoctorEmailAdress = doctorEmailAdress;
		DoctorDoJ = doctorDoJ;
		DoctorSalary = doctorSalary;
		DoctorPhoneNumber = doctorPhoneNumber;
		DoctorSpecialization = doctorSpecialization;
	}

	//endregion

	//region getters/setters
	/**
	 * @return the doctorID
	 */
	public long getDoctorID()
	{
		return DoctorID;
	}

	/**
	 * @param doctorID the doctorID to set
	 */
	public void setDoctorID(long doctorID)
	{
		DoctorID = doctorID;
	}

	/**
	 * @return the doctorFirstName
	 */
	public String getDoctorFirstName()
	{
		return DoctorFirstName;
	}

	/**
	 * @param doctorFirstName the doctorFirstName to set
	 */
	public void setDoctorFirstName(String doctorFirstName)
	{
		DoctorFirstName = doctorFirstName;
	}

	/**
	 * @return the doctorLastName
	 */
	public String getDoctorLastName()
	{
		return DoctorLastName;
	}

	/**
	 * @param doctorLastName the doctorLastName to set
	 */
	public void setDoctorLastName(String doctorLastName)
	{
		DoctorLastName = doctorLastName;
	}

	/**
	 * @return the doctorGender
	 */
	public Gender getDoctorGender()
	{
		return DoctorGender;
	}

	/**
	 * @param doctorGender the doctorGender to set
	 */
	public void setDoctorGender(Gender doctorGender)
	{
		DoctorGender = doctorGender;
	}

	/**
	 * @return the doctorDoB
	 */
	public Date getDoctorDoB()
	{
		return DoctorDoB;
	}

	/**
	 * @param doctorDoB the doctorDoB to set
	 */
	public void setDoctorDoB(Date doctorDoB)
	{
		DoctorDoB = doctorDoB;
	}

	/**
	 * @return the doctorEmailAdress
	 */
	public String getDoctorEmailAdress()
	{
		return DoctorEmailAdress;
	}

	/**
	 * @param doctorEmailAdress the doctorEmailAdress to set
	 */
	public void setDoctorEmailAdress(String doctorEmailAdress)
	{
		DoctorEmailAdress = doctorEmailAdress;
	}

	/**
	 * @return the doctorDoJ
	 */
	public Date getDoctorDoJ()
	{
		return DoctorDoJ;
	}

	/**
	 * @param doctorDoJ the doctorDoJ to set
	 */
	public void setDoctorDoJ(Date doctorDoJ)
	{
		DoctorDoJ = doctorDoJ;
	}

	/**
	 * @return the doctorSalary
	 */
	public float getDoctorSalary()
	{
		return DoctorSalary;
	}

	/**
	 * @param doctorSalary the doctorSalary to set
	 */
	public void setDoctorSalary(float doctorSalary)
	{
		DoctorSalary = doctorSalary;
	}

	/**
	 * @return the doctorSpecialization
	 */
	public Specialization getDoctorSpecialization()
	{
		return DoctorSpecialization;
	}

	/**
	 * @param doctorSpecialization the doctorSpecialization to set
	 */
	public void setDoctorSpecialization(Specialization doctorSpecialization)
	{
		DoctorSpecialization = doctorSpecialization;
	}

	/**
	 * @return the doctorPhoneNumber
	 */
	public String getDoctorPhoneNumber()
	{
		return DoctorPhoneNumber;
	}

	/**
	 * @param doctorPhoneNumber the doctorPhoneNumber to set
	 */
	public void setDoctorPhoneNumber(String doctorPhoneNumber)
	{
		DoctorPhoneNumber = doctorPhoneNumber;
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
		result = prime * result + (int) (DoctorID ^ (DoctorID >>> 32));
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
		Doctor other = (Doctor) obj;
		if (DoctorID != other.DoctorID)
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
		builder.append("Doctor [DoctorID=");
		builder.append(DoctorID);
		builder.append(", DoctorFirstName=");
		builder.append(DoctorFirstName);
		builder.append(", DoctorLastName=");
		builder.append(DoctorLastName);
		builder.append(", DoctorGender=");
		builder.append(DoctorGender);
		builder.append(", DoctorDoB=");
		builder.append(DoctorDoB);
		builder.append(", DoctorEmailAdress=");
		builder.append(DoctorEmailAdress);
		builder.append(", DoctorDoJ=");
		builder.append(DoctorDoJ);
		builder.append(", DoctorSalary=");
		builder.append(DoctorSalary);
		builder.append(", DoctorPhoneNumber=");
		builder.append(DoctorPhoneNumber);
		builder.append(", DoctorSpecialization=");
		builder.append(DoctorSpecialization);
		builder.append("]");
		return builder.toString();
	}

	//endregion
}
