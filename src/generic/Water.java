package generic;

public class Water {
    private double liter;
    private double temp;

    public Water(double liter, double temp) {
        this.liter = liter;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "water{" +
                "liter=" + liter +
                ", temp=" + temp +
                '}';
    }
}
