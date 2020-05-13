package finalProject.validator;

public class Laser implements CreditCardType {
	private static final String PREFIX = "67";

	public boolean matches(String card) {
		String prefix2 = card.substring(0, 2);
		return ((PREFIX.equals(prefix2)) && (card.length() >= 16 || card.length() <= 19));
	}
	
	@Override
	public String getCardIssuer() {
		return "Laser card";
		
	}

}
