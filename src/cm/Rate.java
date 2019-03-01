package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CM on 01/02/2018.
 */
class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced;
    private ArrayList<Period> normal;

    Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) < 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
            /*spec states normal rate CAN be equal to reduced rate so removed = */
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1  the length of time
     * @param periods2  the length of time
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size()) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            if(!isValid){
                break;
            }
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            // removed non used variable cm.Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                if(!isValid){
                    break;
                }
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the cm.Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collection of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) { // changed from private to remove warning
        boolean isValid = true;
        int i = 0;
        while (i < list.size()) {
            isValid = !period.overlaps(list.get(i));
            if(!isValid){
                break;
            }
            i++;
        }
        return isValid;
    }
    BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurrences(normal);
        int reducedRateHours = periodStay.occurrences(reduced);
        BigDecimal amountDue;
        amountDue = ((this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours)))
                .add(this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)))
                .subtract(this.kind.getFree()));
        /*if a negative amount is calculated no charge is applied*/
        if (amountDue.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.valueOf(0.00);
        }else{  // apply the reduction
            amountDue = amountDue.multiply(this.kind.getReduction());
        }
        /* only do this if minimum amount is set */
        if(this.kind.getMinimum().compareTo(BigDecimal.ZERO) > 0
                /* and the amount due is less than the minimum charge */
                && amountDue.compareTo(this.kind.getMinimum()) < 0) {
            return this.kind.getMinimum();
        }
        if(this.kind.getMaximum().compareTo(BigDecimal.ZERO) > 0.00
                && amountDue.compareTo(this.kind.getMaximum()) > 0) {
            return this.kind.getMaximum();
        }
        return amountDue;
    }
    }


