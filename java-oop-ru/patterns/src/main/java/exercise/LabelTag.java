package exercise;

import java.util.LinkedList;
import java.util.List;

// BEGIN
public final class LabelTag implements TagInterface {
    private List<TagInterface> tags = new LinkedList<>();
    private String label;

    public LabelTag(String paramLabel, TagInterface tag) {
        label = paramLabel;
        tags.add(tag);
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder("<label>" + label);
        tags.forEach(t -> builder.append(t.render()));
        builder.append("</label>");
        return builder.toString();
    }
}
// END
