package com.result.result_manage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.sql.ResultSet;

public class profileIn {
    profileIn(int roll)
    {
        Stage stage = new Stage();
        Group root_3 = new Group();

        Rectangle rc_3 = new Rectangle(1200,50, Color.rgb(250, 27, 87));
        rc_3.setTranslateY(40);

        Image icon_3 = new Image("F:\\result management\\website-attandence-features-page.png");
        ImageView img_3 = new ImageView(icon_3);
        img_3.setX(250);
        img_3.setY(20);
        img_3.setTranslateY(25);
        img_3.setFitHeight(50);
        img_3.setFitWidth(60);

        Label l_3 = new Label("Student Personal Details : ");
        l_3.setFont(Font.font("Aerial", FontWeight.BOLD, FontPosture.REGULAR,25));
        l_3.setTextFill(Color.WHITE);
        l_3.setTranslateY(45);
        l_3.setTranslateX(320);


//        TextField tf_3 = new TextField("Enter your Roll Number : ");
        Insets in_3 = new Insets(10);
//        tf_3.setPadding(in_3);
//        tf_3.setTranslateY(100);
//        tf_3.setTranslateX(420);
//        tf_3.setOpacity(0.7);
//        tf_3.setMinWidth(180);
//        tf_3.setFont(Font.font("Aerial",FontWeight.BOLD,FontPosture.REGULAR,15));


        GridPane gps_3 = new GridPane();
        gps_3.setBackground(Background.fill(Color.rgb(33, 27, 51)));


        Circle cr1_3 = new Circle(30,Color.rgb(250, 27, 87));
        cr1_3.setTranslateX(45);
        cr1_3.setTranslateY(150);


        Circle cr2_3 = new Circle(25,Color.rgb(250, 27, 87));
        cr2_3.setTranslateX(45);
        cr2_3.setTranslateY(250);


        Circle cr3_3 = new Circle(20,Color.rgb(250, 27, 87));
        cr3_3.setTranslateX(45);
        cr3_3.setTranslateY(350);


        Circle cr4_3 = new Circle(15,Color.rgb(250, 27, 87));
        cr4_3.setTranslateX(45);
        cr4_3.setTranslateY(450);


        Circle cr5_3 = new Circle(10,Color.rgb(250, 27, 87));
        cr5_3.setTranslateX(45);
        cr5_3.setTranslateY(530);

        Circle cr6_3 = new Circle(5,Color.rgb(250, 27, 87));
        cr6_3.setTranslateX(45);
        cr6_3.setTranslateY(610);

        GridPane gpp1_3 = new GridPane();
        GridPane gpp2_3 = new GridPane();



        Button btn_3 = new Button("Show");
        btn_3.setCursor(Cursor.HAND);
        btn_3.setPadding(in_3);
        btn_3.setTranslateX(550);
        btn_3.setTranslateY(100);
        btn_3.setMinWidth(100);
        btn_3.setOnAction(e->{
            BtnAction(gps_3,roll,gpp1_3,gpp2_3);

        });
        gps_3.addRow(0,gpp1_3,gpp2_3);
        root_3.getChildren().add(gps_3);
        btn_3.setFont(Font.font("Aerial",FontWeight.BOLD,FontPosture.REGULAR,15));


        root_3.getChildren().addAll(rc_3,l_3,btn_3,img_3,cr1_3,cr2_3,cr3_3,cr4_3,cr5_3,cr6_3);
        new MenuFinal(root_3,stage,roll);
        Scene sc_3 = new Scene(root_3, Color.rgb(33, 27, 51));
        stage.setScene(sc_3);
        stage.setHeight(700);
        stage.setWidth(1200);
        stage.setResizable(true);

        stage.show();
    }
    void BtnAction(GridPane gps_3, int roll_3,GridPane gpp1_3,GridPane gpp2_3) {
        String fn = null;
        String ln = null;
        String eml = null;
        String br = null;
        String st = null;
        String ct = null;
        BigInteger yr = null;
        BigInteger sem = null;
        BigInteger mbno = null;
        BigInteger pinc = null;
        String dob = null;
        Conn_Data1 c = new Conn_Data1();
        String q_3 = "select * from student_info where roll_no =" + roll_3 + ";";

        try {
            ResultSet rs_3 = c.s.executeQuery(q_3);
            rs_3.next();
            fn = rs_3.getString(3);
            ln = rs_3.getString(4);
            eml = rs_3.getString(5);
            dob = rs_3.getString(6);
            mbno = new BigInteger(rs_3.getString(7));
            br = rs_3.getString(8);
            sem = new BigInteger(rs_3.getString(9));
            yr = new BigInteger(rs_3.getString(10));
            pinc = new BigInteger(rs_3.getString(11));
            st = rs_3.getString(12);
            ct = rs_3.getString(13);
            Image i1 = new Image("F:\\result management\\s1.png");
            ImageView im1 = new ImageView(i1);
            im1.setFitWidth(50);
            im1.setFitHeight(50);

            Label t1 = new Label("Personal Information");
            t1.setFont(Font.font("Cursive", FontWeight.BOLD, FontPosture.REGULAR, 20));
            t1.setTextFill(Color.WHITE);


            Label t2 = new Label("First name : ");
            t2.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t2.setTextFill(Color.WHITE);
            Label t22 = new Label(fn);
            t22.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t22.setTextFill(Color.WHITE);

            Label t3 = new Label("Last name : ");
            t3.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t32 = new Label(ln);
            t32.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t3.setTextFill(Color.WHITE);
            t32.setTextFill(Color.WHITE);

            Label t4 = new Label("Email : ");
            t4.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t42 = new Label(eml);
            t42.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t4.setTextFill(Color.WHITE);
            t42.setTextFill(Color.WHITE);

            Label t5 = new Label("Mobile Number : ");
            t5.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t52 = new Label(mbno.toString());
            t52.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t5.setTextFill(Color.WHITE);
            t52.setTextFill(Color.WHITE);

            Label t6 = new Label("DOB : ");
            t6.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t62 = new Label(dob);
            t62.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t6.setTextFill(Color.WHITE);
            t62.setTextFill(Color.WHITE);

            Label t7 = new Label("City : ");
            t7.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t72 = new Label(ct);
            t72.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t7.setTextFill(Color.WHITE);
            t72.setTextFill(Color.WHITE);

            Label t8 = new Label("State : ");
            t8.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t82 = new Label(st);
            t82.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t8.setTextFill(Color.WHITE);
            t82.setTextFill(Color.WHITE);

            Label t9 = new Label("PIN Code : ");
            t9.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t92 = new Label(pinc.toString());
            t92.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t9.setTextFill(Color.WHITE);
            t92.setTextFill(Color.WHITE);

            Label t10 = new Label("Academics Information : ");
            t10.setFont(Font.font("Cursive", FontWeight.BOLD, FontPosture.REGULAR, 20));
            Image i2 = new Image("F:\\result management\\aca icon.png");
            ImageView im2 = new ImageView(i2);
            im2.setFitWidth(50);
            im2.setFitHeight(50);
            t10.setTextFill(Color.WHITE);


            Label t11 = new Label("Roll Number : ");
            t11.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            String ro_3 = new String(String.valueOf(roll_3));
            Label t112 = new Label(ro_3);
            t112.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t11.setTextFill(Color.WHITE);
            t112.setTextFill(Color.WHITE);

            Label t12 = new Label("Branch : ");
            t12.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t122 = new Label(br);
            t122.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t12.setTextFill(Color.WHITE);
            t122.setTextFill(Color.WHITE);


            Label t13 = new Label("Semester : ");
            t13.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t132 = new Label(sem.toString());
            t132.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t13.setTextFill(Color.WHITE);
            t132.setTextFill(Color.WHITE);

            Label t14 = new Label("Year : ");
            t14.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label t142 = new Label(yr.toString());
            t142.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            t14.setTextFill(Color.WHITE);
            t142.setTextFill(Color.WHITE);

            im2.setTranslateY(-100);
            t10.setTranslateY(-100);
            t11.setTranslateY(-100);
            t112.setTranslateY(-100);
            t12.setTranslateY(-100);
            t122.setTranslateY(-100);
            t13.setTranslateY(-100);
            t132.setTranslateY(-100);
            t14.setTranslateY(-100);
            t142.setTranslateY(-100);

            gps_3.getChildren().clear();

            gpp1_3.getChildren().clear();
            gpp2_3.getChildren().clear();

            gpp1_3.addRow(0, im1, t1);
            gpp1_3.addRow(1, t2, t22);
            gpp1_3.addRow(2, t3, t32);
            gpp1_3.addRow(3, t4, t42);
            gpp1_3.addRow(4, t5, t52);
            gpp1_3.addRow(5, t6, t62);
            gpp1_3.addRow(6, t7, t72);
            gpp1_3.addRow(7, t8, t82);
            gpp1_3.addRow(8, t9, t92);
            gpp2_3.addRow(9, im2, t10);
            gpp2_3.addRow(10, t11, t112);
            gpp2_3.addRow(11, t12, t122);
            gpp2_3.addRow(12, t13, t132);
            gpp2_3.addRow(13, t14, t142);
            gpp2_3.setHgap(15);
            gpp2_3.setVgap(10);
            gpp1_3.setHgap(15);
            gpp1_3.setVgap(10);
            gps_3.setTranslateY(150);
            gps_3.setHgap(100);
            gps_3.setAlignment(Pos.TOP_CENTER);
            gps_3.setTranslateX(50);
            CornerRadii cr = new CornerRadii(25);
            BorderStroke bs_3 = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, cr, BorderWidths.DEFAULT);
            gpp1_3.setBorder(new Border(bs_3));
            gpp2_3.setBorder(new Border(bs_3));
            gps_3.addRow(0, gpp1_3, gpp2_3);
            Insets ins2_3 = new Insets(50, 50, 50, 50);
            gpp1_3.setPadding(ins2_3);
            gpp2_3.setPadding(ins2_3);
            gps_3.setPadding(ins2_3);
        } catch (Exception ex) {
            gps_3.getChildren().clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No Data Found for Given Roll Number");
            alert.showAndWait();
        }
    }
}
