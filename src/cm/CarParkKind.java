package cm;
import java.math.BigDecimal;
/**
 * Created by CM on 01/02/2018.
 */
public enum CarParkKind {
    STAFF(0.00, 1.00, 0.00, 16.00),
    STUDENT(5.50, 0.25, 0.00, 0.00),
    MANAGEMENT( 0.00, 1.00, 3.00, 0.00),
    VISITOR( 8.00, 0.50, 0.00, 0.00);
    private final double free;
    private final double reduction;
    private final double minimum;
    private final double maximum;

    CarParkKind(double free, double reduction, double minimum, double maximum) {
        this.free = free;
        this.reduction = reduction;
        this.minimum = minimum;
        this.maximum = maximum;
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
