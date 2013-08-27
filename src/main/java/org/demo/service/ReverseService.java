package org.demo.service;

/**
 * Reverse service (to be injected)
 * 
 * @author L. Guerin
 *
 */
public class ReverseService {

	public String reverse( String s ) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
}
