package org.springframework.social.yahoo.module;

import java.util.Set;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class Field extends YahooObject {

    private FieldType fieldType;
    private FieldValue value;
    private Set<FieldFlag> flags;
    private String title;
    private boolean isConnection;
    private String nickname;

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public FieldValue getValue() {
        return value;
    }

    public void setValue(FieldValue value) {
        this.value = value;
    }

    public Set<FieldFlag> getFlags() {
        return flags;
    }

    public void setFlags(Set<FieldFlag> flags) {
        this.flags = flags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isConnection() {
        return isConnection;
    }

    public void setConnection(boolean isConnection) {
        this.isConnection = isConnection;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
