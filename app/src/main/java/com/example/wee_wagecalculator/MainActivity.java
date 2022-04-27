package com.example.wee_wagecalculator;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Name, Type, Hours;
    Button Calc;
    TextView tot_wage,reg_wage,ot_wage, tot_hours,ot_hours;
    int hours, overtime_hours, total_hours, regular_wage, overtime_wage, total_wage;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.txt_name);
        Type = findViewById(R.id.txt_type);
        Hours = findViewById(R.id.txt_hours);
        Calc = findViewById(R.id.button);
        Calc.setOnClickListener(this);
        tot_wage = findViewById(R.id.total_wage);
        reg_wage = findViewById(R.id.reg_wage);
        ot_wage = findViewById(R.id.ot_wage);
        tot_hours = findViewById(R.id.total_hours);
        ot_hours = findViewById(R.id.ot_hours);
    }

    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }
    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: mic test woo baka naman gusto mo work fr fr");
        hours = Integer.parseInt(Hours.getText().toString());
        type = (Type.getText().toString());
        switch (type) {
            case "regular":
            case "Regular":
            case "reg":
            case "Reg":
            case "REG":
                if (hours > 8) {
                    total_hours = hours;
                    overtime_hours = hours - 8;
                    regular_wage = 800;
                    overtime_wage = overtime_hours * 115;
                    total_wage = regular_wage + overtime_wage;
                } else {
                    regular_wage = hours * 100;
                    total_wage = regular_wage;
                }
                break;
            case "probationary":
            case "Probationary":
            case "prob":
            case "Prob":
            case "PROB":
                if (hours > 8) {
                    total_hours = hours;
                    overtime_hours = hours - 8;
                    regular_wage = 720;
                    overtime_wage = overtime_hours * 100;
                    total_wage = regular_wage + overtime_wage;
                } else {
                    regular_wage = hours * 90;
                    total_wage = regular_wage;
                }
                break;
            case "part-time":
            case "Part-Time":
            case "PART-TIME":
            default:
                if (hours > 8) {
                    total_hours = hours;
                    overtime_hours = hours - 8;
                    regular_wage = 600;
                    overtime_wage = overtime_hours * 90;
                    total_wage = regular_wage + overtime_wage;
                } else {
                    regular_wage = hours * 75;
                    total_wage = regular_wage;
                }
            }
            tot_wage.setText(String.valueOf(total_wage));
            reg_wage.setText(String.valueOf(regular_wage));
            ot_wage.setText(String.valueOf(overtime_wage));
            tot_hours.setText(String.valueOf(hours));
            ot_hours.setText(String.valueOf(overtime_hours));

    }
}