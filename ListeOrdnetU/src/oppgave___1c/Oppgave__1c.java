package oppgave___1c;

import java.util.*;
import no.hvl.dat102.*;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.listeklient.Person;

public class Oppgave__1c {

	public static void main(String[] args) {
		
		OrdnetListeADT<Person> listeMedPersoner = new KjedetOrdnetListe<>();
		
		Scanner scanner = new Scanner(System.in);
		String fornavn,etternavn,svar;
		int fodselsaar;
		
		
		for (int i =0; i<2; i++) {
		System.out.println("Skriv inn info om person: ");
		fornavn= scanner.nextLine();
		etternavn = scanner.nextLine();
		fodselsaar = scanner.nextInt();
		scanner.nextLine();
		Person person = new Person(fornavn, etternavn, fodselsaar);
		listeMedPersoner.leggTil(person);
				
		System.out.println(fornavn+" "+etternavn+" "+fodselsaar);
		}
		
		
	}

}
