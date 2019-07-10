package ufcg.p1_project.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;

public class UserDataOpenHelper extends SQLiteOpenHelper {

    public UserDataOpenHelper(Context context) {
        super(context, "USERDATA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(ScriptDLL.getCreatedTableUserData());
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "USERDATA");
        onCreate(sqLiteDatabase);

    }



}
