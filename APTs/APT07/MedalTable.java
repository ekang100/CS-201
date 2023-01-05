import java.util.*;
public class MedalTable {
    private class MedalCountry {
        String myName;
        int myGold;
        int mySilver;
        int myBronze;

        MedalCountry(String name) {
            myName = name;
        }
        public int getGold(){
            return myGold;
        }
        public String getName(){
            return myName;
        }
        public int getSilver(){
            return mySilver;
        }
        public int getBronze() {
            return myBronze;
        }

        @Override
        public String toString() {
            return String.format("%s %d %d %d", myName,myGold,mySilver,myBronze);
        }
    }
    public String[] generate(String[] results) {
        Map<String,MedalCountry> map = new HashMap<>();
        for (String s: results) {
            String[] data = s.split(" ");
            String gold = data[0];
            String silver = data[1];
            String bronze = data[2];

            map.putIfAbsent(gold, new MedalCountry(gold));
            map.putIfAbsent(silver, new MedalCountry(silver));
            map.putIfAbsent(bronze, new MedalCountry(bronze));

            map.get(gold).myGold++;
            map.get(silver).mySilver++;
            map.get(bronze).myBronze++;
        }

        List <MedalCountry> countries = new ArrayList<>(map.values());

        countries.sort(Comparator.comparing(MedalCountry::getName));
        countries.sort(Collections.reverseOrder(Comparator.comparing(MedalCountry::getBronze)));
        countries.sort(Collections.reverseOrder(Comparator.comparing(MedalCountry::getSilver)));
        countries.sort(Collections.reverseOrder(Comparator.comparing(MedalCountry::getGold)));

        String[] ret = new String[countries.size()];

        for (int i = 0; i < countries.size(); i++) {
            MedalCountry country = countries.get(i);
            ret[i] = country.toString();
        }

        return ret;
    }
    
  }