package com.newegg.tr.dagger2prac.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.newegg.tr.dagger2prac.R;
import com.newegg.tr.dagger2prac.model.action.ActionType;
import com.newegg.tr.dagger2prac.presenter.MainPresenter;
import com.newegg.tr.dagger2prac.view.MainPageView;
import com.newegg.tr.dagger2prac.view.component.MainComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements MainPageView, AdapterView.OnItemSelectedListener {

    public static MainComponent component;

    @Inject
    MainPresenter mPresenter;

    @InjectView(R.id.mainPage_messageText)
    TextView messageTextView;
    @InjectView(R.id.mainPage_actionSpinner)
    Spinner actionSpinner;
    @InjectView(R.id.mainPage_inputEditText)
    EditText inputText;
    @InjectView(R.id.mainPage_submitButton)
    Button submitButton;
    @InjectView(R.id.mainPage_progress)
    View progress;

    @Override
    protected void onCreateComponent() {

        MainComponent.Initializer.init(getApplication(), this).inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initSpinner();
        initSubmitButton();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            mPresenter.updateUser();
        }
    }

    private void initSubmitButton() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(inputText.getText().toString().isEmpty()) {
                    MainActivity.this.onActionError();
                    return;
                }

                mPresenter.calcFib(Integer.valueOf(inputText.getText().toString()));
            }
        });
    }

    private void initSpinner() {
        String[] actionTexts = {"Hello", "Bye", "Fibonacci"};
        ArrayAdapter<String> actionTextArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, actionTexts);
        actionSpinner.setAdapter(actionTextArray);
        actionSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivityForResult(intent, 17);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showActionResultText(String resultText) {
        messageTextView.setText(resultText);
    }

    @Override
    public void showInputMethodView(boolean isShow) {
        int status = (isShow) ? View.VISIBLE : View.GONE;

        inputText.setVisibility(status);
        submitButton.setVisibility(status);
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void onActionError() {
        messageTextView.setText(getString(R.string.main_error));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                mPresenter.onActionSelected(ActionType.HELLO);
                break;
            case 1:
                mPresenter.onActionSelected(ActionType.BYE);
                break;
            case 2:
                mPresenter.onActionSelected(ActionType.FIBONACCI);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
