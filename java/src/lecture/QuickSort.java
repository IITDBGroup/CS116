package lecture;

@Maintainer(firstName = "Peter", lastName = "Peterson")
public class QuickSort {
    
    public static void sortIt(int[] l) {
        qsort(l, 0, l.length - 1);
    }
    
    private static void qsort(int[] l, int low, int high) {
        if (low < high) {
            dostuff(l, low, high);
        }
    }

	private static void dostuff(int[] l, int low, int high) {
		int mid = partition(l, low, high);
		qsort(l, low, mid - 1);
		qsort(l, mid + 1, high);
	}
    
    private static void swap(int[] l, int left, int right) {
        int temp = l[left];
        l[left] = l[right];
        l[right] = temp;
    }
    
    private static int partition(int[] l, int low, int high) {
        int p = l[high]; // choose last element as pivot
        while(low < high) {
            if (l[low] > p)
                swap(l, low, high--);
            else
                low++;
        }
        
        return low;
    }
    
}