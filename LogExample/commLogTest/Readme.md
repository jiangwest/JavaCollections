- Commons Logging: 提供一个日志(Log)接口(interface)
  - 两个基本抽象类：
    - Log(基本记录器)
    - LogFactory(负责创建Log实例)
    
Apache Commons logging开发流程

- 获取Log实例: `private static Log log = LogFactory.getLog(Test.class);`
- 日志记录: `log.debug("Debug info.");`
