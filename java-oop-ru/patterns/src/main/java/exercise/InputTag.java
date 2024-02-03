package exercise;

// BEGIN
public final class InputTag implements TagInterface {
    private String inputType;
    private String value;

    public InputTag(String type, String val) {
        inputType = type;
        value = val;
    }

    @Override
    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", inputType, value);
    }
}
// END
