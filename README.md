# spring-boot-swagger-starter
spring-boot项目快速添加swagger包括swagger-ui，用于管理接口文档以及页面调试
## 使用方法
**0.0.1已发布到maven中央仓库，欢迎使用**

```xml
    <dependency>
        <groupId>com.github.wangyuheng</groupId>
        <artifactId>swagger-starter</artifactId>
        <version>0.0.1</version>
    </dependency>
```

### 发布starter到本地仓库
在**SwaggerStarter**目录执行

```
    mvn clean install 
```

此命令可以将jar添加进本地仓库
### 运行demo
在SwaggerStarterDemo目录执行

```
    mvn spring-boot:run 
```

可以启动spring-boot项目，默认端口号为**8080**,在浏览器访问[http://localhost:8080/](http://localhost:8080/),可以看到demo接口事例。
或者可以将项目导入常用IDE运行。
### 编辑配置文件
配置文件路径为 **spring-boot-swagger-starter/SwaggerStarterDemo/src/main/resources**，修改对应的配置项，重新启动可以在demo页面查看变动。
## 设计
starter为方便项目使用，尽量简化，不添加无用依赖，自动化部分设置，留出配置文件方便定制化。


