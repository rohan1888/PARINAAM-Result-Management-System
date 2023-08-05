package com.result.result_manage;

import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Objects;

public class WelStuCgpa {
    int rollno;

    private float sgpaCalc(int sem) {

        Conn_Data1 c = new Conn_Data1();
        String q = "select pf,course_id,grade,credit \n" +
                "from result \n" +
                "where roll_no = "+rollno+" and semster = "+sem+";";
        int total_grades = 0;
        int total_cre = 0;
        int paf = 1;
        int cre = 0;
        String cid = null;
        String gra = null;
        int pf = 0;


        try{
            ResultSet rs_1 = c.s.executeQuery(q);
            ResultSet rs2;
            int i = 0;
            while(rs_1.next())
            {
//                cid=(rs_1.getString(2));
                cre=Integer.parseInt(rs_1.getString(4));
                gra=(rs_1.getString(3));

                int point = 0;
                if(Objects.equals(gra, "A+"))
                {
                    point = 10;
                } else if (Objects.equals(gra,"A")) {
                point = 9;
            }
            else if (Objects.equals(gra,"B")) {
                point = 8;
            }
            else if (Objects.equals(gra,"C")) {
                point = 6;
            }
            else if (Objects.equals(gra,"D")) {
                point = 4;
            }
                total_grades = total_grades + (point * cre);
                total_cre += (cre);
                if(point == 0)
                {
                    paf = 0;
                }
                i++;
            }

            if(paf == 0)
            {
                total_grades = 0;
            }
            float sgpa = total_grades / total_cre;
            return sgpa;

        }catch (Exception ex) {

//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setContentText("No Data Found for Given Roll Number");
//            alert.showAndWait();
            System.out.println(ex);
            ex.printStackTrace();
            return 0;
        }

    }
    HashMap<Integer,Float> map;

    public WelStuCgpa(int roll){
        float sgp;
        this.rollno=roll;
        map=new HashMap<>();
        for (int i=1;i<=8;i++){
            sgp=sgpaCalc(i);
            map.put(i,sgp);
        }

    }


}
