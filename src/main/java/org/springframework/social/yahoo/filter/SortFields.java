package org.springframework.social.yahoo.filter;

import org.springframework.social.yahoo.module.FieldType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.social.yahoo.filter.TokenUtils.shouldAddTokenSeparator;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SortFields extends RequestCustomizer {

    private static final String SORT_FIELDS_KEY = "sort-fields";
    private static final List<String> SORTABLE_FIELDS = sortableFields();

    public void addFields(FieldType... fieldTypes) {
        for (FieldType type : fieldTypes) {
            String fieldName = type.name().toLowerCase();
            addToken(new CustomizerToken(fieldName, null, fieldName));
        }
    }

    public void addFields(SortableField... sortableFields) {
        for (SortableField field : sortableFields) {
            addToken(new CustomizerToken(field.getParameterName(), null, field.getParameterName()));
        }
    }

    /**
     * The 'sort-fields' key can consist of any of Field Types except the structured fields Name
     * and Address. Use displayName, first or last to sort by name.
     */
    @Override
    public boolean isFieldAllowed(String fieldName) {
        return SORTABLE_FIELDS.contains(fieldName);
    }

    @Override
    public String toRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append(SORT_FIELDS_KEY).append("=");
        List<CustomizerToken> tokens = getTokens();
        for (CustomizerToken token : getTokens()) {
            sb.append(token.getValue());
            if (shouldAddTokenSeparator(tokens, token)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * Verify only that, if a FieldType is added, it is not of type NAME or ADDRESS.
     * The other allowable fields are of type {@link SortableField} which are implicitly
     * enforced through the {@link #addFields(SortableField...)}
     */
    private static List<String> sortableFields() {
        List<String> sortableFields = new ArrayList<>();
        for (FieldType type : FieldType.values()) {
            if (!(type.equals(FieldType.NAME) || type.equals(FieldType.ADDRESS))) {
                sortableFields.add(type.name().toLowerCase());
            }
        }
        return sortableFields;
    }


    /**
     * Sort-specific field names by which a sort can be performed
     */
    public static enum SortableField {

        DISPLAY_NAME("displayName"),
        FIRST_NAME("first"),
        LAST_NAME("last");

        private String parameterName;

        SortableField(String parameterName) {
            this.parameterName = parameterName;
        }

        public String getParameterName() {
            return parameterName;
        }
    }
}

