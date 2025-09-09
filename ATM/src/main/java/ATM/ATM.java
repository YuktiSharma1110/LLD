// File: ATM.java
package ATM;

public class ATM {
    private final long totalCash;
    private final int notes100;
    private final int notes50;
    private final int notes20;

    public ATM(long totalCash, int notes100, int notes50, int notes20)
    {
        if (totalCash < 0) throw new IllegalArgumentException("totalCash < 0");

        if (notes100 < 0 || notes50 < 0 || notes20 < 0)
            throw new IllegalArgumentException("note counts < 0");

        this.totalCash = totalCash;
        this.notes100 = notes100;
        this.notes50 = notes50;
        this.notes20 = notes20;
    }

    public long getTotalCash() { return totalCash; }
    public int getNotes100() { return notes100; }
    public int getNotes50()  { return notes50; }
    public int getNotes20()  { return notes20; }
}
