package finalProject.validator;

public class Amex implements CreditCardType {
	private static final String PREFIX = "34,37,";
	
    public boolean matches(String card) {
        String prefix2 = card.substring(0, 2) + ",";
        return ((PREFIX.contains(prefix2)) && (card.length() == 15));
    }
    
    @Override
	public String getCardIssuer() {
		return "AMEX Card";
		
	}

}
