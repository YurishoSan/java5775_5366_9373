/**
 * 
 */
package entities.enums;

/**
 * Enum representing the different service levels the medical company provides.
 * <p>
 * Credit to Javarevisited for info on enums.
 * Read more:  {@link http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html#ixzz3IrkBxYfG }
 * 
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 *
 * @see entities.Patient
 */
public enum ServiceClass
{
	//region values
	
	REGULAR, //Fedaraly required minimum service
	SILVER,
	GOLD,
	PLATINUM,
	VIP
	
	//endregion
}
