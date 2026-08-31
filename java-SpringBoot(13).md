1、为什么要用SpringBoot
`   快速开发，快速整合，配置简化、内嵌服务容器（内置的Tomcat）`


2、SpringBoot与SpringCloud 区别
    SpringBoot：是快速开发框架
    SpringCloud：是完整的微服务框架 ，SpringCloud依赖于SpringBoot

3、Spring Boot 的核心注解是哪个？它主要由哪几个注解组成的？(重点)
`   核心注解：启动类上面的@SpringBootApplication
    组成：
    @SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。
    @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置， 例
    如： java 如关闭数据源自动配置功能： @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })。
    @ComponentScan：包扫描`


4、SpringBoot Starter的工作原理
`   理解：SpringBoot就是依赖聚合 + 自动配置
    原理：扫描Jar包的META_INF/spring.factories 文件、   条件筛选：@Conditional 系列注解 、  生成 Bean 并注入容器`


5、运行 Spring Boot 有哪几种方式？
    开发环境：执行main方法
    打包后：打包用java -jar 命令 


6、Async异步调用方法     补充代码实例
    在方法上使用@Async注解即可实现方法的异步调用。 注意：需要在启动类加入@EnableAsync


7、如何在 Spring Boot 启动的时候运行一些特定的代码？  StartUpTask.java 
`   应用级业务初始化：实现ApplicationRunner接口，run方法接收一个ApplicationArguments对象；实现CommandLineRunner接口，run方法接收一个String对象
    Bean初始化： @PostConstruct 注解 
`


8、Spring Boot 有哪几种 `读取配置文件属性值` 的方式？ 补充代码实例
    @Value ：轻量级注入， 单个配置项
    @ConfigurationPropertie：`强烈推荐`；支持嵌套对象、集合
    @PropertySource ： 外部文件，仅支持 .properties 格式
    @Environment：动态读取所有配置


9、什么是 JavaConfig？
    定义：用于 `替代` 传统XML配置文件的一种配置方式 ， 使用 `Java代码 和 注解` 来定义Spring容器中的Bean及其依赖关系，从而实现依赖注入（DI）和控制反转（IoC）
    核心注解：
        @Configuration‌：用于标记一个类作为配置类，相当于传统的XML配置文件。
        @Bean‌：用于标记一个方法，返回一个Bean实例，并交给Spring容器管理。
        @ComponentScan‌：默认会扫描该类所在的包下所有的配置类，并注册Bean。
        @Autowired‌：用于自动装配依赖的Bean


10、SpringBoot的 自动配置 原理是什么？(重点)
`   @EnableAutoConfiguration‌用于启用自动配置：
        扫描：读取所有jar包中META_INF/Spring.factories加载可能用到的自动配置类
        手动排除：不想用的类，通过@SpringBootApplication 或者 application.yml 排除指定类
        条件过滤：将满足条件（@Conditional）的自动配置类返回
        生成 Bean 并注入容器
`

11、spring boot 核心配置文件是什么？bootstrap.properties 和application.properties 有何区别 ?
    spring boot 核心的两个配置文件：bootstrap (. yml 或者 . properties) 、application (. yml 或者 . properties)
    ‌加载顺序：bootstrap在Boot应用程序启动时加载； application在bootstrap.properties之后加载
    ‌作用范围：bootstrap`全局`的;application`应用`程序级别
    使用场景：Spring Cloud项目中使用；Boot项目中使用


12、 Spring Boot 中如何实现定时任务 ?
    使用 Spring 中的 @Scheduled注解
    使用第三方框架 Quartz


13、SpringBoot 启动过程(重点)
    `
    启动入口(调用主启动类的SpringApplication.run()方法)、
    初始化配置(判断应用类型；加载 spring.factories 中的配置类、监听器)、
    环境准备(加载配置源：命令行参数、配置文件、环境变量等；激活环境配置：开发、测试、生产环境‌)、
    应用上下文创建(根据应用类型创建对应的上下文对象)、
    刷新上下文(加载 Bean定义：注解 、加载并过滤 spring.factories 中的自动配置类;  实例化单例 Bean； 启动内嵌服务器;)、
    完成启动`