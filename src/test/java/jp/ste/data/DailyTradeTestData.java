package jp.ste.data;

import jp.ste.model.Instruction;

import static java.time.LocalDate.of;
import static java.time.Month.JANUARY;
import static jp.ste.data.TestEntities.BAR;
import static jp.ste.data.TestEntities.FOO;
import static jp.ste.model.InstructionBuilder.anInstruction;
import static jp.ste.model.InstructionType.BUY;
import static jp.ste.model.InstructionType.SELL;

/**
 * Created by Stefano Formaggi on 30/06/17.
 */
public class DailyTradeTestData {
    //PDF example
    public static Instruction instrFoo1() {
        return anInstruction()
                .withEntity(FOO)
                .withType(BUY)
                .withAgreedFx(0.50)
                .withCurrency("SGP")
                .withInstructionDate(of(2016, JANUARY, 1))
                .withRequestedSettlementDate(of(2016, JANUARY, 2))
                .withUnits(200)
                .withPrice(100.25).build();
    }

    //PDF example
    public static Instruction instrBar1() {
        return anInstruction()
                .withEntity(BAR)
                .withType(SELL)
                .withAgreedFx(0.22)
                .withCurrency("AED")
                .withInstructionDate(of(2016, JANUARY, 5))
                .withRequestedSettlementDate(of(2016, JANUARY, 7))
                .withUnits(450)
                .withPrice(150.5).build();
    }

    /* OTHER TEST DATA FOR FOO*/

    public static Instruction instrFoo2() {
        return anInstruction()
                .withEntity(FOO)
                .withType(BUY)
                .withAgreedFx(0.50)
                .withCurrency("SGP")
                .withInstructionDate(of(2016, JANUARY, 1))
                .withRequestedSettlementDate(of(2016, JANUARY, 2))
                .withUnits(200)
                .withPrice(100.25).build();
    }

    public static Instruction instrFoo3() {
        return anInstruction()
                .withEntity(FOO)
                .withType(SELL)
                .withAgreedFx(0.50)
                .withCurrency("SGP")
                .withInstructionDate(of(2016, JANUARY, 2))
                .withRequestedSettlementDate(of(2016, JANUARY, 4))
                .withUnits(100)
                .withPrice(101.6).build();
    }

    public static Instruction instrFoo4() {
        return anInstruction()
                .withEntity(FOO)
                .withType(BUY)
                .withAgreedFx(0.50)
                .withCurrency("SGP")
                .withInstructionDate(of(2016, JANUARY, 2))
                .withRequestedSettlementDate(of(2016, JANUARY, 3))
                .withUnits(50)
                .withPrice(102.40).build();
    }

    /* OTHER TEST DATA FOR BAR */

    public static Instruction instrBar2() {
        return anInstruction()
                .withEntity(BAR)
                .withType(BUY)
                .withAgreedFx(0.22)
                .withCurrency("AED")
                .withInstructionDate(of(2016, JANUARY, 2))
                .withRequestedSettlementDate(of(2016, JANUARY, 3))
                .withUnits(400)
                .withPrice(150.3).build();
    }

    public static Instruction instrBar3() {
        return anInstruction()
                .withEntity(BAR)
                .withType(SELL)
                .withAgreedFx(0.22)
                .withCurrency("AED")
                .withInstructionDate(of(2016, JANUARY, 2))
                .withRequestedSettlementDate(of(2016, JANUARY, 4))
                .withUnits(75)
                .withPrice(148.4).build();
    }

    public static Instruction instrBar4() {
        return anInstruction()
                .withEntity(BAR)
                .withType(BUY)
                .withAgreedFx(0.22)
                .withCurrency("AED")
                .withInstructionDate(of(2016, JANUARY, 3))
                .withRequestedSettlementDate(of(2016, JANUARY, 5))
                .withUnits(400)
                .withPrice(151.2).build();
    }

}
