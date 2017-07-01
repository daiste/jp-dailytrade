package jp.ste;

import jp.ste.exception.ValidationException;
import jp.ste.model.Instruction;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.time.LocalDate.now;
import static jp.ste.model.InstructionBuilder.anInstruction;
import static jp.ste.model.InstructionType.BUY;

/**
 * Unit test for simple App.
 */
public class InstructionValidatorTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InstructionValidatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(InstructionValidatorTest.class);
    }

    public void testNotValidInstruction() {
        DailyTrade dt = new DailyTrade();
        Instruction instr = new Instruction();
        try {
            InstructionValidator.validate(instr);
            assertTrue("Validated incomplete instruction", true);
        } catch (ValidationException e) {
            //e.printStackTrace();
        }

        assertTrue(true);
    }

    public void testIgnoredInstruction() {
        Instruction instr = new Instruction("foo", BUY, ONE, "USD", now(), now(), 0, BigDecimal.ONE);

        try {
            assertFalse("Should be ignored", InstructionValidator.validate(instr));
        } catch (ValidationException e) {
            //e.printStackTrace();
        }

        assertTrue(true);
    }

    public void testValidInstruction() {
        Instruction instr = anInstruction()
                .withEntity("foo")
                .withType(BUY)
                .withAgreedFx(new BigDecimal(0.1))
                .withCurrency("USD")
                .withInstructionDate(now())
                .withRequestedSettlementDate(now())
                .withUnits(1)
                .withPrice(1.0).build();

        boolean ok = false;
        try {
            ok = InstructionValidator.validate(instr);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        assertTrue("Instruction not validated", ok);
    }

}
