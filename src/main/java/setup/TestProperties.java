package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static setup.PropertyFile.NATIVE;
import static setup.PropertyFile.WEB;

class TestProperties {
    private String currentPropertiesFile;
    Properties currentProps = new Properties();

    Properties getCurrentProps() throws IOException {

       // currentPropertiesFile = WEB.path; // my way to choose property file :)
        currentPropertiesFile = NATIVE.path;
        FileInputStream in = new FileInputStream(currentPropertiesFile);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}