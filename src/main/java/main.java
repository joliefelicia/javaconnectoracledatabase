import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            database_student db = new database_student();
            ArrayList<student> students=db.selectStudent();
            int pilihan;
            String fullname,username;
            int id;
            Scanner s=new Scanner (System.in);
            char mau;
            System.out.println("Database is connected: "+db.isConnected());
            do {
                System.out.println("menu: \n1. insert\n2. update by id\n3. delete from id\n4 ArrayList\n" +
                        "pilihan: ");
                pilihan = s.nextInt();
                if (pilihan == 1) {
                    System.out.println("username: ");
                    username = s.nextLine();
                    username= s.nextLine();
                    System.out.println("fullname: ");
                    fullname = s.nextLine();
                    System.out.print(username);
                    System.out.println(fullname);
                    db.insertStudents(username, fullname);

                }
                if (pilihan == 2) {
                    System.out.println("username: ");
                    username = s.nextLine();
                    username = s.nextLine();
                    System.out.println("id: ");
                    id = s.nextInt();
                    fullname = s.nextLine();
                    System.out.println("fullname: ");
                    fullname = s.nextLine();
                    db.updateStudents(id,username,fullname);


                }

                if (pilihan == 3) {
                    System.out.println("id:");
                    id = s.nextInt();
                    db.deleteUser(id);


                }
                if(pilihan==4){
                    students=db.selectStudent();
                    for(student st:students){
                        System.out.println(st.getId()+" "+st.getUsername()+" "+st.getFullname());
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


