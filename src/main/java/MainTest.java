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
//        ArrayList<Student> list3 = Student.readStudent("data.csv");
        for (int i = 0; i < list.size();i++){
            System.out.println("id = "+list.get(i).getId()+"\ttotal score = "
                    + Student.totalPoint(list.get(i)));
        }

//        /**10 sv có tổng điểm thấp nhất*/
        System.out.println("------------10 students with the lowest scores-----------");
////        Student.tenLowerPointTK(list);
        Student.top10LowerPoitTotal(Student.readStudent("data.csv"));

        /**Lưu file**/
        Student.output(list);

        /**Xuất danh sách sinh viên vào file*/

        /**Câu 2*/
        System.out.println("------------Câu 2");
        System.out.println(BAI_2.checkGmail("oanhmpp@gmail.com"));

        System.out.println("------------Has Email");
        Student.printList(BAI_2.listedHasEmail(list));
    }
}
