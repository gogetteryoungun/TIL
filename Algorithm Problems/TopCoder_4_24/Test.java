package practice;

public class Test {

	public static void main(String[] args) {
		String first[] = {"fishing", "gardening", "swimming", "fishing"};
		String second[] = {"hunting","fishing","fishing","biting"};
		InterestingParty i = new InterestingParty();
		System.out.println(i.bestInvitation(first, second));
		
		Cryptography c = new Cryptography();
		int[] list = {5,4,3,2};
		System.out.println(c.encrypt(list));
	
		Palindrome p = new Palindrome();
		String s ="abdfhdyrbdbsdfghjkllkjhgfds";
		String s2 = "abab";
		System.out.println(p.palindrome(s2));
	}
}
