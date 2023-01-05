import java.util.*;
public class FriendScore {
    public int highestScore(String[] friends) {
        // you fill in code here
        List<Set<Integer>> friendSet = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            friendSet.add(new HashSet<>());
        }

        for (int i = 0; i < friends.length; i++) {
            char[] row = friends[i].toCharArray();
            for (int j = 0; j <friends.length; j++) {
                if (row[j] == 'Y') {
                    friendSet.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < friends.length; i++) {
            for (int friend : friendSet.get(i)) {
                if (!friendSet.get(friend).contains(i)) {
                    friendSet.get(i).remove(friend);
                }
            }
        }

        List<Set<Integer>> friendOfFriend = new ArrayList<>();

        for (int i = 0; i < friends.length; i++) {
            friendOfFriend.add(new HashSet<>());
        }

        for (int i = 0; i < friends.length; i++) {
            for (int friend : friendSet.get(i)) {
                for (int friendsFriend : friendSet.get(friend)) {
                    if (friendsFriend != i) {
                        friendOfFriend.get(i).add(friendsFriend);
                    }
                }
            }
        }

        for (int i = 0; i < friendSet.size(); i++) {
            Set<Integer> person = friendSet.get(i);
            person.addAll(friendOfFriend.get(i));
        }

        return Collections.max(friendSet, new Comparator<Set<Integer>>() {
            @Override
            public int compare(Set<Integer> set1, Set<Integer> set2) {
                return set1.size() - set2.size();
            }
        }).size();
    }

     
}
