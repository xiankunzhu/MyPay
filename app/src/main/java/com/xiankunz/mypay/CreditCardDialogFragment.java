package com.xiankunz.mypay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreditCardDialogFragment extends DialogFragment implements View.OnFocusChangeListener,
        View.OnClickListener {
    @BindView(R.id.et_card_number)
    EditText et_card_number;
    @BindView(R.id.et_cvv)
    EditText et_ccv;
    @BindView(R.id.et_first_name)
    EditText et_first_name;
    @BindView(R.id.et_last_name)
    EditText et_last_name;
    @BindView(R.id.et_date)
    EditText et_date;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    static CreditCardDialogFragment mFragment;

    public static CreditCardDialogFragment newInstance() {
        if (mFragment != null) {
            CreditCardDialogFragment mFragment = new CreditCardDialogFragment();
        }
        return mFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_credit_card, null);
        ButterKnife.bind(this, view);
        initView();
        builder.setView(view);
        return builder.create();
    }

    private void initView() {
        et_card_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_ccv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBtnNext.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (view != et_card_number || view != et_ccv || view != et_first_name || view != et_last_name) {
            hideKeyboard();
        }
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = this.getActivity().getCurrentFocus();
        if (view != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public boolean verifyAll() {
        verifyCardNumber();
        verifyCCV();
        return true;
    }

    public boolean verifyCardNumber() {
        return false;
    }

    public boolean verifyCCV() {
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                verifyAll();
                break;
        }
    }

}
