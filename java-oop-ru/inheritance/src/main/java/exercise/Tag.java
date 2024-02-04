package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> attributes;

    protected Tag(String tagName, Map<String, String> tagAttributes) {
        name = tagName;
        attributes = tagAttributes;
    }

    /**
     * @return tag string representation
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<" + getName() + " ");
        getAttributes().forEach((k, v) -> {
            String pair = String.format("%s=\"%s\" ", k, v);
            builder.append(pair);
        });
        builder.append(">");
        return builder.toString();
    }

    /**
     * @return tag name
     */
    public String getName() {
        return name;
    }

    /**
     * @return tag attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }
}
// END
