package ufcg.p1_project.data;

public class ScriptDLL {

    public static String getCreatedTableUserData(){

        StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE IF NOT EXISTS USERDATA ( ");
        sql.append("        LOGIN    VARCHAR (250) PRIMARY KEY ");
        sql.append("        DEFAULT (''), ");
        sql.append("        PASSWORD VARCHAR (250) NOT NULL ");
        sql.append("        DEFAULT ('') ) ");

        return sql.toString();
    }
}
