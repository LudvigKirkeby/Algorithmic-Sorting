package Sorting;

import java.util.Random;

public class Quick extends ComparingAndExchanging{

    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = new Random().nextInt(high - low + 1) + low;
        Comparable pivot = a[pivotIndex];
        super.exchange(a, pivotIndex, high);
        int lp = low;
        int rp = high - 1;

        while (lp <= rp) {
            while (lp <= rp && a[lp].compareTo(pivot) < 0) {
                lp++;
            }

            while (lp <= rp && a[rp].compareTo(pivot) > 0) {
                rp--;
            }

            if (lp <= rp) {
                super.exchange(a, lp, rp);
                lp++;
                rp--;
            }
        }

        super.exchange(a, lp, high);

        sort(a, low, rp);
        sort(a, lp, high);
    }
}