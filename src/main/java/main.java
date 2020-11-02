import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        try {
            database_student db = new database_student();
            int id,pilihan;
            String username,fullname;
            Scanner s=new Scanner (System.in);
            char mau;
            System.out.println("Database is connected: "+db.isConnected());
            do {
                System.out.println("menu: \n1. insert\n2. update by id\n3. update by username\n4. delete from id\n5.ArrayList\n" +
                        "pilihan: ");
                pilihan = s.nextInt();
                if (pilihan == 1) {
                    username = s.nextLine();
                    System.out.println("username: ");
                    username = s.nextLine();
                    System.out.println("id: ");
                    id = s.nextInt();
                    fullname = s.nextLine();
                    System.out.println("fullname: ");
                    fullname = s.nextLine();
                    db.insertStudents(id, username, fullname);
                }
                if (pilihan == 2) {
                    username = s.nextLine();
                    System.out.println("username: ");
                    username = s.nextLine();
                    System.out.println("id: ");
                    id = s.nextInt();
                    fullname = s.nextLine();
                    System.out.println("fullname: ");
                    fullname = s.nextLine();
                    db.updateStudents(id, username, fullname);
                }
                if (pilihan == 3) {
                    username = s.nextLine();
                    System.out.println("username: ");
                    username = s.nextLine();
                    System.out.println("id: ");
                    id = s.nextInt();
                    fullname = s.nextLine();
                    System.out.println("fullname: ");
                    fullname = s.nextLine();
                    db.updateStudentswithusername(id, username, fullname);
                }

                if (pilihan == 4) {
                    System.out.println("id:");
                    id = s.nextInt();
                    db.deleteUser(id);
                }
                if(pilihan==5){
                    ArrayList<student> students=db.selectStudent();
                    for(student student:students){
                        System.out.println(student.getId()+" "+student.getUsername()+" "+student.getFullname());
                    }
                }

                System.out.println("apakah anda mau  lagi= ");
                mau = s.next().charAt(0);

            }while(mau=='y'||mau=='Y');
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }



    }
}
