package gestionelibreria;

public class Libro {
	private String titolo;
	private String autore;
	private String codice;
	private int pagine;
	public Libro(String titolo, String autore) {
		this.titolo = titolo;
		this.autore = autore;
	}
	
	public String toString() {
		String s;
		s=titolo + ", autore: " + autore + ", codice:" + codice + ", pagine: " + pagine;
		return s;
	}
	
	public int getPagine() {
		return pagine;
	}
	
	public String getAutore() {
		return autore;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public static void main(String[] args) {
		Libro l1=new Libro("Titolo a caso","Io");
		l1.setCodice("codice555");
		l1.setPagine(125);
		System.out.println(l1);
	}
}
