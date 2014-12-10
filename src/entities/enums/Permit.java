/**
 * 
 */
package entities.enums;

import java.io.Serializable;

/**
 * Enum representing the permeations a user can have in the system.
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see entities.Password
 */
public enum Permit
{
	//region values
	DENIED, //wrong password or username
	ADMIN,	//system admin
	COMPANY,//company worker
	DOCTOR, //company doctor
	PATIENT //other users.
	//endregion
}
