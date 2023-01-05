import java.util.*;

public class HashMarkov implements MarkovInterface {
    protected String[] myWords;
	protected Random myRandom;		
	protected int myOrder;
    protected Map<WordGram,ArrayList<String>> myMap;

    //public HashMarkov() {
    //    this(3);
    //    myMap = new HashMap<WordGram, ArrayList<String>>();
    //}
    public HashMarkov(int order) {
        myOrder = order;
		myRandom = new Random();
        myMap = new HashMap<>();

    }

    @Override
	public void setTraining(String text){
		myWords = text.split("\\s+");
        myMap.clear();
        for (int i = 0; i < myWords.length - myOrder; i++) {
            WordGram wg = new WordGram(myWords, i, myOrder);

            if (!myMap.containsKey(wg)) {
                myMap.put(wg, new ArrayList<String>());
            }

            myMap.get(wg).add(myWords[i+myOrder]);

        }

	}
    @Override
    public List<String> getFollows(WordGram wgram) {
        // TODO Auto-generated method stub
        List <String> follows = new ArrayList<>();
        follows = myMap.get(wgram);
        if (follows == null) {
            List<String> followsNew = new ArrayList<>();
            follows = followsNew;
        }

        return follows;
    }

    private String getNext(WordGram wgram) {
		List<String> follows = getFollows(wgram);
		if (follows.size() == 0) {
			int randomIndex = myRandom.nextInt(myWords.length);
			follows.add(myWords[randomIndex]);
		}
		int randomIndex = myRandom.nextInt(follows.size());
		return follows.get(randomIndex);
	}
   

    @Override
    public String getRandomText(int length) {
        // TODO Auto-generated method stub
        ArrayList<String> randomWords = new ArrayList<>(length);
		int index = myRandom.nextInt(myWords.length - myOrder + 1);
		WordGram current = new WordGram(myWords,index,myOrder);
		randomWords.add(current.toString());

		for(int k=0; k < length-myOrder; k += 1) {
            String nextWord = getNext(current);
            randomWords.add(nextWord);
			current = current.shiftAdd(nextWord);
		}
		return String.join(" ", randomWords);
    }
    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return myOrder;
    }
    @Override
    public void setSeed(long seed) {
        // TODO Auto-generated method stub
        myRandom.setSeed(seed);
    }
}
