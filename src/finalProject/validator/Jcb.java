package finalProject.validator;

public class Jcb implements CreditCardType {
	private static final String PREFIX = "31,33,";

	public boolean matches(String card) {
		String prefix2 = card.substring(0, 2) + ",";
		return ((PREFIX.contains(prefix2)) && (card.length() == 16));
	}
	
	@Override
	public String getCardIssuer() {
		return "JCB card";
		
	}

}
