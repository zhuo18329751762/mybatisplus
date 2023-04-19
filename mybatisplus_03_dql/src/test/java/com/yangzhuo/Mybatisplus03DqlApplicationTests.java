package com.yangzhuo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangzhuo.dao.UserDao;
import com.yangzhuo.domain.User;
import com.yangzhuo.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus03DqlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // 方式一 按照条件查询
//        QueryWrapper wrapper=new QueryWrapper();
//        wrapper.lt("age",18);
//        List<User> list = userDao.selectList(wrapper);
//        System.out.println(list);

        // 方式二 Lambda格式按条件查询
//        QueryWrapper<User> wrapper=new QueryWrapper();
//        wrapper.lambda().lt(User::getAge,18);
//        List<User> list = userDao.selectList(wrapper);
//        System.out.println(list);

        //方式三 Lambda格式按条件查询
//        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
//        //3~18之间
////        wrapper.lt(User::getAge,18);
////        wrapper.gt(User::getAge,3);
//        //小于3或者大于18
//        wrapper.lt(User::getAge,3).or().gt(User::getAge,18);
//
//        List<User> list = userDao.selectList(wrapper);
//        System.out.println(list);

        UserQuery uq=new UserQuery();
        //uq.setAge(10);
        //uq.setAge2(30);
        //null判定
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        //先判定第一个参数是否为true，如果为true连接当前条件
        lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        lqw.gt(null!=uq.getAge(),User::getAge,uq.getAge());
        List<User> userList=userDao.selectList(lqw);
        System.out.println(userList);
    }

}
