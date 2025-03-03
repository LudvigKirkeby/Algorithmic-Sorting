package Algorithmic-Sorting.Sorting;

public class Insertion extends ComparingAndExchanging {

    protected void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (super.less(a[j], a[j - 1])) {
                    super.exchange(a, j, j - 1);
                }
            }
        }
    }
}
