package com.aitguigu.springbootmybatisquickstart.controller;

import com.aitguigu.springbootmybatisquickstart.domain.Taobao;
import com.aitguigu.springbootmybatisquickstart.service.impl.TaobaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: springboot-mybatis-quickstart
 * @BelongsPackage: com.aitguigu.springbootmybatisquickstart.controller
 * @Author: Boss_king
 * @CreateTime: 2020-05-11 19:32
 * @Description: 控制层
 */
@RestController
@CrossOrigin(origins = "*")
public class TaobaoController {
    private TaobaoServiceImpl taobaoService;

    @Autowired
    public void setTaobaoService(TaobaoServiceImpl taobaoService) {
        this.taobaoService = taobaoService;
    }
    @RequestMapping(value = "/taobao")
    public List<Taobao> findAll(){
        return taobaoService.findAll();
    }
    @RequestMapping(value = "/gender",method = RequestMethod.GET)
    public List<Map> findGroupBy(){
        return taobaoService.findGroupBy();
    }
    @RequestMapping(value = "/sale_action",method = RequestMethod.GET)
    public List<Map> findSaleAction(){
        return taobaoService.findSaleAction();
    }
    @RequestMapping(value = "/gender_age",method = RequestMethod.GET)
    public List<Map> findGenderAge(){
        return taobaoService.findGenderAge();
    }
    @RequestMapping(value = "/top_five",method = RequestMethod.GET)
    public List<Map> findTopFive(){
        return taobaoService.findTopFive();
    }
    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public List<Map> findProvince(){
        return taobaoService.findProvince();
    }
}
