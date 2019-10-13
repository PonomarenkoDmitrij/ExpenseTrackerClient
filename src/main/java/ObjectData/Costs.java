package ObjectData;

import org.json.JSONObject;

import java.sql.Date;

public class Costs extends Object {

    private int userID;         // ID user
    private double sum_money;   // total amount of money
    // supposed costs
    private double one_day;
    private double seven_day;
    private double month;
    // costs:
    private double travel;      // travel expenses
    private double food;        // food expenses
    private double clothes;     // clothes expenses
    private double other;       // other expenses
    private double sum_costs;   // general cost per month. This data need for database.
    private Date create_entry;  // date create entry

    public Costs(){
        super(-1);
    }

    public Costs(int id, int userID, double one_day,double seven_day, double month,
                 double sum_money, double travel, double food, double clothes, double other) {
        super(id);
        this.userID = userID;
        this.sum_money = sum_money;
        this.one_day = one_day;
        this.seven_day = seven_day;
        this.month = month;
        this.travel = travel;
        this.food = food;
        this.clothes = clothes;
        this.other = other;
    }

    @Override
    public void JSONObject(JSONObject obj) {
        super.JSONObject(obj);
        userID = obj.getInt("userID");
        sum_money = obj.getDouble("sum_money");
        one_day = obj.getDouble("one_day");
        seven_day = obj.getDouble("seven_day");
        month = obj.getDouble("month");
        travel = obj.getDouble("travel");
        food = obj.getDouble("food");
        clothes = obj.getDouble("clothes");
        other = obj.getDouble("other");
        sum_costs = obj.getDouble("sum_costs");
        create_entry = Date.valueOf(obj.getString("create_entry"));
    }

    @Override
    public JSONObject toJSON() {
        JSONObject obj = super.toJSON();
        obj.put("userID", userID);
        obj.put("sum_money", sum_money);
        obj.put("one_day", one_day);
        obj.put("seven_day", seven_day);
        obj.put("month", month);
        obj.put("travel", travel);
        obj.put("food", food);
        obj.put("clothes", clothes);
        obj.put("other", other);
        obj.put("sum_costs", getSumCosts());
        return obj;
    }

    private double getSumCosts(){
        return this.travel + this.food + this.clothes + this.other;
    }

}
