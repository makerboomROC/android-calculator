package nl.roc_ictal.marcelakerboom.calculator;

import java.math.BigDecimal;

/**
 * Created by marcelakerboom on 23/06/16.
 */
public class Calculator {
    private String entry;
    private String operand;
    private String augment;
    private Operator operator;

    private boolean hasDot;
    private boolean isResult;
    private String memoryEntry;

    public enum Operator {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }

    Calculator() {
        this.clear();
        this.memoryClear();
    }

    public void append(int digit) {
        this.append(Integer.toString(digit).charAt(0));
    }

    public void append(char digit) {
        String entry = this.entry;
        if (this.isResult) {
            entry = "";
        }
        entry += digit;
        this.setEntry(entry);
    }

    public void appendDot() {
        if(this.isResult) {
            this.clearEntry();
        }
        if(!this.hasDot) {
            this.setEntry(this.entry + ".");
        }
    }

    public void operate(Operator operator) {
        this.operator = operator;
        this.operand = this.entry;
        this.isResult = true;
    }

    public void evaluate() {
        if(this.isResult) {
            this.operand = this.entry;
        } else {
            this.augment = this.entry;
        }
        BigDecimal operand = new BigDecimal(this.operand);
        BigDecimal augment = new BigDecimal(this.augment);
        BigDecimal result;

        switch (this.operator) {
            case ADD:
                result = operand.add(augment);
                break;
            case SUBTRACT:
                result = operand.subtract(augment);
                break;
            case MULTIPLY:
                result = operand.multiply(augment);
                break;
            case DIVIDE:
                result = operand.divide(augment);
                break;
            default:
                result = augment;
                break;
        }

        this.setEntry(result.toString(), true);
    }

    public void clearEntry() {
        this.entry = "0";
        this.hasDot = false;
        this.isResult = true;
    }

    public void clearOperation() {
        this.operand = null;
        this.operator = null;
        this.augment = null;
    }

    public void clear() {
        this.clearEntry();
        this.clearOperation();
    }

    public String getEntry() {
        return this.entry;
    }

    public void setEntry(String entry) {
        this.setEntry(entry, false);
    }

    public void setEntry(String entry, boolean isResult) {
        this.entry = entry;
        this.isResult = isResult;
    }

    public void memoryAdd() {
        BigDecimal memoryEntry = new BigDecimal(this.memoryEntry);
        BigDecimal entry = new BigDecimal(this.entry);
        memoryEntry = memoryEntry.add(entry);
        this.memoryEntry = memoryEntry.toString();
        this.setEntry(this.memoryEntry, true);
    }

    public void memoryClear() {
        this.memoryEntry = "0";
    }
}
