package org.springframework.social.yahoo.module;

import java.util.List;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class Categories extends YahooObject {

    private List<Category> category;

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
