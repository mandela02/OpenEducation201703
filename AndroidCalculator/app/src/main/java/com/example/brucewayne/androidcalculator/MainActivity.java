package com.example.brucewayne.androidcalculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button num0;
    private Button num9;
    private Button num8;
    private Button num7;
    private Button num6;
    private Button num5;
    private Button num4;
    private Button num3;
    private Button num2;
    private Button num1;

    private Button del;
    private Button delALL;

    private Button btnAdd;
    private Button btnMul;
    private Button btnDiv;
    private Button btnMinus;
    private Button btnEqua;

    private Button dot;

    private TextView Result;

    String str = "";
    String strNum = "";
    Character op = 'q';
    float firstNumber = 0;
    float secondNumber = 0;
    float math = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = (TextView) findViewById(R.id.Result);

        num0 = (Button) findViewById(R.id.num0);
        num9 = (Button) findViewById(R.id.num9);
        num8 = (Button) findViewById(R.id.num8);
        num7 = (Button) findViewById(R.id.num7);
        num6 = (Button) findViewById(R.id.num6);
        num5 = (Button) findViewById(R.id.num5);
        num4 = (Button) findViewById(R.id.num4);
        num3 = (Button) findViewById(R.id.num3);
        num2 = (Button) findViewById(R.id.num2);
        num1 = (Button) findViewById(R.id.num1);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnEqua = (Button) findViewById(R.id.btnEqua);

        dot = (Button) findViewById(R.id.dot);

        delALL = (Button) findViewById(R.id.delALL);
        del = (Button) findViewById(R.id.del);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqua.setOnClickListener(this);

        dot.setOnClickListener(this);
        del.setOnClickListener(this);
        delALL.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num0:
                strNum = strNum + Integer.toString(0);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num1:
                strNum = strNum + Integer.toString(1);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num2:
                strNum = strNum + Integer.toString(2);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num3:
                strNum = strNum + Integer.toString(3);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num4:
                strNum = strNum + Integer.toString(4);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num5:
                strNum = strNum + Integer.toString(5);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num6:
                strNum = strNum + Integer.toString(6);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num7:
                strNum = strNum + Integer.toString(7);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num8:
                strNum = strNum + Integer.toString(8);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.num9:
                strNum = strNum + Integer.toString(9);
                firstNumber = Float.parseFloat(strNum);
                Result.setText(strNum);
                break;
            case R.id.btnAdd:
                secondNumber = firstNumber;
                firstNumber = 0;
                op = '+';
                str = strNum;
                strNum = "";
                Result.setText(" + ");
                break;
            case R.id.btnMinus:
                secondNumber = firstNumber;
                firstNumber = 0;
                op = '-';
                str = strNum;
                strNum = "";
                Result.setText(" - ");
                break;
            case R.id.btnDiv:
                secondNumber = firstNumber;
                firstNumber = 0;
                op = '/';
                str = strNum;
                strNum = "";
                Result.setText(" / ");
                break;
            case R.id.btnMul:
                secondNumber = firstNumber;
                firstNumber = 0;
                op = '*';
                str = strNum;
                strNum = "";
                Result.setText(" * ");
                break;
            case R.id.btnEqua:
                if (op == '+')
                    math = firstNumber + secondNumber;
                else if (op == '-')
                    math = secondNumber - firstNumber;
                else if (op == '*')
                    math = firstNumber * secondNumber;
                else if (op == '/')
                    math = secondNumber / firstNumber;
                else math = firstNumber;
                strNum = Float.toString(math);
                Result.setText(strNum);
                strNum = "";
                str = "";
                op = 'q';
                firstNumber = 0;
                secondNumber = 0;
                math = 0;
                break;
            case R.id.dot:
                if (strNum.indexOf(".") != -1) Result.setText(strNum);
                else {
                    strNum = strNum + '.';
                    Result.setText(strNum);
                }
                break;
            case R.id.delALL:
                strNum = "";
                str = "";
                op = 'q';
                firstNumber = 0;
                secondNumber = 0;
                math = 0;
                Result.setText(strNum);
                break;

            case R.id.del:
                if (op == '+'
                        || op == '-'
                        || op == '*'
                        || op == '/') {
                    op = 'q';
                    secondNumber = 0;
                    strNum = str;
                    firstNumber = Float.parseFloat(strNum);
                    Result.setText(strNum);
                } else {
                    if (strNum.length() > 1) {
                        strNum = strNum.substring(0, strNum.length() - 1);
                        firstNumber = Float.parseFloat(strNum);
                        Result.setText(strNum);
                    } else {
                        strNum = "";
                        Result.setText(strNum);
                    }
                }
                break;
        }
    }
}
