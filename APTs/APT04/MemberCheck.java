import java.util.ArrayList;
import java.util.Collections;

public class MemberCheck {
    public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
        ArrayList<String> dishonest = new ArrayList<>();
		
		for (int i = 0; i < club1.length; i++) {
			for (int j = 0; j < club2.length; j++) {
				if (club1[i].equals(club2[j]) && !dishonest.contains(club1[i])) {
					dishonest.add(club1[i]);
				}
			}
		}
		
		for (int i = 0; i < club1.length; i++) {
			for (int j = 0; j < club3.length; j++) {
				if (club1[i].equals(club3[j]) && !dishonest.contains(club1[i])) {
					dishonest.add(club1[i]);
				}
			}
		}
		
		for (int i = 0; i < club2.length; i++) {
			for (int j = 0; j < club3.length; j++) {
				if (club2[i].equals(club3[j]) && !dishonest.contains(club2[i])) {
					dishonest.add(club2[i]);
				}
			}
		}

		Collections.sort(dishonest);

		String[] dishonestArray = new String[dishonest.size()];
		dishonestArray = dishonest.toArray(dishonestArray);
		
		return dishonestArray;
      }

}
