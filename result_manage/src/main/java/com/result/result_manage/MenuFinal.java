package com.result.result_manage;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class MenuFinal {
    MenuFinal(Group root, Stage st,int roll)
    {


        Circle[]cr = new Circle[4];
        for (int i =0;i<4;i++)
        {
            cr[i] = new Circle();
            cr[i].setRadius(30);
            cr[i].setFill(Color.GRAY);
            cr[i].setTranslateX(80);
            cr[i].setTranslateY(600);
        }

        cr[0].setFill(Color.rgb(189, 125, 241));
        cr[1].setFill(Color.rgb(234, 216, 122));
        cr[2].setFill(Color.rgb(222, 125, 69));

//        cr[0].setFill(Color.GRAY);
//        cr[1].setFill(Color.GRAY);
//        cr[2].setFill(Color.GRAY);

        Circle cr5 = new Circle();
        cr5.setRadius(30);
        cr5.setFill(Color.GRAY);
        cr5.setTranslateX(80);
        cr5.setTranslateY(600);





        Image icon = new Image("F:\\result management\\menu (1).png");
        if (icon.isError())
        {
            System.out.println("cant load");
        }
        ImageView img = new ImageView(icon);
        img.setFitHeight(30);
        img.setFitWidth(30);
        img.setTranslateY(586);
        img.setTranslateX(65);

        Image icon2 = new Image("F:\\result management\\profile.png");
        ImageView img2 = new ImageView(icon2);
        img2.setFitHeight(30);
        img2.setFitWidth(30);
        img2.setTranslateY(586);
        img2.setTranslateX(65);


        Image icon3 = new Image("F:\\result management\\close-button (1).png");
        ImageView img3 = new ImageView(icon3);
        img3.setFitHeight(30);
        img3.setFitWidth(30);
        img3.setTranslateY(586);
        img3.setTranslateX(65);

        Image icon4 = new Image("F:\\result management\\exam.png");
        ImageView img4 = new ImageView(icon4);
        img4.setFitHeight(30);
        img4.setFitWidth(30);
        img4.setTranslateY(586);
        img4.setTranslateX(65);

        Image icon5 = new Image("F:\\result management\\back-arrow.png");
        ImageView img5 = new ImageView(icon5);
        img5.setFitHeight(30);
        img5.setFitWidth(30);
        img5.setTranslateY(586);
        img5.setTranslateX(65);

        cr[0].setOnMouseClicked(e->{
            st.hide();
            new profileIn(roll);
        });
        img2.setOnMouseClicked(e->{
            st.hide();
            new profileIn(roll);
        });

        cr[1].setOnMouseClicked(e->{
            st.hide();
            try {
                new Semui(roll);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        });
        img4.setOnMouseClicked(e->{
            st.hide();
            try {
                new Semui(roll);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        });

        cr[2].setOnMouseClicked(e->{
            st.hide();
            new WelPage(roll);
        });
        img5.setOnMouseClicked(e->{
            st.hide();
            new WelPage(roll);
        });

        cr5.setOnMouseClicked(e->{

            root.getChildren().removeAll(cr5);
            root.getChildren().removeAll(img3);
            animation2(cr,img2,img4,img5);
            root.getChildren().removeAll(img2);
            root.getChildren().removeAll(img4);
            root.getChildren().removeAll(img5);
        });

        img3.setOnMouseClicked(e->{

            root.getChildren().removeAll(cr5);
            root.getChildren().removeAll(img3);
            animation2(cr,img2,img4,img5);
            root.getChildren().removeAll(img2);
            root.getChildren().removeAll(img4);
            root.getChildren().removeAll(img5);
        });

        img.setOnMouseClicked(e->{
            root.getChildren().add(img2);
            root.getChildren().add(cr5);

            root.getChildren().add(img4);
            root.getChildren().add(img3);
            root.getChildren().add(img5);
            animation1(cr,img2,img4,img5);
        });

        cr[3].setOnMouseClicked(e->{
            root.getChildren().add(img2);

            root.getChildren().add(cr5);
            root.getChildren().add(img4);
            root.getChildren().add(img3);
            root.getChildren().add(img5);
            animation1(cr,img2,img4,img5);
        });

        root.getChildren().addAll(cr);
        root.getChildren().add(img);

    }

    void animation1(Circle []cr,ImageView img1,ImageView img2,ImageView img3)
    {
        TranslateTransition tr = new TranslateTransition();
        tr.setDuration(Duration.millis(700));
        tr.setNode(cr[0]);
        tr.setByX(100);
        tr.setByY(-90);
        tr.setAutoReverse(false);
        tr.play();

        TranslateTransition tri2 = new TranslateTransition();
        tri2.setDuration(Duration.millis(700));
        tri2.setNode(img1);
        tri2.setByX(100);
        tri2.setByY(-90);
        tri2.setAutoReverse(false);
        tri2.play();

        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.millis(700));
        tr1.setNode(cr[1]);
        tr1.setByY(-120);
        tr1.setAutoReverse(false);
        tr1.play();

        TranslateTransition tri3 = new TranslateTransition();
        tri3.setDuration(Duration.millis(700));
        tri3.setNode(img2);
        tri3.setByY(-120);
//        tri3.setByX(-15);
        tri3.setAutoReverse(false);
        tri3.play();

        TranslateTransition tr2 = new TranslateTransition();
        tr2.setDuration(Duration.millis(700));
        tr2.setNode(cr[2]);
        tr2.setByX(140);
        tr2.setAutoReverse(false);
        tr2.play();

        TranslateTransition tri4 = new TranslateTransition();
        tri4.setDuration(Duration.millis(700));
        tri4.setNode(img3);
        tri4.setByX(140);
//        tri4.setByY(-15);
        tri4.setAutoReverse(false);
        tri4.play();
    }


    void animation2(Circle []cr,ImageView img1,ImageView img2,ImageView img3)
    {
        TranslateTransition tr = new TranslateTransition();
        tr.setDuration(Duration.millis(700));
        tr.setNode(cr[0]);
        tr.setByX(-100);
        tr.setByY(+90);
        tr.setAutoReverse(false);
        tr.play();

        TranslateTransition tri2 = new TranslateTransition();
        tri2.setDuration(Duration.millis(700));
        tri2.setNode(img1);
        tri2.setByX(-100);
        tri2.setByY(+90);
        tri2.setAutoReverse(false);
        tri2.play();

        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.millis(700));
        tr1.setNode(cr[1]);
        tr1.setByY(+120);
        tr1.setAutoReverse(false);
        tr1.play();
        TranslateTransition tri3 = new TranslateTransition();
        tri3.setDuration(Duration.millis(700));
        tri3.setNode(img2);
        tri3.setByY(+120);
//        tri3.setByX(+15);
        tri3.setAutoReverse(false);
        tri3.play();

        TranslateTransition tr2 = new TranslateTransition();
        tr2.setDuration(Duration.millis(700));
        tr2.setNode(cr[2]);
        tr2.setByX(-140);
        tr2.setAutoReverse(false);
        tr2.play();

        TranslateTransition tri4 = new TranslateTransition();
        tri4.setDuration(Duration.millis(700));
        tri4.setNode(img3);
        tri4.setByX(-140);
//        tri4.setByY(15);
        tri4.setAutoReverse(false);
        tri4.play();
    }
}
