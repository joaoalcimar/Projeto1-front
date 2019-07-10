package ufcg.p1_project.data;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;

public class AssincDB extends AsyncTask<String, Void, ResultSet> {

    private Connection conn;
    private String query;

    public AssincDB(Connection conn, String query) {
        this.conn = conn;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ResultSet resultSet = null;
        try{
            resultSet = conn.prepareStatement(query).getGeneratedKeys();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return resultSet;
    }
}
