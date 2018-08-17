package com.test;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by liusong on 2018/5/4.
 */
public class RollBackData {

    public static void main(String[] args) {
        String search = "SELECT * FROM SEND_HIS";
        List<Map<String, String>> list = RollBackData.search(search);
        String update = "UPDATE EP_ORDER_DETAIL SET COMPANY_CODE = ?, BUDGET_ENTITY = ?, EXPENSE_TYPE = ? WHERE EPOD_ID = ?";
        for (Map tmp : list) {
            tmp.put("COMPANY_CODE", "1000");
            RollBackData.save(update, tmp);
        }
    }

    private static int save(String sql, Map<String, String> data){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            conn = RollBackData.getConnection();
            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(true);
            ps.setString(1, data.get("COMPANY_CODE"));
            ps.setString(2, data.get("RESPONSIBILITY_CENTER_ID"));
            ps.setString(3, data.get("EXPENSE_TYPE_ID"));
            ps.setObject(4, data.get("CREATED_BY"));
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            RollBackData.close(conn, ps, result);
        }
        return 0;
    }

    private static List<Map<String, String>> search(String sql){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            conn = RollBackData.getConnection();
            ps = conn.prepareStatement(sql);
            result = ps.executeQuery();
            return RollBackData.getData(result);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            RollBackData.close(conn, ps, result);
        }
        return null;
    }

    public static List<Map<String, String>> getData(ResultSet rs) throws SQLException {
        List<Map<String, String>> result = new LinkedList<Map<String, String>>();
        ResultSetMetaData rsmd = rs.getMetaData();
        String[] colums = new String[rsmd.getColumnCount()];
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            colums[i] = rsmd.getColumnName(i+1);
        }
        Map<String, String> map;
        while (rs.next()){
            map = new LinkedHashMap();
            for (String key : colums) {
                String value = rs.getString(key);
                map.put(key, value);
            }
            result.add(map);
        }
        return result;
    }

    private static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn =  DriverManager.getConnection("jdbc:oracle:thin:@172.16.6.28:1521:hepp","hepp","hepp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
