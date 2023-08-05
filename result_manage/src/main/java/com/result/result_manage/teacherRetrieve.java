package com.result.result_manage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teacherRetrieve {

    // making connections
    Conn_Data1 c;

    // declaring vars
    int tid ;
    String sb_name1;
    String cid1;
    String sb_name2;
    String cid2;
    String sb_name3;
    String cid3;
    int cnt;

    // getting from subject table values from mysql database


    public teacherRetrieve(int tid) throws IOException {
        String query1 = "select course_id1,course_id2,course_id3 from teacher_info where t_id=" + tid + ";";
        String query2 = "select sub_name from subject  where course_id='" + cid1 + "';";
        String query3 = "select sub_name from subject  where course_id='" + cid2 + "';";
        String query4 = "select sub_name from subject  where course_id='" + cid3 + "';";
        c = new Conn_Data1();
//        this.tid = tid;
        //query1
        {
            ResultSet rs = null;
            try {
                rs = c.s.executeQuery(query1);
            } catch (SQLException ex) {
                System.out.println("error at execution of query1");
                throw new RuntimeException(ex);
            }
            try {
                if (rs.next()) {
                    cid1 = rs.getString("course_id1");
                    cid2 = rs.getString("course_id2");
                    cid3 = rs.getString("course_id3");
                }
            } catch (SQLException ex) {
                System.out.println("error at extraction of query1");
                throw new RuntimeException(ex);
            }
        }

        //query2
        {
            ResultSet rs = null;
            try {
                rs = c.s.executeQuery(query2);
            } catch (SQLException ex) {
                System.out.println("error at execution of query2");
                throw new RuntimeException(ex);
            }
            try {
                if (rs.next()) {
                    sb_name1 = rs.getString("sub_name");
                }
            } catch (SQLException ex) {
                System.out.println("error at extraction of query2");
                throw new RuntimeException(ex);
            }
            cnt++;
        }

        //query3
        {
            ResultSet rs = null;
            if(cid2!=null){
                cnt++;
                try {
                    rs = c.s.executeQuery(query3);
                } catch (SQLException ex) {
                    System.out.println("error at execution of query3");
                    throw new RuntimeException(ex);
                }
                try {
                    if (rs.next()) {
                        sb_name2 = rs.getString("sub_name");
                    }
                } catch (SQLException ex) {
                    System.out.println("error at extraction of query3");
                    throw new RuntimeException(ex);
                }
            }

        }

        //query4
        {
            ResultSet rs = null;
            if(cid3!=null){
                cnt++;
                try {
                    rs = c.s.executeQuery(query4);
                } catch (SQLException ex) {
                    System.out.println("error at execution of query4");
                    throw new RuntimeException(ex);
                }
                try {
                    if (rs.next()) {
                        sb_name3 = rs.getString("sub_name");
                    }
                } catch (SQLException ex) {
                    System.out.println("error at extraction of query4");
                    throw new RuntimeException(ex);
                }
            }
        }
    }

}