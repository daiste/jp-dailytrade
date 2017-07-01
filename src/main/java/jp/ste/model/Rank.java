package jp.ste.model;

import java.math.BigDecimal;

/**
 * Created by Stefano Formaggi on 30/06/17.
 */
public class Rank {
    String entity;
    BigDecimal in;
    BigDecimal out;

    public Rank(String entity) {
        this.entity = entity;
        this.in = BigDecimal.ZERO;
        this.out = BigDecimal.ZERO;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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
