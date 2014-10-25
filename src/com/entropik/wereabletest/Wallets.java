package com.entropik.wereabletest;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.SharedPreferences;

class Wallet {
	String total_mount;
    String from;
    String to;
    String result;
    int the_id;

    public Wallet()
    {

    }
    public Wallet(int _the_id, String _total_mont, String _from, String _to, String _result)
    {
        this.total_mount = _total_mont;
        this.from = _from;
        this.to = _to;
        this.result = _result;
        this.the_id = _the_id;
    }

    public boolean is_correcta(int tipo)
    {
       
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(from).append(" li ha enviat ").append(total_mount).append(" a vostè");
        return builder.toString();
    }
}

public class Wallets {


    public List<Wallet> lst_wallets = new ArrayList<Wallet>();
    public String ultimo_tipo = "1";

    private Context context;

    public Wallets(Context _c) {

        this.context = _c;
        this.ultimo_tipo = get_tipo();
        for(int i=1;i<4;i++)
        {
        	lst_wallets.add(get_wallet(i));
        }

    }

    public void set_tipo(String _tipo)
    {
        SharedPreferences.Editor editor = this.getSettings().edit();
        this.ultimo_tipo = _tipo;
        editor.putString("KEY_TIPO", this.ultimo_tipo);
        editor.commit();
    }

    private String get_tipo()
    {
        return getSettings().getString("KEY_TIPO", "");

    }


    public void set_wallet(int i, Wallet wallet)
    {
        SharedPreferences.Editor editor = this.getSettings().edit();

        switch (i)
        {
            case 1:
                editor.putString("KEY_FROM_1", wallet.from);
                editor.putString("KEY_TO_1", wallet.to);
                editor.putString("KEY_TOTAL_MOUNT_1", wallet.total_mount);
                editor.putString("KEY_RESULT_1", wallet.result);
                editor.putInt("KEY_THE_ID_1", wallet.the_id);

                break;
            case 2:
                editor.putString("KEY_FROM_2", wallet.from);
                editor.putString("KEY_TO_2", wallet.to);
                editor.putString("KEY_TOTAL_MOUNT_2", wallet.total_mount);
                editor.putString("KEY_RESULT_2", wallet.result);
                editor.putInt("KEY_THE_ID_2", wallet.the_id);

                break;
            case 3:
                editor.putString("KEY_FROM_3", wallet.from);
                editor.putString("KEY_TO_3", wallet.to);
                editor.putString("KEY_TOTAL_MOUNT_3", wallet.total_mount);
                editor.putString("KEY_RESULT_3", wallet.result);
                editor.putInt("KEY_THE_ID_3", wallet.the_id);
                break;
        }

        editor.commit();
    }


    public Wallet get_wallet(int i)
    {
        Wallet wallet = new Wallet();

        switch (i)
        {
            case 1:

            	wallet.from =  getSettings().getString("KEY_FROM_1", "");
            	wallet.to =  getSettings().getString("KEY_TO_1", "");
            	wallet.total_mount =  getSettings().getString("KEY_TOTAL_MOUNT_1", "");
            	wallet.result =  getSettings().getString("KEY_RESULT_1", "");
            	wallet.the_id =  getSettings().getInt("KEY_THE_ID_1", 0);
             break;
            case 2:
            	wallet.from =  getSettings().getString("KEY_FROM_2", "");
            	wallet.to =  getSettings().getString("KEY_TO_2", "");
            	wallet.total_mount =  getSettings().getString("KEY_TOTAL_MOUNT_2", "");
            	wallet.result =  getSettings().getString("KEY_RESULT_2", "");
            	wallet.the_id =  getSettings().getInt("KEY_THE_ID_2", 0);
                break;

            case 3:
            	wallet.from =  getSettings().getString("KEY_FROM_3", "");
            	wallet.to =  getSettings().getString("KEY_TO_3", "");
            	wallet.total_mount =  getSettings().getString("KEY_TOTAL_MOUNT_3", "");
            	wallet.result =  getSettings().getString("KEY_RESULT_3", "");
            	wallet.the_id =  getSettings().getInt("KEY_THE_ID_3", 0);
                break;
        }
        return wallet;
    }



    private SharedPreferences getSettings() {
        return this.context.getSharedPreferences("MIS_WALLETS", 0);
    }


}
