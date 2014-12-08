package org.springframework.social.yahoo.filter.search;

import org.springframework.social.yahoo.module.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * Filters can only be used when calling the HTTP GET method of the Contacts URI.
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SearchFilter {

    private List<SingleFilter> filters = new ArrayList<>();

    public SearchFilter withCondition(SearchFilterFieldType fieldType,
                                        SearchFilterConditionParameter condition, String conditionValue) {
        return withCondition(fieldType.name().toLowerCase(), condition.getParameterName(), conditionValue);
    }

    public SearchFilter withCondition(FieldType fieldType, SearchFilterConditionParameter condition, String conditionValue) {
        return withCondition(fieldType.name().toLowerCase(), condition.getParameterName(), conditionValue);
    }

    private SearchFilter withCondition(String field, String conditionParameter, String conditionValue) {
        filters.add(new SingleFilter(field, conditionParameter, conditionValue));
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        for (SingleFilter filter : filters) {
            sb.append(filter.field).append(".").append(filter.conditionParameter).append("=").append(filter.conditionValue);
            sb.append(";");
        }
        return sb.toString();
    }

    private class SingleFilter {
        private String field;
        private String conditionParameter;
        private String conditionValue;

        public SingleFilter(String field, String conditionParameter, String conditionValue) {
            this.field = field;
            this.conditionParameter = conditionParameter;
            this.conditionValue = conditionValue;
        }
    }
}
