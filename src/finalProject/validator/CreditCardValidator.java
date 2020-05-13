package finalProject.validator;

import java.util.ArrayList;
import java.util.Collection;

public class CreditCardValidator {

	private final Collection<CreditCardType> cardTypes = new ArrayList<CreditCardType>();

	public CreditCardValidator() {
		cardTypes.add(new Visa());
		cardTypes.add(new Amex());
		cardTypes.add(new MasterCard());
		cardTypes.add(new Discover());
		cardTypes.add(new DinersClubInternational());
		cardTypes.add(new DinersClubCarteBlanche());
		cardTypes.add(new DinersClubNorthAmerica());
		cardTypes.add(new VisaElectron());
		cardTypes.add(new Jcb());
		cardTypes.add(new Laser());
		cardTypes.add(new Maestro());
		cardTypes.add(new InstaPayment());

	}

	public boolean isValid(String card) {
		if ((card == null) || (card.length() < 13) || (card.length() > 19)) {
			System.out.println("Card is invalid due to length - card:" + card);
			return false;
		}

		if (!validateUsingLuhnAlgorithm(card)) {
			System.out.println("Card is invalid due to Luhn - card:" + card);
			return false;
		}

		for (Object cardType : this.cardTypes) {
			CreditCardType type = (CreditCardType) cardType;
			if (type.matches(card)) {
				return true;
			}
		}
		System.out.println("Card is invalid due to no card matching..:" + card);
		return false;
	}
	
	public CreditCardType getCardType(String cardNumber) {
		for (Object cardType : this.cardTypes) {
			CreditCardType type = (CreditCardType) cardType;
			if (type.matches(cardNumber)) {
				return type;
			}
		}
		return null;
	}

	private boolean validateUsingLuhnAlgorithm(String cardNumber) {
		int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                        n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
	}
}