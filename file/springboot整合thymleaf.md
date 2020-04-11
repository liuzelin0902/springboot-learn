## 整合thymleaf

* ### 配置thymleaf过程

1. 加入依赖spring-boot-starter-thymeleaf

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  ```

2. 添加thymeleaf配置

  ```properties
  # html缓存，生产环境可开启
  spring.thymeleaf.cache=false
  spring.thymeleaf.prefix=classpath:/templates/
  spring.thymeleaf.suffix=.html
  spring.thymeleaf.mode=HTML5
  spring.thymeleaf.encoding=UTF-8
  ```

3. 在resources下的templates目录下创建html文件，如果要是使用thymeleaf语法，要在html标签中添加xmlns:th="http://www.thymeleaf.org"

  ```html
  <!DOCTYPE html>
  <!--suppress ALL-->
  <html xmlns:th="http://www.thymeleaf.org">
  <head>
      <meta charset="UTF-8"/>
      <h1 th:text="${title}"></h1>
  </head>
  <body>
  </body>
  </html>
  ```

4. 在controller中写业务逻辑

  ```java
  @GetMapping("/index")
  public String index(Model model) {
      model.addAttribute("title", "liuzelin");
      return "index";
  }
  ```

5. html中引入静态文件，如引入layui，将layui目录放在在resources下static目录下

   ![Snipaste_2020-04-11_18-18-22.png](https://user-gold-cdn.xitu.io/2020/4/11/17168bfb3608e7db?w=409&h=487&f=png&s=18699)

   ```
   <link th:href="@{/layui/css/layui.css}" rel="stylesheet" type="text/css">
   <script th:src="@{/layui/layui.all.js}"></script>
   ```
* ### controller传值的4种方式

  1. 使用Model

     ```java
     @GetMapping("/index")
     public String index(Model model) {
         model.addAttribute("title", "liuzelin");
         return "index";
     }
     ```

  2. 使用ModelAndView

     ```java
     @GetMapping("/index1")
     public ModelAndView index1(ModelAndView view) {
         view.setViewName("index");
         view.addObject("title", "liuzelin, ModelAndView");
         return view;
     }
     ```

  3. 使用HashMap

     ```java
     @GetMapping("/index2")
     public String index2(HashMap map) {
         map.put("title", "liuzelin, HashMap");
         return "index";
     }
     ```

  4. 使用HttpServletRequest

     ```java
     @GetMapping("/index3")
     public String index3(HttpServletRequest request) {
         request.setAttribute("title", "liuzelin, HttpServletRequest");
         return "index";
     }
     ```

### Thymeleaf语法

html有的属性，Thymeleaf基本都有，而常用的属性大概有七八个。其中th属性执行的优先级从1~8，数字越低优先级越高。

一、**th:text** ：设置当前元素的文本内容，相同功能的还有**th:utext**，两者的区别在于前者不会转义html标签，后者会。优先级不高：order=7

二、**th:value**：设置当前元素的value值，类似修改指定属性的还有**th:src**，**th:href**。优先级不高：order=6

三、**th:each**：遍历循环元素，和th:text或th:value一起使用。注意该属性修饰的标签位置，详细往后看。优先级很高：order=2

四、**th:if**：条件判断，类似的还有**th:unless**，**th:switch**，**th:case**。优先级较高：order=3

五、**th:insert**：代码块引入，类似的还有**th:replace**，**th:include**，三者的区别较大，若使用不恰当会破坏html结构，常用于公共代码块提取的场景。优先级最高：order=1

六、**th:fragment**：定义代码块，方便被th:insert引用。优先级最低：order=8

七、**th:object**：声明变量，一般和*{}一起配合使用，达到偷懒的效果。优先级一般：order=4

八、**th:attr**：修改任意属性，实际开发中用的较少，因为有丰富的其他th属性帮忙，类似的还有th:attrappend，th:attrprepend。优先级一般：order=5



常用的内置方法

一、**strings**：字符串格式化方法，常用的Java方法它都有。比如：equals，equalsIgnoreCase，length，trim，toUpperCase，toLowerCase，indexOf，substring，replace，startsWith，endsWith，contains，containsIgnoreCase等

二、**numbers**：数值格式化方法，常用的方法有：formatDecimal等

三、**bools**：布尔方法，常用的方法有：isTrue，isFalse等

四、**arrays**：数组方法，常用的方法有：toArray，length，isEmpty，contains，containsAll等

五、**lists**，**sets**：集合方法，常用的方法有：toList，size，isEmpty，contains，containsAll，sort等

六、**maps**：对象方法，常用的方法有：size，isEmpty，containsKey，containsValue等

七、**dates**：日期方法，常用的方法有：format，year，month，hour，createNow等