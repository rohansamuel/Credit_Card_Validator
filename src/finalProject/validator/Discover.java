package finalProject.validator;

public class Discover implements CreditCardType {
	
	private static final String PREFIX = "60";
	
	public boolean matches(String card) {
		return (card.substring(0, 2).equals(PREFIX) && (card.length() == 16));
	}

	@Override
	public String getCardIssuer() {
		return "Discover Card";
		
	}

}
