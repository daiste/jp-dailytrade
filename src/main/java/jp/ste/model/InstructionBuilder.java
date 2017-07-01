package jp.ste.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Stefano Formaggi on 30/06/17.
 */
public final class InstructionBuilder {
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

    private InstructionBuilder() {
    }

    public static InstructionBuilder anInstruction() {
        return new InstructionBuilder();
    }

    public InstructionBuilder withEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public InstructionBuilder withType(InstructionType type) {
        this.type = type;
        return this;
    }

    public InstructionBuilder withAgreedFx(BigDecimal agreedFx) {
        this.agreedFx = agreedFx;
        return this;
    }

    public InstructionBuilder withAgreedFx(double agreedFx) {
        this.agreedFx = BigDecimal.valueOf(agreedFx);
        return this;
    }

    public InstructionBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

//    public InstructionBuilder withCurrency(String currencyCode) {
//        this.currency = Currency.getInstance(currencyCode); //TODO: should handle wrong codes
//        return this;
//    }

    public InstructionBuilder withInstructionDate(LocalDate instructionDate) {
        this.instructionDate = instructionDate;
        return this;
    }

    public InstructionBuilder withRequestedSettlementDate(LocalDate requestedSettlementDate) {
        this.requestedSettlementDate = requestedSettlementDate;
        return this;
    }

    public InstructionBuilder withFixedSettlementDate(LocalDate fixedSettlementDate) {
        this.fixedSettlementDate = fixedSettlementDate;
        return this;
    }

    public InstructionBuilder withUnits(Integer units) {
        this.units = units;
        return this;
    }

    public InstructionBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public InstructionBuilder withPrice(double price) {
        this.price = BigDecimal.valueOf(price);
        return this;
    }

    public InstructionBuilder withUsdAmount(BigDecimal usdAmount) {
        this.usdAmount = usdAmount;
        return this;
    }

    public Instruction build() {
        Instruction instruction = new Instruction();
        instruction.setEntity(entity);
        instruction.setType(type);
        instruction.setAgreedFx(agreedFx);
        instruction.setCurrency(currency);
        instruction.setInstructionDate(instructionDate);
        instruction.setRequestedSettlementDate(requestedSettlementDate);
        instruction.setFixedSettlementDate(fixedSettlementDate);
        instruction.setUnits(units);
        instruction.setPrice(price);
        instruction.setUsdAmount(usdAmount);
        return instruction;
    }
}
