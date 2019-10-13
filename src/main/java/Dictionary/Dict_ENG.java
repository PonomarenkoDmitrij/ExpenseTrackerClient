package Dictionary;

import Service.*;
import Service.Service.*;
import Service.Service_User.*;

public class Dict_ENG {

    public static String[][] message_user = {
            {
                    "Verification is successful", "User was create", "User was update", "User was delete"
            },
            {
                    "Verification isn`t successful. Please, try again.",
                    "User was not created. Please, try again.",
                    "User was not updated. Please, try again.",
                    "User was not deleted. Please, try again."
            }
    };

    public static String[][] message_costs = {
            {"Entry was created", "Entry was deleted.", "Entry was updated."},
            {"Entry was not created", "Entry was not deleted.", "Entry was not deleted."}
    };

    public static String getMessUser(int code, boolean result){
        switch (code) {
            case unique_numb.verification:
                return message_user[result ? 0 : 1][0];
            case NAME_OPERATION.create:
                return message_user[result ? 0 : 1][1];
            case NAME_OPERATION.update:
                return message_user[result ? 0 : 1][2];
            case NAME_OPERATION.delete:
                return message_user[result ? 0 : 1][3];
        }
        return null;
    }

}
