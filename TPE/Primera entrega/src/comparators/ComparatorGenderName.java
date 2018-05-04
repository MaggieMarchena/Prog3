package comparators;

import java.util.Comparator;

import components.Gender;

public class ComparatorGenderName implements Comparator<Gender> {

	//CONSTRUCTORS
	public ComparatorGenderName() {
	}

	/**
	 * Compara los nombres de los géneros para ordenarlos de forma alfabética
	 */
	@Override
	public int compare(Gender g1, Gender g2) {
		return (g1.getName().compareTo(g2.getName()));
	}
}
