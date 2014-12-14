package org.springframework.social.yahoo.module;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class NameFieldValue extends FieldValue {

    private String givenName;
    private String middleName;
    private String familyName;
    private String prefix;
    private String suffix;
    private String givenNameSound;
    private String familyNameSound;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGivenNameSound() {
        return givenNameSound;
    }

    public void setGivenNameSound(String givenNameSound) {
        this.givenNameSound = givenNameSound;
    }

    public String getFamilyNameSound() {
        return familyNameSound;
    }

    public void setFamilyNameSound(String familyNameSound) {
        this.familyNameSound = familyNameSound;
    }
}
