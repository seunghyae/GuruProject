package com.example.guruproject.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.guruproject.model.MemberModel;
import com.example.guruproject.model.MyItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public final static String TBL_ITEM = "ITEM";

    private static Database inst;
    private static SharedPreferences sf = null;

    private static List<MyItem> items = null; // 원본 데이터

    private Database() {}

    public static Database getInstance(Context context) {

        if (items == null) {
            items = new ArrayList<>();
        }

        if (sf == null) {
            sf = context.getSharedPreferences("MEMO", Activity.MODE_PRIVATE);
        }

        if (inst == null) {
            inst = new Database();
        }

        return inst;
    }

    public void setMember(MemberModel member) {
        String memberString = new GsonBuilder().serializeNulls().create().toJson(member);

        SharedPreferences.Editor editor = sf.edit();
        editor.putString(member.getId(), memberString);
        editor.commit();
    }

    public MemberModel getMember(String id) {
        MemberModel member = null;

        // id를 이용해 회원정보 획득
        String memberString = sf.getString(id, "");
        if (memberString != null && memberString.length() > 0) {
            member = new Gson().fromJson(memberString, MemberModel.class);
        } else {
            Log.e("Database", "member null");
        }

        return member;
    }

    public boolean checkMember(String id, String pwd) {
        boolean isTrue = false;

        if (id.isEmpty() || pwd.isEmpty()) {
            return isTrue; // 실패
        }
        // 회원 획득
        MemberModel member = getMember(id);
        if (member == null) {
            return isTrue; // 실패
        }

        if (member.getPwd().equals(pwd)) {
            isTrue = true; // 성공
        }

        return isTrue;
    }
}
