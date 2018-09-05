2.0版本中所有的事件按执行的先后顺序如下：

ApplicationStartingEvent<BR>
ApplicationEnvironmentPreparedEvent<BR>
ApplicationPreparedEvent<BR>
ApplicationStartedEvent <= 新增的事件<BR>
(CommandLineRunner)<br>
ApplicationReadyEvent<BR>
ApplicationFailedEvent