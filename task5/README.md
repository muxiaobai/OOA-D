# OOA&D
Object-Oriented Analysis &amp; Design 课程设计作业

-------------

##说明：[数据库](https://github.com/muxiaobai/OOAD/tree/master/task5/database) ，Spring注入
----------------------------
##图片运行结果
![Test](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041015.png "title")
![](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041017.png "title")
![](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041020.png "title")
-----------------------------
##代码分析
###更换文件，修改数据库
![更换文件修改数据库](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041021.png "title")
![更换文件修改数据库](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041022.PNG "title")
![更换文件修改数据库](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041023.PNG "title")
###初始化仓库，中间注入IGuitarDao
![注入](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041024.png "title")
###init方法中调用IGuitarDao，findAll方法
![](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041025.png "title")
###Inventory其他方法
![Inventory其他方法](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041026.png "title")
###Inventory其他方法。调用IGuitarDao方法，持久化
![Inventory其他方法实现](https://github.com/muxiaobai/OOAD/blob/master/task5/201606041040.png "title")

--------------
