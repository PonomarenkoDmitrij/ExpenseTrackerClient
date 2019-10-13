package ObjectData;

import org.json.JSONObject;
import java.util.Date;

public class Users extends Object {

    private String full_name;
    private String login;
    private String email;
    private String password;
    private Date birthday;

    public Users(){
        super(-1);
    }

    public Users(int id, String full_name, String email, String login, String password, Date birthday) {
        super(id);
        this.full_name = full_name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
    }

    public void JSONObject(JSONObject obj){
        super.JSONObject(obj);
        full_name = obj.getString("full_name");
        email = obj.getString("email");
        login = obj.getString("login");
        password = obj.getString("password");
        birthday = java.sql.Date.valueOf( obj.getString("birthday"));
    }

    public JSONObject toJSON(){
        JSONObject obj = super.toJSON();
        if(full_name != null) obj.put("full_name",full_name);
        if(email != null) obj.put("email",email);
        obj.put("login",login);
        obj.put("password",password);
        if(birthday != null) obj.put("birthday",birthday.toString());
        return obj;
    }
}
