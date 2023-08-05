package com.result.result_manage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class uploadMarks {
    private File selectedFile = null;
    uploadMarks(String cid,int tid)
    {
        Stage stage = new Stage();
        Group root  = new Group();
        javafx.scene.shape.Rectangle rc = new Rectangle(1200,60, Color.rgb(250, 27, 87));
        rc.setTranslateY(45);
        root.getChildren().add(rc);

        javafx.scene.control.Label l_3 = new Label("Course Details and Marks Entry : ");
        l_3.setFont(Font.font("Aerial", FontWeight.BOLD, FontPosture.REGULAR,25));
        l_3.setTextFill(Color.WHITE);
        l_3.setTranslateY(53);
        l_3.setTranslateX(320);
        root.getChildren().add(l_3);

        new MenuTeacher(root,stage,tid);

        Button btn  = new Button("Upload File");
        btn.setTranslateX(800);
        btn.setTranslateY(250);
        root.getChildren().add(btn);
        btn.setOnAction(e->{
            FileChooser f = new FileChooser();
            f.setTitle("Upload");
            selectedFile = f.showOpenDialog(stage);
            System.out.println(selectedFile.getPath());
            try {
                new csv(selectedFile.getPath(),cid);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Conn_Data1 c = new Conn_Data1();
        String q = "select * from subject where course_id =\"" + cid + "\";";

        String c_name = "";
        int cred = 0;
        boolean prac = false;
        GridPane gp1 = new GridPane();
        try {
            ResultSet rs_3 = c.s.executeQuery(q);
            rs_3.next();
            c_name += rs_3.getString(2);
            cred = rs_3.getInt(4);
            prac = rs_3.getBoolean(3);
            Label l = new Label("Course Details : ");
            l.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 25));
            l.setTextFill(Color.WHITE);
            Label l2 = new Label("Course id : ");
            l2.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l22 = new Label(cid);
            l22.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l3 = new Label("Course Name : ");
            l3.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l33 = new Label(c_name);
            l33.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l4 = new Label("Credits : ");
            l4.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l44 = new Label(""+cred);
            l44.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l5 = new Label("Whether Integerated or not : ");
            l5.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            Label l55 = new Label();
            if(prac)
            {
                l55.setText("Yes");
            }
            else
            {
                l55.setText("No");
            }
            l55.setFont(Font.font("Cursive", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            l2.setTextFill(Color.WHITE);
            l22.setTextFill(Color.WHITE);
            l3.setTextFill(Color.WHITE);
            l33.setTextFill(Color.WHITE);
            l4.setTextFill(Color.WHITE);
            l44.setTextFill(Color.WHITE);
            l5.setTextFill(Color.WHITE);
            l55.setTextFill(Color.WHITE);
            gp1.addRow(0, l);
            gp1.addRow(1, l2, l22);
            gp1.addRow(2, l3, l33);
            gp1.addRow(3, l4, l44);
            gp1.addRow(4, l5, l55);
            Insets in = new Insets(50, 50, 50, 50);
            gp1.setPadding(in);
            //gp1.setBackground(Background.fill(Color.rgb(33, 27, 51)));
            gp1.setVgap(10);
            gp1.setHgap(25);
            gp1.setTranslateY(150);
            gp1.setTranslateX(100);
        } catch (SQLException e) {
            System.out.println(e);
        }

        Image im5_4=new Image("F:\\result management\\upload.gif");
        ImageView im5=new ImageView(im5_4);
        im5.setFitHeight(220);
        im5.setFitWidth(450);
        im5.setPreserveRatio(true);
        im5.setTranslateX(720);
        im5.setTranslateY(70);

        gp1.setAlignment(Pos.CENTER);
        CornerRadii cr = new CornerRadii(25);
        BorderStroke bs_3 = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, cr, BorderWidths.DEFAULT);
        gp1.setBorder(new Border(bs_3));
//    gp1.addRow(1,l2,l22);



        root.getChildren().addAll(gp1,im5);
        Scene sc = new Scene(root, Color.rgb(33, 27, 51));
        stage.setScene(sc);
        stage.setHeight(700);
        stage.setWidth(1200);
        stage.show();
    }
}
