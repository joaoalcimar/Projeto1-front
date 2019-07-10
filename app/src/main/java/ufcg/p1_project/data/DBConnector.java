package ufcg.p1_project.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.transform.Result;

public class DBConnector implements Runnable{

    private Connection conn;
    private String host = "192.168.0.15";
    private String db = "UserData";
    private int port = 5432;
    private String user = "postgres";
    private String pass = "794613";
    private String url = "jdbc:postgresql://%s:%d/%s";

    public DBConnector(){
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);

        this.connect();
        this.closeConnection();
    }

    private void connect(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeConnection(){
        if (this.conn != null){
            try{
                this.conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }

    }

    public ResultSet execute(String query){
        this.connect();
        ResultSet resultSet = null;

        try{
            resultSet = new AssincDB(this.conn, query).execute().get();
        }catch(Exception e){
            e.printStackTrace();
        }

        return resultSet;
    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet select(String query){
        this.connect();
        ResultSet resultSet = null;
        try{
            resultSet = new AssincDB(this.conn, query).execute().get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

}
