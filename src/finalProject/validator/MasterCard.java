package finalProject.validator;

public class MasterCard implements CreditCardType {
	private static final String PREFIX = "51,53,";

	public boolean matches(String card) {
		String prefix2 = card.substring(0, 2) + ",";
		return ((PREFIX.contains(prefix2)) && (card.length() >= 16 || card.length() <= 19));
	}
	
	@Override
	public String getCardIssuer() {
		return "MasterCard";
		
	}

}
