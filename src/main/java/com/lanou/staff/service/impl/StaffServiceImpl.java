package com.lanou.staff.service.impl;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public boolean login(Staff staff) {
        return staffDao.login(staff);
    }

    @Override
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    @Override
    public Staff findStaffById(String staffId) {

        return staffDao.findStaffById(staffId);
    }

    @Override
    public List<Staff> findCondition(Staff staff) {

         return staffDao.findCondition(staff);
    }


    @Override
    public boolean delete(Staff staff) {
        return true;
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public Staff findById(Serializable id) {

        return null;
    }

    @Override
    public boolean update(Staff staff) {
        return true;
    }

    @Override
    public boolean saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
        return true;
    }

    @Override
    public List<Staff> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        return 0;
    }



    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
