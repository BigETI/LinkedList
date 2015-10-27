/**
 * Doppelt verkettete Liste Klasse
 * 
 * @author Ethem Kurt
 * @param <T>
 *            Template
 */
public class MyLinkedList<T> {
	/**
	 * Erstes Element
	 */
	private MyLinkedListElem<T> first = null;

	/**
	 * Letztes Element
	 */
	private MyLinkedListElem<T> last = null;

	/**
	 * @author Ethem Kurt
	 * @return erstes Element
	 */
	public MyLinkedListElem<T> getFirst() {
		return first;
	}

	/**
	 * @author Ethem Kurt
	 * @return letztes Element
	 */
	public MyLinkedListElem<T> getLast() {
		return last;
	}

	/**
	 * @author Ethem Kurt
	 * @param obj
	 *            Referenz
	 * @return Iterator
	 */
	public MyLinkedListElem<T> push_back(T obj) {
		MyLinkedListElem<T> ret = new MyLinkedListElem<T>(last, null, obj, this);
		if (first == null)
			first = ret;
		last = ret;
		return ret;
	}

	/**
	 * @author Ethem Kurt
	 * @param obj
	 *            Referenz
	 * @return Iterator
	 */
	public MyLinkedListElem<T> push_front(T obj) {
		MyLinkedListElem<T> ret = new MyLinkedListElem<T>(null, first, obj,
				this);
		first = ret;
		if (last == null)
			last = ret;
		return ret;
	}

	/**
	 * Fügt ein Element hinten hinzu
	 * 
	 * @author Ethem Kurt
	 */
	public void pop_back() {
		MyLinkedListElem<T> t;
		if (last != null) {
			if (last == first)
				first = null;
			t = last.getPrev();
			remove(last);
			last = t;
		}
	}

	/**
	 * Fügt ein Element vorne ein
	 * 
	 * @author Ethem Kurt
	 */
	public void pop_front() {
		MyLinkedListElem<T> t;
		if (first != null) {
			if (last == first)
				last = null;
			t = first.getNext();
			remove(first);
			first = t;
		}
	}

	/**
	 * Fügt ein Element nach dem Element
	 * 
	 * @author Ethem Kurt
	 * @param at
	 *            am Element
	 * @param obj
	 *            Referenz
	 * @return Iterator
	 */
	public MyLinkedListElem<T> insert(MyLinkedListElem<T> at, T obj) {
		MyLinkedListElem<T> ret = null;
		if (at != null) {
			if (at.getParent() == this) {
				at.insert(obj);
			} else
				throw new MyLinkedListException(at + " is not a member of "
						+ this);
		} else
			throw new MyLinkedListException(at + " is not a member of " + this);
		return ret;
	}

	/**
	 * Entfernt das Element aus der Liste
	 * 
	 * @author Ethem Kurt
	 * @param elem
	 *            Iterator
	 */
	public void remove(MyLinkedListElem<T> elem) {
		if (elem != null) {
			if (elem.getParent() == this) {
				if (elem.getPrev() == null) {
					first = elem.getNext();
					if (first == null)
						last = null;
				} else
					elem.getPrev().linkRight(elem.getNext());
				if (elem.getNext() == null) {
					last = elem.getPrev();
					if (last == null)
						first = null;
				} else
					elem.getNext().linkLeft(elem.getPrev());
				elem.reset();
			} else
				throw new MyLinkedListException(elem + " is not a member of "
						+ this);
		} else
			throw new MyLinkedListException(elem + " is not a member of "
					+ this);
	}

	/**
	 * Leert die Liste
	 * 
	 * @author Ethem Kurt
	 */
	public void clear() {
		MyLinkedListElem<T> it = first, o = null;
		while (it != null) {
			o = it;
			it = o.getNext();
			o.dispose();
		}
		first = null;
		last = null;
	}

	/**
	 * Beinhaltet Referenz?
	 * 
	 * @author Ethem Kurt
	 * @param obj
	 *            Referenz
	 * @return Iterator wenn erfolgreich, sonst "null"
	 */
	public MyLinkedListElem<T> contains(T obj) {
		MyLinkedListElem<T> ret = null, i = first;
		while (i != null) {
			if (i.Obj == obj) {
				ret = i;
				break;
			}
			i = i.getNext();
		}
		return ret;
	}
}
