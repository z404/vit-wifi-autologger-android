/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.vitwifi.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class DebugActivity
extends Activity {
    String[] errMessage = new String[]{"Invalid string operation\n", "Invalid list operation\n", "Invalid arithmetical operation\n", "Invalid toNumber block operation\n", "Invalid intent operation"};
    String[] exceptionType = new String[]{"StringIndexOutOfBoundsException", "IndexOutOfBoundsException", "ArithmeticException", "NumberFormatException", "ActivityNotFoundException"};

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void onCreate(Bundle bundle) {
        String string2;
        block6 : {
            String string3;
            block5 : {
                int n = 0;
                super.onCreate(bundle);
                Intent intent = this.getIntent();
                string3 = "";
                if (intent == null) break block5;
                string2 = intent.getStringExtra("error");
                String[] arrstring = string2.split("\n");
                try {
                    do {
                        block8 : {
                            boolean bl;
                            block7 : {
                                String string4;
                                if (n >= this.exceptionType.length) break block7;
                                if (!arrstring[0].contains((CharSequence)this.exceptionType[n])) break block8;
                                string3 = this.errMessage[n];
                                int n2 = arrstring[0].indexOf(this.exceptionType[n]) + this.exceptionType[n].length();
                                string3 = string4 = String.valueOf((Object)string3) + arrstring[0].substring(n2, arrstring[0].length());
                            }
                            if (!(bl = string3.isEmpty())) break block5;
                            break block6;
                        }
                        ++n;
                    } while (true);
                }
                catch (Exception exception) {
                    string2 = string3;
                    break block6;
                }
            }
            string2 = string3;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)this);
        builder.setTitle((CharSequence)"An error occured");
        builder.setMessage((CharSequence)string2);
        builder.setNeutralButton((CharSequence)"End Application", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n) {
                DebugActivity.this.finish();
            }
        });
        builder.create().show();
    }

}

