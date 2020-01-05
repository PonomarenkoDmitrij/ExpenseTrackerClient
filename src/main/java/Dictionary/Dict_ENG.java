package Dictionary;


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
        return null;
    }

}
