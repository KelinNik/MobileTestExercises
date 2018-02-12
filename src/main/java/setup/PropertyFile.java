package setup;

public enum PropertyFile {
    NATIVE("webtest.properties"),
    WEB("nativetest.properties");

    private String path;

    PropertyFile(String path) {
        this.path = path;
    }
}
