package com.fit.guzelsozler.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.fit.guzelsozler.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by trinaldi on 2/22/18.
 */

public class DictionaryUtil {

    private Context context;
    private Dictionary dictionary;

    public DictionaryUtil(Context context) {
        this.context = context;
    }

    public void initDictionary() {
        dictionary = new Hashtable();
        String[] categories = context.getResources().getStringArray(R.array.array_category);
        dictionary.put(categories[0], R.array.ask_sozleri);
        dictionary.put(categories[1], R.array.anlamli_sozler);
        dictionary.put(categories[2], R.array.anlamli_guzel_sozler);
        dictionary.put(categories[3], R.array.ayrilik_sozleri);
        dictionary.put(categories[4], R.array.aci_sozler);
        dictionary.put(categories[5], R.array.asker_sozleri);
        dictionary.put(categories[6], R.array.aldatma_sozleri);
        dictionary.put(categories[7], R.array.araba_yazilari);
        dictionary.put(categories[8], R.array.atarli_sozler);
        dictionary.put(categories[9], R.array.agir_abi_sozleri);
        dictionary.put(categories[10], R.array.asik_edici_sozler);
        dictionary.put(categories[11], R.array.damar_sozler);
        dictionary.put(categories[12], R.array.davetiye_sozleri);
        dictionary.put(categories[13], R.array.dostluk_sozleri);
        dictionary.put(categories[14], R.array.dokunakli_sozler);
        dictionary.put(categories[15], R.array.duygusal_sozler);
        dictionary.put(categories[16], R.array.duvar_yazilari);
        dictionary.put(categories[17], R.array.efsane_sozler);
        dictionary.put(categories[18], R.array.espirili_sozler);
        dictionary.put(categories[19], R.array.etkileyici_sozler);
        dictionary.put(categories[20], R.array.evlilik_sozleri);
        dictionary.put(categories[21], R.array.facebook_sozleri);
        dictionary.put(categories[22], R.array.face_sozleri);
        dictionary.put(categories[23], R.array.gunaydin_sozleri);
        dictionary.put(categories[24], R.array.guzel_laflar);
        dictionary.put(categories[25], R.array.giderli_sozler);
        dictionary.put(categories[26], R.array.harbi_sozler);
        dictionary.put(categories[27], R.array.harika_sozler);
        dictionary.put(categories[28], R.array.hasret_sozleri);
        dictionary.put(categories[29], R.array.isyan_sozleri);
        dictionary.put(categories[30], R.array.i̇yi_geceler_sozleri);
        dictionary.put(categories[31], R.array.kapak_laflar);
        dictionary.put(categories[32], R.array.kapak_sozler);
        dictionary.put(categories[33], R.array.laf_sokucu_sozler);
        dictionary.put(categories[34], R.array.kizginlik_sozleri);
        dictionary.put(categories[35], R.array.komik_sozler);
        dictionary.put(categories[36], R.array.nefret_sozleri);
        dictionary.put(categories[37], R.array.ogrenci_sozleri);
        dictionary.put(categories[38], R.array.ogrenci_laflari);
        dictionary.put(categories[39], R.array.ozel_sozler);
        dictionary.put(categories[40], R.array.ozlem_sozleri);
        dictionary.put(categories[41], R.array.ozlu_sozler);
        dictionary.put(categories[42], R.array.ozur_sozleri);
        dictionary.put(categories[43], R.array.romantik_sozler);
        dictionary.put(categories[44], R.array.saglik_sozleri);
        dictionary.put(categories[45], R.array.seni_seviyorum_sozleri);
        dictionary.put(categories[46], R.array.seni_seviyorum_mesajlari);
        dictionary.put(categories[47], R.array.serseri_sozleri);
        dictionary.put(categories[48], R.array.sempatik_sozler);
        dictionary.put(categories[49], R.array.sert_sozler);
        dictionary.put(categories[50], R.array.sevgi_sozleri);
        dictionary.put(categories[51], R.array.sevgi_sozcukleri);
        dictionary.put(categories[52], R.array.sevenler_icin_sozler);
        dictionary.put(categories[53], R.array.sevgiliye_sozler);
        dictionary.put(categories[54], R.array.sitem_sozleri);
        dictionary.put(categories[55], R.array.skype_sozleri);
        dictionary.put(categories[56], R.array.sms_sozleri);
        dictionary.put(categories[57], R.array.super_sozler);
        dictionary.put(categories[58], R.array.tebrik_sozleri);
        dictionary.put(categories[59], R.array.teklif_sozleri);
        dictionary.put(categories[60], R.array.terketme_sozleri);
        dictionary.put(categories[61], R.array.tesekkur_sozleri);
        dictionary.put(categories[62], R.array.twitter_sozleri);
        dictionary.put(categories[63], R.array.yalnizlik_sozleri);
        dictionary.put(categories[64], R.array.alman_atasozleri);
        dictionary.put(categories[65], R.array.whatsapp_durumlari);
        dictionary.put(categories[66], R.array.amerikan_atasozleri);
        dictionary.put(categories[67], R.array.cin_atasozleri);
        dictionary.put(categories[68], R.array.i̇ngiliz_atasozleri);
        dictionary.put(categories[69], R.array.asker_mektuplari);
        dictionary.put(categories[70], R.array.ataturk_siirleri);
        dictionary.put(categories[71], R.array.ask_siirleri);
        dictionary.put(categories[72], R.array.sevgi_siirleri);
        dictionary.put(categories[73], R.array.cuma_mesajlari);
        dictionary.put(categories[74], R.array.dini_sozler);
        dictionary.put(categories[75], R.array.dini_mesajlar);
        dictionary.put(categories[76], R.array.dua_sozleri);
        dictionary.put(categories[77], R.array.kandil_sozleri);
        dictionary.put(categories[78], R.array.kandil_mesajlari);
        dictionary.put(categories[79], R.array.kisa_dini_sozler);
        dictionary.put(categories[80], R.array.kadir_gecesi_mesajlari);
        dictionary.put(categories[81], R.array.kadir_gecesi_sozleri);
        dictionary.put(categories[82], R.array.ramazan_bayrami_mesajlari);
        dictionary.put(categories[83], R.array.mirac_kandili_sozleri);
        dictionary.put(categories[84], R.array.berat_kandili_sozleri);
        dictionary.put(categories[85], R.array.regaib_kandili_sozleri);
        dictionary.put(categories[86], R.array.mevlid_kandili_sozleri);
        dictionary.put(categories[87], R.array.evlilik_yildonumu_mesajlari);
        dictionary.put(categories[88], R.array.anneler_gunu_sozleri);
        dictionary.put(categories[89], R.array.babalar_gunu_sozleri);
        dictionary.put(categories[90], R.array.dogum_gunu_sozleri);
        dictionary.put(categories[91], R.array.polis_haftasi_sozleri);
        dictionary.put(categories[92], R.array.sevgililer_gunu_sozleri);
        dictionary.put(categories[93], R.array.cumhuriyet_bayrami_sozleri);
        dictionary.put(categories[94], R.array.on_kasim_sozleri);
        dictionary.put(categories[95], R.array.ogretmenler_gunu_sozleri);
        dictionary.put(categories[96], R.array.ulusal_egemenlik_ve_cocuk_bayrami_sozleri);
        dictionary.put(categories[97], R.array.i̇sci_bayrami_sozleri);
        dictionary.put(categories[98], R.array.genclik_ve_spor_bayrami_sozleri);
        dictionary.put(categories[99], R.array.zafer_bayrami_sozleri);
        dictionary.put(categories[100], R.array.spor_sozleri);
        dictionary.put(categories[101], R.array.besiktas_sozleri);
        dictionary.put(categories[102], R.array.fenerbahce_sozleri);
        dictionary.put(categories[103], R.array.galatasaray_sozleri);
        dictionary.put(categories[104], R.array.trabzonspor_sozleri);
        dictionary.put(categories[105], R.array.milli_takim_sozleri);

    }

    public Object getValue(String s) {
        return dictionary.get(s);
    }
}
