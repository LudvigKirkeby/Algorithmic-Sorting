package Kattis.Sorting;

public class Quick extends ComparingAndExchanging{


    protected void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    protected void sort(Comparable[] a, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivotIndex = new Random().nextInt(high - low) + low;

        partition(a, low, high, pivotIndex);

        sort(a, low, lp - 1);
        sort(a, lp + 1, high);
    }

    private void partition(Comparable[] a, int low, int high, int pivotIndex) {
        Comparable pivot = a[pivotIndex];
        super.exchange(a, pivotIndex, high);
        Comparable lp = a[low];
        Comparable rp = a[high];

        while (lp < rp) {
            while (array[lp] <= pivot && lp < rp) {
                lp++;
            }

            while (array[rp] >= pivot && lp < rp) {
                rp--;
            }

            super.exchange(a, lp, rp);
        }
        super.exchange(a, lp, high);
        return lp;
    }
}
