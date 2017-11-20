package com.lanou.department.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class DepartmentAction extends BaseAction<Department,DepartmentService> {

    private List<Department> allList;

    private List<Staff> staffList;

    public String findAllDepartment(){

        this.allList = service.findAll();
        return SUCCESS;
    }



    public String addDept(){
        if (getModel() != null)
        service.save(getModel());

        return SUCCESS;
    }

    public String update(){
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    public List<Department> getAllList() {
        return allList;
    }

    public void setAllList(List<Department> allList) {
        this.allList = allList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
