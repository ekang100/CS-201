public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long ret = 0;
        for (int size: sizes) {
            int disk = (size + clusterSize - 1) / clusterSize;
            long prod = disk * clusterSize;
            ret += prod;
        }

        return ret;
     }
    
}
