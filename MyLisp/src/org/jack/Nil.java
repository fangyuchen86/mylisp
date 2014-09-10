package org.jack;

public class Nil {
	private Nil(){}
	private static Nil nil = new Nil();
	
	public static Nil getNil(){
		return nil;
	}
	 
}
