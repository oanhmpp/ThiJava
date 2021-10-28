package BAI_2;

import BAI_1.Student;

import java.util.ArrayList;

public class BAI_2 {

    /**1 Chuỗi regex*/
    public static boolean checkGmail (String s){
        String regex = "[a-zA-Z0-9-]{3,15}@[a-z].?[a-z]{2,}.[a-z]{2,}";
        return s.matches(regex);
    }

    public static ArrayList<Student> listedHasEmail(ArrayList<Student> list){
        ArrayList<Student> result = new ArrayList<>();
        for(int i = 0; i<list.size();i++){
            if(checkGmail(list.get(i).getEmail())){
                result.add(list.get(i));
            }
        }
        return result;
    }
}
