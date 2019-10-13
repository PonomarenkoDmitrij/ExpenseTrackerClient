package Service;

import FXML_Controller.AddCosts;
import FXML_Controller.Verification_Contr;
import Main.Main;
import ObjectData.Users;
import org.json.JSONObject;

public class Service {


    private static Verification_Contr ver;
    private static AddCosts add;

    private static int value;

    public static class NAME_OBJECT {
        public static final int user = 1;
        public static final int costs = 2;
    }

    ;

    public static class NAME_OPERATION {
        public static final byte create = 0;
        public static final byte update = 1;
        public static final byte delete = 2;
        public static final byte show = 3;
    }

    ;

    public static void func(JSONObject obj) {
        if (obj == null || obj.isEmpty()) return;

        value = obj.getInt("enum_object");
        switch (value) {
            case NAME_OBJECT.user:
                Service_User s = new Service_User();
                s.acceptMessage(obj);
                break;
            case NAME_OBJECT.costs:
                Service_Costs costs = new Service_Costs();
                costs.acceptMessage(obj);
                break;
        }
    }

    public static void parse_answer(JSONObject obj) {
        System.out.println(obj.toString());
        int code = obj.getInt("code");
        int object = obj.getInt("object");

        boolean result = obj.getBoolean("result");
        switch (object) {
            case NAME_OBJECT.user:
                Service_User.acceptMessage(obj.getJSONObject("user"));
                // передать ответ и данные в сервисы юзера
                // если ошибка то вывести ответ на экран
                break;        
            case NAME_OBJECT.costs:
                switch (code) {
                    case NAME_OPERATION.create:
                        if (result) Main.frames.closeAdd();
                }
                break;
        }
    }

    public static void frames(Object frame) {
        Class<?> obj = frame.getClass();
        if (obj == Verification_Contr.class) ver = (Verification_Contr) frame;
    }
    public static Verification_Contr getVer() {
        return ver;
    }

    public static AddCosts getAdd() {
        return add;
    }
}
