package BAI_2;

public class BAI_2 {

    /**1 Chuỗi regex*/
    public static boolean checkGmail (String s){
        String regex = "[a-zA-Z0-9-]{3,15}@[a-z].?[a-z]{2,}.[a-z]{2,}";
        return s.matches(regex);
    }
}
