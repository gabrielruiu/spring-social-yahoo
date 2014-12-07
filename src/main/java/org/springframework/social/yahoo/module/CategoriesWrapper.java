package org.springframework.social.yahoo.module;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class CategoriesWrapper extends YahooObject {

    private Categories categories;

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
