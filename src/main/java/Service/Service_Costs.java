package Service;

import Main.*;
import ObjectData.Costs;
import ObjectData.CostsList;
import Service.Service.*;
import org.json.JSONObject;

//import static Service.Service_Abs.operations;

public class Service_Costs extends Service_Abs {

    public static class unique_numb {
        public static final byte none = -1;
        public static final byte one_day = 11;      // show data in one day
        public static final byte seven_day = 12;    // show data in seven days
        public static final byte month = 13;        // show data in month
    }
    // create request to server
    public static void createMessage(Costs costs, byte code, byte unique){
        switch (code){
            case NAME_OPERATION.create:
                operations(costs, NAME_OPERATION.create);
                break;
            case NAME_OPERATION.delete:
                operations(costs, NAME_OPERATION.delete);
                break;
            case NAME_OPERATION.update:
                operations(costs, NAME_OPERATION.update);
                break;
            case NAME_OPERATION.show:
                requestShow(costs, code, unique);
                break;
        }
    }
    // get message from server
    public void acceptMessage(JSONObject obj) {
        value = obj.getInt("process");
        int unique = obj.getInt("unique");
        Costs costs = new Costs();
        costs.JSONObject((JSONObject) obj.get("object"));
        boolean result;
        switch (value) {
            case NAME_OPERATION.create:
                operations(costs, NAME_OPERATION.create);
                break;
            case NAME_OPERATION.delete:
                operations(costs, NAME_OPERATION.delete);
                break;
            case NAME_OPERATION.update:
                operations(costs, NAME_OPERATION.update);
                break;
            case NAME_OPERATION.show:
                CostsList.setList(obj.getJSONArray("costs"));
                break;
        }
    }

    // send message to server with request for data
    public static void requestShow(Costs costs, byte code, byte unique){
        obj = new JSONObject();
        obj.put("enum_object", NAME_OBJECT.costs);
        obj.put("code",code);
        obj.put("unique_numb", unique);
        Client_Socket.postMessage(obj);
    }

}
