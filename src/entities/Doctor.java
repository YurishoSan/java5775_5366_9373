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
public class Doctor
{
	private long DoctorID;
	private String DoctorFirstName;
	private String DoctorLastName;
	private Date DoctorDoB; //Date of birth
	private Date DoctorDoJ; //Date of joining company
	private float DoctorSalary;
	
	public Doctor()
	{
	}
	
	public Doctor(long DoctorID, String DoctorFirstName, String DoctorLastName,
					Date DoctorDoB, Date DoctorDoJ, float DoctorSalary)
	{
		this.DoctorID = DoctorID;
		
	}
}
