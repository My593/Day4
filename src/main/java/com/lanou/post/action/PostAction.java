package com.lanou.post.action;

import com.lanou.base.BaseAction;
import com.lanou.department.domain.Department;
import com.lanou.department.service.DepartmentService;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post, PostService> {

    private List<Post> allList;

    private List<Department> deptList;

    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService postService;

    private List<Post> postList;
    private String post_dept_id;

    // 查询所有
    public String findAllPost() {
        allList = postService.findAll();
        return SUCCESS;
    }

    // 添加部门
    public String addPost() {
        deptList = departmentService.findAll();
        return SUCCESS;
    }

    public String savePost() {
        postService.saveOrUpdate(getModel());
        return SUCCESS;
    }

    // 修改
    public String update() {
        deptList = departmentService.findAll();
//        postService.saveOrUpdate(getModel());
        return SUCCESS;
    }


    public String getPostByDeptId() {
        System.out.println("000000000000000000"+post_dept_id);

        postList = postService.getPostByDeptId(post_dept_id);
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
}
