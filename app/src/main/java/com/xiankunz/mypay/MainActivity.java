package com.xiankunz.mypay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_pay = (Button) findViewById(R.id.btn_pay);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreditCardDialogFragment creditCardDialogFragment = CreditCardDialogFragment.newInstance();
                creditCardDialogFragment.show(getFragmentManager(), "creditCardDialog");
            }
        });

    }
}
