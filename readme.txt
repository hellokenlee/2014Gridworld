**Copyright@2014 KenLee All Rights Reserved**

1.根目录其实为

	- /Gridworld Project/GridWorldCode/projects

2.目录结构
	- firsprohect 		为 Part1代码

	- boxBug      		为 Part2~Part3代码

	- critter     		为 Part4代码

	- sparsegrid  		为 Part5代码

	- gridworld.jar     为 原来提供的包

3.每个目录下的说明

	- build.xml  		ant执行的build

	- src		 		源文件(*.java)

	- bin		 		图片+二进制文件(*.gif+*.class)

	- TestRunner.java   main()函数文件，请把测试代码写在这。

4.怎样运行？

	- cd到带有build.xml的目录

	- 把你的测试代码写到TestRunner.java

	- 执行 ant 会自动编译运行

ps. 其中sparseGrid/src中

SGN,LLOC,HM,TM分别对应要求的SparseGridNode version，LinkedList<OccupantInCol> version,HashMap version,TreeMap version
(TM才不是提莫呢！哼！)