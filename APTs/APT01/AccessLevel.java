public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String ret = "";
        for (int i = 0; i < rights.length; i ++) {
            if (rights[i] >= minPermission) {
                ret = ret + "A";
            }
            else {
                ret = ret + "D";
            }
        }

        return ret;
    }
}
