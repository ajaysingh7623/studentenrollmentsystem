/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import stmgmt.dbutil.DBConnection;
import stmgmt.pojo.StudentInfo;

/**
 *
 * @author admin
 */
public class StudentDAO {
    public static boolean addStudent(StudentInfo st) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into student values (?,?,?,?,?)");
        ps.setString(1,st.getName());
        ps.setInt(2,st.getRoll());
        ps.setInt(3,st.getMarks());
        ps.setInt(4,st.getAge());
        ps.setString(5,st.getGender());
        int ans=ps.executeUpdate();
        if(ans!=0){
            return true;
        }
        else
            return false;
    }
    
    public static boolean deleteStudent(int roll) throws SQLException{
         Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from student where roll=?");
        ps.setInt(1,roll);
        int ans=ps.executeUpdate();
        if(ans!=0){
            return true;
        }
        else
            return false;
    }
    
    public static ArrayList<StudentInfo> getStudents() throws SQLException{
        Connection conn=DBConnection.getConnection();
        ArrayList<StudentInfo> stlist=new ArrayList<>();
        PreparedStatement ps=conn.prepareStatement("select * from student");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            StudentInfo std=new StudentInfo();
            std.setName(rs.getString(1));
            std.setRoll(rs.getInt(2));
            std.setMarks(rs.getInt(3));
            std.setAge(rs.getInt(4));
            std.setGender(rs.getString(5));
            stlist.add(std);
        }
        return stlist;
    }

       public static StudentInfo searchstudent(String name) throws SQLException{
       Connection conn=DBConnection.getConnection();
       StudentInfo st=new StudentInfo(); 
       PreparedStatement ps=conn.prepareStatement("select * from student where Stud_name=?");
        ps.setString(1,name);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
String s=rs.getString(1);
int s1=rs.getInt(2);
int s2=rs.getInt(3);
int s3=rs.getInt(4);
String s4=rs.getString(5);
st.setRoll(s1);
st.setName(s);
st.setMarks(s2);
st.setGender(s4);
st.setAge(s3);
}
   return st;
       }


public static boolean loginUser(String id,String pwd) throws SQLException{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("select username from userinfo where username=? and password=?");
    ps.setString(1,id);
    ps.setString(2,pwd);
    ResultSet rs=ps.executeQuery();
    if(rs.next())
        return true;
    else
    return false;
}
public static boolean registration(String name,String password) throws SQLException{
 Connection conn=DBConnection.getConnection();
 PreparedStatement ps=conn.prepareStatement("insert into userinfo values(?,?)");
 ps.setString(1, name);
 ps.setString(2, password);
 ResultSet rs=ps.executeQuery();
 if(rs.next())
     return true;
 else
     return false;
}
public static boolean updatestudent(StudentInfo st) throws SQLException{
 Connection conn=DBConnection.getConnection();
 PreparedStatement ps=conn.prepareStatement("update student set stud_name=?,roll=?,marks=?,age=?,sex=? where stud_name=?");

        ps.setString(1,st.getName());
        ps.setInt(2,st.getRoll());
        ps.setInt(3,st.getMarks());
        ps.setInt(4,st.getAge());
        ps.setString(5,st.getGender());
        ps.setString(6,st.getName());
        int ans=ps.executeUpdate();
        if(ans!=0){
            return true;
        }
        else
            return false;
}

    
}


