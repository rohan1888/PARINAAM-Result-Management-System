package com.result.result_manage;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.util.Objects;

public class ResultFinal {

    ResultFinal(int roll,int sem)
    {
        Stage st = new Stage();
        Group root = new Group();

        Rectangle rc = new Rectangle(1200,60,Color.rgb(250, 27, 87));
        rc.setTranslateY(45);
        root.getChildren().add(rc);

        new MenuFinal(root,st,roll);

        Label l = new Label("Result Dashboard");
        l.setFont(Font.font("Aerial", FontWeight.BOLD, FontPosture.REGULAR,25));
        l.setTextFill(Color.WHITE);
        l.setTranslateX(450);
        l.setTranslateY(53);

        root.getChildren().add(l);

        Insets in_3 = new Insets(10);

        Button btn_3 = new Button("Show");
        btn_3.setCursor(Cursor.HAND);
        btn_3.setPadding(in_3);
        btn_3.setTranslateX(500);
        btn_3.setTranslateY(130);
        btn_3.setMinWidth(100);
        GridPane gp = new GridPane();
        btn_3.setOnAction(e->{
            BtnAction(roll,sem,gp, root);
        });

        root.getChildren().addAll(btn_3,gp);

        Scene sc = new Scene(root, Color.rgb(33, 27, 51));
        st.setScene(sc);
        st.setWidth(1200);
        st.setHeight(700);
        st.show();
    }
    private void BtnAction(int roll,int sem, GridPane gp, Group res_1) {

        Conn_Data1 c = new Conn_Data1();
        Conn_Data1 c2 = new Conn_Data1();
        String q = "select pf,course_id,grade,credit \n" +
                "from result \n" +
                "where roll_no = "+roll+" and semster = "+sem+";";

        Label []cid = new Label[6];
        Label []cna = new Label[6];
        Label []cre = new Label[6];
        Label []gra = new Label[6];
        Label []pf = new Label[6];
        int total_grades = 0;
        int total_cre = 0;
        int paf = 1;

        for (int i =0;i<6;i++)
        {
            cid[i] = new Label(" ");
            cid[i].setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,14));
            cid[i].setTextFill(Color.WHITE);

            cre[i] = new Label(" ");
            cre[i].setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,14));
            cre[i].setTextFill(Color.WHITE);

            cna[i] = new Label(" ");
            cna[i].setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,14));
            cna[i].setTextFill(Color.WHITE);

            gra[i] = new Label(" ");
            gra[i].setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,14));
            gra[i].setTextFill(Color.WHITE);

            pf[i] = new Label(" ");
            pf[i].setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,14));
            pf[i].setTextFill(Color.WHITE);

        }

        try{
            ResultSet rs_1 = c.s.executeQuery(q);
            ResultSet rs2;
            int i = 0;
            while(rs_1.next())
            {
                cid[i].setText(rs_1.getString(2));
                cre[i].setText(rs_1.getString(4));
                gra[i].setText(rs_1.getString(3));
                pf[i].setText(rs_1.getString(1));
                String q2 = "select distinct sub_name from subject where course_id = '"+cid[i].getText()+"';";
                rs2 = c2.s.executeQuery(q2);

                if (rs2.next())
                {
                    cna[i].setText(rs2.getString(1));
                }
                int point = 0;
                if(Objects.equals(gra[i].getText(), "A+"))
                {
                    point = 10;
                } else if (Objects.equals(gra[i].getText(),"A")) {
                    point = 9;
                }
                else if (Objects.equals(gra[i].getText(),"B")) {
                    point = 8;
                }
                else if (Objects.equals(gra[i].getText(),"C")) {
                    point = 6;
                }
                else if (Objects.equals(gra[i].getText(),"D")) {
                    point = 4;
                }
                total_grades = total_grades + (point * Integer.parseInt(cre[i].getText()));
                total_cre += Integer.parseInt(cre[i].getText());
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
            String res3 = "";
            if(paf == 1)
            {
                res3 = res3 + "Pass";
            }
            else
            {
                res3 = res3 + "Re";
            }

            Image i1_1 = new Image("F:\\result management\\education.png");
            ImageView im1_1 = new ImageView(i1_1);
            im1_1.setFitWidth(50);
            im1_1.setFitHeight(50);

            Label t1 = new Label("Course Id  ");
            t1.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,15));
            t1.setTextFill(Color.WHITE);


            Label t16= new Label("Course Name  ");
            t16.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,15));
            t16.setTextFill(Color.WHITE);


            Label t2 = new Label("Credit Points  ");
            t2.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,15));
            t2.setTextFill(Color.WHITE);


            Label t3 = new Label("Grade  ");
            t3.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,15));
            t3.setTextFill(Color.WHITE);


            Label t17 = new Label("Sub 1");
            t17.setFont(Font.font("Cursive",FontWeight.BOLD, FontPosture.REGULAR,15));
            t17.setTextFill(Color.WHITE);
            Label t18 = new Label("Sub 2");
            t18.setFont(Font.font("Cursive",FontWeight.BOLD, FontPosture.REGULAR,15));
            t18.setTextFill(Color.WHITE);
            Label t19 = new Label("Sub 3");
            t19.setFont(Font.font("Cursive",FontWeight.BOLD, FontPosture.REGULAR,15));
            t19.setTextFill(Color.WHITE);
            Label t20 = new Label("Sub 4");
            t20.setFont(Font.font("Cursive",FontWeight.BOLD, FontPosture.REGULAR,15));
            t20.setTextFill(Color.WHITE);
            Label t21 = new Label("Sub 5");
            t21.setFont(Font.font("Cursive",FontWeight.BOLD, FontPosture.REGULAR,15));
            t21.setTextFill(Color.WHITE);
            Label t22 = new Label("Sub 6");
            t22.setFont(Font.font("Cursive",FontWeight.BOLD, FontPosture.REGULAR,15));
            t22.setTextFill(Color.WHITE);

            gp.getChildren().clear();

            gp.addColumn(0,im1_1,t17,t18,t19,t20,t21,t22);
            gp.addColumn(1,t1,cid[0],cid[1],cid[2],cid[3],cid[4],cid[5]);
            gp.addColumn(2,t16,cna[0],cna[1],cna[2],cna[3],cna[4],cna[5]);
            gp.addColumn(3,t2,cre[0],cre[1],cre[2],cre[3],cre[4],cre[5]);
            gp.addColumn(4,t3,gra[0],gra[1],gra[2],gra[3],gra[4],gra[5]);

            gp.setHgap(20);
            gp.setVgap(11);
