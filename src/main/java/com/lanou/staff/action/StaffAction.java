package com.lanou.staff.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.post.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.lanou.staff.service.impl.StaffServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffServiceImpl> {

    private String loginName, loginPwd;
    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;

    private List<Staff> allList;

    private String staffId;

    private List<Department> deptList;

    private String crmPost_postId;
    private Staff staff;
    private Staff staffById;



    public String login() {
        boolean result = staffService.login(getModel());
        if (result == true) {
            sessionPut("login", getModel().getLoginName());
            return SUCCESS;
        } else {
            addFieldError("msg", "请输入正确的用户名和密码");
            return INPUT;
        }

    }


    public String findAllStaff() {
        allList = staffService.findAll();
        sessionPut("allList",allList);

        return SUCCESS;
    }

    public String addStaff(){

        staff = getModel();
        staff.setPost(new Post(crmPost_postId));
        staffService.save(getModel());
        System.out.println(getModel());
        return SUCCESS;
    }

    public String update(){

        getModel().setPost(new Post(crmPost_postId));
        staffService.saveOrUpdate(getModel());
        return SUCCESS;
    }

    public String editStaffPre(){
        deptList =departmentService.findAll();
        staffById = staffService.findStaffById(getModel().getStaffId());
        System.out.println(staffById);
        return SUCCESS;
    }





    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public List<Staff> getAllList() {
        return allList;
    }

    public void setAllList(List<Staff> allList) {
        this.allList = allList;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getCrmPost_postId() {
        return crmPost_postId;
    }

    public void setCrmPost_postId(String crmPost_postId) {
        this.crmPost_postId = crmPost_postId;
    }

    public Staff getStaffById() {
        return staffById;
    }

    public void setStaffById(Staff staffById) {
        this.staffById = staffById;
    }
}
