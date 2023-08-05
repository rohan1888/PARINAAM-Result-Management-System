package com.result.result_manage;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Conn_Data1{
    public Connection c;
    public Statement s;
    public Conn_Data1()
    {
        try{
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/result_management","root","Abc123@#");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}




