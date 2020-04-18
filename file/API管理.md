## API管理

我给大家介绍一个API管理框架[knife4j](<https://doc.xiaominfo.com/>)，是swagger的升级版，在swagger的基础上新增了一些功能

用法：

 * 加入依赖knife4j-spring-boot-starter

   ```xml
   <dependency>
       <groupId>com.github.xiaoymin</groupId>
       <artifactId>knife4j-spring-boot-starter</artifactId>
       <!--在引用时请在maven中央仓库搜索最新版本号-->
       <version>2.0.2</version>
   </dependency>
   ```

* 新增swagger配置类

  ```java
  @Configuration
  @EnableSwagger2
  @EnableKnife4j
  @Import(BeanValidatorPluginsConfiguration.class)
  public class SwaggerConfiguration {
      @Bean(value = "defaultApi2")
      public Docket defaultApi2() {
          Docket docket = new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  //分组名称
                  .groupName("2.X版本")
                  .select()
                  //这里指定Controller扫描包路径
                  .apis(RequestHandlerSelectors.basePackage("com.liuzlin.springbootdemo.controller"))
                  .paths(PathSelectors.any())
                  .build();
          return docket;
      }
  
      private ApiInfo apiInfo() {
          Contact contact = new Contact("liuzelin", "", "XXX@foxmail.com");
          return new ApiInfoBuilder()
                  .title("Swagger 1.x API接口文档")
                  .description("")
                  .contact(contact)
                  .version("1.0.0")
                  .build();
      }
  }
  ```

* swagger API使用

  常用注解： 
  - @Api()用于类； 
    表示标识这个类是swagger的资源 

  - @ApiOperation()用于方法； 
    表示一个http请求的操作 

  - @ApiParam()用于方法，参数，字段说明； 
    表示对参数的添加元数据（说明或是否必填等） 

  - @ApiModel()用于类 
    表示对类进行说明，用于参数用实体类接收 

  - @ApiModelProperty()用于方法，字段 
    表示对model属性的说明或者数据操作更改 

  - @ApiIgnore()用于类，方法，方法参数 
    表示这个方法或者类被忽略 

  - @ApiImplicitParam() 用于方法 
    表示单独的请求参数 

  - @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam

    

输入<http://127.0.0.1:8080/springboot-learn/doc.html>，展示如下

![图片](https://ae01.alicdn.com/kf/H8411105029014dec9e7e424dc3727221D.png)
