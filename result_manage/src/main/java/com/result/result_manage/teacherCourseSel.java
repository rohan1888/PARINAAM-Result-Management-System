package com.result.result_manage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class teacherCourseSel {
    teacherCourseSel(int tid) throws IOException {
        Stage stage = new Stage();
        int cnt = 0;

        teacherRetrieve obj=new teacherRetrieve(tid);
        cnt=obj.cnt;    //please uncomment it !!

        Group root = new Group();

        new MenuTeacher(root,stage,tid);

        //root.getChildren().add(l);
        Rectangle rc = new Rectangle(450,250, Color.rgb(250, 27, 87));
        rc.setRotate(45);
        rc.setTranslateX(200);
        rc.setTranslateY(-150);
        rc.setArcWidth(75);
        rc.setArcHeight(75);
        root.getChildren().add(rc);


        Group subgrp1 = new Group();
        // code for cnt value evaluation
        Rectangle rec_head=new Rectangle(550,40,Color.WHITE);
        rec_head.setTranslateX(195);
        rec_head.setTranslateY(90);
        rec_head.setOpacity(0.2);
        rec_head.setArcHeight(30);
        rec_head.setArcWidth(25);

        Label lab=new Label("Course Selection");
        lab.setFont(Font.font("bold", FontWeight.BOLD,25));
        lab.setTextFill(Color.WHITE);
        lab.setTranslateX(200);
        lab.setTranslateY(90);

        subgrp1.getChildren().addAll(rec_head,lab);



        if(cnt >= 1){
            Rectangle r1=new Rectangle(180,180,Color.WHITE);
            r1.setTranslateX(190);
            r1.setTranslateY(150);
            r1.setOpacity(0.2);
            r1.setArcHeight(30);
            r1.setArcWidth(25);
            Image im1_4=new Image("F:\\result management\\OIG-removebg-preview.png");
            ImageView im1=new ImageView(im1_4);
            im1.setFitHeight(120);
            im1.setPreserveRatio(true);
            im1.setTranslateX(215);
            im1.setTranslateY(180);
            r1.setOnMouseClicked(e->{
                stage.hide();
                new uploadMarks(obj.cid1,tid);// to be checked later
            });
            im1.setOnMouseClicked(e->{
                stage.hide();
                new uploadMarks(obj.cid1,tid);// to be checked later
            });


            Label l1=new Label(obj.cid1+"");
            l1.setFont(Font.font("bold", FontWeight.BOLD,25));
            l1.setTextFill(Color.WHITE);
            l1.setTranslateX(215);
            l1.setTranslateY(150);

            subgrp1.getChildren().addAll(r1,im1,l1);
        }
        if(cnt >= 2){

            Rectangle r2=new Rectangle(180,180,Color.WHITE);
            r2.setTranslateX(390);
            r2.setTranslateY(150);
            r2.setOpacity(0.2);
            r2.setArcHeight(30);
            r2.setArcWidth(25);
            Image im2_4=new Image("F:\\result management\\OIG-removebg-preview.png");
            ImageView im2=new ImageView(im2_4);
            im2.setFitHeight(120);
            im2.setPreserveRatio(true);
            im2.setTranslateX(415);
            im2.setTranslateY(180);

            r2.setOnMouseClicked(e->{
                stage.hide();
                new uploadMarks(obj.cid2,tid);// to be checked later
            });
            im2.setOnMouseClicked(e->{
                stage.hide();
                new uploadMarks(obj.cid2,tid);// to be checked later
            });

            Label l2=new Label(obj.cid2+"");
            l2.setFont(Font.font("bold", FontWeight.BOLD,25));
            l2.setTextFill(Color.WHITE);
            l2.setTranslateX(415);
            l2.setTranslateY(150);
            subgrp1.getChildren().addAll(r2,im2,l2);

        }
        if(cnt >= 3){

            Rectangle r3=new Rectangle(180,180,Color.WHITE);
            r3.setTranslateX(590);
            r3.setTranslateY(150);
            r3.setOpacity(0.2);
            r3.setArcHeight(30);
            r3.setArcWidth(25);
            Image im3_4=new Image("F:\\result management\\OIG-removebg-preview.png");
            ImageView im3=new ImageView(im3_4);
            im3.setFitHeight(120);
            im3.setPreserveRatio(true);
            im3.setTranslateX(615);
            im3.setTranslateY(180);


            r3.setOnMouseClicked(e->{
                stage.hide();
                new uploadMarks(obj.cid3,tid);// to be checked later
            });
            im3.setOnMouseClicked(e->{
                stage.hide();
                new uploadMarks(obj.cid3,tid);// to be checked later
            });

            Label l3=new Label(obj.cid3+"");
            l3.setFont(Font.font("bold", FontWeight.BOLD,25));
            l3.setTextFill(Color.WHITE);
            l3.setTranslateX(615);
            l3.setTranslateY(150);
            subgrp1.getChildren().addAll(r3,im3,l3);

        }else{
            Label l3=new Label("No Course Allotted !!");
            l3.setFont(Font.font("bold", FontWeight.BOLD,25));
            l3.setTextFill(Color.WHITE);
            l3.setTranslateX(325);
            l3.setTranslateY(150);
            subgrp1.getChildren().addAll(l3);
        }

        subgrp1.setTranslateX(140);
        subgrp1.setTranslateY(80);
        root.getChildren().add(subgrp1);

        Scene sc = new Scene(root, Color.rgb(33, 27, 51));
        stage.setHeight(700);
        stage.setWidth(1200);
        stage.setScene(sc);
        stage.show();
    }
}
