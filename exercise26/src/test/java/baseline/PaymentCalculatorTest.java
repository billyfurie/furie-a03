package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testSources.csv", numLinesToSkip = 1)
    void calculateMonthsUntilPaidOff(double balance, double apr, double monthlyPayment, int expectedMonths) {
        PaymentCalculator calc = new PaymentCalculator(balance, apr, monthlyPayment);

        int calculatedMonths = calc.calculateMonthsUntilPaidOff();

        assertEquals(calculatedMonths, expectedMonths);
    }

}