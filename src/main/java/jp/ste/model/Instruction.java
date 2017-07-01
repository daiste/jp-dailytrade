package jp.ste.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Stefano Formaggi on 29/06/17.
 */
public class Instruction {
    private String entity;
    private InstructionType type;
    private BigDecimal agreedFx;
    private String currency;
    private LocalDate instructionDate;
    private LocalDate requestedSettlementDate;
    private LocalDate fixedSettlementDate;
    private Integer units;
    private BigDecimal price;
    private BigDecimal usdAmount;

    public Instruction() {
    }

    public Instruction(String entity, InstructionType type, BigDecimal agreedFx, String currency, LocalDate instructionDate, LocalDate requestedSettlementDate, Integer units, BigDecimal price) {
        this.entity = entity;
        this.type = type;
        this.agreedFx = agreedFx;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.requestedSettlementDate = requestedSettlementDate;
        this.units = units;
        this.price = price;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public InstructionType getType() {
        return type;
    }

    public void setType(InstructionType type) {
        this.type = type;
    }

    public BigDecimal getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(BigDecimal agreedFx) {
        this.agreedFx = agreedFx;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(LocalDate instructionDate) {
        this.instructionDate = instructionDate;
    }

    public LocalDate getRequestedSettlementDate() {
        return requestedSettlementDate;
    }

    public void setRequestedSettlementDate(LocalDate requestedSettlementDate) {
        this.requestedSettlementDate = requestedSettlementDate;
    }

    public LocalDate getFixedSettlementDate() {
        return fixedSettlementDate;
    }

    public void setFixedSettlementDate(LocalDate fixedSettlementDate) {
        this.fixedSettlementDate = fixedSettlementDate;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getUsdAmount() {
        return usdAmount;
    }

    public void setUsdAmount(BigDecimal usdAmount) {
        this.usdAmount = usdAmount;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                 entity  +" "+
                  type +
                ", fx=" + agreedFx +
                ", curr='" + currency + '\'' +
                ", instrDate=" + instructionDate +
                ", reqSettDate=" + requestedSettlementDate +
                ", fixedSettDate=" + fixedSettlementDate +
                ", units=" + units +
                ", price=" + price +
                ", usdAm=" + usdAmount +
                '}';
    }
}
