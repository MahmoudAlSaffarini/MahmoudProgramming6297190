package org.Mahmoud;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Department {

    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Checks if a department name is valid.
     * @param departmentName the input department name to validate.
     * @return true if the department name contains only letters or spaces, else false.
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char ch = departmentName.charAt(i);

            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch == ' '))) {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId);
            nextId++;

            this.departmentName = Util.toTitleCase(departmentName);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        }
    }
}
