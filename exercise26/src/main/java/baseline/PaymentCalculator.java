package baseline;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentCalculator {

    private double balance;
    private double apr;
    private double dailyRate;
    private double monthlyPayment;

    public PaymentCalculator(double balance, double apr, double monthlyPayment) {
        // balance = balance
        this.balance = balance;
        // apr = apr / 100 (since this is entered as percent)
        this.apr = apr / 100;
        // monthlyPayment = monthlyPayment
        this.monthlyPayment = monthlyPayment;
        // dailyRate = apr / 365 / 100 (again, since apr is a percent)
        this.dailyRate = apr / 365 / 100;
    }

    private double roundUpPenny(double value) {
        // Maybe use BigDecimal to avoid any precision errors

        BigDecimal total = BigDecimal.valueOf(value);
        BigDecimal comp = BigDecimal.valueOf(0.01);
        BigDecimal multiplier = BigDecimal.valueOf(100);

        // multiply by 100
        total = total.multiply(multiplier);
        // use ceiling to round
        total = total.setScale(0, RoundingMode.CEILING);
        // divide by 100
        total = total.multiply(comp);
        // return value

        return total.doubleValue();
    }

    public int calculateMonthsUntilPaidOff() {
        // BigDecimal is ugly.

        if (monthlyPayment <= 0) {
            if (balance > 0){
                System.out.println("You are never going to pay this off.");
            }
            return 0;
        }

        // This would cause an error otherwise
        if (apr == 0) {
            return (int)Math.ceil(balance / monthlyPayment);
        }

        // use formula
        // n = -(1/30) * log(1 + balance/monthlyPayment * (1 - (1 + dailyRate)^30)) / log(1 + dailyRate)
        // might need to consider BigDecimal

        // Part 1: -(1/30)
        BigDecimal part1Total = new BigDecimal(1).divide(new BigDecimal(30), 40, RoundingMode.CEILING).negate();

        // log(1 + balance/monthlyPayment * (1 - (1 + dailyRate)^30))
        // break into Part 2 and Part 3

        // Part 2: (1 - (1 + dailyRate)^30)
        BigDecimal one = new BigDecimal(1);
        BigDecimal statement2 = one.subtract(BigDecimal.valueOf(1 + dailyRate).pow(30));

        // Part 3: 1 + balance/monthlyPayment * (1 - (1 + dailyRate)^30)
        BigDecimal part2Total = statement2.multiply(BigDecimal.valueOf(roundUpPenny(balance/monthlyPayment))).add(one);
        BigDecimal part3Total = BigDecimal.valueOf(Math.log10(part2Total.doubleValue()));

        // Part 4: log(1 + dailyRate)
        BigDecimal part4Total = BigDecimal.valueOf(Math.log10(1 + dailyRate));

        // -(1/30) * log(1 + balance/monthlyPayment * (1 - (1 + dailyRate)^30))
        BigDecimal numMonths = part1Total.multiply(part3Total).divide(part4Total, 40, RoundingMode.CEILING);

        // log(1 + dailyRate)
        return (int)Math.ceil(numMonths.doubleValue());
    }
}
