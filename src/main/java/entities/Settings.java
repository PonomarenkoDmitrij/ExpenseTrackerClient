package entities;

import Form.IntegerFormer;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Settings {
    final static Logger LOGGER = Logger.getLogger(Settings.class);

    private static Properties properties;
    private static final String APPLICATION_PROPERTIES = "property.properties";
    private static final String workingDir = System.getProperty("java");
    private static File file = new File(workingDir, APPLICATION_PROPERTIES);
    static {
        properties = new Properties();
    }

    private int language;
    private String login;
    private String password;

    public Settings(int language, String login, String password) {
        this.language = language;
        this.login = login;
        this.password = password;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void editProperty(){
        try (OutputStream output = new FileOutputStream(file)) {
            properties.setProperty("language", IntegerFormer.parseInt(language));
            properties.setProperty("login", login);
            properties.setProperty("password", password);
            properties.store(output, null);
        } catch (IOException io) {
            LOGGER.error(io);
        }
    }

    public void writeUser(){
        try (OutputStream output = new FileOutputStream(file)) {
            properties.setProperty("login", login);
            properties.setProperty("password", password);
            properties.store(output, null);
        } catch (IOException io) {
            LOGGER.error(io);
        }
    }


}
