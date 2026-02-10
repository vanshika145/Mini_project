package com.example.mini_project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etName, etPassword;
    private RadioGroup rgRole;
    private MaterialButton btnLogin;
    private TextView tvRegister;
    private TextInputLayout tilName, tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        rgRole = findViewById(R.id.rgRole);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);

        tilName = findViewById(R.id.tilName);
        tilPassword = findViewById(R.id.tilPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    etName.setError("Enter Name");
                    return;
                }

                // UI-only logic: check which role is selected
                int selectedId = rgRole.getCheckedRadioButtonId();
                if (selectedId == R.id.rbStudent) {
                    Intent intent = new Intent(LoginActivity.this, StudentDashboardActivity.class);
                    intent.putExtra("NAME", name);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(LoginActivity.this, WardenDashboardActivity.class);
                    intent.putExtra("NAME", name);
                    startActivity(intent);
                }
                finish();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
