package nl.roc_ictal.marcelakerboom.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Calculator calculator;

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
    private Button btnDot;

    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEqual;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClear:
                calculator.clear();
                break;
            case R.id.btnMemoryAdd:
                calculator.memoryAdd();
                break;
            case R.id.btnMemoryClear:
                calculator.memoryClear();
                break;
            case R.id.btnClearEntry:
                calculator.clearEntry();
                break;
            case R.id.btnOne:
                calculator.append(1);
                break;
            case R.id.btnTwo:
                calculator.append(2);
                break;
            case R.id.btnThree:
                calculator.append(3);
                break;
            case R.id.btnFour:
                calculator.append(4);
                break;
            case R.id.btnFive:
                calculator.append(5);
                break;
            case R.id.btnSix:
                calculator.append(6);
                break;
            case R.id.btnSeven:
                calculator.append(7);
                break;
            case R.id.btnEight:
                calculator.append(8);
                break;
            case R.id.btnNine:
                calculator.append(9);
                break;
            case R.id.btnZero:
                calculator.append(0);
                break;
            case R.id.btnDot:
                calculator.appendDot();
                break;
            case R.id.btnAdd:
                calculator.operate(Calculator.Operator.ADD);
                break;
            case R.id.btnSubtract:
                calculator.operate(Calculator.Operator.SUBTRACT);
                break;
            case R.id.btnMultiply:
                calculator.operate(Calculator.Operator.MULTIPLY);
                break;
            case R.id.btnDivide:
                calculator.operate(Calculator.Operator.DIVIDE);
                break;
            case R.id.btnEqual:
                calculator.evaluate();
                break;
        }
        this.display();
    }

    /**
     * Displays the entry to the screen
     */
    protected void display() {
        txtScreen.setText(calculator.getEntry());;
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
        btnDot = (Button) findViewById(R.id.btnDot);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEqual = (Button) findViewById(R.id.btnEqual);

        calculator = new Calculator();

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
        this.btnDot.setOnClickListener(this);

        this.btnAdd.setOnClickListener(this);
        this.btnSubtract.setOnClickListener(this);
        this.btnMultiply.setOnClickListener(this);
        this.btnDivide.setOnClickListener(this);
        this.btnEqual.setOnClickListener(this);
    }
}
