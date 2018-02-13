package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

class TestProperties {
    String currentPropertyFile;
    private Properties currentProps = new Properties();

    public TestProperties() {

    }

    private Properties getCurrentProps() throws IOException {

        FileInputStream in = new FileInputStream(currentPropertyFile);
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