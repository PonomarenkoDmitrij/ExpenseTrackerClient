package Service;

import FXML_Controller.Verification_Contr;
import Main.Client_Socket;
import Main.Main;
import ObjectData.*;
import org.json.JSONObject;
import Service.Service.*;
import sun.print.resources.serviceui_zh_TW;

public class Service_User {

    static Verification_Contr vc;
    static Users user;

    private static int value;
    private static JSONObject obj;
    private boolean result;

    public static class unique_numb {
        public static final byte verification = 10;
    }

    // get message from server
    public static void acceptMessage(JSONObject jobj) {
        obj = new JSONObject();
        value = jobj.getInt("code");
        if (jobj.has("user")) {
            Main.user.getUsers().JSONObject(jobj.getJSONObject("user")); // create object user
            user = Main.user.getUsers();
        }
        user.JSONObject((JSONObject) obj.get("object"));

//        boolean result;
        switch (value) {
            case NAME_OPERATION.create:
                createMessage(user, NAME_OPERATION.create);
                break;
            case NAME_OPERATION.delete:
                createMessage(user, NAME_OPERATION.delete);
                break;
            case NAME_OPERATION.update:
                createMessage(user, NAME_OPERATION.update);
                break;
            case NAME_OPERATION.show:
                createMessage(user, NAME_OPERATION.show);
                break;
            case unique_numb.verification:
                Service.getVer().next_window();
                break;
        }
    }

    // create request to server
    public static void createMessage(Users user, int code) {
        operation(user, NAME_OPERATION.create);
    }

    private static void operation(Users user, int code) {
        obj = new JSONObject();
        obj.put("enum_object", NAME_OBJECT.user);
        obj.put("code", code);
        obj.put("user", user.toJSON());
        Client_Socket.postMessage(obj);
    }

}
