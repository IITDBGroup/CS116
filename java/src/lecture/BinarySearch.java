package lecture;

import java.util.List;

public class BinarySearch {
    
    public static boolean search(List l, int e) {
        return binSearch(l, e, 0, l.size() - 1);
    }
    
    private static boolean binSearch(List<Integer> l, int e, int low, int high) {
        int mid = (low + high) / 2;
        if (low >= high)
            return false;
        if (e == l.get(mid))
            return true;
        if (e < l.get(mid))
            return binSearch(l, e, low, mid - 1);
        if (e > l.get(mid))
            return binSearch(l, e, mid + 1, high);
        return false; // keep compiler qiet
    }
    
}