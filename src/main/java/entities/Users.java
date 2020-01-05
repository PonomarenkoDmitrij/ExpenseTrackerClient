package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Users {

    private String full_name;
    private String login;
    private String email;
    private String password;
    private Date birthday;

}
