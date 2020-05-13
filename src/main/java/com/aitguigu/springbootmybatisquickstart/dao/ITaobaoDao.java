package com.aitguigu.springbootmybatisquickstart.dao;

import com.aitguigu.springbootmybatisquickstart.domain.Taobao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: springboot-mybatis-quickstart
 * @BelongsPackage: com.aitguigu.springbootmybatisquickstart.dao
 * @Author: Boss_king
 * @CreateTime: 2020-05-11 19:05
 * @Description: 数据层接口
 */
@Mapper
public interface ITaobaoDao {
    public List<Taobao> findAll();
    /*查询男女买家对比*/
    public List<Map> findGroupBy();
    /*数据库双11 所有买家消费行为比例*/
    public List<Map> findSaleAction();
    //男女买家各个年龄段交易对比
    public List<Map> findGenderAge();
    //获取销量前五的商品类别
    public List<Map> findTopFive();
    //各个省份的总成交量对比
    public List<Map> findProvince();
}
