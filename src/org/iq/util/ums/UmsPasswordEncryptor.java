package org.iq.util.ums;

import java.util.Random;

import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public final class UmsPasswordEncryptor {

	/**
	 * 
	 */
	public static String encrypt(String password) {
		char[] passChars = password.toCharArray();
		StringBuffer tempBuf = new StringBuffer();
		for (int i = 0; i < passChars.length; i++) {
			int randomNum = getRandomNumberBetween(1, 9);
			tempBuf.append(randomNum);
			tempBuf.append(StringUtil.padCharLead(
					Integer.toOctalString(passChars[i] * randomNum), 5, "0"));
		}

		String temp = tempBuf.toString();
		StringBuffer encryted = new StringBuffer();
		while (temp.length() > 0) {
			int ascii = Integer.valueOf(temp.substring(0, 2));
			encryted.append((char) ascii);
			temp = temp.substring(2);
		}
		return encryted.toString();
	}

	/**
	 * 
	 */
	public static String decrypt(String encryptedPassword) {
		char[] passChars = encryptedPassword.toCharArray();
		StringBuffer tempBuf = new StringBuffer();
		for (char passChar : passChars) {
			tempBuf.append(StringUtil.padCharLead("" + (int) passChar, 2, "0"));
		}

		StringBuffer password = new StringBuffer();
		String temp = tempBuf.toString();
		while (temp.length() > 0) {
			String oneChar = temp.substring(0, 6);
			int multiplier = Integer.valueOf(oneChar.substring(0, 1));
			int octal = Integer.valueOf(oneChar.substring(1));
			int dec = Integer.valueOf("" + octal, 8);
			int ascii = dec / multiplier;
			password.append((char) ascii);
			temp = temp.substring(6);
		}
		return password.toString();
	}

	private static int getRandomNumberBetween(int numOne, int numTwo) {
		int i = 0;
		while ((i = new Random().nextInt(numTwo + 1)) < numOne)
			;
		return i;
	}
}