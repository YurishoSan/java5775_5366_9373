/**
 * 
 */
package entities.enums;

/**
 * Enum representing the different types a medicine can be.
 * <p>
 * Credit to Javarevisited for info on enums.
 * Read more:  {@link http://javarevisited.blogspot.com/2011/08/enum-in-java-example-tutorial.html#ixzz3IrkBxYfG}
 *
 * @author Yitzhak Goldstein
 * @author Shalom Tzichtig
 * 
 * @see entities.Medicine
 */
public enum MedicineType
{
	//region values
	
	PILL_TABLET(0),
	PILL_BOTTLE(1),
	LIQUID_BOTTLE(10);
	
	//endregion
	
	@SuppressWarnings("unused")
	private int value;

	private MedicineType(int value)
    {
            this.value = value;
    }
}
