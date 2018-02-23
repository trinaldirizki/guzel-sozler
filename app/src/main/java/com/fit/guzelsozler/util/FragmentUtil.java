package com.fit.guzelsozler.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.fit.guzelsozler.fragment.BaseFragment;

/**
 * Created by fidel on 15.02.2018.
 */

public class FragmentUtil {

    /**
     * Parametre olarak veirlen fragmenti id si verilen layout içeirisinde açar
     * */

    public static void open(FragmentManager fragmentManager, int layoutId, BaseFragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(layoutId, fragment, fragment.getFragmentTag());
        transaction.commit();
    }

    public static void refresh(FragmentManager fragmentManager, int layoutId, BaseFragment fragment){
        fragmentManager.beginTransaction().detach(fragment).attach(fragment).commit();
    }
}
