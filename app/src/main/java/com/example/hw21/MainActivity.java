package com.example.hw21;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText mPaymentAmount;
    private EditText mPaymentInfo;
    private Button mOK;
    private CheckBox mPayByCard;
    private CheckBox mPayByPhone;
    private CheckBox mCashPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mPaymentAmount = findViewById(R.id.edt_paymentAmount);
        mPaymentInfo = findViewById(R.id.edt_paymentInfo);
        mOK = findViewById(R.id.btn_ok);
        mPayByCard = findViewById(R.id.box_payByBankCart);
        mPayByPhone = findViewById(R.id.box_payByPhone);
        mCashPay = findViewById(R.id.box_CashPay);
        mPayByCard.setOnCheckedChangeListener(checkedChangeListener);
        mPayByPhone.setOnCheckedChangeListener(checkedChangeListener);
        mCashPay.setOnCheckedChangeListener(checkedChangeListener);
    }
    private void resetCheckBoxes(){
        mPayByCard.setChecked(false);
        mPayByPhone.setChecked(false);
        mCashPay.setChecked(false);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView.getId()) {
                    case R.id.box_payByBankCart:
                        resetCheckBoxes();
                        mPayByCard.setChecked(true);
                        mPaymentInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.box_payByPhone:
                        resetCheckBoxes();
                        mPayByPhone.setChecked(true);
                        mPaymentInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.box_CashPay:
                        resetCheckBoxes();
                        mCashPay.setChecked(true);
                        mPaymentInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    default:
                }
            }mOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "необходимое сообщение", Toast.LENGTH_LONG).show();
                }
            });
        }
    };
}