package Sorting;

public class Selection extends ComparingAndExchanging {

    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (super.less(a[j], a[min])) {
                    min = j;
                }
                super.exchange(a, i, min);
            }
        }
    }
}