/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.util.SparseBooleanArray
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.ListView
 *  android.widget.TextView
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Random
 */
package com.vitwifi.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.vitwifi.login.R;
import com.vitwifi.login.SketchwareUtil;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity
        extends Activity {
    private Button button1;
    private EditText edittext1;
    private EditText edittext2;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private String password = "";
    private SharedPreferences savepass;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private String username = "";

    private void _login() {
        SketchwareUtil.showMessage(this.getApplicationContext(), "checklogin");
    }

    static /* synthetic */ void access$1(MainActivity mainActivity, String string2) {
        mainActivity.username = string2;
    }

    static /* synthetic */ void access$3(MainActivity mainActivity, String string2) {
        mainActivity.password = string2;
    }

    private void initialize(Bundle bundle) {
        this.textview1 = (TextView) this.findViewById(R.id.textview1);
        this.linear1 = (LinearLayout) this.findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) this.findViewById(R.id.linear2);
        this.button1 = (Button) this.findViewById(R.id.button1);
        this.textview2 = (TextView) this.findViewById(R.id.textview2);
        this.edittext1 = (EditText) this.findViewById(R.id.edittext1);
        this.textview3 = (TextView) this.findViewById(R.id.textview3);
        this.edittext2 = (EditText) this.findViewById(R.id.edittext2);
        this.savepass = this.getSharedPreferences("savepass", 0);
        this.button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                MainActivity.access$1(MainActivity.this, MainActivity.this.textview1.getText().toString());
                MainActivity.access$3(MainActivity.this, MainActivity.this.textview2.getText().toString());
                SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "checklogin");
                if (1 == 2) {
                    savepass.edit().putString("username", username).commit();
                    savepass.edit().putString("password", password).commit();
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(),
                            "Login Complete! Close the app and use wifi as usual.");
                } else {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(),
                            "That didn't work! Check your connection with VIT wifi, or your username and password!");
                }
            }
        });
    }

    private void initializeLogic() {
        if (!this.savepass.getString("username", "").equals((Object) "")) {
            this._login();
            this.finish();
        }
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList arrayList = new ArrayList();
        SparseBooleanArray sparseBooleanArray = listView.getCheckedItemPositions();
        int n = 0;
        while (n < sparseBooleanArray.size()) {
            if (sparseBooleanArray.valueAt(n)) {
                arrayList.add((Object) sparseBooleanArray.keyAt(n));
            }
            ++n;
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int n) {
        return TypedValue.applyDimension((int) 1, (float) n, (DisplayMetrics) this.getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return this.getResources().getDisplayMetrics().heightPixels;
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return this.getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] arrn = new int[2];
        view.getLocationInWindow(arrn);
        return arrn[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] arrn = new int[2];
        view.getLocationInWindow(arrn);
        return arrn[1];
    }

    @Deprecated
    public int getRandom(int n, int n2) {
        return n + new Random().nextInt(1 + (n2 - n));
    }

    protected void onActivityResult(int n, int n2, Intent intent) {
        super.onActivityResult(n, n2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(R.layout.main);
        this.initialize(bundle);
        this.initializeLogic();
    }

    @Deprecated
    public void showMessage(String string2) {
        Toast.makeText((Context) this.getApplicationContext(), (CharSequence) string2, (int) 0).show();
    }

}
