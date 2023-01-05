import java.util.List;
import java.util.*;

public class HashListAutocomplete implements Autocompletor {

    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
			throw new NullPointerException("One or more arguments null");
		}
		
		initialize(terms,weights);
    }


    @Override
    public List<Term> topMatches(String prefix, int k) {
        // TODO Auto-generated method stub
        if (k==0) {
            return new ArrayList<>();
        }
        if(prefix.length()>=MAX_PREFIX){
            String pre = prefix.substring(0,MAX_PREFIX);
            if(!myMap.containsKey(pre)){
                return new ArrayList<>();
            }
            List<Term> all = myMap.get(pre);
            return all.subList(0,Math.min(k, all.size()));
        }
        if(!myMap.containsKey(prefix)) {
            return new ArrayList<>();
        }
        List<Term> all = myMap.get(prefix);
        return all.subList(0,Math.min(k,all.size()));


    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        // TODO Auto-generated method stub
        myMap = new HashMap<String, List<Term>>();

        if (!(terms.length == weights.length)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i <= MAX_PREFIX; i++) {
            for (int j = 0; j < terms.length; j++) {
                if (terms[j].length() >= i) {
                    String keyTerm = terms[j].substring(0,i);
                    Term newTerm = new Term(terms[j], weights[j]);

                    if (!myMap.containsKey(keyTerm)) {
                        List newList = new ArrayList<>();
                        newList.add(newTerm);
                        myMap.put(keyTerm, newList);
                    }
                    else {
                        myMap.get(keyTerm).add(newTerm);
                    }
                }
            }
        }

        for (String key : myMap.keySet()) {
            Collections.sort(myMap.get(key), Comparator.comparing(Term::getWeight).reversed());
        }
        
    }

    @Override
    public int sizeInBytes() {
        // TODO Auto-generated method stub
        if (mySize == 0) {

            for(String key: myMap.keySet()) {
                mySize += BYTES_PER_CHAR * key.length();
            }
            for(Term t: myMap.get("")){
                mySize += BYTES_PER_DOUBLE + BYTES_PER_CHAR * t.getWord().length();
            }
        }
        return mySize;

    }
    
}