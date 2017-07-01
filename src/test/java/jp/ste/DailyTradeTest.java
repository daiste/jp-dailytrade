package jp.ste;

import jp.ste.data.DailyTradeTestData;
import jp.ste.exception.ValidationException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static java.time.LocalDate.of;
import static java.time.Month.JANUARY;
import static jp.ste.DailyTrade.printReport;
import static jp.ste.data.TestEntities.BAR;
import static jp.ste.data.TestEntities.FOO;

/**
 * Unit test for simple App.
 */
public class DailyTradeTest
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DailyTradeTest(String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( DailyTradeTest.class );
    }


    public void testPDFData1() throws ValidationException {
        DailyTrade dt = new DailyTrade();
        dt.newInstruction(DailyTradeTestData.instrFoo1());
        dt.newInstruction(DailyTradeTestData.instrBar1());
        Report report = dt.buildReport();
        printReport(report);

        assertEquals("wrong ranking ", BAR, report.orderByIn.get(0).getEntity());
        assertEquals("wrong ranking ", FOO, report.orderByIn.get(1).getEntity());

        //by out
        assertEquals("wrong ranking ", FOO, report.orderByOut.get(0).getEntity());
        assertEquals("wrong ranking ", BAR, report.orderByOut.get(1).getEntity());

        //daily, ordered by date
        assertEquals(of(2016, JANUARY, 4), report.days.get(0).getDay());
        assertEquals(of(2016, JANUARY, 7), report.days.get(1).getDay());
    }


    public void testExtraData() throws ValidationException {
        DailyTrade dt = new DailyTrade();
        dt.newInstruction(DailyTradeTestData.instrFoo1());
        dt.newInstruction(DailyTradeTestData.instrFoo2());
        dt.newInstruction(DailyTradeTestData.instrFoo3());
        dt.newInstruction(DailyTradeTestData.instrFoo4());
        dt.newInstruction(DailyTradeTestData.instrBar1());
        dt.newInstruction(DailyTradeTestData.instrBar2());
        dt.newInstruction(DailyTradeTestData.instrBar3());
        dt.newInstruction(DailyTradeTestData.instrBar4());

        Report report = dt.buildReport();
        printReport(report);

        assertEquals("wrong ranking ", BAR, report.orderByIn.get(0).getEntity());
        assertEquals("wrong ranking ", FOO, report.orderByIn.get(1).getEntity());

        //by out
        assertEquals("wrong ranking ", BAR, report.orderByOut.get(0).getEntity());
        assertEquals("wrong ranking ", FOO, report.orderByOut.get(1).getEntity());

        //daily, ordered by date
        assertEquals(of(2016, JANUARY, 3), report.days.get(0).getDay());
        assertEquals(of(2016, JANUARY, 4), report.days.get(1).getDay());
        assertEquals(of(2016, JANUARY, 5), report.days.get(2).getDay());
        assertEquals(of(2016, JANUARY, 7), report.days.get(3).getDay());
    }

}