//
            gp.setTranslateY(200);
            gp.setTranslateX(280);
            CornerRadii cr = new CornerRadii(25);
            BorderStroke bs_1 = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,cr,BorderWidths.DEFAULT);
            gp.setBorder(new Border(bs_1));
            gp.setMaxWidth(600);
            gp.setMinWidth(600);
            Insets ins3_1 = new Insets(9,9,9,9);
            gp.setPadding(ins3_1);

            Label res = new Label("Result: ");
            res.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,25));
            res.setTextFill(Color.WHITE);
            res.setTranslateX(400);
            res.setTranslateY(580);

            Label cg= new Label("SGPA: ");
            cg.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,25));
            cg.setTextFill(Color.WHITE);
            cg.setTranslateX(900);
            cg.setTranslateY(580);

            Label sg= new Label("" + sgpa);
            sg.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,25));
            sg.setTextFill(Color.WHITE);
            sg.setTranslateX(1000);
            sg.setTranslateY(580);

            Label paff= new Label(res3);
            paff.setFont(Font.font("Cursive",FontWeight.NORMAL,FontPosture.REGULAR,25));
            paff.setTextFill(Color.WHITE);
            paff.setTranslateX(500);
            paff.setTranslateY(580);

            Rectangle res1 = new Rectangle(250,65,Color.WHITE);
            res1.setTranslateX(370);
            res1.setTranslateY(565);
            res1.setOpacity(0.2);
            res1.setArcHeight(30);
            res1.setArcWidth(25);


            Rectangle cg1 = new Rectangle(250,65,Color.WHITE);
            cg1.setTranslateX(860);
            cg1.setTranslateY(565);
            cg1.setOpacity(0.2);
            cg1.setArcHeight(30);
            cg1.setArcWidth(25);


            res_1.getChildren().remove(res);
            res_1.getChildren().removeAll(cg);
            res_1.getChildren().removeAll(cg1);
            res_1.getChildren().remove(res1);
            res_1.getChildren().addAll(res,cg,res1,cg1);
            res_1.getChildren().addAll(sg,paff);


        }catch (Exception ex) {
            gp.getChildren().clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No Data Found for Given Roll Number");
            alert.showAndWait();
            System.out.println(ex);
        }

    }
}
