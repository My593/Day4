package com.lanou.post.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */

public class PostAction extends BaseAction<Post, PostService> {

    private DepartmentService departmentService;

    private List<Post> allList;

    private List<Department> deptList;

    private List<Post> postList;
    private String post_dept_id;

    // 查询所有
    public String findAllPost() {
        allList = service.findAll();
        return SUCCESS;
    }

    // 添加部门
    public String addPost() {
        deptList = departmentService.findAll();
        return SUCCESS;
    }

    public String savePost() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    // 修改
    public String update() {
        deptList = departmentService.findAll();
//        postService.saveOrUpdate(getModel());
        return SUCCESS;
    }













    public List<Post> getAllList() {
        return allList;
    }
    public void setAllList(List<Post> allList) {
        this.allList = allList;
    }

    public List<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Department> deptList) {
        this.deptList = deptList;
    }


    public String getPost_dept_id() {
        return post_dept_id;
    }

    public void setPost_dept_id(String post_dept_id) {
        this.post_dept_id = post_dept_id;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }


    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
