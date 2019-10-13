package ObjectData;

import org.json.JSONObject;

public class Object extends AbsObject {

    public int id;

    public Object(int id){
        this.id = id;
    }

    public void JSONObject(JSONObject obj) {
        this.id = obj.getInt("id");
    }

    public JSONObject toJSON()  {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        return obj;
    }

    public String toString() {
        return "id"+id;
    }
}
