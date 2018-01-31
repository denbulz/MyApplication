package com.example.denver.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bpodgursky.jbool_expressions.And;
import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.Not;
import com.bpodgursky.jbool_expressions.Or;
import com.bpodgursky.jbool_expressions.Variable;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.bpodgursky.jbool_expressions.rules.RuleSet;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    static Expression<String> exprr;
    static Expression<String> sim;
    public static Expression<String> expr;
    public static Expression<String> simplified;
    String thos = "( ( (! C) | C) & A & B)";
    public static TextView samp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        exprr = And.of(Variable.of("A"),
                Variable.of("B"),
                Or.of(Variable.of("C"), Not.of(Variable.of("C"))));

        System.out.println(exprr);
        //  ((!C | C) & A & B)

      sim = RuleSet.simplify(ExprParser.parse(thos));

        System.out.println(simplified);
        //  (A & B)
    }


}
