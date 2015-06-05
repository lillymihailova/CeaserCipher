import java.util.Scanner;

public class CeaserCipher {

	public static void main(String[] args) {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z' };

		String cipher = null;
		String error = "Invalid displacement!";
		Scanner input = new Scanner(System.in);
		System.out
				.println("Plese enter 1 if you want to encrypt or 2 if you want to decrypt:");
		int n = input.nextInt();
		if (n == 1) {
			String answer = encrypt(alphabet, cipher, error);
			System.out.println(answer);
		} else if (n == 2) {
			String answer = decrypt(alphabet, cipher,error);
			System.out.println(answer);
		} else if (n != 1 || n != 2) {
			System.out.println("Invalid choice!");
		}
	}

	public static String encrypt(char[] alphabet, String cipher, String error) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter the text to encrypt:");
		String cip1 = sc.nextLine();
		char[] cipher1 = cip1.toCharArray();
		System.out.println("Please, enter displacement:");
		int m = sc.nextInt();
		if (m > 0) {
			for (int i = 0; i < cipher1.length; i++) {
				for (int j = 0; j < alphabet.length; j++) {
					if ((j + m <= alphabet.length)
							&& (cipher1[i] == alphabet[j])) {
						cipher1[i] = alphabet[j + m];
						break;
					}
					if ((j + m > alphabet.length)
							&& (cipher1[i] == alphabet[j])) {
						cipher1[i] = alphabet[(j + m) - alphabet.length];
					}
				}
			}
			cipher = String.valueOf(cipher1);
			return cipher;
		} else {
			return error;
		}
	}

	public static String decrypt(char[] alphabet, String cipher, String error) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please, enter text to decrypt:");
		String cip2 = in.nextLine();
		char[] cipher2 = cip2.toCharArray();
		System.out.println("Please, enter the displacement:");
		int d = in.nextInt();
		if (d > 0) {
			for (int i = 0; i < cipher2.length; i++) {
				for (int j = 0; j < alphabet.length; j++) {
					if ((j >= d) && (cipher2[i] == alphabet[j])) {
						cipher2[i] = alphabet[j - d];
						break;
					}
					if ((j < d) && (cipher2[i] == alphabet[j])) {
						cipher2[i] = alphabet[j + (alphabet.length - d)];
						break;
					}
				}
			}
			cipher = String.valueOf(cipher2);
			return cipher;
		} else {
			return error;
		}
	}
}