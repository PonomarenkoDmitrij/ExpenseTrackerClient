package ObjectData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
// Create and save all costs in this object
public class CostsList {

    private static ArrayList<Costs> costs;

    public static void setList(JSONArray ar){
        if(ar.length() == 0) return;
        costs = new ArrayList<>();
        for(int i = 0; i < ar.length();i++ ) {
            Costs c = new Costs();
            c.JSONObject(ar.optJSONObject(i));
            costs.add(c);
        }
    }

    public static ArrayList<Costs> getList(){
        return costs;
    }
}
