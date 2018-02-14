package setup;

public enum PropertyFile {
    NATIVE("nativetest.properties"),
    WEB("webtest.properties");

    public String path;

    PropertyFile(String path) {
        this.path = path;
    }
}
