package jp.ste;

import jp.ste.exception.ValidationException;
import jp.ste.model.Instruction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.*;

/**
 * Created by Stefano Formaggi on 29/06/17.
 */
public class InstructionValidator {

    /**
     * Check the instruction for required field
     * throws ValidationException if instruction is not valid
     * return false if instruction is for 0 units
     *
     * @param instr
     * @return
     * @throws ValidationException
     */
    public static boolean validate(Instruction instr) throws ValidationException {

        List<String> errors = new ArrayList<>();

        required(instr.getEntity(), "Missing entity", errors);
        required(instr.getType(), "Missing type", errors);
        required(instr.getAgreedFx(), "Missing agreed fx", errors);
        required(instr.getCurrency(), "Missing currency", errors);
        required(instr.getInstructionDate(), "Missing instruction date", errors);
        required(instr.getRequestedSettlementDate(), "Missing requestedSettlementDate", errors);
        required(instr.getUnits(), "Missing units", errors);
        required(instr.getPrice(), "Missing price", errors);

        //TODO:
        /*
        Other evaluation could be done:
        - unknown entities
        - unknown currencies
        - date ranges
         */

        if (instr.getInstructionDate()!=null
                && instr.getRequestedSettlementDate()!=null
                && instr.getInstructionDate().isAfter(instr.getRequestedSettlementDate())){
            errors.add("Settlement date before instruction date");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        if (instr.getUnits() == 0) {
            return false; //simply ignored
        }

        return true;
    }

    private static void required(Object o, String s, List<String> errors) {
        if (o == null) errors.add(s);
    }


    protected static void prepare(Instruction instr) {
        instr.setFixedSettlementDate(evaluatedSettlementDate(instr));
        instr.setUsdAmount(evaluateUsdAmount(instr));
    }

    protected static BigDecimal evaluateUsdAmount(Instruction instr) {
        return instr.getPrice().multiply(new BigDecimal(instr.getUnits())).multiply(instr.getAgreedFx());
    }

    protected static LocalDate evaluatedSettlementDate(Instruction instr) {
        LocalDate req = instr.getRequestedSettlementDate();
        int offset = 0;
        switch (instr.getCurrency()) {
            case "AED":
            case "SAR":
                if (SATURDAY.equals(req.getDayOfWeek()) || FRIDAY.equals(req.getDayOfWeek())) {
                    offset = (SUNDAY.getValue() + 7 - req.getDayOfWeek().getValue()) % 7;
                }
                break;
            default:
                if (SATURDAY.equals(req.getDayOfWeek()) || SUNDAY.equals(req.getDayOfWeek())) {
                    offset = (MONDAY.getValue() + 7 - req.getDayOfWeek().getValue()) % 7;
                }
        }
        return instr.getRequestedSettlementDate().plusDays(offset);
    }

}
