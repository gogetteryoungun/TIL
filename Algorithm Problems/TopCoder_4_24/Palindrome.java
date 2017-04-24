package practice;
import java.util.*;

public class Palindrome {

	public int palindrome(String list){
		
		int len = list.length();
		int k=0; // counter from the beginning
		int r=0; // counter from the end
		while(k!=len/2){
			if(list.charAt(k)==list.charAt(len-r-1)){// if they match, narrow down symmetrically
				k++; 
				r++;	
			}else{//if they don't match symmetrically, fix len-r-1 and increase k for next comparison
				k++; r++; len++; //increase r also in order to offset len increased
			}	
		}
		return len; //return increased or non-increased(if palindrome already) length
	}
	
}
