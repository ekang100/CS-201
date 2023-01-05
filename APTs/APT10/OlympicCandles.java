import java.util.*;
public class OlympicCandles {
    public int numberOfNights(int[] candles){
        // write code
        ArrayList<Integer> candleList = new ArrayList<>();
        for (int elem : candles) {
            candleList.add(elem);
        }

        Collections.sort(candleList, Collections.reverseOrder());
        int night = 1;
        while (true) {
            for (int i = 0; i < night; i++) {
                candleList.set(i, candleList.get(i) - 1);
            }

            Collections.sort(candleList, Collections.reverseOrder());
            if (night == candleList.size() || candleList.get(night) == 0) {
                return night;
            }
            night += 1;
        }
     }
}
