package ufcg.p1_project.data;

public class ScriptDLL {

    public static String getCreatedTableUserData(){

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE IF NOT EXISTS TABLE USERDATA (");
        sql.append("LOGIN    VARCHAR (250) PRIMARY KEY");
        sql.append("NOT NULL,");
        sql.append("PASSWORD VARCHAR (250) NOT NULL");
        sql.append("DEFAULT ('')");
        sql.append(");");

        return sql.toString();
    }
}
