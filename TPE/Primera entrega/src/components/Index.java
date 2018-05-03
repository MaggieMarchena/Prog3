package components;
import java.util.ArrayList;
import java.util.List;

import comparators.ComparatorGenderName;

public class Index {
	
	//ATTRIBUTES
	private List<Gender> genders;
	private List<String> genderNames;

	public Index() {
		this.genders = new ArrayList<Gender>();
		this.genderNames = new ArrayList<String>();
	}
	
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
	
	private Gender createGender(String name){
		Gender g = new Gender (name);
		return g;
	}
	
	private Gender getGender(String name){
		int aux = 0;
		while ((aux < this.genders.size()) && !(this.genders.get(aux).getName().equals(name))){
			aux++;
		}
		return this.genders.get(aux);
	}
	
	public void sort(ComparatorGenderName c){
		this.genders.sort(c);
	}
	
	public List<Book> getBooksByGender(String genderName){
		List<Book> copy = new ArrayList<Book>();
		copy.addAll(this.getGender(genderName).getBooks());
		return copy;
	}

}
