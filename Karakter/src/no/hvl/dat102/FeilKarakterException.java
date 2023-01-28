package no.hvl.dat102;

/**
 * Feilh�ndtering for karakter.
 * 
 * @author Ole Olsen
 */
public class FeilKarakterException extends RuntimeException {

	/**
	 * Lager et nytt unntak.
	 * 
	 * @param melding
	 *            melding
	 */
	public FeilKarakterException(String melding) {
		super(melding);
	}

}
