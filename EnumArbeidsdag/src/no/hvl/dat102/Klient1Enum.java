package no.hvl.dat102;

public class Klient1Enum {
	

	public static void main(String[] args) {
		
		Arbeidsdag startdag = Arbeidsdag.MANDAG;
		Arbeidsdag sluttdag = Arbeidsdag.FREDAG;
		
		System.out.println("Arbeidet startet p� " + startdag);
		System.out.println("Arbeidet slutter p� " + sluttdag);	
		
		//Alt
		System.out.println("Arbeidet startet p� " + startdag.toString());
		System.out.println("Arbeidet slutter p� " + sluttdag.toString());	
		
		
		System.out.println("Arbeidet startet p� " + startdag.name());
		System.out.println("Arbeidet slutter p� " + sluttdag.name());	
		
			
	}

}
