package comparators;

import java.util.Comparator;

import components.Gender;

public class ComparatorGenderName implements Comparator<Gender> {

	//CONSTRUCTORS
	public ComparatorGenderName() {
	}

	/**
	 * Compara los nombres de los g�neros para ordenarlos de forma alfab�tica
	 */
	@Override
	public int compare(Gender g1, Gender g2) {
		return (g1.getName().compareTo(g2.getName()));
	}
}
