/**
 * 
 */
package entities;

import java.util.Date;

import enums.Specialization;

/**
 * Class representing a doctor working for the medical company
 *  
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 */
public class Doctor extends Human
{
	//region attributes
	
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
	 * @param doctorDoJ
	 * @param doctorSalary
	 * @param doctorPhoneNumber
	 * @param doctorSpecialization
	 */
<<<<<<< HEAD
	public Doctor(long humanID, String humanFirstName, String humanLastName,
			Date humanDoB,String email, Date doctorDoJ, float doctorSalary,
			String doctorPhoneNumber)
	{
		super(humanID, humanFirstName, humanLastName, humanDoB ,email);
=======
	public Doctor(Date doctorDoJ, float doctorSalary, String doctorPhoneNumber,
			Specialization doctorSpecialization)
	{
		super();
>>>>>>> origin/master
		DoctorDoJ = doctorDoJ;
		DoctorSalary = doctorSalary;
		DoctorPhoneNumber = doctorPhoneNumber;
		DoctorSpecialization = doctorSpecialization;
	}
	//endregion
	
	//region getters/setters
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Doctor [DoctorDoJ=");
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
}
