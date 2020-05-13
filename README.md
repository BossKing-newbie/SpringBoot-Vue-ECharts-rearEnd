# 一、创建SpringBoot项目

![](https://s1.ax1x.com/2020/05/13/YaVYM8.png)

# 二、创建类路径下结构

![](https://s1.ax1x.com/2020/05/13/YaVtsS.png)

## 1、创建实体类

用户行为日志user_log.csv，日志中的字段定义如下：
1. user_id | 买家id
2. item_id | 商品id
3. cat_id | 商品类别id
4. merchant_id | 卖家id
5. brand_id | 品牌id
6. month | 交易时间:月
7. day | 交易事件:日
8. action | 行为,取值范围{0,1,2,3},0表示点击，1表示加入购物车，2表示购买，3表示关注商品
9. age_range | 买家年龄分段：1表示年龄<18,2表示年龄在[18,24]，3表示年龄在[25,29]，4表示年龄在[30,34]，5表示年龄在[35,39]，6表示年龄在[40,49]，7和8表示年龄>=50,0和NULL则表示未知
10. gender | 性别:0表示女性，1表示男性，2和NULL表示未知
11. province| 收获地址省份

以user_log表结构进行创建，表结构如下：

![](https://s1.ax1x.com/2020/05/13/YaV8RP.png)

```java
public class Taobao implements Serializable {
    private String user_id;
    private String item_id;
    private String cat_id;
    private String merchant_id;
    private String brand_id;
    private String month;
    private String day;
    private String action;
    private String age_range;
    private String gender;
    private String province;

    @Override
    public String toString() {
        return "Taobao{" +
                "user_id='" + user_id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", cat_id='" + cat_id + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", brand_id='" + brand_id + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", action='" + action + '\'' +
                ", age_range='" + age_range + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

```

## 2、创建Dao层接口和Service层接口

```java
public interface ITaobaoDao {
    public List<Taobao> findAll();
}
```

```java
public interface ITaobaoService {
    public List<Taobao> findAll();
}
```

## 3、创建application.yml进行数据源配置

```yaml
server:
  port: 8081
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/dbtaobao?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: password
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.aitguigu.springbootmybatisquickstart.domain
  #开启驼峰命名 该配置项就是指将带有下划线的表字段映射为驼峰格式的实体类属性
  configuration:
    map-underscore-to-camel-case: false
# mybatis相关配置
```

## 4、编写taobaoMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		"http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.aitguigu.springbootmybatisquickstart.dao.ITaobaoDao">
	<select id="findAll" resultType="Taobao">
		select * from user_log
	</select>

</mapper>
```



## 5、创建Service层实现类，Dao层添加注解映射@Mapper

```java
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
}
```

```java
@Mapper
public interface ITaobaoDao {
    public List<Taobao> findAll();
}
```

## 6、编写controller层

```java
@RestController
public class TaobaoController {
    private TaobaoServiceImpl taobaoService;

    //这里差点忘记配置
    @Autowired
    public void setTaobaoService(TaobaoServiceImpl taobaoService) {
        this.taobaoService = taobaoService;
    }
    @RequestMapping("/taobao")
    public List<Taobao> findAll(){
        return taobaoService.findAll();
    }
}
```

# 三、启动

![](https://s1.ax1x.com/2020/05/13/YaVGxf.png)

# 四、resultMap知识点

**resultMap是Mybatis最强大的元素，它可以将查询到的复杂数据（比如\**查询到\**几个表中数据）\**映射\**到一个结果集当中。**

**resultMap包含的元素：**

```xml
<!--column不做限制，可以为任意表的字段，而property须为type 定义的pojo属性-->
<resultMap id="唯一的标识" type="映射的pojo对象">
  <id column="表的主键字段，或者可以为查询语句中的别名字段" jdbcType="字段类型" property="映射pojo对象的主键属性" />
  <result column="表的一个字段（可以为任意表的一个字段）" jdbcType="字段类型" property="映射到pojo对象的一个属性（须为type定义的pojo对象中的一个属性）"/>
  <association property="pojo的一个对象属性" javaType="pojo关联的pojo对象">
    <id column="关联pojo对象对应表的主键字段" jdbcType="字段类型" property="关联pojo对象的主席属性"/>
    <result  column="任意表的字段" jdbcType="字段类型" property="关联pojo对象的属性"/>
  </association>
  <!-- 集合中的property须为oftype定义的pojo对象的属性-->
  <collection property="pojo的集合属性" ofType="集合中的pojo对象">
    <id column="集合中pojo对象对应的表的主键字段" jdbcType="字段类型" property="集合中pojo对象的主键属性" />
    <result column="可以为任意表的字段" jdbcType="字段类型" property="集合中的pojo对象的属性" />  
  </collection>
</resultMap>
```

# 五、以user_log为例，查询男女买家对比

mapper/taobaoMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		"http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.aitguigu.springbootmybatisquickstart.dao.ITaobaoDao">
	<select id="findAll" resultType="Taobao">
		select * from user_log limit 10
	</select>

	<select id="findGroupBy" resultMap="groupByMapper">
/*男女买家交易对比*/
		select gender,count(*) as num from user_log group by gender ORDER BY num desc
	</select>
	<resultMap id="groupByMapper" type="java.util.Map">
		<result column="gender" property="gender" jdbcType="VARCHAR"/>
		<result column="num" property="num" jdbcType="INTEGER"/>
	</resultMap>
</mapper>
```

ITaobaoDao.java

```java
@Mapper
public interface ITaobaoDao {
    public List<Taobao> findAll();
    public List<Map> findGroupBy();
}
```

