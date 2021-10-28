package BAI_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private String email;
    private int bonus;
    private int report;
    private int app;
    private double lt;

    public Student(int id, String name, String email, int bonus, int report, int app, double lt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
    }

    public Student() {
    }

    public static String toString(Student st) {
        return "Student [id =" + st.id + ", name =" + st.name + ", email =" + st.email + ", bonus =" + st.bonus +
                ", report =" + st.report + ", app =" + st.app + ", lt =" + st.lt + "]";
    }

    public static ArrayList<Student> readStudent(String nameFile) throws IOException {
        String re = "";
        String[] split;
        String line;
        Student student = null;
        ArrayList<Student> arrStudent = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile));
        while ((line = bufferedReader.readLine()) != null) {
            re = line;
            split = re.split(",");
//            for (int i = 0; i < 7; i++) {
                student = new Student(Integer.parseInt(split[0]), split[1], split[2], Integer.parseInt(split[3])
                        , Integer.parseInt(split[4]), Integer.parseInt(split[5]), Double.parseDouble(split[6]));
//            }
            arrStudent.add(student);
        }
        bufferedReader.close();
        return arrStudent;
    }

    public static void printList(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(toString(list.get(i)));
        }
    }

    public static boolean findMin(ArrayList<Student> list, double pointLT) {
        int i = 0;
        while (i != list.size()) {
            if (pointLT > list.get(i).lt) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean findMinTotal(ArrayList<Student> list, double pointTotal) {
        int i = 0;
        while (i != list.size()) {
            if (pointTotal > totalPoint(list.get(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static ArrayList<Student> tenHighestPointLT(ArrayList<Student> list) {
        ArrayList<Student> arrayList = new ArrayList<>();
        while (!findMin(list, list.get(0).lt)) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1).lt < list.get(i).lt) {
                    Student a = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, a);
                }
            }
        }
        int size = list.size();
        for (int i = size - 10; i < size; i++) {
           arrayList.add(list.get(i));
        }
        System.out.println(arrayList.size() + "---");
        printList(arrayList);
        return arrayList;
    }

    public static double totalPoint(Student student) {
        double result = 0;
        System.out.println(toString(student));
        result = student.bonus * 0.1 + student.report * 0.3 + student.app * 0.15 + student.lt * 0.45;
        result = Math.ceil(result*100)/100;
        return result;
    }

    public static ArrayList<Student> tenLowerPointTK(ArrayList<Student> list){
        ArrayList<Student> arrayList = new ArrayList<>();
        while (!findMin(list, totalPoint(list.get(0)))) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (totalPoint(list.get(i + 1)) < totalPoint(list.get(i))) {
                    Student a = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, a);
                }
            }
        }
        int size = list.size();
        for (int i = 0; i < 10; i++) {
            arrayList.add(list.get(i));
        }
        System.out.println(arrayList.size() + "---");
        printList(arrayList);
        return arrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public int getApp() {
        return app;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

}
