package com.result.result_manage;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
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

public class WelPage {
    WelPage(int roll){
        Stage st = new Stage();
        Group root = new Group();
        Scene sc = new Scene(root, Color.rgb(33, 27, 51));

        new MenuFinal(root,st,roll);

        Image icon = new Image("F:\\result management\\mortarboard (1).png");
        ImageView img = new ImageView(icon);
        img.setFitWidth(50);
        img.setFitHeight(50);

        Rectangle r = new Rectangle(1000,90,Color.rgb(250, 27, 87));
        r.setArcHeight(25);
        r.setArcWidth(25);
        r.setTranslateY(19);
        r.setTranslateX(100);

        root.getChildren().add(r);

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

        root.getChildren().addAll(cr1_3,cr2_3,cr3_3,cr4_3,cr5_3,cr6_3);

        Circle cr1 = new Circle(30,Color.rgb(250, 27, 87));
        cr1.setTranslateX(1140);
        cr1.setTranslateY(150);


        Circle cr2 = new Circle(25,Color.rgb(250, 27, 87));
        cr2.setTranslateX(1140);
        cr2.setTranslateY(250);


        Circle cr3 = new Circle(20,Color.rgb(250, 27, 87));
        cr3.setTranslateX(1140);
        cr3.setTranslateY(350);


        Circle cr4 = new Circle(15,Color.rgb(250, 27, 87));
        cr4.setTranslateX(1140);
        cr4.setTranslateY(450);


        Circle cr5 = new Circle(10,Color.rgb(250, 27, 87));
        cr5.setTranslateX(1140);
        cr5.setTranslateY(530);

        Circle cr6 = new Circle(5,Color.rgb(250, 27, 87));
        cr6.setTranslateX(1140);
        cr6.setTranslateY(610);

        root.getChildren().addAll(cr1,cr2,cr3,cr4,cr5,cr6);

        Label l1 = new Label("Academic Performance",img);
        l1.setFont(Font.font("Aerial", FontWeight.BOLD, FontPosture.REGULAR,25));
        l1.setTextFill(Color.WHITE);
        Insets in = new Insets(14);
        l1.setPadding(in);
        l1.setBackground(Background.fill(Color.rgb(250, 27, 87)));
        l1.setTranslateY(20);
        l1.setTranslateX(400);


        final NumberAxis xaxis = new NumberAxis(0,10,0.5);
        final NumberAxis yaxis = new NumberAxis(0,11.5,0.1);

        //Defining Label for Axis


        //Creating the instance of linechart with the specified axis
        LineChart linechart = new LineChart(xaxis, yaxis);

        //creating the series
        XYChart.Series series = new XYChart.Series();

        //setting name and the date to the series
        series.setName("SGPA");
//        series.getData().add(new XYChart.Data(1,9.2));
//        series.getData().add(new XYChart.Data(2,9.6));
//        series.getData().add(new XYChart.Data(3,9.8));
//        series.getData().add(new XYChart.Data(4,9.2));
//        series.getData().add(new XYChart.Data(5,9.0));
//        series.getData().add(new XYChart.Data(6,8.6));
//        series.getData().add(new XYChart.Data(7,9.6));
//        series.getData().add(new XYChart.Data(8,9.4));

        WelStuCgpa welmap = new WelStuCgpa(roll);
        for(int i = 0;i<8;i++)
        {
            series.getData().add(new XYChart.Data(i+1,welmap.map.get(i+1)));
        }


        Rectangle rc= new Rectangle(600,430,Color.WHITE);
        rc.setOpacity(0.4);
        rc.setTranslateX(280);
        rc.setTranslateY(130);
        CornerRadii cr = new CornerRadii(25);
        BorderStroke bs = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,cr, BorderWidths.DEFAULT);
        rc.setArcWidth(25);
        rc.setArcHeight(25);


        root.getChildren().add(rc);


        //adding series to the linechart
        linechart.getData().add(series);
//        linechart.setBackground(Background.fill(Color.rgb(250, 27, 87)));
        linechart.setCreateSymbols(true);
        linechart.setTranslateX(300);
        linechart.setTranslateY(150);

        Label x = new Label("SGPA");
        Label y = new Label("SEMESTER");
        x.setFont(Font.font("Aerial",FontWeight.BOLD,FontPosture.REGULAR,20));
        y.setFont(Font.font("Aerial",FontWeight.BOLD,FontPosture.REGULAR,20));

        xaxis.setLabel("Semester");
        yaxis.setLabel("SGPA");

        root.getChildren().add(l1);
        root.getChildren().add(linechart);

        st.setHeight(700);
        st.setWidth(1200);
        st.setScene(sc);
        st.show();
    }
}
