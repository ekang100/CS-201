import java.util.ArrayList;

public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;
        public Node(String x) {
            info = x;
            next = null;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;

    public LinkStrand() {
        this("");
    }

    public LinkStrand(String s) {
        initialize(s);
    }
    
 
    @Override
    public long size() {
        // TODO Auto-generated method stub
        return mySize;
    }

    @Override
    public void initialize(String source) {
        // TODO Auto-generated method stub
        myFirst = new Node(source);
        myLast = myFirst;
        mySize = myFirst.info.length();
        myAppends = 0;
        myIndex = 0;
        myCurrent = myFirst;
        myLocalIndex = 0;
        
    }

    @Override
    public IDnaStrand getInstance(String source) {
        // TODO Auto-generated method stub
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        // TODO Auto-generated method stub
        myLast.next = new Node(dna);
        myLast = myLast.next;
        mySize += myLast.info.length();
        myAppends++;
        return this;
    }

    @Override
    public String toString() {
        Node lst = myFirst;
        StringBuilder ret = new StringBuilder();
        while (lst.next != null) {
            ret.append(lst.info);
            lst = lst.next;
        }

        ret.append(lst.info);
        
        return ret.toString();
    }

    @Override
    public IDnaStrand reverse() {
        //TODO Auto-generated method stub
        Node newNode = myFirst;
        LinkStrand ret = new LinkStrand();
        ArrayList<String> dnaList = new ArrayList<>();
        while (newNode != null) {
            StringBuilder dna = new StringBuilder(newNode.info);
            String x = dna.reverse().toString();
            dnaList.add(x);
            newNode = newNode.next;
            
        }
        Node head = new Node("");
        Node nxt = new Node("");
        ret.myFirst = head;
        for (int i = dnaList.size()-1; i >= 0; i--) {
            head.info = dnaList.get(i);
            head.next = nxt;
            ret.mySize += head.info.length();
            head = nxt;
            nxt = new Node("");
        }

        return ret;
    }

    @Override
    public int getAppendCount() {
        // TODO Auto-generated method stub
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        // TODO Auto-generated method stub
        if(index < 0 || this.size() <= index) {
			throw new IndexOutOfBoundsException();
		}
		if (myIndex >= index)
		{
			myIndex = 0;
			myLocalIndex = 0;
			myCurrent = myFirst;
		}
		while (index != myIndex)
		{
			myIndex += 1;
			myLocalIndex += 1;
			if (myCurrent.next != null && myCurrent.info.length()<= myLocalIndex) {
				myCurrent = myCurrent.next;
				myLocalIndex = 0;
			}	
		}
		return myCurrent.info.charAt(myLocalIndex);
    }
    
}

    