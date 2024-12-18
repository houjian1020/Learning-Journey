1、MyBatis是什么？
    是一个持久层框架框架，开发时只需要关注 SQL 语句本身，不需要关注加载驱动、创建连接、创建statement 等繁杂的过程
    MyBatis 可以使用 XML 或注解来配置和映射原生信息

2、JDBC编程有哪些不足之处，MyBatis是如何解决的？
    频繁创建数据库连接对象、释放，容易造成系统资源浪费，影响系统性能。
    解决：在mybatis中配置数据链接池，使用连接池管理数据库连接
    Sql语句写在代码中造成代码不易维护
    解决：将Sql语句配置在XXXXmapper.xml文件中与java代码分离


3、#{}和${}的区别
    #{}是占位符，预编译处理；可以防止SQL注入
    ${}是拼接符，没有预编译处理；${} 不能防止SQL 注入

4、模糊查询like语句该怎么写    MybatisExampleController.java
    CONCAT(’%’,#{question},’%’) 使用CONCAT()函数，（推荐）


5、在mapper中如何传递多个参数 MybatisExampleController.java



6、Mybatis如何执行批量操作 MybatisExampleController.java 
    使用foreach标签，主要用在构建in条件中属性主要有item，index，collection，open，separator，close。
    item 表示集合中每一个元素进行迭代时的别名，随便起的变量名；
    index 指定一个名字，用于表示在迭代过程中，每次迭代到的位置，不常用；
    open 表示该语句以什么开始，常用“(”；
    separator 表示在每次进行迭代之间以什么符号作为分隔符，常用“,”；
    close 表示以什么结束，常用“)”








