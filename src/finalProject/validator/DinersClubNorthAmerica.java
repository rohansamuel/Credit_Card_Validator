package finalProject.validator;

public class DinersClubNorthAmerica implements CreditCardType {
	private static final String PREFIX = "54,55,";

	public boolean matches(String card) {
		String prefix2 = card.substring(0, 2) + ",";
		return ((PREFIX.contains(prefix2)) && (card.length() == 16));
	}
	
	@Override
	public String getCardIssuer() {
		return "Diners Club - North America card";
		
	}

}
