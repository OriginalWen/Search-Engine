package com.uptodate;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void Run(){
		Synonyms synonyms=new Synonyms("synonyms");
		Quotes quotes=new Quotes("quotes");
		//Get the search term
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term: ");
		//You can successively search for different words. 
		while(scanner.hasNext()){
			String searchTerm = scanner.next();
			synonyms.SetSearchTerms(searchTerm);
			ArrayList<String> outputs=quotes.Search(synonyms.getSearchTerms());
			System.out.println("The quote numbers match your search terms are as following: ");
			quotes.PrintSolution(outputs);
			//System.out.println(synonyms.getSynsTable());
			synonyms.MaintainTable();
			//System.out.println(synonyms.getSynsTable());
			System.out.println("Enter the search term for another search.");
		}
		scanner.close();		
	}
	public static void main(String[] args) {
		Run();
	}
	
}
