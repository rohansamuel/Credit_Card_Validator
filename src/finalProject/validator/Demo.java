package finalProject.validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//import java.util.Scanner;
public class Demo {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to the Credit Card Validator");

		CreditCardValidator ccv = new CreditCardValidator();
		ArrayList<String> validCards = new ArrayList<String>();
		ArrayList<String> invalidCards = new ArrayList<String>();

		try {
			File file = new File("final.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String cardNumber;

			while ((cardNumber = in.readLine()) != null) {

				if (ccv.isValid(cardNumber)) {
					validCards.add(cardNumber);
				} else {
					invalidCards.add(cardNumber);
				}
			}
			in.close();

			System.out.println("validCards=" + validCards);
			System.out.println("invalidCards=" + invalidCards);
			writeValidCards(validCards, ccv);
			writeInValidCards(invalidCards);
		} catch (FileNotFoundException e)

		{
			System.out.println("File not found");

		}

	}// end of main
	
	private static void writeToFile(String fileName, String contents) throws IOException
	{
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileWriter(fileName, true));
			writer.write(contents + "\n");
			writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	// writing the valid and invalid files
	public static void writeValidCards(ArrayList<String> validCards, CreditCardValidator ccv) throws IOException
	{
		StringBuffer contents = new StringBuffer();
		for(String cardNumber : validCards) {
			contents.append(cardNumber).append(" Card Issuer:");
			contents.append(ccv.getCardType(cardNumber).getCardIssuer()).append("\n");	
		}
		writeToFile("valid_cards.txt", contents.toString());
	}
	
	// writing the valid and invalid files
	public static void writeInValidCards(ArrayList<String> inValidCards) throws IOException
	{
		StringBuffer contents = new StringBuffer();
		for(String cardNumber : inValidCards) {
			contents.append(cardNumber).append("\n");	
		}
		writeToFile("invalid_cards.txt", contents.toString());
	}
}// end of class
