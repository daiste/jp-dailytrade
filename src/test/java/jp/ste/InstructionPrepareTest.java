package jp.ste;

import jp.ste.data.DailyTradeTestData;
import jp.ste.exception.ValidationException;
import jp.ste.model.Instruction;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.DayOfWeek;

import static java.time.LocalDate.of;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static jp.ste.InstructionValidator.evaluateUsdAmount;
import static jp.ste.InstructionValidator.evaluatedSettlementDate;
import static jp.ste.model.InstructionBuilder.anInstruction;

/**
 * Unit test for simple App.
 */
public class InstructionPrepareTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InstructionPrepareTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(InstructionPrepareTest.class);
    }


    /*
    Test date evaluation
     */
    public void testSettledDateFix() throws ValidationException {
        Instruction i1 = anInstruction()
                .withCurrency("SGP")
                .withRequestedSettlementDate(of(2017, JUNE, 30)).build();
        assertTrue(evaluatedSettlementDate(i1).getDayOfWeek().equals(DayOfWeek.FRIDAY));

        Instruction i2 = anInstruction()
                .withCurrency("SGP")
                .withRequestedSettlementDate(of(2017, JULY, 1)).build();
        assertTrue(evaluatedSettlementDate(i2).getDayOfWeek().equals(DayOfWeek.MONDAY));

        Instruction i3 = anInstruction()
                .withCurrency("SGP")
                .withRequestedSettlementDate(of(2017, JULY, 2)).build();
        assertTrue(evaluatedSettlementDate(i3).getDayOfWeek().equals(DayOfWeek.MONDAY));

        Instruction i4 = anInstruction()
                .withCurrency("SGP")
                .withRequestedSettlementDate(of(2017, JULY, 3)).build();
        assertTrue(evaluatedSettlementDate(i4).getDayOfWeek().equals(DayOfWeek.MONDAY));

        Instruction i5 = anInstruction()
                .withCurrency("SGP")
                .withRequestedSettlementDate(of(2017, JULY, 4)).build();
        assertTrue(evaluatedSettlementDate(i5).getDayOfWeek().equals(DayOfWeek.TUESDAY));
    }

    public void testSettledDateFix2() throws ValidationException {
        Instruction i0 = anInstruction()
                .withCurrency("AED")
                .withRequestedSettlementDate(of(2017, JUNE, 29)).build();
        assertTrue(evaluatedSettlementDate(i0).getDayOfWeek().equals(DayOfWeek.THURSDAY));

        Instruction i1 = anInstruction()
                .withCurrency("AED")
                .withRequestedSettlementDate(of(2017, JUNE, 30)).build();
        assertTrue(evaluatedSettlementDate(i1).getDayOfWeek().equals(DayOfWeek.SUNDAY));

        Instruction i2 = anInstruction()
                .withCurrency("AED")
                .withRequestedSettlementDate(of(2017, JULY, 1)).build();
        assertTrue(evaluatedSettlementDate(i2).getDayOfWeek().equals(DayOfWeek.SUNDAY));

        Instruction i3 = anInstruction()
                .withCurrency("AED")
                .withRequestedSettlementDate(of(2017, JULY, 2)).build();
        assertTrue(evaluatedSettlementDate(i3).getDayOfWeek().equals(DayOfWeek.SUNDAY));

        Instruction i4 = anInstruction()
                .withCurrency("AED")
                .withRequestedSettlementDate(of(2017, JULY, 3)).build();
        assertTrue(evaluatedSettlementDate(i4).getDayOfWeek().equals(DayOfWeek.MONDAY));

        Instruction i5 = anInstruction()
                .withCurrency("AED")
                .withRequestedSettlementDate(of(2017, JULY, 4)).build();
        assertTrue(evaluatedSettlementDate(i5).getDayOfWeek().equals(DayOfWeek.TUESDAY));
    }

    public void testUSD1() throws ValidationException {
        assertEquals("Wrong usd value", 10025.0, evaluateUsdAmount(DailyTradeTestData.instrFoo1()).doubleValue());
    }

    public void testUSD2() throws ValidationException {
        assertEquals("Wrong usd value", 14899.5, evaluateUsdAmount(DailyTradeTestData.instrBar1()).doubleValue());
    }
}
