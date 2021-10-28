package BAI_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String email;
    private double bonus;
    private double report;
    private double app;
    private double lt;
    private double total;

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
                ", report =" + st.report + ", app =" + st.app + ", lt =" + st.lt +"]";
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
            student = new Student(Integer.parseInt(split[0]), split[1], split[2], Integer.parseInt(split[3])
                    , Integer.parseInt(split[4]), Integer.parseInt(split[5]), Double.parseDouble(split[6]));
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

    public static ArrayList<Student> tenHighestPointLT(ArrayList<Student> list) {
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).lt < list.get(i).lt) {
                    Student a = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, a);
                }
            }
        }
        int size = list.size();
        for (int i = size - 10; i < size; i++) {
            arrayList.add(list.get(i));
        }
        printList(arrayList);
        return arrayList;
    }

    public static double totalPoint(Student student) {
        double result = 0;
        result = student.bonus * 0.1 + student.report * 0.3 + student.app * 0.15 + student.lt * 0.45;
        result = Math.ceil(result * 100) / 100;
        student.setTotal(result);
        return result;
    }

    public static void top10LowerPoitTotal(List<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(totalPoint(o1), totalPoint(o2));
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(toString(list.get(i)));
            if (i == 9)
                break;
        }
    }

    public static void output(ArrayList<Student> list) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("." + File.separator + "output.csv"));
        bufferedWriter.write("ID,name,email,bonus,report,app,lt,total\n");
        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.get(i).id + "," + list.get(i).name + "," + list.get(i).email + "," + list.get(i).bonus + ","
                    + list.get(i).report + "," + list.get(i).app + "," + list.get(i).lt + "," + list.get(i).total + "\n");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        System.out.println("DONE");
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getReport() {
        return report;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public double getApp() {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
