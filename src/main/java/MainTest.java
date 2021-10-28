import BAI_1.Student;
import BAI_2.BAI_2;

import java.io.IOException;
import java.util.ArrayList;

public class MainTest {
    private static ArrayList<Student> list;
    public static void main(String[] args) throws IOException {
        /**Câu 1*/
        /**Đọc file*/
        System.out.println("-----------Read file-----------");
        ArrayList<Student> studentsList = new ArrayList<>();
        list = Student.readStudent("data.csv");
        Student.printList(list);

        /**Lọc 10 sv điểm cao nhất*/
        System.out.println("-----------Top 10 students with the highest scores-----------");
        Student.tenHighestPointLT(Student.readStudent("data.csv"));

        /**Tính tổng điểm*/
        System.out.println("-----------Total score-----------");
        ArrayList<Student> list3 = Student.readStudent("data.csv");
        for (int i = 0; i < list3.size();i++){
            System.out.println("id = "+list3.get(i).getId() +"\ttotal score = "
                    + Student.totalPoint(list3.get(i)));
        }

        /**10 sv có tổng điểm thấp nhất*/
        System.out.println("------------10 students with the lowest scores-----------");
        Student.tenLowerPointTK(Student.readStudent("data.csv"));

        /**Câu 2*/
        System.out.println("------------Câu 2");
        System.out.println(BAI_2.checkGmail("oanhmpp@gmail.com"));

    }
}
