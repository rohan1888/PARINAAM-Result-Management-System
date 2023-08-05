package com.result.result_manage;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    login() throws FileNotFoundException {
        Stage stage =new Stage();
        Group root = new Group();
        Circle cr = new Circle(550);
        Stop[]st = new Stop[]{new Stop(0, Color.rgb(33, 27, 51)),new Stop(1,Color.rgb(250, 27, 87))};
        LinearGradient rg = new LinearGradient(0,0,500,500,false, CycleMethod.REFLECT,st);
        cr.setFill(rg);
        cr.setTranslateY(80);

        Rectangle r1=new Rectangle(350,400,Color.rgb(33,27,51));
        r1.setArcWidth(75);
        r1.setArcHeight(75);
        r1.setOpacity(0.5);
        r1.setTranslateX(700);
        r1.setTranslateY(100);

        Insets in = new Insets(10);
        Label l1 = new Label("ROLL NO : ");
        l1.setTranslateX(750);
        l1.setTranslateY(200);
        l1.setPadding(in);
        TextField tf1 = new TextField();
        l1.setLabelFor(tf1);
        tf1.setTranslateX(880);
        tf1.setTranslateY(200);
        tf1.setMaxWidth(150);
        tf1.setPadding(in);
        l1.setFont(Font.font("bold", FontWeight.BOLD,20));

        Label l2=new Label("Password :");
        l2.setTranslateX(750);
        l2.setTranslateY(250);
        l2.setPadding(in);
        l2.setFont(Font.font("bold", FontWeight.BOLD,20));
        TextField tf2=new PasswordField();
        l2.setLabelFor(tf2);
        tf2.setTranslateX(880);
        tf2.setTranslateY(250);
        tf2.setPadding(in);
        tf2.setMaxWidth(150);


        Image im5_4=new Image("F:\\result management\\login.png");
        ImageView im5=new ImageView(im5_4);
        im5.setFitHeight(100);
        im5.setPreserveRatio(true);
        im5.setTranslateX(840);
        im5.setTranslateY(340);
        im5.setOnMouseClicked(e->{
            int roll = Integer.parseInt(tf1.getText());
            String Password = tf2.getText();
            Conn_Data1 c = new Conn_Data1();
            String query = "Select * from student_info where roll_no= " + roll + " and password = '" + Password + "';";
            try {
                ResultSet resultSet = c.s.executeQuery(query);
                if (resultSet.next()) {
                    stage.hide();
                    new WelPage(roll);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Roll No. OR Password");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        Image im0=new Image(new FileInputStream("F:\\result management\\key.png"));
        ImageView im02=new ImageView(im0);
        im02.setFitHeight(50);
        im02.setPreserveRatio(true);
        im02.setTranslateX(740);
        im02.setTranslateY(120);
        root.getChildren().addAll(r1,l1,tf1,im5,l2,tf2,im02);

        root.getChildren().add(cr);

        stage.setHeight(700);
        stage.setWidth(1200);
        Scene sc  = new Scene(root);
        stage.setScene(sc);
        stage.show();
    }
}
