package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public final class PairedTag extends Tag {

    private String body;
    private List<Tag> singleTags;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String b, List<Tag> tags) {
        super(tagName, tagAttributes);
        body = b;
        singleTags = tags;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

        builder.append(body);
        singleTags.forEach(t -> builder.append(t.toString()));
        builder.append(String.format("</%s>", super.getName()));
        return builder.toString();
    }
}
// END
