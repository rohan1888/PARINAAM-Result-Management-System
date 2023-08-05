package com.result.result_manage;

import javafx.application.Application;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Group root = new Group();

        //root.getChildren().add(l);
        Rectangle rc = new Rectangle(450,250,Color.rgb(250, 27, 87));
        rc.setRotate(45);
        rc.setTranslateX(200);
        rc.setTranslateY(-150);
        rc.setArcWidth(75);
        rc.setArcHeight(75);

        root.getChildren().add(rc);

        Label t1_4=new Label("STUDENTS LOGIN ");
        t1_4.setFont(Font.font("bold", FontWeight.BOLD,20));
        t1_4.setTextFill(Color.WHITE);
        t1_4.setTranslateX(300);
        t1_4.setTranslateY(210);
        Rectangle rc1 = new Rectangle(280,300,Color.WHITE);

        Image im1_4=new Image(new FileInputStream("F:\\result management\\graduated.png"));
        ImageView im_4=new ImageView(im1_4);
        im_4.setFitHeight(150);
        im_4.setPreserveRatio(true);
        im_4.setTranslateX(310);
        im_4.setTranslateY(260);
        rc1.setTranslateX(250);
        rc1.setTranslateY(180);
        rc1.setArcHeight(30);
        rc1.setArcWidth(25);
        rc1.setOpacity(0.2);

        root.getChildren().addAll(rc1,im_4,t1_4);

        //clicking Feature
        rc1.setOnMouseClicked(e->{
            stage.hide();
            try {
                new login();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        im_4.setOnMouseClicked(e->{
            stage.hide();
            try {
                new login();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Label t2_4=new Label("TEACHERS LOGIN ");
        t2_4.setFont(Font.font("bold", FontWeight.BOLD,20));
        t2_4.setTextFill(Color.WHITE);
        t2_4.setTranslateX(740);
        t2_4.setTranslateY(210);
        Image im2_4=new Image(new FileInputStream("F:\\result management\\teacher (1).png"));
        ImageView imv2_4=new ImageView(im2_4);
        imv2_4.setFitHeight(150);
        imv2_4.setPreserveRatio(true);
        imv2_4.setTranslateX(750);
        imv2_4.setTranslateY(260);
        Rectangle rc2 = new Rectangle(280,300, Color.WHITE);
        rc2.setTranslateX(680);
        rc2.setTranslateY(180);
        rc2.setArcHeight(30);
        rc2.setArcWidth(25);
        rc2.setOpacity(0.2);

        root.getChildren().addAll(rc2,imv2_4,t2_4);
        //clicking Feature
        rc2.setOnMouseClicked(e->{
            stage.hide();
            try {
                new loginteac();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });


        imv2_4.setOnMouseClicked(e->{
            stage.hide();
            try {
                new loginteac();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        Scene sc = new Scene(root, Color.rgb(33, 27, 51));
        stage.setHeight(700);
        stage.setWidth(1200);
        stage.setScene(sc);
        stage.show();


    }
}
