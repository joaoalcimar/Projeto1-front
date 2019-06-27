package ufcg.p1_project.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDataOpenHelper extends SQLiteOpenHelper {

    public UserDataOpenHelper(Context context) {
        super(context, "USERDATA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(ScriptDLL.getCreatedTableUserData());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(ScriptDLL.getCreatedTableUserData());

    }



}
