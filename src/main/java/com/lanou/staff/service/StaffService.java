package com.lanou.staff.service;

import com.lanou.base.BaseDao;
import com.lanou.staff.domain.Staff;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService extends BaseDao<Staff> {

    boolean login(Staff staff);


    @Override
    void save(Staff staff);

    @Override
    boolean delete(Staff staff);

    @Override
    List<Staff> findAll();

    @Override
    Staff findById(Serializable id);

    @Override
    boolean update(Staff staff);

    @Override
    boolean saveOrUpdate(Staff staff);

    @Override
    List<Staff> findAll(String condition, Object... params);

    @Override
    int getTotalrecord(String condition, Object[] params);

    Staff findStaffById(String staffId);

    List<Staff> findCondition(Staff staff);}
