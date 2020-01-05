package Form;

public class IntegerFormer {

    public static int parse(String str){
        if(str == null || str.trim().equals("")) return 0;
        return Integer.parseInt(str);
    }

    public static String parseInt(int numb){
        return String.valueOf(numb);
    }

}
