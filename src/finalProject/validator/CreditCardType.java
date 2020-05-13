/**
 * 
 */
package finalProject.validator;


public interface CreditCardType {
	
	/**
	 * Returns true if the card number matches this type of credit
	 * card.
	 * @param card The card number, never null.
	 * @return true if the number matches.
	 */
	 public boolean matches(String cardNumber);
	 
	 public String getCardIssuer();

}
