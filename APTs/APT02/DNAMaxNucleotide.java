public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
          int maxCount = 0;
          int maxLength = 0;
          char nucleotide = nuc.charAt(0);
          String ret = "";

          for (int i = 0; i < strands.length; i++) {
            int count = 0;
            int length = 0;
            char[] element = strands[i].toCharArray();

            for (int j = 0; j < element.length; j++) {
                if (element[j] == nucleotide) {
                    count++;
                }
                length++;
            }
            
            if (count > maxCount) {
                maxCount = count;
                maxLength = length;
                ret = strands[i];
                
            }
            if (count == maxCount && count != 0) {
                if (length > maxLength) {
                    maxLength = length;
                    ret = strands[i];
                }
            }
            

          }

          return ret;
          
    }
 }