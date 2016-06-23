package nl.roc_ictal.marcelakerboom.calculator;

import java.math.BigDecimal;

/**
 * Created by marcelakerboom on 23/06/16.
 */
public class Calculator {
    private BigDecimal entry;
    private BigDecimal operand;
    private BigDecimal augment;
    private Operator operator;
    private BigDecimal memoryEntry;

    private boolean hasDot;
    private boolean isResult;

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
        String entry = this.entry.toString();
        if (this.isResult) {
            entry = "";
        }
        entry += digit;
        this.setEntry(entry);
    }

    public void appendDot() {
        if (this.isResult) {
            this.clearEntry();
        }
        if (!this.hasDot) {
            this.setEntry(this.entry + ".");
        }
    }

    public void operate(Operator operator) {
        this.operator = operator;
        this.operand = this.entry;
        this.augment = null;
        this.isResult = true;
    }

    public void evaluate() {
        BigDecimal result;

        if (this.operator != null) {
            if (this.isResult && this.augment != null) {
                this.operand = this.entry;
            } else {
                this.augment = this.entry;
            }

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
        } else {
            result = this.entry;
        }

        this.setEntry(result.toString(), true);
    }

    public void clearEntry() {
        this.entry = new BigDecimal("0");
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
        return this.entry.toString();
    }

    public void setEntry(String entry) {
        this.setEntry(entry, false);
    }

    public void setEntry(String entry, boolean isResult) {
        this.setEntry(new BigDecimal(entry), isResult);
    }

    public void setEntry(BigDecimal entry, boolean isResult) {
        this.entry = entry;
        this.isResult = isResult;
    }

    public void memoryAdd() {
        memoryEntry = memoryEntry.add(entry);
        this.setEntry(memoryEntry, true);
    }

    public void memoryClear() {
        this.memoryEntry = new BigDecimal("0");
    }
}
