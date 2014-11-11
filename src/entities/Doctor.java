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
	private String DoctorPhoneNumber;
	
	public Doctor()
	{
       DoctorID = 0;
	   DoctorFirstName="";
	   DoctorLastName="";
	   DoctorDoB=null;
	   DoctorDoJ=null;
	   DoctorSalary=0;
	   DoctorPhoneNumber = "";
	}
	
	public Doctor(long DoctorID, String DoctorFirstName, String DoctorLastName,
					Date DoctorDoB, Date DoctorDoJ, float DoctorSalary, String DoctorPhoneNumber)
	{
		this.DoctorID = DoctorID;
		this.DoctorFirstName=DoctorFirstName;
		this.DoctorLastName=DoctorLastName;
		this.DoctorDoB=DoctorDoB;
		this.DoctorDoJ=DoctorDoJ;
		this.DoctorSalary=DoctorSalary;	
		this.DoctorPhoneNumber = DoctorPhoneNumber;
	}
}
