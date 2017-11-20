package com.lanou.staff.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffAction extends BaseAction<Staff, StaffService> {

    private String loginName, loginPwd;

    private DepartmentService departmentService;

    private List<Staff> allList;

    private String staffId;

    private List<Department> deptList;

    private String postId;

    private Staff staffById;
    private String deptId;

    private PostService postService;
    private List<Post> postByDeptId;

    private List<Post> postList;


    public String login() {

        boolean result = service.login(getModel());
        if (result == true) {
            sessionPut("login", getModel().getLoginName());
            return SUCCESS;
        } else {
            addFieldError("msg", "请输入正确的用户名和密码");
            return INPUT;
        }

    }

    public String validateLogin() {
        if (StringUtils.isBlank(getModel().getLoginName())){
            addFieldError("loginName","请输入用户名");
            return INPUT;
        }
        if (StringUtils.isBlank(getModel().getLoginPwd())){
            addFieldError("loginPwd","请输入密码");
            return INPUT;
        }
        return SUCCESS;
    }

    public String findAllStaff() {
        allList = service.findAll();
        return SUCCESS;
    }

    public String findDept(){
        deptList = departmentService.findAll();
        return SUCCESS;
    }

    public String addStaff() {

        service.save(getModel());
        System.out.println(getModel());
        return SUCCESS;
    }

    public String update() {
        System.out.println(getModel());
        System.out.println(getModel().getStaffName());
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    public String editStaffPre() {
        deptList = departmentService.findAll();
        staffById = service.findStaffById(getModel().getStaffId());
        ActionContext.getContext().put("setDeptId", staffById.getPost().getDept().getDeptId());
        ActionContext.getContext().getSession().put("setPostId", staffById.getPost().getPostId());
        ActionContext.getContext().getSession().put("setPostName", staffById.getPost().getPostName());
        System.out.println(staffById);
        return SUCCESS;
    }

    public String getPostsByDeptId() {
        postByDeptId = postService.getPostByDeptId(getModel().getPost().getDept().getDeptId());
        return SUCCESS;
    }

    public String staffAction_findAll(){
        deptList = departmentService.findAll();
        postList = postService.findAll();
        allList = service.findCondition(getModel());
        System.out.println(allList);
        return SUCCESS;
    }

    public String staffAction_logout(){
        ActionContext.getContext().getSession().clear();
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

    public void setPostByDeptId(List<Post> postByDeptId) {
        this.postByDeptId = postByDeptId;
    }

    public List<Post> getPostByDeptId() {
        return postByDeptId;
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Staff getStaffById() {
        return staffById;
    }

    public void setStaffById(Staff staffById) {
        this.staffById = staffById;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}

