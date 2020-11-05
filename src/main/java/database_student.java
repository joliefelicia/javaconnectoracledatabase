import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class database_student {
private Connection db;
    public database_student() throws SQLException, ClassNotFoundException {

            Class.forName("oracle.jdbc.driver.OracleDriver");



        db=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","user","password");

    }

    public boolean isConnected(){
        return( db != null);
    }

    public void insertStudents(int id,String username, String fullname)throws SQLException{
String sql="INSERT into students(id,username,fullname) values (?,?,?)";
        PreparedStatement s=db.prepareStatement(sql);
        s.setInt(1,id);
        s.setString(2,username);
        s.setString(3,fullname);
        s.execute();
    }

public void updateStudents(int id,String username, String fullname)throws SQLException{
        String sql="UPDATE students set username=?, fullname=? where id=?";
    PreparedStatement s=db.prepareStatement(sql);
    s.setString(1,username);
    s.setString(2,fullname);
    s.setInt(3,id);
    s.execute();

}

    public void updateStudentswithusername(int id,String username, String fullname)throws SQLException{
        String sql="UPDATE students set fullname=?, id=? where username=?";
        PreparedStatement s=db.prepareStatement(sql);
        s.setString(1,fullname);
        s.setInt(2,id);
        s.setString(3,username);
        s.execute();

    }

public void deleteUser(int id ) throws SQLException{
        String sql="DELETE FROM students where id=? ";
    PreparedStatement s=db.prepareStatement(sql);
    s.setInt(1, id);
    s.execute();
    }


public ArrayList<student> selectStudent()throws SQLException{
        String sql="SELECT * FROM students";
    PreparedStatement s=db.prepareStatement(sql);
    ResultSet rs=s.executeQuery(sql);

    ArrayList<student>retval=new ArrayList<>();

    while (rs.next()){
        student student=new student(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("fullname")

        );
        retval.add(student);

    }
return retval;
}



}

