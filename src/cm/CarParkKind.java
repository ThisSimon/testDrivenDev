package cm;
import java.math.BigDecimal;
/**
 * Created by CM on 01/02/2018.
 */
public enum CarParkKind {
    STAFF("staff",  0, 1, 0, 16),
    STUDENT("student", 5.50, 0.25, 0.00, 0.00),
    MANAGEMENT("management", 0.00, 1.00, 3, 0.00),
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

    public BigDecimal getFree() {
        return BigDecimal.valueOf(this.free);
    }

    public BigDecimal getReduction() {
        return BigDecimal.valueOf(this.reduction);
    }

    public BigDecimal getMinimum() {
        return BigDecimal.valueOf(this.minimum);
    }

    public BigDecimal getMaximum() {
        return BigDecimal.valueOf(this.maximum);
    }
}
