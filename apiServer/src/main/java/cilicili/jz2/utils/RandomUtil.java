package cilicili.jz2.utils;

import java.util.Random;

public class RandomUtil {
	private static final int length = 30; // 必须大于 13
	private static final String salt = "CilIcILiByJZ2hnmcs4NGGYEGjg34yugbEYr2UJHENRUnkguhnmkHNeN4yu3tbyu4tb";
	private static final char[] alphaBetArr = "qwertyuiopa1s0dfghjkl2zx5cvbn7mMNBVC3X9Z6LKJHGFD4SA8POIUYTREWQ".toCharArray();
	private static final String baseToken = "iUYTpcvbn7REWQX9ertyuBVC3KZAqwMozx5SD4a1s0JHG8Pmdfghjkl2OINF6L";
	
	public static String getRandomFilename(String extension, String filename, String token) {
		Random rnd = new Random(System.currentTimeMillis());
		char[] saltArr = salt.toCharArray();
		char[] filenameArr = getRandomString(filename);
		char[] tokenArr = getRandomString(token);
		String currentTime = String.valueOf(System.currentTimeMillis());
		char[] currentTimeArr = currentTime.toCharArray();
		StringBuilder res = new StringBuilder();
		int timeSplitPos = 7;
		res.append(currentTime, 0, timeSplitPos);
		for (int i = timeSplitPos; i < length - 6; i ++) {
			char thisChar = '*';
			switch (rnd.nextInt(4)) {
				case 0:
					thisChar = saltArr[rnd.nextInt(saltArr.length)];
					break;
				case 1:
					thisChar = filenameArr[rnd.nextInt(filenameArr.length)];
					break;
				case 2:
					thisChar = tokenArr[rnd.nextInt(tokenArr.length)];
					break;
				case 3:
					thisChar = currentTimeArr[rnd.nextInt(currentTimeArr.length)];
					break;
			}
			res.append(thisChar);
		}
		res.append(currentTime, timeSplitPos, currentTime.length());
		return res.append('.').append(extension).toString();
	}
	
	static String getRandomToken(int seed) {
		Random rnd = new Random(System.currentTimeMillis() + seed);
		char[] saltArr = salt.toCharArray();
		String currentTime = String.valueOf(System.currentTimeMillis());
		char[] currentTimeArr = currentTime.toCharArray();
		char[] baseTokenArr = getRandomString(baseToken);
		StringBuilder res = new StringBuilder();
		int timeSplitPos = 7;
		res.append(currentTime, 0, timeSplitPos);
		for (int i = timeSplitPos; i < length - 6; i ++) {
			char thisChar = '*';
			switch (rnd.nextInt(2)) {
				case 0:
					thisChar = saltArr[rnd.nextInt(saltArr.length)];
					break;
				case 1:
					thisChar = currentTimeArr[rnd.nextInt(currentTimeArr.length)];
					break;
				case 2:
					thisChar = baseTokenArr[rnd.nextInt(baseTokenArr.length)];
					break;
			}
			res.append(thisChar);
		}
		res.append(currentTime, timeSplitPos, currentTime.length());
		return res.toString();
	}
	
	private static char[] getRandomString(String target) {
		Random rnd = new Random(System.currentTimeMillis());
		char[] targetArr = target.toCharArray();
		for (int i = 0; i < targetArr.length; i ++) {
			int charCode = (int)targetArr[i];
			int pos = (alphaBetArr.length + charCode + rnd.nextInt(charCode)) % alphaBetArr.length;
			targetArr[i] = alphaBetArr[pos];
		}
		return targetArr;
	}
}
