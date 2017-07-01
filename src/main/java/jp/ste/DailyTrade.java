package jp.ste;

import jp.ste.exception.ValidationException;
import jp.ste.model.Daily;
import jp.ste.model.Instruction;
import jp.ste.model.Rank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefano Formaggi on 29/06/17.
 */
public class DailyTrade {

    List<Instruction> allInstruction = new ArrayList<>();

    /**
     * Validate, prepare and add instruction sent to execute
     * @param instr the instruction to add to the list of instruction to execute
     * @throws ValidationException
     */
    protected void newInstruction(Instruction instr) throws ValidationException {
        if (InstructionValidator.validate(instr)) {
            InstructionValidator.prepare(instr);
            allInstruction.add(instr);
        } else {
            System.out.println("Instruction ignored");
        }
    }

    /**
     * Build a report from instruction collected so far
     * @return
     */
    public Report buildReport() {
        Report report = new Report();

        report.allInstruction.addAll(allInstruction);

        for (Instruction i : allInstruction) {
            Rank r = report.rankMap.getOrDefault(i.getEntity(), new Rank(i.getEntity()));
            Daily d = report.dailyMap.getOrDefault(i.getFixedSettlementDate(), new Daily(i.getFixedSettlementDate()));

            switch (i.getType()) {
                case BUY:
                    r.setOut(r.getOut().add(i.getUsdAmount()));
                    d.setOut(d.getOut().add(i.getUsdAmount()));
                    break;
                case SELL:
                    r.setIn(r.getIn().add(i.getUsdAmount()));
                    d.setIn(d.getIn().add(i.getUsdAmount()));
                    break;
            }

            if (!report.rankMap.containsKey(i.getEntity())) {
                report.rankMap.put(i.getEntity(), r);
            }

            if (!report.dailyMap.containsKey(i.getFixedSettlementDate())) {
                report.dailyMap.put(i.getFixedSettlementDate(), d);
            }
        }

        report.orderByIn.addAll(report.rankMap.values());
        report.orderByIn.sort((o1, o2) -> -o1.getIn().compareTo(o2.getIn()));

        report.orderByOut.addAll(report.rankMap.values());
        report.orderByOut.sort((o1, o2) -> -o1.getOut().compareTo(o2.getOut()));

        report.days.addAll(report.dailyMap.values());
        report.days.sort((o1, o2) -> o1.getDay().compareTo(o2.getDay()));
        return report;
    }


    /**
     * Print a report to stdout
     * @param report
     */
    public static void printReport(Report report) {

        report.allInstruction.forEach(i -> System.out.println(i));

        System.out.println("\n ---   Daily in/out  ---");

        report.days.forEach(d -> System.out.println(d.getDay() + "\t\t " + d.getIn() + "\t\t " + d.getOut()));

        System.out.println("\n ---   In ranking    ---");

        int i = 1;
        for (Rank r : report.orderByIn) {
            System.out.println((i++) + ") " + r.getEntity() + " - " + r.getIn() + " USD");
        }
        System.out.println("\n ---   Out ranking    ---");

        int j = 1;
        for (Rank r : report.orderByOut) {
            System.out.println((j++) + ") " + r.getEntity() + " - " + r.getOut() + " USD");
        }
    }
}
