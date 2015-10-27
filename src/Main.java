import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasse mit dem Startpunkt
 * 
 * @author Ethem Kurt
 */
public class Main {

	/**
	 * WortIndex Instanz
	 * 
	 * @author Ethem Kurt
	 */
	WortIndex wi = new WortIndex();

	/**
	 * Iterationsmethode
	 * 
	 * @author Ethem Kurt
	 */
	boolean iterate_forward = true;

	/**
	 * Startpunkt
	 * 
	 * @author Ethem Kurt
	 * @param args
	 *            Argumente
	 */
	public static void main(String[] args) {
		Main m = new Main();
		m.loadFromFile("WikiDeutschland.txt");
		// m.wi.sort(true);
		System.out.println(m);
	}

	/**
	 * Lade von Datei
	 * 
	 * @author Ethem Kurt
	 * @param file_name
	 *            Dateiname
	 */
	public void loadFromFile(String file_name) {
		loadFromFile(file_name, StandardCharsets.UTF_8);
	}

	/**
	 * Lade von Datei
	 * 
	 * @author Ethem Kurt
	 * @param file_name
	 *            Dateiname
	 * @param charset
	 *            Charset
	 */
	public void loadFromFile(String file_name, Charset charset) {
		String[] fld;
		int i;
		MyLinkedListElem<WortInIndex> it;
		wi.clear();
		try {
			for (String line : Files
					.readAllLines(Paths.get(file_name), charset)) {
				fld = line.split("[\\W^ä^ö^ü^Ä^Ö^Ü]");
				if (fld != null) {
					for (i = 0; i < fld.length; i++) {
						it = wi.findeWortInIndex(fld[i]);
						if (it == null)
							wi.getList().push_back(new WortInIndex(fld[i]));
						else
							it.Obj.incCount();
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\r\n");
			e.printStackTrace();
		}
	}

	/**
	 * Iterationsmethode für toString() setzen
	 * 
	 * @author Ethem Kurt
	 * @param iterate_forward
	 *            "true", damit toString() die Liste vorwärts durchgeht, sonst
	 *            umgekehrt
	 */
	public void setIterateForward(boolean iterate_forward) {
		this.iterate_forward = iterate_forward;
	}

	/**
	 * Wiedergibt die Iterationsmethode
	 * 
	 * @author Ethem Kurt
	 * @return "true", wenn toString() die Liste vorwärts durchgeht, sonst
	 *         "false"
	 */
	public boolean isIteratingForward() {
		return iterate_forward;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		MyLinkedListElem<WortInIndex> it;
		if (iterate_forward) {
			it = wi.getList().getFirst();
			for (it = wi.getList().getFirst(); it != null; it = it.getNext()) {
				buf.append(it.Obj);
				buf.append("\r\n");
			}
		} else {
			it = wi.getList().getLast();
			for (it = wi.getList().getLast(); it != null; it = it.getPrev()) {
				buf.append(it.Obj);
				buf.append("\r\n");
			}
		}
		return buf.toString();
	}
}
