package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		
		if(erTom()) 
		{
			siste=null;
		}
		// ...Fyll ut
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		antall--;
		if(antall==0) 
		{
			foerste=null;
			siste=null;
		}
		else
		{
			siste = foerste;
			for(int i=0; i<antall-1; i++) 
			{
				siste = siste.getNeste();
				
			}
			siste.setNeste(null);
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();

		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		LinearNode<T> ny = new LinearNode<T>(element), denne = foerste, forrige = null;
		
		while(denne !=null && element.compareTo(denne.getElement()) > 0) 
		{
			forrige = denne;
			denne = denne.getNeste();
		}
		
		if (forrige == null) 
		{
			ny.setNeste(foerste);
			foerste = ny;
			if(antall == 0)
			{
				siste = ny;
			}
		}
		
		else if (denne == null)
		{
			forrige.setNeste(ny);
			siste=ny;
		}
		
		else
		{
			forrige.setNeste(ny);
			ny.setNeste(denne);
		}
		
		antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
