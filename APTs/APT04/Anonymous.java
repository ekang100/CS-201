public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		String headlinesNew = "";
		for(String s : headlines) {
			headlinesNew += s.toLowerCase();
		}
		int count = 0;
		for(String message : messages) {
			if (canMake(message.toLowerCase(), headlinesNew)) {
				count += 1;
			}
		}
		return count;
	}

	private boolean canMake(String message, String headline) {
		for(char ch = 'a'; ch <= 'z'; ch += 1) {
			int messageCount = count(message,ch);
			int headlinesCount = count(headline,ch);
			
			if (messageCount > headlinesCount) {			
				return false;
			}
		}
		return true;
	}

	private int count(String s, char ch) {
		int t = 0;
		for(char c : s.toCharArray()) {
			if (c == ch) t++;
		}
		return t;
	}
}