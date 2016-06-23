package nl.roc_ictal.marcelakerboom.calculator;

import java.math.BigDecimal;

/**
 * Created by marcelakerboom on 23/06/16.
 */
public class Calculator {
    // De invoer / uitvoer
    private String entry;

    // De operand is het getal links van een operatie (3 + 2, operand: 3)
    private BigDecimal operand;

    // De augment is het getal rechts van een operatie (3 + 2, augment: 2)
    private BigDecimal augment;

    // De operator geeft de type operatie aan (3 + 2, operator: +)
    private Operator operator;

    // Het geheugen (M+,MC knoppen)
    private BigDecimal memory;

    // Geeft aan of de entry een invoer of uitvoer is. (Als het een uitvoer is, kan hier geen input bijkomen)
    private boolean isResult;

    private boolean hasDot;

    // De operaties die deze rekenmachine beheerst.
    public enum Operator {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }

    /**
     * De constructor! Altijd handig.
     */
    Calculator() {
        this.clear();
        this.memoryClear();
    }

    /**
     * Voegt een cijfer toe aan de invoer.
     * @param digit
     */
    public void append(int digit) {
        this.append(Integer.toString(digit).charAt(0));
    }


    /**
     * Voegt een cijfer toe aan de invoer.
     * @param digit
     */
    public void append(char digit) {
        String entry = this.entry;

        // Als de calculator nu een uitvoer bevat, moeten we de inhoud legen.
        if (this.isResult) {
            entry = "";
        }

        // We voegen het cijfer toe aan de inhoud.
        entry += digit;
        // En slaan deze op.
        this.setEntry(entry);
    }

    /**
     * Voegt een punt toe aan de invoer, als dit mogelijk is.
     */
    public void appendDot() {
        // Als de invoer een resultaat is, resetten we eerst dit resultaat.
        if (this.isResult) {
            this.clearEntry();
        }
        // Alleen de invoer nog geen punt bevat, mag er een punt worden ingevoerd.
        if (!this.hasDot()) {
            this.setEntry(this.entry + ".");
        }
    }

    /**
     * Bereidt een operatie voor, dit houdt in:
     * 1. de invoer onthouden
     * 2. nieuwe invoer beginnen
     * @param operator
     */
    public void operate(Operator operator) {
        // We onthouden de operator
        this.operator = operator;
        // We onthouden de huidige invoer
        this.operand = this.entryDecimal();
        // We legen de augmentatie
        this.augment = null;
        // We legen de augmentatie
        this.isResult = true;
    }

    /**
     * Berekent het antwoord.
     */
    public void evaluate() {
        BigDecimal result;

        // Als de operator gegeven is kunnen we we rekenen
        if (operator != null) {

            // Als de invoer een resultaat is en de augmentatie leeg is
            if (isResult && augment != null) {
                operand = entryDecimal();
            } else {
                augment = entryDecimal();
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
            // Als de operator leeg is, dan is de invoer ook het antwoord.
            result = entryDecimal();
        }

        // Sla het antwoord op als uitvoer
        this.setEntry(result.toString(), true);
    }

    /**
     * Reset de in-/uitvoer
     */
    public void clearEntry() {
        this.entry = "0";
        this.isResult = true;
    }

    /**
     * Reset alles met betrekking tot operaties.
     */
    public void clearOperation() {
        this.operand = null;
        this.operator = null;
        this.augment = null;
    }

    /**
     * Reset de calculator.
     * Dit gebeurt door het resetten van de inhoud en de operatie.
     */
    public void clear() {
        this.clearEntry();
        this.clearOperation();
    }

    /**
     * Geeft de inhoud terug als String
     * @return String
     */
    public String getEntry() {
        return this.entry;
    }

    /**
     * Zet de inhoud als invoer
     * @param entry
     */
    public void setEntry(String entry) {
        this.setEntry(entry, false);
    }

    /**
     * Zet de inhoud als in- of uitvoer.
     * @param entry
     * @param isResult
     */
    public void setEntry(String entry, boolean isResult) {
        this.entry = entry;
        this.isResult = isResult;
    }

    /**
     * Zet de inhoud als in- of uitvoer.
     * @param entry
     * @param isResult
     */
    public void setEntry(BigDecimal entry, boolean isResult) {
        this.setEntry(entry.toString(), isResult);
    }

    /**
     * Telt de invoer op bij het geheugen
     */
    public void memoryAdd() {
        memory = memory.add(this.entryDecimal());
        this.setEntry(memory, true);
    }

    /**
     * Reset het geheugen
     */
    public void memoryClear() {
        this.memory = new BigDecimal("0");
    }

    /**
     * Geeft aan of de invoer een punt bevat
     * @return boolean
     */
    public boolean hasDot() {
        return entry.matches(".*\\..*");
    }

    /**
     * Maakt een BigDecimal van de entry
     * @return BigDecimal
     */
    private BigDecimal entryDecimal() {
        return new BigDecimal(this.entry);
    }
}
