package baseline;

public class PaymentCalculator {

    private double balance;
    private double apr;
    private double dailyRate;
    private double monthlyPayment;

    public PaymentCalculator(double balance, double apr, double monthlyPayment) {
        // balance = balance
        // apr = apr / 100 (since this is entered as percent)
        // monthlyPayment = monthlyPayment
        // dailyRate = apr / 365 / 100 (again, since apr is a percent)
    }

    private double roundUpPenny(double value) {
        // Maybe use BigDecimal to avoid any precision errors

        // multiply by 100
        // use ceiling to round
        // divide by 100
        // return value

        // placeholder
        return 0;
    }

    public int calculateMonthsUntilPaidOff() {
        // use formula
        // n = -(1/30) * log(1 + balance/monthlyPayment * (1 - (1 + dailyRate)^30)) / log(1 + dailyRate)
        // might need to consider BigDecimal

        // placeholder
        return 0;
    }
}
