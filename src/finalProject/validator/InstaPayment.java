package finalProject.validator;

public class InstaPayment implements CreditCardType {
	private static final String PREFIX = "63";

	public boolean matches(String card) {
		String prefix2 = card.substring(0, 2);
		return ((PREFIX.equals(prefix2)) && (card.length() == 16));
	}
	
	@Override
	public String getCardIssuer() {
		return "InstaPayment card";
		
	}

}
