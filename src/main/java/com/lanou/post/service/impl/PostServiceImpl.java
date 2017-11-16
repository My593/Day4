package com.lanou.post.service.impl;

import com.lanou.post.dao.PostDao;
import com.lanou.post.domain.Post;
import com.lanou.post.service.PostService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;
    @Override
    public void save(Post post) {
        postDao.save(post);

    }

    @Override
    public List<Post> findAll() {
       return postDao.findAll();

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
    public boolean update(Post post) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Post post) {
        postDao.saveOrUpdate(post);
        return true;
    }

    @Override
    public List<Post> getPostByDeptId(String deptId) {
        return postDao.getPostByDeptId(deptId);
    }

    @Override
    public boolean delete(Post post) {
        return false;
    }

    @Override
    public Post findById(Serializable id) {
        return null;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
