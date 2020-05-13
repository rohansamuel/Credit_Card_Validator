package finalProject.validator;

public class VisaElectron implements CreditCardType {
	
private static final String PREFIX = "48,49,";
  
   public boolean matches(String card) {
	   String prefix2 = card.substring(0, 2) + ",";
	   return ((PREFIX.contains(prefix2)) && (card.length() == 13 || card.length() == 16));
    }
   
   @Override
	public String getCardIssuer() {
		return "Visa Electron Card";
		
	}
}
