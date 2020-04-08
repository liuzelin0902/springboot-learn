## springboot搭建多模块项目

* 先创建一个maven项目demo-parent，删除src文件夹

* 然后创建4个module（demo-base，demo-dao，demo-service，demo-web）,其中demo-web是springboot项目，其他三个是maven项目，demo-web依赖demo-service，demo-service依赖demo-dao，demo-dao依赖demo-base

* 修改5个pom.xml文件

  demo-parent的pom.xml文件声明父类项目spring-boot-starter-parent，添加4个module，添加spring-boot-starter依赖

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.2.6.RELEASE</version>
          <relativePath/> <!-- lookup parent from repository -->
      </parent>
      
      <groupId>com.liuzelin</groupId>
      <artifactId>demo-parent</artifactId>
      <version>1.0-SNAPSHOT</version>
      <modules>
          <module>demo-base</module>
          <module>demo-dao</module>
          <module>demo-service</module>
          <module>demo-web</module>
      </modules>
      <packaging>pom</packaging>
  
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter</artifactId>
          </dependency>
      </dependencies>
  </project>
  ```

  demo-base的pom.xml声明父类项目demo-parent

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <parent>
          <artifactId>demo-parent</artifactId>
          <groupId>com.liuzelin</groupId>
          <version>1.0-SNAPSHOT</version>
      </parent>
      <modelVersion>4.0.0</modelVersion>
  
      <artifactId>demo-base</artifactId>
  </project>
  ```

  demo-dao的pom.xml声明父类项目demo-parent，添加demo-base依赖

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <parent>
          <artifactId>demo-parent</artifactId>
          <groupId>com.liuzelin</groupId>
          <version>1.0-SNAPSHOT</version>
      </parent>
      <modelVersion>4.0.0</modelVersion>
      <artifactId>demo-dao</artifactId>
  
      <dependencies>
          <dependency>
              <groupId>com.liuzelin</groupId>
              <artifactId>demo-base</artifactId>
              <version>1.0-SNAPSHOT</version>
          </dependency>
      </dependencies>
  </project>
  ```

  demo-service的pom.xml声明父类项目demo-parent，添加demo-dao依赖

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <parent>
          <artifactId>demo-parent</artifactId>
          <groupId>com.liuzelin</groupId>
          <version>1.0-SNAPSHOT</version>
      </parent>
      <modelVersion>4.0.0</modelVersion>
      <artifactId>demo-service</artifactId>
  
      <dependencies>
          <dependency>
              <groupId>com.liuzelin</groupId>
              <artifactId>demo-dao</artifactId>
              <version>1.0-SNAPSHOT</version>
          </dependency>
      </dependencies>
  </project>
  ```

  demo-web的pom.xml声明父类项目demo-parent，添加demo-service，spring-boot-starter-web依赖

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <parent>
          <artifactId>demo-parent</artifactId>
          <groupId>com.liuzelin</groupId>
          <version>1.0-SNAPSHOT</version>
      </parent>
      <groupId>com.liuzelin</groupId>
      <artifactId>demo-web</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <name>demo-web</name>
      <description>Demo project for Spring Boot</description>
  
      <properties>
          <java.version>1.8</java.version>
      </properties>
  
      <dependencies>
          <dependency>
              <groupId>com.liuzelin</groupId>
              <artifactId>demo-service</artifactId>
              <version>1.0-SNAPSHOT</version>
          </dependency>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-test</artifactId>
              <scope>test</scope>
              <exclusions>
                  <exclusion>
                      <groupId>org.junit.vintage</groupId>
                      <artifactId>junit-vintage-engine</artifactId>
                  </exclusion>
              </exclusions>
          </dependency>
      </dependencies>
  
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build>
  </project>
  ```

  若项目启动时报错：required a bean of type 'xxxService' that could not be found，需将application.java移动到demo-web下与xxxService同名的目录下
