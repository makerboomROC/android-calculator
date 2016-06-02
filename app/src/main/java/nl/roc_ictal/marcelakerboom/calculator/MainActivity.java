package nl.roc_ictal.marcelakerboom.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String entry;
    private boolean hasDot;
    private boolean isResult;

    private String memoryEntry;

    private String operator;
    private String operatorEntry;

    private EditText txtScreen;

    private Button btnClear;
    private Button btnClearEntry;
    private Button btnMemoryAdd;
    private Button btnMemoryClear;

    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnZero;

    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEqual;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClear:
                this.clear();
                break;
            case R.id.btnMemoryAdd:
                this.memoryAdd();
                break;
            case R.id.btnMemoryClear:
                this.memoryClear();
                break;
            case R.id.btnClearEntry:
                this.clearEntry();
                break;
            case R.id.btnOne:
                this.digit(1);
                break;
            case R.id.btnTwo:
                this.digit(2);
                break;
            case R.id.btnThree:
                this.digit(3);
                break;
            case R.id.btnFour:
                this.digit(4);
                break;
            case R.id.btnFive:
                this.digit(5);
                break;
            case R.id.btnSix:
                this.digit(6);
                break;
            case R.id.btnSeven:
                this.digit(7);
                break;
            case R.id.btnEight:
                this.digit(8);
                break;
            case R.id.btnNine:
                this.digit(9);
                break;
            case R.id.btnZero:
                this.digit(0);
                break;
            case R.id.btnDot:
                this.dot();
                break;
            case R.id.btnAdd:
                this.operation("+");
                break;
            case R.id.btnSubtract:
                this.operation("-");
                break;
            case R.id.btnMultiply:
                this.operation("*");
                break;
            case R.id.btnDivide:
                this.operation("/");
                break;
            case R.id.btnEqual:
                this.evaluate();
                break;
        }
    }

    protected void operation(String operator) {
        this.operator = operator;
        this.operatorEntry = this.entry;
        this.clearEntry();
    }

    protected void memoryAdd() {
        BigDecimal memoryEntry = new BigDecimal(this.memoryEntry);
        BigDecimal entry = new BigDecimal(this.entry);
        memoryEntry = memoryEntry.add(entry);
        this.memoryEntry = memoryEntry.toString();
        this.setEntry(this.memoryEntry);
    }

    protected void memoryClear() {
        this.memoryEntry = "0";
    }

    protected void evaluate() {
        BigDecimal result = new BigDecimal(this.entry);

        if(this.operator != null) {
            BigDecimal left = new BigDecimal(this.operatorEntry);

            switch (this.operator) {
                case "+":
                    result = left.add(result);
                    break;
                case "-":
                    result = left.subtract(result);
                    break;
                case "*":
                    result = left.multiply(result);
                    break;
                case "/":
                    result = left.divide(result);
                    break;
            }
        }

        this.setEntry(result.toString());
        this.isResult = true;
    }

    protected void dot() {
        if(this.hasDot) {
            return;
        }
        this.pushEntry(".");
        this.hasDot = true;
    }

    protected void digit(Integer digit) {
        if(this.entry.equals("0")) {
            this.setEntry("");
        }
        this.pushEntry(digit.toString());
        this.show();
    }

    protected void clear() {
        this.operator = null;
        this.operatorEntry = null;
        this.clearEntry();
    }

    protected void clearEntry() {
        this.entry = "0";
        this.hasDot = false;
        this.isResult = false;
        this.show();
    }

    protected void setEntry(String value) {
        this.entry = value;
        this.show();
    }

    protected void pushEntry(String value) {
        if(this.isResult) {
            this.entry = "";
        }
        this.setEntry(this.entry + value);
        this.isResult = false;
    }

    protected void show() {
        this.txtScreen.setText(this.entry);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtScreen = (EditText) findViewById(R.id.txtScreen);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearEntry = (Button) findViewById(R.id.btnClearEntry);

        btnMemoryAdd = (Button) findViewById(R.id.btnMemoryAdd);
        btnMemoryClear = (Button) findViewById(R.id.btnMemoryClear);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEqual = (Button) findViewById(R.id.btnEqual);

        this.clear();
        this.memoryClear();

        this.btnClear.setOnClickListener(this);
        this.btnClearEntry.setOnClickListener(this);

        this.btnMemoryAdd.setOnClickListener(this);
        this.btnMemoryClear.setOnClickListener(this);

        this.btnOne.setOnClickListener(this);
        this.btnTwo.setOnClickListener(this);
        this.btnThree.setOnClickListener(this);
        this.btnFour.setOnClickListener(this);
        this.btnFive.setOnClickListener(this);
        this.btnSix.setOnClickListener(this);
        this.btnSeven.setOnClickListener(this);
        this.btnEight.setOnClickListener(this);
        this.btnNine.setOnClickListener(this);
        this.btnZero.setOnClickListener(this);

        this.btnAdd.setOnClickListener(this);
        this.btnSubtract.setOnClickListener(this);
        this.btnMultiply.setOnClickListener(this);
        this.btnDivide.setOnClickListener(this);
        this.btnEqual.setOnClickListener(this);
    }
}
