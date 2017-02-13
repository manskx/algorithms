package interviewbit.strings;

public class Atoi {

	public static void main(String[] args) {
		System.out.println(atoi("9 2704"));
	}

	public static int atoi(final String a) {
		boolean negative = false;
		boolean signDetected = false;
		boolean numberDetected = false;
		boolean numberOverflow = false;
		int i = 0;
		int result = 0;
		while (i < a.length()) {
			if (a.charAt(i) == ' ' && !signDetected && !numberDetected) {
				i++;
				continue;
			}
			if ((a.charAt(i) == '-' || a.charAt(i) == '+') && (!signDetected && !numberDetected)) {
				if (a.charAt(i) == '-') {
					negative = true;
				}
				signDetected = true;

				i++;
				continue;
			}

			int diff = a.charAt(i) - '0';
			if (diff >= 0 && diff <= 9) {
				numberDetected = true;
				long resultLong = ((long) result) * 10;
				if (resultLong > Integer.MAX_VALUE) {
					numberOverflow = true;
					break;
				}
				result *= 10;
				result += diff;
				i++;
				continue;
			} else {
				break;
			}
		}
		if (!numberDetected)
			return 0;

		if (numberOverflow) {
			if (negative)
				return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		}

		if (negative)
			result *= -1;
		return result;
	}

}
