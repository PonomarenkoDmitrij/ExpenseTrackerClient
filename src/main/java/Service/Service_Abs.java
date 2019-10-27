package Service;

import Main.Client_Socket;
import ObjectData.Costs;
import ObjectData.Users;
import org.json.JSONObject;

public class Service_Abs {
    static int value;
    static JSONObject obj;

    // send message to server with create, delete, update data
    protected static void operations(Object object, int code) {
        obj = new JSONObject();
        if (object.getClass() == Costs.class) {
            Costs c = (Costs) object;
            obj.put("enum_object", Service.NAME_OBJECT.costs);
            obj.put("costs", c.toJSON());
        }
        if (object.getClass() == Users.class) {
            Users u = (Users) object;
            obj.put("enum_object", Service.NAME_OBJECT.user);
            obj.put("user", u.toJSON());
        }
        obj.put("code", code);
        Client_Socket.postMessage(obj);
    }
}
