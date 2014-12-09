package org.springframework.social.yahoo.filter.display;

import org.springframework.social.yahoo.filter.ContactsFilter;
import org.springframework.social.yahoo.module.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * Filters can only be used when calling the HTTP GET method of the Contacts URI.
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class DisplayFilter implements ContactsFilter {

    private List<String> fields = new ArrayList<>();

    public DisplayFilter withAllFields() {
        fields.clear();
        fields.add("all");
        return this;
    }

    public DisplayFilter withFields(FieldType... fields) {
        for (FieldType field : fields) {
            this.fields.add(field.name().toLowerCase());
        }
        return this;
    }

    public String buildFilter() {
        StringBuilder sb = new StringBuilder();
        if (fields.size() > 0) {
            sb.append("out=");
            for (String field : fields) {
                sb.append(field);
                if (fields.size() > 1 && !field.equals(fields.get(fields.size() - 1))) {
                    sb.append(",");
                }
            }
            sb.append(";");
        }
        return sb.toString();
    }
}
