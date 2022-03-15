# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration). 

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .

## MVC
MVC分别对应model,view,control三层。model主要针对业务逻辑模型,view负责页面展示,control用于页面操作逻辑控制和界面切换。下面分别针对三层进行详细分析。

### Model
该部分保护db,model,biz三个子层与之前分层结构的分工类似，分别处理不同的业务分工。

### View
页面展示部分，在该作业中使用的是网页。先编写模板，然后在用户具体的请求中，根据状态control层再对模型进行填充

### Control
View层的模板的填充,根据用户的动作进行页面的切换


