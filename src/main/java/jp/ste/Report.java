package jp.ste;

import jp.ste.model.Daily;
import jp.ste.model.Instruction;
import jp.ste.model.Rank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Stefano Formaggi on 01/07/17.
 */
public class Report {
    protected List<Instruction> allInstruction = new ArrayList<>();

    protected HashMap<String, Rank> rankMap = new HashMap<>();
    protected HashMap<LocalDate, Daily> dailyMap = new HashMap<>();
    protected List<Rank> orderByIn = new ArrayList<>();
    protected List<Rank> orderByOut = new ArrayList<>();
    protected List<Daily> days = new ArrayList<>();
}
