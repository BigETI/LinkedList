/**
 * WortInIndex Klasse
 * 
 * @author Ethem Kurt
 */
public class WortInIndex implements IWortIndex {

	/**
	 * Wort
	 * 
	 * @author Ethem Kurt
	 */
	private String wort = "";

	/**
	 * Anzahl
	 * 
	 * @author Ethem Kurt
	 */
	private int count = 1;

	/**
	 * Konstruktor
	 * 
	 * @param wort
	 *            Wort
	 */
	public WortInIndex(String wort) {
		this.wort = wort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(String o) {
		return wort.compareTo(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IWortIndex#setWort(java.lang.String)
	 */
	@Override
	public void setWort(String wort) {
		this.wort = wort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IWortIndex#incCount()
	 */
	@Override
	public void incCount() {
		count++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IWortIndex#getWord()
	 */
	@Override
	public String getWord() {
		return wort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IWortIndex#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return wort + ": " + count;
	}
}
