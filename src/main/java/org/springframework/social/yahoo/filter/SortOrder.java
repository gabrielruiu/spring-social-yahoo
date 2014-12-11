package org.springframework.social.yahoo.filter;

/**
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
        sb.append(SORT_ORDER_KEY).append("=");
        sb.append(getTokens().get(0).getValue());
        return sb.toString();
    }

    public static enum Order {
        ASC, DESC
    }
}
