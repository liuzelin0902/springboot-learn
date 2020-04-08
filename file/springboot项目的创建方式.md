## 1. springboot项目的创建方式

### 创建方式

* <https://start.spring.io/>在线创建，点击generate，解压生成的zip包
* 工具创建，idea new -> project，选择Spring initializr
* maven项目改成springboot项目，在最里层包下创建Application文件，在pom文件添加父依赖spring-boot-starter-parent

### 版本号选择

![](https://ae01.alicdn.com/kf/H529084aca5ae4ef0bd1a049c761e4c971.png)

* Release（优先使用Lv5）：最终版本,Release不会以单词形式出现在软件封面上，取而代之的是符号(R)

* GA:(优先使用Lv5):General Availability,正式版本，官方推荐使用此版本,在国外都是用GA来说明release版本的

* RC:(优先使用Lv4): 该版本已经相当成熟了，基本上不存在导致错误的BUG，与即将发行的正式版相差无几。

* M(优先使用Lv3): 又叫里程碑版本，表示该版本较之前版本有功能上的重大更新。

* SNAPSHOT(优先使用Lv2): 快照版，可以稳定使用，且仍在继续改进版本。

​    下面的基本不要使用

* Beta(优先使用Lv1): 该版本相对于α版已有了很大的改进，消除了严重的错误，但还是存在着一些缺陷，需要经过多次测试来进一步消除，此版本主要的修改对像是软件的UI。

* Alpha(不建议使用): 主要是以实现软件功能为主，通常只在软件开发者内部交流，Bug较多，需要继续修改。

* PRE(不建议使用): 预览版,内部测试版. 主要是给开发人员和测试人员测试和找BUG用的
