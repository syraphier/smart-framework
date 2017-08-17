package org.smart4j.framework.helper;

import java.sql.Connection;

public class DatabaseHelper {
    private static final String driver = ConfigHelper.getJdbcDriver();
    private static final String url = ConfigHelper.getJdbcUrl();
    private static final String userName = ConfigHelper.getJdbcUser();
    private static final String password = ConfigHelper.getJdbcPassword();

    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    public static Connection getConnection(){
        Connection conn = connContainer.get();
        try {
            if (conn == null){
                Class.forName(driver);
                //todo dirverManager
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            connContainer.set(conn);
        }

        return conn;
    }

    public static void closeConnection(){
        Connection conn = connContainer.get();
        try {
            if (conn != null){
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            connContainer.remove();
        }
    }
}
