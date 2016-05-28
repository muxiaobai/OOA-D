# OOA&D
Object-Oriented Analysis &amp; Design 课程设计作业

-------------


##说明：只用看SSH/src/main/java/ooad/ooad包中代码即可，数据库文件，同[task1数据库](https://github.com/muxiaobai/OOAD/tree/master/task1/database) 中


#图片说明
###访问页面：http:localhost:8080/SSH/send_queryAll
###查询结果：
![alt text](https://github.com/muxiaobai/OOAD/blob/master/task3/201505281339.png "title")
##代码分析
###DaoImpl得到所有数据。
![alt text](https://github.com/muxiaobai/OOAD/blob/master/task3/201605281018.png "title")
###Inventory初始化的时候调用DaoImpl给allDAta添加数据
![alt text](https://github.com/muxiaobai/OOAD/blob/master/task3/201605281019.png "title")

###Inventory的search方法，其中需要调用Guitar的equals判断是否返回该Guitar。
![alt text](https://github.com/muxiaobai/OOAD/blob/master/task3/201605281020.png "title")

###前台传入数据，返回查询的数据，调用Inventory的search方法
![alt text](https://github.com/muxiaobai/OOAD/blob/master/task3/201605281351.png "title")


--------------
