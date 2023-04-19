package com.yangzhuo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangzhuo.dao.UserDao;
import com.yangzhuo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;


    //添加
    @Test
    void testSave(){
        User user=new User();
        user.setName("小红书");
        user.setAge(5);
        user.setPassword("xiaohongshu");
        user.setTel("阿巴阿巴阿巴");
        int a = userDao.insert(user);
        System.out.println(a);
    }

    //删除
    @Test
    void deleteById(){
        int a = userDao.deleteById(1648674347033079809L);
        System.out.println(a);
    }

    //修改
    @Test
    void testUpdate(){
        User user=new User();
        user.setName("小红书数");
        user.setId(1648675884622979074L);
        user.setPassword("xiaohongshu");
        user.setTel("阿巴阿巴阿巴");
        userDao.updateById(user);
    }

    //根据id查询
    @Test
    void testGetById(){
        User user = userDao.selectById(4L);
        System.out.println(user);
    }


    @Test
    void testGetAll() {
        List<User> list = userDao.selectList(null);
        System.out.println(list);
    }

    @Test
    void testGetByPage(){
        IPage page=new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值: "+page.getCurrent());
        System.out.println("当前显示数: "+page.getSize());
        System.out.println("一共多少页: "+page.getPages());
        System.out.println("一共多少条: "+page.getTotal());
        System.out.println("数据 : "+page.getRecords());
    }

}
