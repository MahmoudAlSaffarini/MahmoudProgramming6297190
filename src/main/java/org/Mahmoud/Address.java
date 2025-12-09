package org.Mahmoud;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    /**
     * Checks if postalCode is valid using the CDCDCD format.
     * @param postalCode the input postal code.
     * @return true if postal Code uses the CDCDCD format, else false.
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        postalCode = postalCode.toUpperCase();

        for (int i = 0; i < postalCode.length(); i++) {
            char ch = postalCode.charAt(i);

            if (i % 2 == 0) {
                if (!(ch >= 'A'  && ch <= 'Z')) {
                    return false;
                }
            } else {
                if (!(ch >= '0' && ch <= '9')) {
                    return false;
                }
            }
        }
        return true;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }
}

