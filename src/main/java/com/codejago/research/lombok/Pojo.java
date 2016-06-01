/**
 * 
 */
package com.codejago.research.lombok;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.ToString;

/**
 * "Incorporating Lombok's annotations in a project can greatly reduce the 
 * number of lines of boilerplate code that are either generated in the IDE or 
 * written by hand." 
 * @see http://jnb.ociweb.com/jnb/jnbJan2010.html
 * @see http://awhitford.github.io/lombok.maven/lombok-maven-plugin/usage.html
 * http://mvnrepository.com/artifact/org.projectlombok/lombok-maven-plugin
 * 
 */
@ToString(callSuper = true)
@EqualsAndHashCode
public class Pojo {

	/* Some bean data */
	private @Getter @Setter @NonNull String firstName;
	private @Getter String surname;
	private @Getter int age;
	private @Getter @Setter(AccessLevel.PROTECTED) Date dateOfBirth;

	/**
	 * Write to file with annotated resource release
	 */
	public void persist() throws IOException {

		@Cleanup
		FileWriter f = new FileWriter(new File(getFirstName()));
		f.write(toString());
		f.flush();
	}
	
	/**
	 * Synchronizes on an internal semaphore
	 */
	@Synchronized
	public void lockable() {
		
		System.err.println(toString());
	}
	
	/**
	 * Throws the exception even though it isn't listed 
	 * in the method's throws clause.
	 */
	@SneakyThrows
	public void throwsUnchecked() {
		throw new Exception();
	}
}
