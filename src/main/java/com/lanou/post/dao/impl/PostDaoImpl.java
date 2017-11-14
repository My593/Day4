package com.lanou.post.dao.impl;

import com.lanou.post.dao.PostDao;
import com.lanou.post.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<Post> findAll() {
        List<Post> list = (List<Post>) getHibernateTemplate().find("from Post T_POST");

        return list;
    }
    @Override
    public void save(Post post) {
        getHibernateTemplate().save(post);

    }
    @Override
    public boolean saveOrUpdate(Post post) {

        if (post.getPostId().isEmpty()) {
            getHibernateTemplate().save(post);
        } else {
            getHibernateTemplate().saveOrUpdate(post);
        }



        return true;
    }

    @Override
    public boolean update(Post post) {
        return false;
    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

    @Override
    public List<Post> findAll(String condition, Object... params) {
        return null;
    }

    @Override
    public int getTotalrecord(String condition, Object[] params) {
        return 0;
    }



    @Override
    public Post findById(Serializable id) {
        return null;
    }
}
