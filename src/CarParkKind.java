//package cm;
import java.math.BigDecimal;
/**
 * Created by CM on 01/02/2018.
 */
public enum CarParkKind {STAFF("staff", 0.00, 1.00, 0.00, 16.00),
    STUDENT("student", 5.50, 0.25, 0.00, 0.00),
    MANAGEMENT("management", 0.00, 1.00, 3.00, 0.00),
    VISITOR("visitor", 8.00, 0.50, 0.00, 0.00);
    private final String name;
    private final double free;
    private final double reduction;
    private final double minimum;
    private final double maximum;

    CarParkKind(String name, double free, double reduction, double minimum, double maximum) {
        this.name = name;
        this.free = free;
        this.reduction = reduction;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public String getName() {
        return this.name;
    }

    public double getFree() {
        return this.free;
    }

    public double getReduction() {
        return this.reduction;
    }

    public double getMinimum() {
        return this.minimum;
    }

    public double getMaximum() {
        return this.maximum;
    }
}
