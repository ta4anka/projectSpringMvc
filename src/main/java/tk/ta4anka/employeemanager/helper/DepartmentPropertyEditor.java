package tk.ta4anka.employeemanager.helper;

import tk.ta4anka.employeemanager.model.Department;
import tk.ta4anka.employeemanager.service.DepartmentService;

import java.beans.PropertyEditorSupport;

/*
https://howtodoinjava.com/spring-boot/custom-property-editor-example/
https://technology.amis.nl/2018/02/22/java-how-to-fix-spring-autowired-annotation-not-working-issues/  TODO: DELETE
*/

public class DepartmentPropertyEditor extends PropertyEditorSupport {

    private final DepartmentService departmentService;

    public DepartmentPropertyEditor(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void setAsText(String departmentFromForm) {
        Integer  id = Integer.parseInt(departmentFromForm);
        Department department = departmentService.getById(id);
        setValue(department);
    }

}

