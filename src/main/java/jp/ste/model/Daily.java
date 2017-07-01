package jp.ste.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Stefano Formaggi on 30/06/17.
 */
public class Daily {
    LocalDate day;
    BigDecimal in;
    BigDecimal out;

    public Daily(LocalDate day) {
        this.day = day;
        this.in = BigDecimal.ZERO;
        this.out = BigDecimal.ZERO;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public BigDecimal getIn() {
        return in;
    }

    public void setIn(BigDecimal in) {
        this.in = in;
    }

    public BigDecimal getOut() {
        return out;
    }

    public void setOut(BigDecimal out) {
        this.out = out;
    }
}
