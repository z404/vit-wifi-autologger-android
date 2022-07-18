/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.SparseBooleanArray
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.ListView
 *  android.widget.Toast
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Random
 *  java.util.Set
 */
package com.vitwifi.login;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SketchwareUtil {
    /*
     * Enabled aggressive block sorting
     */
    public static void getAllKeysFromMap(Map<String, Object> map, ArrayList<String> arrayList) {
        if (arrayList != null) {
            arrayList.clear();
            if (map != null && map.size() > 0) {
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)((String)((Map.Entry)iterator.next()).getKey()));
                }
            }
        }
    }

    public static ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList arrayList = new ArrayList();
        SparseBooleanArray sparseBooleanArray = listView.getCheckedItemPositions();
        int n = 0;
        while (n < sparseBooleanArray.size()) {
            if (sparseBooleanArray.valueAt(n)) {
                arrayList.add((Object)sparseBooleanArray.keyAt(n));
            }
            ++n;
        }
        return arrayList;
    }

    public static float getDip(Context context, int n) {
        return TypedValue.applyDimension((int)1, (float)n, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    public static int getDisplayHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getLocationX(View view) {
        int[] arrn = new int[2];
        view.getLocationInWindow(arrn);
        return arrn[0];
    }

    public static int getLocationY(View view) {
        int[] arrn = new int[2];
        view.getLocationInWindow(arrn);
        return arrn[1];
    }

    public static int getRandom(int n, int n2) {
        return n + new Random().nextInt(1 + (n2 - n));
    }

    public static void showMessage(Context context, String string2) {
        Toast.makeText((Context)context, (CharSequence)string2, (int)0).show();
    }
}

