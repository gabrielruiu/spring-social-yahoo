package org.springframework.social.yahoo.filter;

import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_EQUALS;

/**
 * When sorting a Contacts resource, the order, in which the Contact objects appear, can be specified
 * through one or more Fields.
 *
 * Whether the order is ascending or descending, is specified through the SortOrder class.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/sorting.html">Sorting</a>
 * @see {@link ContactsFilter#sortOrder(Order))
 * @see {@link SortFields}
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SortOrder extends ContactsRequestCustomizer {

    private static final String SORT_ORDER_KEY = "sort";

    public void setOrder(Order order) {
        getTokens().clear();
        String fieldName = order.name().toLowerCase();
        addToken(new CustomizerToken(fieldName, null, fieldName));
    }

    @Override
    public boolean isFieldAllowed(String fieldName) {
        return fieldName.equals(Order.ASC.name().toLowerCase()) ||
               fieldName.equals(Order.DESC.name().toLowerCase());
    }

    @Override
    public String toRequest() {
        StringBuilder sb = new StringBuilder();
        if (hasTokens()) {
            sb.append(SORT_ORDER_KEY).append(SYMBOL_EQUALS);
            sb.append(getTokens().get(0).getValue());
        }
        return sb.toString();
    }

    public static enum Order {
        ASC, DESC
    }
}
