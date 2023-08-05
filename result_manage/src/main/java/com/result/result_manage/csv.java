package com.result.result_manage;

import com.result.result_manage.Conn_Data1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

//import static jdk.internal.org.jline.utils.Colors.s;
public class csv {

    // making connections
    Conn_Data1 c;

    // declaring vars
//    String cid = "CSPC41";
    String sb_name;
    int sem;
    int cp;
    int cdit;

    // getting from subject table values from mysql database



    // declaring variables
    int roll_no;
    String course_id;
    String sub_name;
    int check_prac;
    int semester;
    int int_1_prac;
    int int_2_prac;
    int viva_ex;
    int ext_prac;
    int int_1_thy;
    int int_2_thy;
    int ext_thy;
    int attendance;
    int class_perf;
    String db;


    // getting values from csv and putting them in mysql database
    BufferedReader lineReader = null;
    String filePath = "";// ENter the filepath please---------->>

    String lineText = null;
    int count = 0;

    public csv(String fpath,String cid) throws IOException {
        c = new Conn_Data1();
        String query1 = "select sub_name,check_prac,credits from subject where course_id='" + cid + "';";
//        String query2 = "select dob from student_info where roll_no=" + roll_no + ";";
        filePath = fpath;
        {
            ResultSet rs = null;
            try {
                rs = c.s.executeQuery(query1);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                if (rs.next()) {
                    sb_name = rs.getString("sub_name");
//                    sem = rs.getInt("semester");
                    cp = rs.getInt("check_prac");
                    cdit=rs.getInt("credits");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        {
            try {
                lineReader = new BufferedReader(new FileReader(filePath));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        String st = lineReader.readLine();
        {
            while (true) {
                try {
                    if ((lineText = lineReader.readLine()) == null) {
                        break;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] data = lineText.split(",");
                roll_no = Integer.parseInt(data[0]);
                course_id = cid;// 1
                // String sub_name = "Cloud and Grid Computing";

                semester = Integer.parseInt(data[2]);;// 2
                // int check_prac = Integer.parseInt(data[2]);

                // conditions
                if (cp == 0) {
                    int_1_prac = Integer.parseInt(null);
                    int_2_prac = Integer.parseInt(null);
                    viva_ex = Integer.parseInt(null);
                    ext_prac = Integer.parseInt(null);
                } else {
                    int_1_prac = Integer.parseInt(data[3]);
                    int_2_prac = Integer.parseInt(data[4]);
                    if (int_1_prac > 20 || int_1_prac < 0 || int_2_prac > 20 || int_2_prac < 0) {
                        pop("internal practical marks should be btw 0 and 20 for rollno. : ", roll_no);
                    }
                    viva_ex = Integer.parseInt(data[5]);
                    if (viva_ex > 20 || viva_ex < 0) {
                        pop("internal viva practical marks should be btw 0 and 20 for rollno. : ", roll_no);
                    }
                    ext_prac = Integer.parseInt(data[6]);
                    if (ext_prac > 40 || ext_prac < 0) {
                        pop("external viva practical marks should be btw 0 and 40 for rollno. : ", roll_no);
                    }
                }

                int_1_thy = Integer.parseInt(data[7]);
                int_2_thy = Integer.parseInt(data[8]);
                if (int_1_thy > 15 || int_1_thy < 0 || int_2_thy > 15 || int_2_thy < 0) {
                    pop("internal theoratical marks should be btw 0 and 15 for rollno. : ", roll_no);
                }

                ext_thy = Integer.parseInt(data[9]);
                if (ext_thy > 40 || ext_thy < 0) {
                    pop("external theoratical marks should be btw 0 and 50 for rollno. : ", roll_no);
                }
                attendance = Integer.parseInt(data[10]);
                class_perf = Integer.parseInt(data[11]);
                if (attendance > 10 || attendance < 0 || class_perf > 10 || class_perf < 0) {
                    pop("internal practical marks should be btw 0 and 10 for rollno. : ", roll_no);
                }

                String query = "Insert Into marks Values(" + roll_no + ",'" + course_id + "'," + semester + "," + int_1_prac + "," + int_2_prac + ","
                        + viva_ex + "," + ext_prac + "," + int_1_thy + "," + int_2_thy + "," + ext_thy + "," + attendance + "," + class_perf + ")";
                try {
                    c.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println("Error while inserting query line in database");
                    System.out.println(e);
                }

                // if (count % batchSize == 0) {
                // statement.executeBatch();
                // }
                ////--------------------------Do not touch

                {
//                    ResultSet rs = null;
//                    try {
//                        rs = c.s.executeQuery(query2);
//                    } catch (SQLException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                    try {
//                        if (rs.next()) {
//                            db = rs.getString("dob");
//                        }
//                    } catch (SQLException ex) {
//                        throw new RuntimeException(ex);
//                    }
                }

                // do not touch it belongs to result
                result obj = new result();
                int prac_tot = int_1_prac + int_2_prac + viva_ex + ext_prac;
                int thry_tot = int_1_thy + int_2_thy + ext_thy + attendance + class_perf;
                double tot = (prac_tot / (100.0)) * (0.4) + (thry_tot / (100.0)) * (0.6);

                if (tot >= 85) {
                    obj.grade = "A+";
                    obj.pass_fail = "pass";
                } else if (74 < tot) {
                    obj.grade = "A";
                    obj.pass_fail = "pass";
                } else if (64 < tot) {
                    obj.grade = "B";
                    obj.pass_fail = "pass";
                } else if (54 < tot) {
                    obj.grade = "C";
                    obj.pass_fail = "pass";
                } else if (40 < tot) {
                    obj.grade = "D";
                    obj.pass_fail = "pass";
                } else {
                    obj.grade = "F";
                    obj.pass_fail = "fail";
                }

                obj.cid = course_id;
                obj.credit = cdit;
                obj.date = db;
                obj.roll_no = roll_no;
                obj.semester = semester;
                // do not touch ends
                String query3 = "Insert Into result Values(" + obj.semester + "," + obj.roll_no + ",'0000-00-00','" + obj.pass_fail + "','" + obj.cid + "','"
                        + obj.grade + "'," + obj.credit + ")";
                try {
                    c.s.executeUpdate(query3);
                } catch (Exception e) {
                    System.out.println("Error while inserting query2 line in database");
                    System.out.println(e);
                }

            }
        }


    }

    public void pop(String st, int a) {
        System.out.println(st + a);
    }
//    s.executeBatch();
//    c.commit();
//    c.close();
}

class result{
    int semester;
    int roll_no;
    String date;
    String pass_fail;
    String grade;
    int credit;
    String cid;
    result(){
        semester=0;
        roll_no=0;
        date="";
        pass_fail=null;
        grade="";
        credit=0;
        cid="";
    }

}