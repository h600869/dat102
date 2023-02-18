package no.hvl.dat102;

public class SorteringOgSoking {

	/*************************************************************************************************/
	// S�kealgoritmer
	/*************************************************************************************************/

	/**
	 * Metoden gj�r et line�rt s�k i en full tabell av usorterte data
	 * 
	 * @param data er data som skal s�kes i
	 * @param min  er startindeks
	 * @param maks er sluttindeks
	 * @param el   er verdien vi s�ker etter
	 * @return elementet ved funn funnet ellers null-referanse
	 */
	public static <T extends Comparable<T>> T sok(T[] data, int min, int maks, T el) {
		int indeks = min;
		boolean funnet = false;
		T resultat = null;

		while (indeks <= maks && !funnet) {
			if (data[indeks].compareTo(el) == 0) {
				funnet = true;
				resultat = data[indeks];
			}
			indeks++;
		} // while
		return resultat;
	}// metode
	
	/****************************************************************************/

	// Her kan en legge inn andre s�ke og sorteringsmetoder.
}
