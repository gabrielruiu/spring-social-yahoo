package org.springframework.social.yahoo.filter.display;

import org.springframework.social.yahoo.module.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class DisplayFilter {

    private List<String> fields = new ArrayList<>();

    public DisplayFilter withField(FieldType field) {
        fields.add(field.name().toLowerCase());
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        if (fields.size() > 0) {
            for (String field : fields) {
                sb.append(field);
                if (fields.size() > 1 && !field.equals(fields.get(fields.size() - 1))) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
}
