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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Semui {
    Semui(int roll) throws FileNotFoundException {
        Stage stage = new Stage();
        Group root = new Group();


        new MenuFinal(root,stage,roll);

        //root.getChildren().add(l);
        Rectangle rc = new Rectangle(450,250, Color.rgb(250, 27, 87));
        rc.setRotate(45);
        rc.setTranslateX(200);
        rc.setTranslateY(-150);
        rc.setArcWidth(75);
        rc.setArcHeight(75);
        root.getChildren().add(rc);

        Rectangle r1=new Rectangle(150,150,Color.WHITE);
        r1.setTranslateX(190);
        r1.setTranslateY(150);
        r1.setOpacity(0.2);
        r1.setArcHeight(30);
        r1.setArcWidth(25);
        Image im1_4=new Image(new FileInputStream("F:\\result management\\1.png"));
        ImageView im1=new ImageView(im1_4);
        im1.setFitHeight(100);
        im1.setPreserveRatio(true);
        im1.setTranslateX(215);
        im1.setTranslateY(180);
        r1.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,1);
        });
        im1.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,1);
        });


        Label l1=new Label("SEMESTER");
        l1.setFont(Font.font("bold", FontWeight.BOLD,20));
        l1.setTextFill(Color.WHITE);
        l1.setTranslateX(215);
        l1.setTranslateY(150);

        root.getChildren().addAll(r1,im1,l1);

        Rectangle r2=new Rectangle(150,150,Color.WHITE);
        r2.setTranslateX(390);
        r2.setTranslateY(150);
        r2.setOpacity(0.2);
        r2.setArcHeight(30);
        r2.setArcWidth(25);
        Image im2_4=new Image(new FileInputStream("F:\\result management\\2.png"));
        ImageView im2=new ImageView(im2_4);
        im2.setFitHeight(90);
        im2.setPreserveRatio(true);
        im2.setTranslateX(415);
        im2.setTranslateY(180);

        r2.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,2);
        });
        im2.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,2);
        });

        Label l2=new Label("SEMESTER");
        l2.setFont(Font.font("bold", FontWeight.BOLD,20));
        l2.setTextFill(Color.WHITE);
        l2.setTranslateX(415);
        l2.setTranslateY(150);
        root.getChildren().addAll(r2,im2,l2);

        Rectangle r3=new Rectangle(150,150,Color.WHITE);
        r3.setTranslateX(590);
        r3.setTranslateY(150);
        r3.setOpacity(0.2);
        r3.setArcHeight(30);
        r3.setArcWidth(25);
        Image im3_4=new Image(new FileInputStream("F:\\result management\\3.png"));
        ImageView im3=new ImageView(im3_4);
        im3.setFitHeight(90);
        im3.setPreserveRatio(true);
        im3.setTranslateX(615);
        im3.setTranslateY(180);


        r3.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,3);
        });
        im3.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,3);
        });

        Label l3=new Label("SEMESTER");
        l3.setFont(Font.font("bold", FontWeight.BOLD,20));
        l3.setTextFill(Color.WHITE);
        l3.setTranslateX(615);
        l3.setTranslateY(150);
        root.getChildren().addAll(r3,im3,l3);


        Rectangle r4=new Rectangle(150,150,Color.WHITE);
        r4.setTranslateX(790);
        r4.setTranslateY(150);
        r4.setOpacity(0.2);
        r4.setArcHeight(30);
        r4.setArcWidth(25);
        Image im4_4=new Image(new FileInputStream("F:\\result management\\4.png"));
        ImageView im4=new ImageView(im4_4);
        im4.setFitHeight(90);
        im4.setPreserveRatio(true);
        im4.setTranslateX(815);
        im4.setTranslateY(180);


        r4.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,4);
        });
        im4.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,4);
        });

        Label l4=new Label("SEMESTER");
        l4.setFont(Font.font("bold", FontWeight.BOLD,20));
        l4.setTextFill(Color.WHITE);
        l4.setTranslateX(815);
        l4.setTranslateY(150);
        root.getChildren().addAll(r4,im4,l4);

        Rectangle r5=new Rectangle(150,150,Color.WHITE);
        r5.setTranslateX(190);
        r5.setTranslateY(350);
        r5.setOpacity(0.2);
        r5.setArcHeight(30);
        r5.setArcWidth(25);
        Image im5_4=new Image(new FileInputStream("F:\\result management\\5.png"));
        ImageView im5=new ImageView(im5_4);
        im5.setFitHeight(100);
        im5.setPreserveRatio(true);
        im5.setTranslateX(215);
        im5.setTranslateY(380);

        r5.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,5);
        });
        im5.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,5);
        });

        Label l5=new Label("SEMESTER");
        l5.setFont(Font.font("bold", FontWeight.BOLD,20));
        l5.setTextFill(Color.WHITE);
        l5.setTranslateX(215);
        l5.setTranslateY(350);

        root.getChildren().addAll(r5,im5,l5);


        Rectangle r6=new Rectangle(150,150,Color.WHITE);
        r6.setTranslateX(390);
        r6.setTranslateY(350);
        r6.setOpacity(0.2);
        r6.setArcHeight(30);
        r6.setArcWidth(25);
        Image im6_4=new Image(new FileInputStream("F:\\result management\\6.png"));
        ImageView im6=new ImageView(im6_4);
        im6.setFitHeight(90);
        im6.setPreserveRatio(true);
        im6.setTranslateX(415);
        im6.setTranslateY(380);

        r6.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,6);
        });
        im6.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,6);
        });

        Label l6=new Label("SEMESTER");
        l6.setFont(Font.font("bold", FontWeight.BOLD,20));
        l6.setTextFill(Color.WHITE);
        l6.setTranslateX(415);
        l6.setTranslateY(350);
        root.getChildren().addAll(r6,im6,l6);


        Rectangle r7=new Rectangle(150,150,Color.WHITE);
        r7.setTranslateX(590);
        r7.setTranslateY(350);
        r7.setOpacity(0.2);
        r7.setArcHeight(30);
        r7.setArcWidth(25);
        Image im7_4=new Image(new FileInputStream("F:\\result management\\7.png"));
        ImageView im7=new ImageView(im7_4);
        im7.setFitHeight(90);
        im7.setPreserveRatio(true);
        im7.setTranslateX(615);
        im7.setTranslateY(380);


        r7.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,7);
        });
        im7.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,7);
        });

        Label l7=new Label("SEMESTER");
        l7.setFont(Font.font("bold", FontWeight.BOLD,20));
        l7.setTextFill(Color.WHITE);
        l7.setTranslateX(615);
        l7.setTranslateY(350);
        root.getChildren().addAll(r7,im7,l7);


        Rectangle r8=new Rectangle(150,150,Color.WHITE);
        r8.setTranslateX(790);
        r8.setTranslateY(350);
        r8.setOpacity(0.2);
        r8.setArcHeight(30);
        r8.setArcWidth(25);
        Image im8_4=new Image(new FileInputStream("F:\\result management\\8.png"));
        ImageView im8=new ImageView(im8_4);
        im8.setFitHeight(90);
        im8.setPreserveRatio(true);
        im8.setTranslateX(815);
        im8.setTranslateY(380);


        r8.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,8);
        });
        im8.setOnMouseClicked(e->{
            stage.hide();
            new ResultFinal(roll,8);
        });

        Label l8=new Label("SEMESTER");
        l8.setFont(Font.font("bold", FontWeight.BOLD,20));
        l8.setTextFill(Color.WHITE);
        l8.setTranslateX(815);
        l8.setTranslateY(350);
        root.getChildren().addAll(r8,im8,l8);





        Scene sc = new Scene(root, Color.rgb(33, 27, 51));
        stage.setHeight(700);
        stage.setWidth(1200);
        stage.setScene(sc);
        stage.show();
    }
}
