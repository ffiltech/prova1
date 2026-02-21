package gestionelibreria;
//versione 6 online
import java.util.Arrays;

public class Libreria {
	private String nome;
	// private int maxLibri;
	private Libro[] libri;
	// private Libro libri[];
	private int numLibri;

	public Libreria(String nome, int maxLibri) {
		this.nome = nome;
		libri = new Libro[maxLibri];
		numLibri = 0;
	}

	public boolean addLibro(Libro lib) {
		if (numLibri < libri.length) {
			libri[numLibri] = lib;
			numLibri++;
			return true;
		}
		
		return false;
	}

	//elimina libro per posizione senza controllo
	public void delLibroPos(int pos) {
		libri[pos]=null;
	}
	
	//elimina libro per codice con controllo
		public boolean delLibroCodice(String cod) {
			for(int i=0;i<libri.length;i++) {
				if(libri[i]!=null && libri[i].getCodice().equalsIgnoreCase(cod)) {
					libri[i]=null;
					return true;
				}
			}
			return false;
		}
		
		//elimina libro per codice con controllo e compattazione
				public boolean delLibroCodiceComp(String cod) {
					int j;
					for(int i=0;i<libri.length;i++) {
						if(libri[i]!=null && libri[i].getCodice().equalsIgnoreCase(cod)) {
							//libri[i]=null;
							for(j=i+1;j<libri.length;j++) {
								libri[j-1]=libri[j];
							}
							libri[j-1]=null;
							numLibri--;
							return true;
						}
					}
					return false;
				}
	
	/*
	 * public boolean addLibro(Libro lib) { libri[numLibri]=lib; numLibri++; return
	 * false; }
	 */
	
	//libri presenti in biblioteca
				
	int libriPresenti() {
		return numLibri;
	}
				
	//libro con più pagine
	Libro libroPiuPagine() {
		Libro libMax=libri[0];
		int pagMax=libri[0].getPagine();
		for(int i=0;i<libri.length;i++) {
			if(libri[i] != null && libri[i].getPagine()>pagMax) {
				pagMax=libri[i].getPagine();
				libMax=libri[i];
			}
		}
			
		return libMax;
	}
	
	//ricerca di tutti i libri scritti da un autore
	String libriPerAutore(String autore) {
		String st="";
		for(int i=0;i<libri.length;i++) {
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				st+=libri[i]+"\n";
			}
		}
		return st;
	}
	
	//ricerca di tutti i libri scritti da un autore - ritorno di oggetti
	Libro[] libriPerAutoreArray(String autore) {
		// dichiaro un array di tipo libro temporaneo
		Libro libriPerAutore[] = new Libro[numLibri];
		int n=0;	//variabile per i libri trovati
		for(int i=0;i<libri.length;i++) {
			if (libri[i] != null && libri[i].getAutore().equalsIgnoreCase(autore)) {
				libriPerAutore[n]=libri[i];
				n++;
			}
		}
		return libriPerAutore;	//ritorno array
	}
	
	public String toString() {
		String s="Nome Libreria: "+nome+"\n";
		for(int i=0;i<libri.length;i++) {
			if(libri[i]!=null) {
				s=s+libri[i]+" \n";
			}
		}
		return s;
	}

	/*public String toString() {
		return "Libreria [nome=" + nome + ", libri=" + Arrays.toString(libri) + "]";
	}*/

	// test di classe
	public static void main(String[] args) {
		Libreria libCentrale = new Libreria("Libreria Viale Ferrari", 5);
		Libro lib1 = new Libro("Libro 1", "autore 1");
		Libro lib2 = new Libro("Libro 2", "autore 2");
		Libro lib3 = new Libro("Libro 3", "autore 3");
		Libro lib4 = new Libro("Libro 4", "autore 1");

		System.out.println(libCentrale.addLibro(lib1));
		System.out.println(libCentrale.addLibro(lib2));
		System.out.println(libCentrale.addLibro(lib3));
		System.out.println(libCentrale.addLibro(lib4));
		
		libCentrale.libri[0].setPagine(200);
		libCentrale.libri[1].setPagine(100);
		libCentrale.libri[2].setPagine(150);
		libCentrale.libri[3].setPagine(50);
		
		libCentrale.libri[0].setCodice("COD1");
		libCentrale.libri[1].setCodice("COD2");
		libCentrale.libri[2].setCodice("COD3");
		libCentrale.libri[3].setCodice("COD4");

		//libCentrale.delLibroPos(1);
		System.out.println(libCentrale.delLibroCodiceComp("COD3"));
				
		System.out.println(libCentrale);

		System.out.println("Libri in libreria: "+libCentrale.libriPresenti());
		System.out.println("Libro con più pagine: "+libCentrale.libroPiuPagine());
		
		//libri per autore array
		Libro libAut[] = libCentrale.libriPerAutoreArray("autore 1");
		
		System.out.println("Libri per autore array: ");
		
		for(int i=0;i<libAut.length;i++) {
			if(libAut[i]!= null)
			System.out.println(libAut[i]);
		}
	}

}
