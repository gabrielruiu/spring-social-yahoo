package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
//TODO: add mixins for all objects and models
public class YahooModule extends SimpleModule {

    public YahooModule() {
        super("YahooModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);
        context.setMixInAnnotations(YahooContact.class, ContactMixin.class);
    }
}
