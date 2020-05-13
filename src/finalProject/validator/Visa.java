package finalProject.validator;

public class Visa implements CreditCardType {
	
private static final String PREFIX = "45,44,";
  
   public boolean matches(String card) {
	   String prefix2 = card.substring(0, 2) + ",";
		return ((PREFIX.contains(prefix2)) && (card.length() >= 13 || card.length() <= 16));
    }
   
   @Override
	public String getCardIssuer() {
		return "Visa Card";
		
	}
}
