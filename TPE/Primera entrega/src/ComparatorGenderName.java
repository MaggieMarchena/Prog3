package comparators;

import java.util.Comparator;

import components.Gender;

public class ComparatorGenderName implements Comparator<Gender> {

	public ComparatorGenderName() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Gender g1, Gender g2) {
		return (g1.getName().compareTo(g2.getName()));
	}
}
