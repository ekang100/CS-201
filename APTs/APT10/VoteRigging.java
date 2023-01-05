public class VoteRigging {
    public int minimumVotes(int[] votes) {
        // fill in code here
        int num = 0;
        while (mostVotes(votes) != 0) {
            votes[mostVotes(votes)]--;
            votes[0]++;
            num++;
        }
        return num;
    }

    public int mostVotes(int[] votes) {
        int max = votes[0];
        int i = 0;

        for (int j = 0; j < votes.length; j++) {
            if (max <= votes[j]) {
                max = votes[j];
                i = j;
            }
        }

        return i;
    }
}
