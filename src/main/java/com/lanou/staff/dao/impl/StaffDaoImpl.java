package com.lanou.staff.dao.impl;

import com.lanou.post.domain.Post;
import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {


    @Override
    public boolean login(Staff staff) {
        List<Staff> staffs = getHibernateTemplate().findByExample(staff);

        if (staffs != null && staffs.size() > 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void save(Staff staff) {
//        if (staff.getStaffId().isEmpty()){
        getHibernateTemplate().save(staff);
//        }
//        getHibernateTemplate().saveOrUpdate(staff);
    }

    @Override
    public boolean saveOrUpdate(Staff staff) {

        getHibernateTemplate().saveOrUpdate(staff);

        return true;
    }

    @Override
    public boolean delete(Staff staff) {

        return true;
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> list = (List<Staff>) getHibernateTemplate().find("from Staff T_STAFF");
        return list;
    }

    @Override
    public Staff findStaffById(String staffId) {

        Staff staff = getHibernateTemplate().get(Staff.class, staffId);

        return staff;
    }

    @Override
    public Staff findById(Serializable id) {

        getHibernateTemplate().find("from Staff T_STAFF where staffId = ?");
        return null;
    }

    @Override
    public boolean update(Staff staff) {
        return true;
    }


    @Override
    public List<Staff> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        getHibernateTemplate().find(condition, params);
        return 0;
    }

    @Override
    public List<Staff> findCondition(Staff staff) {

        List<Staff> list = new ArrayList<>();
        boolean deptId = StringUtils.isBlank(staff.getPost().getDept().getDeptId());
        boolean postId = StringUtils.isBlank(staff.getPost().getPostId());
        boolean staffName = StringUtils.isBlank(staff.getStaffName());
        //根据部门查询
        if (!deptId && postId && staffName) {
            List<Post> posts = (List<Post>) getHibernateTemplate().find("from Post where dept.deptId = ?", staff.getPost().getDept().getDeptId());

            for (int i = 0; i < posts.size(); i++) {
                List<Staff> staffs =
                        (List<Staff>) getHibernateTemplate().
                                find("from Staff where post.postId = ?", posts.get(i).getPostId());
                list.addAll(staffs);
            }
            return list;
            //根据职务查询
        } else if (!postId && staffName) {
            return (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ?", staff.getPost().getPostId());

            //根据名字查询
        } else if (deptId && !staffName) {
            return (List<Staff>) getHibernateTemplate().find("from Staff where staffName like ?", "%" + staff.getStaffName() + "%");

            //根据职务和名字查询

        } else if (!postId && !staffName) {
            return (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ? and staffName like ?", staff.getPost().getPostId(), "%" + staff.getStaffName() + "%");

            //根据部门和名字查询
        } else if (!deptId && postId && !staffName) {
            List<Post> posts = (List<Post>) getHibernateTemplate().find("from Post where dept.deptId = ?", staff.getPost().getDept().getDeptId());
            for (int i = 0; i < posts.size(); i++) {
                List<Staff> staffs = (List<Staff>) getHibernateTemplate().find("from Staff where post.postId = ? and staffName like ?", posts.get(i).getPostId(), "%" + staff.getStaffName() + "%");
                list.addAll(staffs);
            }
            return list;
        } else {
            return (List<Staff>) getHibernateTemplate().find("from Staff");

        }

    }


}
