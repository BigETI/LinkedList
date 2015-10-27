/**
 * @author Ethem Kurt Interface IWortIndex
 */
public interface IWortIndex extends Comparable<String> {
	/**
	 * @author Ethem Kurt
	 * @param wort
	 *            Wort
	 */
	public void setWort(String wort);

	/**
	 * Inkrementiert den Anzahl
	 * 
	 * @author Ethem Kurt
	 */
	public void incCount();

	/**
	 * @author Ethem Kurt
	 * @return Wort
	 */
	public String getWord();

	/**
	 * @author Ethem Kurt
	 * @return Anzahl
	 */
	public int getCount();
}
