/**
 * @author Ethem Kurt
 *
 * @param <T> Template
 */
public class MyLinkedListElem<T> {
	/**
	 * Elternobjekt Referenz
	 * 
	 * @author Ethem Kurt
	 */
	private MyLinkedList<T> parent = null;

	/**
	 * Vorheriges Element
	 * 
	 * @author Ethem Kurt
	 */
	private MyLinkedListElem<T> prev = null;

	/**
	 * Nächstes Element
	 * 
	 * @author Ethem Kurt
	 */
	private MyLinkedListElem<T> next = null;

	/**
	 * Objekt Referenz
	 * 
	 * @author Ethem Kurt
	 */
	public T Obj = null;

	/**
	 * Konstruktor
	 * 
	 * @author Ethem Kurt
	 * 
	 * @param prev
	 *            vorheriges Element
	 * @param next
	 *            nächstes Element
	 * @param obj
	 *            Objekt Referenz
	 * @param parent
	 *            Elternobjekt Referenz
	 */
	public MyLinkedListElem(MyLinkedListElem<T> prev, MyLinkedListElem<T> next,
			T obj, MyLinkedList<T> parent) {
		this.parent = parent;
		this.prev = prev;
		this.next = next;
		if (prev != null)
			prev.linkRight(this);
		if (next != null)
			next.linkLeft(this);
		Obj = obj;
	}

	/**
	 * Verlinke links
	 * 
	 * @author Ethem Kurt
	 * 
	 * @param elem
	 *            Iterator
	 */
	public void linkLeft(MyLinkedListElem<T> elem) {
		linkLeft(elem, false);
	}

	/**
	 * Verlinke links
	 * 
	 * @author Ethem Kurt
	 * 
	 * @param elem
	 *            Iterator
	 * @param sync
	 *            Synchronisiere Verlinkung
	 */
	public void linkLeft(MyLinkedListElem<T> elem, boolean sync) {
		prev = elem;
		if (sync)
			elem.linkRight(this);
	}

	/**
	 * Verlinke rechts
	 * 
	 * @author Ethem Kurt
	 * 
	 * @param elem
	 *            Iterator
	 */
	public void linkRight(MyLinkedListElem<T> elem) {
		linkRight(elem, false);
	}

	/**
	 * Verlinke rechts
	 * 
	 * @author Ethem Kurt
	 * 
	 * @param elem
	 *            Iterator
	 * @param sync
	 *            Synchronisiere Verlinkung
	 */
	public void linkRight(MyLinkedListElem<T> elem, boolean sync) {
		next = elem;
		if (sync)
			elem.linkLeft(this);
	}

	/**
	 * Fügt ein Element rechts hinzu
	 * 
	 * @author Ethem Kurt
	 * 
	 * @param obj
	 *            Objektreferenz
	 * @return Iterator
	 */
	public MyLinkedListElem<T> insert(T obj) {
		return new MyLinkedListElem<T>(this, next, obj, parent);
	}

	/**
	 * Objekt dereferenzieren (synchron)
	 * 
	 * @author Ethem Kurt
	 */
	public void dispose() {
		if (prev != null) {
			prev.next = null;
			prev = null;
		}
		if (next != null) {
			next.prev = null;
			next = null;
		}
	}

	/**
	 * Objekt dereferenzieren (einfach)
	 * 
	 * @author Ethem Kurt
	 */
	public void reset() {
		prev = null;
		next = null;
		Obj = null;
	}

	/**
	 * @author Ethem Kurt
	 * @return vorheriges Element
	 */
	public MyLinkedListElem<T> getPrev() {
		return prev;
	}

	/**
	 * @author Ethem Kurt
	 * @return nächstes Element
	 */
	public MyLinkedListElem<T> getNext() {
		return next;
	}

	/**
	 * @author Ethem Kurt
	 * @return Elternobjekt Referenz
	 */
	public MyLinkedList<T> getParent() {
		return parent;
	}
}
