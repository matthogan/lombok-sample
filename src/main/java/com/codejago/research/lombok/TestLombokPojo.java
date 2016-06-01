/**
 * 
 */
package com.codejago.research.lombok;

import java.io.IOException;
import java.util.Date;

/**
 * Testing {@link Pojo}
 */
public class TestLombokPojo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Pojo pojo = new Pojo();
		Date dob = new Date();

		pojo.setFirstName("John");
		pojo.setDateOfBirth(dob);

		System.err.println(pojo.getFirstName());
		System.err.println(pojo.getDateOfBirth());

		Pojo pojo2 = new Pojo();

		pojo2.setFirstName("John");
		pojo2.setDateOfBirth(dob);

		System.err.println(pojo.hashCode());
		System.err.println(pojo2.hashCode());
		System.err.println(pojo.equals(pojo2));

		try {
			Pojo pojo3 = new Pojo();
			pojo3.setFirstName(null);
		} catch (NullPointerException ex) {
			System.err.println("It failed as expected! " + ex.getMessage());
		}

		try {
			pojo.persist();
			System.err.println("Persist passed.");
		} catch (IOException ex) {
			System.err.println("Persist failed! " + ex.getMessage());
		}
	}

}
