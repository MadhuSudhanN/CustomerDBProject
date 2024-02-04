package com.validate;

public class StringFormat {
	public static String stringF(String s)
	{
		String t="";
		String ar[]=s.trim().split("\\s+");
		for(String a:ar) {
			t=t+stringFx(a)+" ";
		}
		return t;
	}
	
	public static String stringFx(String s)
	{
		String t="";
		String ar[]=s.trim().split("\\s+");
		for(String a:ar) {
			t=t+a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase()+" ";
		}
		return t.trim();
	}
	
	
}
