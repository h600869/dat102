package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		this.foerste = new DobbelNode<T> (minVerdi);
		this.siste = new DobbelNode<T> (maksVerdi);
		this.foerste.setNeste(siste);
		this.siste.setForrige(foerste);
		antall=0;
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste.getNeste();
		while ((el.compareTo(aktuell.getElement()) > 0)) {
			aktuell = aktuell.getNeste();
		}
		// Legg inn foran aktuell
		nyNode.setNeste(aktuell);
		nyNode.setForrige(aktuell.getForrige());
		aktuell.getForrige().setNeste(nyNode);
		aktuell.setForrige(nyNode);
		antall++;

	}

	@Override
	public T fjern(T el) {
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
		DobbelNode<T> aktuell = finn(el);
		if (aktuell != null) {// returner og slett
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());

		}

		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {
		DobbelNode <T> naa= foerste.getNeste();
		
		for (int i=0; i<antall; i++) 
		{
			if(el.equals(naa.getElement())) 
			{
				return naa;
			}
			naa=naa.getNeste();
		}
		
		return null;
		//TODO

	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}

	public void visListe() {
		DobbelNode <T> naa = foerste.getNeste();
		
		for(int i =0; i<antall; i++) 
		{
			System.out.println(naa.getElement());
			naa=naa.getNeste();
		}
		
		if(antall==0) 
		{
			System.out.println("Listen er tom");
		}
	}
}