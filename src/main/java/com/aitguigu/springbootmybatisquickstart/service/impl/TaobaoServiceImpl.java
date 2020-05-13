package com.aitguigu.springbootmybatisquickstart.service.impl;

import com.aitguigu.springbootmybatisquickstart.dao.ITaobaoDao;
import com.aitguigu.springbootmybatisquickstart.domain.Taobao;
import com.aitguigu.springbootmybatisquickstart.service.ITaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @BelongsProject: springboot-mybatis-quickstart
 * @BelongsPackage: com.aitguigu.springbootmybatisquickstart.service.impl
 * @Author: Boss_king
 * @CreateTime: 2020-05-11 19:19
 * @Description: 业务层接口实现类
 */
@Service("taobaoService")
public class TaobaoServiceImpl implements ITaobaoService {

    private ITaobaoDao taobaoDao;

    @Autowired
    public void setTaobaoDao(ITaobaoDao taobaoDao) {
        this.taobaoDao = taobaoDao;
    }

    @Override
    public List<Taobao> findAll() {
        return taobaoDao.findAll();
    }

    @Override
    public List<Map> findGroupBy() {
        List<Map> mapList=taobaoDao.findGroupBy();
        /*变换字段意义：0表示女性，1表示男性，2和NULL表示未知*/
        for (Map map:mapList){
           map.replace("name","0","女性");
           map.replace("name","1","男性");
           map.replace("name","2","未知");
        }
        return mapList;
    }

    @Override
    public List<Map> findSaleAction() {
        List<Map> mapList=taobaoDao.findSaleAction();
        /*<!--所有买家消费行为比例 {0,1,2,3},0表示点击，1表示加入购物车，2表示购买，3表示关注商品-->*/

        for (Map map:mapList){
            map.replace("name","0","点击");
            map.replace("name","1","加入购物车");
            map.replace("name","2","购买");
            map.replace("name","3","关注商品");
        }
        return mapList;
    }

    @Override
    public List<Map> findGenderAge() {
        List<Map> mapList=taobaoDao.findGenderAge();
        /*变换字段意义：0表示女性，1表示男性，2和NULL表示未知
        * 1表示年龄<18,2表示年龄在[18,24]，
        * 3表示年龄在[25,29]，
        * 4表示年龄在[30,34]，5表示年龄在[35,39]，
        * 6表示年龄在[40,49]，
        * 7和8表示年龄>=50,0和NULL则表示未知
        * */
        //删除未知性别以及未知年龄的信息，无分析意义
        // JDK1.8+写法，filter的新特性
        mapList= mapList.stream().filter(map -> !map.get("gender").equals("2")
                && !map.get("age_range").equals("0")).collect(Collectors.toList());
        for (Map map:mapList){
            map.replace("gender","0","女性");
            map.replace("gender","1","男性");

        }
        return mapList;
    }

    @Override
    public List<Map> findTopFive() {
        return taobaoDao.findTopFive();
    }

    @Override
    public List<Map> findProvince() {
        return taobaoDao.findProvince();
    }
}
