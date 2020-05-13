package finalProject.validator;

public class DinersClubInternational implements CreditCardType {
	private static final String PREFIX = "36";

	public boolean matches(String card) {
		String prefix2 = card.substring(0, 2);
		return ((PREFIX.equals(prefix2)) && (card.length() == 14));
	}
	
	@Override
	public String getCardIssuer() {
		return "Diners Club - International card";
		
	}

}
