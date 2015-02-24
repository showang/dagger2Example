package com.newegg.tr.dagger2prac.view.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.newegg.tr.dagger2prac.R;
import com.newegg.tr.dagger2prac.presenter.SettingPresenter;
import com.newegg.tr.dagger2prac.view.SettingView;
import com.newegg.tr.dagger2prac.view.component.SettingComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SettingActivity extends BaseActivity implements SettingView, View.OnClickListener {

    @Inject
    SettingPresenter mPresenter;

    @InjectView(R.id.settingPage_userNameTextView)
    TextView mUserNameTextView;

    @InjectView(R.id.settingPage_changeUserNameButton)
    TextView mChangeNameButton;

    @Override
    protected void onCreateComponent() {
        SettingComponent.Initializer.init(getApplication(), this).inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.inject(this);

        mChangeNameButton.setOnClickListener(this);
        mUserNameTextView.setOnClickListener(this);
        updateUserName(mPresenter.getUserName());
    }

    @Override
    public void onClick(View v) {

        final View dialogView = getLayoutInflater().inflate(R.layout.activity_setting_dialog, null);

        final AlertDialog renameDialog = new AlertDialog.Builder(this).setTitle("Change User Name").setView(dialogView).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText renameEditText = (EditText) dialogView.findViewById(R.id.settingPage_dialogRenameEditText);
                mPresenter.setUserName(renameEditText.getText().toString());
                dialog.dismiss();
                setResult(Activity.RESULT_OK);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();

        renameDialog.show();

    }

    @Override
    public void updateUserName(String userName) {
        mUserNameTextView.setText(userName);
    }
}
