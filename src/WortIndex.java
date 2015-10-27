/**
 * WortIndex Klasse
 * 
 * @author Ethem Kurt
 */
public class WortIndex {
	/**
	 * Wörter Liste
	 * 
	 * @author Ethem Kurt
	 */
	private MyLinkedList<WortInIndex> words = new MyLinkedList<WortInIndex>();

	/**
	 * Konstruktor
	 * 
	 * @author Ethem Kurt
	 */
	public WortIndex() {
		//
	}

	/**
	 * Wiedergibt die Liste
	 * 
	 * @author Ethem Kurt
	 * @return Liste
	 */
	public MyLinkedList<WortInIndex> getList() {
		return words;
	}

	/**
	 * Findet einen Wort im WortIndex
	 * 
	 * @author Ethem Kurt
	 * @param wort
	 *            Wort
	 * @return Iterator wenn erfolgreich, sonst "null"
	 */
	public MyLinkedListElem<WortInIndex> findeWortInIndex(String wort) {
		MyLinkedListElem<WortInIndex> ret = null, it = words.getFirst();
		while (it != null) {
			if (it.Obj.compareTo(wort) == 0) {
				ret = it;
				break;
			}
			it = it.getNext();
		}
		return ret;
	}

	/**
	 * Sortiert die Liste
	 * 
	 * @author Ethem Kurt
	 * @param ascending
	 *            Aufsteigend wenn "true", sonst absteigend
	 */
	public void sort(boolean ascending) {
		MyLinkedList<WortInIndex> new_words = new MyLinkedList<WortInIndex>();
		MyLinkedListElem<WortInIndex> it, h;
		WortInIndex obj;
		while ((it = words.getFirst()) != null) {
			for (h = it; it != null; it = it.getNext()) {
				if (ascending) {
					if (it.Obj.toString().compareToIgnoreCase(h.Obj.toString()) < 0)
						h = it;
				} else {
					if (h.Obj.toString().compareToIgnoreCase(it.Obj.toString()) < 0)
						h = it;
				}
			}
			obj = h.Obj;
			words.remove(h);
			new_words.push_back(obj);
		}
		words = new_words;
	}

	/**
	 * Leert die Liste
	 * 
	 * @author Ethem Kurt
	 */
	public void clear() {
		words.clear();
	}
}
