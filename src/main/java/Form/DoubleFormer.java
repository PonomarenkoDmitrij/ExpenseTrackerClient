package Form;

public class DoubleFormer {

    public static double parse(String str){
        if(str == null || str.trim().equals("")) return 0;
        return Double.parseDouble(str);
    }
}
