package org.springframework.social.yahoo.filter;

/**
 * When requesting a Contacts resource, the order of the Contact objects can be
 * specified using the 'sort' key, which can be either 'asc' (default) and 'desc'.
 *
 * The 'sort' key needs to be accompanied by the 'sort-fields' key, which specifies the fields
 * by which the sort is made.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/sorting.html">Sorting</a>
 * @see {@link ContactsFilter#setOrder(Order))
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SortOrder extends RequestCustomizer {

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
            sb.append(SORT_ORDER_KEY).append(TokenUtils.SYMBOL_EQUALS);
            sb.append(getTokens().get(0).getValue());
        }
        return sb.toString();
    }

    public static enum Order {
        ASC, DESC
    }
}
