package com.fit.guzelsozler.util;

import android.content.Context;
import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.fit.guzelsozler.R;
import com.fit.guzelsozler.model.Quote;

import java.io.File;

/**
 * Created by trinaldi on 2/23/18.
 */

public class DataUtil {
    public static void checkDatabase(Context context) {
//        context.deleteDatabase("quote.db");
        File dbQuote = context.getDatabasePath("quote.db");
        if (dbQuote.exists()) {
            Log.i("Database", "Database exists, " + dbQuote.getTotalSpace());
//            use this only for deleting database if needed
//            deleteDatabase("quote.db");
//            initiliazeApp(context);
        } else {
            Log.i("Database", "Database initialized");
//            initiliazeApp(context);
        }
    }

    private static void initiliazeApp(Context context) {
        ActiveAndroid.beginTransaction();
        try {
            DictionaryUtil dictionaryUtil = new DictionaryUtil(context);
            dictionaryUtil.initDictionary();
            String[] categories = context.getResources().getStringArray(R.array.array_category);
            for (String s : categories) {
                String[] items = context.getResources().getStringArray((int) dictionaryUtil.getValue(s));
                for (String item : items) {
                    Quote quote = new Quote(item, s, false);
                    quote.save();
                }
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }
}
