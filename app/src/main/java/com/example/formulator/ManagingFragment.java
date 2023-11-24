package com.example.formulator;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.formulator.myClass.Comp;
import com.example.formulator.myClass.FormulaWName;

import java.util.ArrayList;

public class ManagingFragment extends Fragment {

    public ArrayList<FormulaWName> formulasList = new ArrayList<>();
    LinearLayout managingLL;
    EditText managingNameBox;
    TextView managingAddBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_managing, container, false);

        managingLL = (LinearLayout) root.findViewById(R.id.managingLL);
        managingNameBox = (EditText) root.findViewById(R.id.managingNameBox);
        managingAddBtn = (TextView) root.findViewById(R.id.managingAddBtn);

        /*
        Comp[] CompsData = new Comp[0];

        Comp[] CompsList = {
                new Comp("shekar", 1.5F),
                new Comp("nokhod", 2F),
                new Comp("kol", 0.05F)
        };
        Comp[] CompsList2 = {
                new Comp("maaaarg", 1.5F),
                new Comp("maaaarg", 2F),
                new Comp("maaaarg", 0.05F)
        };

        FormulaWName[] formulasList = new FormulaWName[4];
        for(int i = 0;i < 2;i++) {
            formulasList[i] = new  FormulaWName(managingNameBox.getText().toString(),CompsList);
        }
        ArrayList<Comp> Khash = new ArrayList<>();
        Comp c1 = new Comp("shekar", 1.5F);
        Comp c2 = new Comp("nokhod", 2F);
        Comp c3 = new Comp("kol", 0.05F);
        Khash.add(c1);
        Khash.add(c2);
        Khash.add(c3);

        ArrayList<Comp> marg = new ArrayList<>();
        Comp c11 = new Comp("kooft", 1.5F);
        Comp c12 = new Comp("dard", 2F);
        Comp c13 = new Comp("zahrmar", 0.05F);
        marg.add(c11);
        marg.add(c12);
        marg.add(c13);
        FormulaWName[] formulasList = new FormulaWName[10];
        if (formulasList.length != 0) {
            for (int i = 0; i < formulasList.length; i++) {
                insertRow(formulasList[i].formulaName);
            }
        }
        i = formulasList.length;

        FormulaWName[] formulasList = new FormulaWName[20];
        formulasList.add(new FormulaWName("mori",emptyCompList));
        int a;
        formulasList.remove(0);
        */
        Comp[] emptyCompList = new Comp[0];
        managingAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String IName = (managingNameBox.getText().toString());
                formulasList.add(new FormulaWName(IName, emptyCompList));

                int I = formulasList.size() - 1;
                insertRow(IName, I);
            }
        });

        return root;
    }

    private int topx(float dp) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return (int) px;
    }

    private void insertRow(String name, int index) {

        LinearLayout newLL = new LinearLayout(getActivity());
        TextView txtView = new TextView(getActivity());
        TextView delete = new TextView(getActivity());


        newLL.setMinimumWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        newLL.setMinimumHeight(topx(60));
        newLL.setPadding(0, topx(10), 0, 0);


        LinearLayout.LayoutParams deleteParams = new LinearLayout.LayoutParams(topx(50), -1);
        deleteParams.setMargins(0, 0, topx(5), 0);

        delete.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_bg));
        delete.setTextColor(ContextCompat.getColor(getActivity(), R.color.white_green));
        delete.setGravity(Gravity.CENTER);
        delete.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f);
        delete.setText("×");
        delete.setPadding(0, 0, 0, 0);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup) newLL.getParent()).removeView(newLL);
                //formulasList.remove(index);

            }
        });


        txtView.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.white_stroke));
        txtView.setPadding(topx(15), 0, 0, 0);
        txtView.setSingleLine(true);
        txtView.setGravity(Gravity.CENTER_VERTICAL);
        txtView.setText(name);
        txtView.setTextColor(ContextCompat.getColor(getActivity(), R.color.white_green));
        txtView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), name + "", Toast.LENGTH_LONG).show();
            }
        });

        newLL.addView(delete, deleteParams);
        newLL.addView(txtView, -1, -1);
        managingLL.addView(newLL);
        managingNameBox.setText("");


    }


}