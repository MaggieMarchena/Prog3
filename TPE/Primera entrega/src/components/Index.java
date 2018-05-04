package components;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comparators.ComparatorGenderName;

public class Index {
	
	//ATTRIBUTES
	private List<Gender> genders;
	private List<String> genderNames;

	//CONSTRUCTORS
	public Index() {
		this.genders = new ArrayList<Gender>();
		this.genderNames = new ArrayList<String>();
	}
	
	//METHODS
	
	/**
	 * Agrega un libro al índice, si el género existe se coloca en la lista del mismo, si no se crea el nuevo género,
	 * se agrega el libro a su lista y se agrega el género a la lista de géneros
	 * @param b el libro que se agrega
	 */
	public void add(Book b){
			String[] genders = b.getGenders();
			for (int i = 0; i < genders.length; i++){
				String genderName = genders[i];
				if (this.genderNames.contains(genderName)){			
					this.getGender(genderName).addBook(b);
				}
				else {
					Gender g = createGender(genderName);
					g.addBook(b);
					this.genders.add(g);
					this.genderNames.add(genderName);
				}	
			}
	}
	
	/**
	 * Crea un nuevo género
	 * @param name el nombre del bueno género
	 * @return Gender
	 */
	private Gender createGender(String name){
		Gender g = new Gender (name);
		return g;
	}
	
	/**
	 * Devuelve el género (Object) con un nombre dado
	 * @param name nombre del género
	 * @return Gender
	 */
	private Gender getGender(String name){
		Gender aux = null;
		Iterator<Gender> itr = this.genders.iterator();
		while (itr.hasNext()){
			Gender gender = (Gender) itr.next();
			if (gender.getName().equals(name)){
				aux = gender;
			}
		}
		return aux;
	}
	
	/**
	 * Devuelve una List<Book> de los libro de un género, copia de la original
	 * @param genderName nombre del género
	 * @return List<Book>
	 */
	public List<Book> getBooksByGender(String genderName){
		List<Book> copy = new ArrayList<Book>();
		copy.addAll(this.getGender(genderName).getBooks());
		return copy;
	}
	
	/**
	 * Ordena la lista de géneros de forma alfabética, utilizando un comparador específico
	 * @param c Comparator<Gender>
	 */
	public void sort(ComparatorGenderName c){
		this.genders.sort(c);
	}

}
