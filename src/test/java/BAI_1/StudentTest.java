package BAI_1;

import BAI_2.BAI_2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Test total point")
    void totalPoint() {
        double actual = Student.totalPoint(new Student(17130160,"Nguyen Van A","a@gmail.com",0,0,0,4.5));
        double expect = 2.03;
        System.out.println(actual);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Test total point")
    void totalPoint2() {
        double actual = Student.totalPoint(new Student(17130160,"Nguyen Van A","a@gmail.com",0,0,0,10));
        double expect = 4.5;
        System.out.println(actual);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Test total point")
    void totalPoint3() {
        double actual = Student.totalPoint(new Student(17130160,"Nguyen Van A","a@gmail.com",0,0,0,5.5));
        double expect = 6.28;
        System.out.println(actual);
        Assertions.assertEquals(expect, actual);
    }

}