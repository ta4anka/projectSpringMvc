package tk.ta4anka.employeemanager.helper;

import tk.ta4anka.employeemanager.model.Role;
import tk.ta4anka.employeemanager.service.RoleService;

import java.beans.PropertyEditorSupport;

public class RolePropertyEditor extends PropertyEditorSupport {

    private final RoleService roleService;

    public RolePropertyEditor(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public void setAsText(String roleFromForm) {
        Integer  id = Integer.parseInt(roleFromForm);
        Role role = roleService.getById(id);
        setValue(role);
    }

}
