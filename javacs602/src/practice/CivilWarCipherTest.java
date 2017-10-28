
package practice;

import java.util.Random;

public class CivilWarCipherTest {
	
	public static void main(String args[])
	{
		test3();
	}
	
	public static void test1() {
		CivilWarCipher enc = new CivilWarCipher(
				"YES", 
				Alphabet.UPPPERCASE_QWERTY
		);
		String plainText = "AT MIDNIGHT ATTACK";
		String encrypted = enc.encrypt(plainText);
		System.out.println(encrypted);
		String decrypted = enc.decrypt(encrypted);
//		System.out.println(encrypted);
//		System.out.println(decrypted);		
	}
	
	public static void test2() {
		CivilWarCipher enc = new CivilWarCipher("BCh0sMz3fK", 
			Alphabet.NUMBERS
			.plus(Alphabet.UPPERCASE)
			.plus(Alphabet.LOWERCASE)
		);
		String plainText = "FKmSs5B0fl";
		String encrypted = enc.encrypt(plainText);
		String decrypted = enc.decrypt(encrypted);
//		System.out.println(encrypted);
		System.out.println(decrypted);
	}

	public static void test3() {

		Alphabet masterAlphabet = Alphabet.NUMBERS
		.plus(Alphabet.UPPERCASE)
		.plus(Alphabet.LOWERCASE);

		
		Alphabet randomAlphabet = Alphabet.NUMBERS
		.plus(Alphabet.UPPERCASE)
		.plus(Alphabet.LOWERCASE);

		char[] validChars = randomAlphabet.validChars;
		Random random = new Random();

		for(int i=0; i<100; i++) {
			String key = new String(randomChars(random, validChars, 10));
			String message = new String(randomChars(random, validChars, 30));
			System.out.println(message);
			CivilWarCipher enc = new CivilWarCipher(key, masterAlphabet);
			String encrypted = enc.encrypt(message);
			String decrypted = enc.decrypt(encrypted);
		
			System.out.println(decrypted);
		}
	}	
	
	static char[] randomChars(Random random, char[] input, int howMany) {
		howMany = Math.min(howMany, input.length);
		for(int i=0; i < input.length; i++) {
			int ni = input.length - i;
			int ri = random.nextInt(ni);
			swap(input, ni - 1, ri);
		}
		char[] answer = new char[howMany];
		System.arraycopy(input, input.length - howMany - 1, answer, 0, howMany);
		return answer;
	}
	
	static void swap(char[] input, int a, int b) {
		char ca = input[a];
		input[a] = input[b];
		input[b] = ca;		
	}
}
