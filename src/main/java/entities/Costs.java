package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Costs {

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

    private double getSumCosts(){
        return this.travel + this.food + this.clothes + this.other;
    }

}
