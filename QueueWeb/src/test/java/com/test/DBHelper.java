package com.test;

import com.queue.util.SecurityUtils;

import java.sql.*;
import java.util.*;

/**
 * Created by liusong on 2018/5/4.
 */
public class DBHelper {

    private static String[] pageKeys = new String[]{"IDENTITY", "TITLE", "PAGE_URL", "VIDEO_ID", "STATUS", "REMARK"};
    private static String[] keys = new String[]{"IDENTITY", "SOURCE_URL", "STATUS"};

    public static void main(String[] args) {
        String sql = "SELECT * FROM VIDEO_PATH";
        List<Map<String, String>> list = DBHelper.search(sql);
        Map data = null;
        for (int i = 0; i < list.size(); i++) {
            data = list.get(i);
            int s = DBHelper.saveVideoPage(data);//保存视频链接
            if(s == 1){
                System.out.println("视频页面保存成功");
                String source = data.get("RESOURCE_PATH") == null ? "" : data.get("RESOURCE_PATH").toString();
                if(!"".equals(source)){
                    String uuid = DBHelper.getSourceUUID(source);
                    if(uuid == null){
                        uuid = DBHelper.saveSource(source);//保存视频资源链接
                    }
                    if(uuid != null){
                        System.out.println("资源保存成功");
                        int res = DBHelper.changeSource(uuid, data.get("IDENTITY").toString());
                        if(res == 1){
                            System.out.println("资源绑定成功");
                        }else{
                            System.out.println("绑定失败");
                        }
                    }else{
                        System.out.println("source save error");
                    }
                }else{
                    System.out.println("not find source");
                }
            }else{
                System.out.println("page save error");
            }
        }
    }

    public static String getSourceUUID(String source){
        String sql = "SELECT IDENTITY FROM RESOURCE_URL WHERE SOURCE_URL = '" + source + "'";
        List<Map<String, String>> list = DBHelper.search(sql);
        if(list.size() == 0){
            return null;
        }
        return list.get(0).get("IDENTITY");
    }

    public static int saveVideoPage(Map data){
        Map v = new HashMap();
        for (String key : pageKeys) {
            if(key.equals("PAGE_URL")){
                v.put(key, data.get("URL_PATH"));
            }else {
                v.put(key, data.get(key));
            }
        }
        String sql = "INSERT INTO VIDEO_PAGE (IDENTITY, TITLE, PAGE_URL, VIDEO_ID, STATUS, REMARK) VALUES (?, ?, ?, ?, ?, ?)";
        return DBHelper.save(sql, pageKeys, v);
    }

    public static int changeSource(String uuid, String pageId){
        String[] update = new String[]{"SOURCE_ID", "IDENTITY"};
        Map v = new HashMap();
        v.put("IDENTITY", pageId);
        v.put("SOURCE_ID", uuid);
        String sql = "UPDATE VIDEO_PAGE SET SOURCE_ID = ? WHERE IDENTITY = ?";
        return DBHelper.save(sql, update, v);
    }

    private static int save(String sql, Object[] colume, Map data){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            conn = DBHelper.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < colume.length; i++) {
                ps.setObject(i+1, data.get(colume[i]));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBHelper.close(conn, ps, result);
        }
        return 0;
    }

    private static List<Map<String, String>> search(String sql){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            conn = DBHelper.getConnection();
            ps = conn.prepareStatement(sql);
            result = ps.executeQuery();
            return DBHelper.getData(result);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            DBHelper.close(conn, ps, result);
        }
        return null;
    }

    public static String saveSource(String source){
        Map v = new HashMap();
        String uuid = SecurityUtils.getUUID();
        v.put(keys[0], uuid);
        v.put(keys[1], source);
        v.put(keys[2], 1);
        String sql = "INSERT INTO RESOURCE_URL (IDENTITY, SOURCE_URL, STATUS) VALUES (?, ?, ?)";
        int res = DBHelper.save(sql, keys, v);
        if(res == 1){
            return uuid;
        }
        return null;
    }

    private static List<Map<String, String>> getData(ResultSet rs) throws SQLException {
        List<Map<String, String>> result = new LinkedList<Map<String, String>>();
        ResultSetMetaData rsmd = rs.getMetaData();
        String[] colums = new String[rsmd.getColumnCount()];
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            colums[i] = rsmd.getColumnName(i+1);
        }
        Map<String, String> map;
        while (rs.next()){
            map = new LinkedHashMap<String, String>();
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb?useUnicode=true&characterEncoding=UTF-8&useSSL=true","root","123456");
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
