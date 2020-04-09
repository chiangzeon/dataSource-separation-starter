# dataSource-separation-starter
基于springboot的SPI的数据库读写分离starter

在启动类上添加EnableDataSourceSeparationConfiguration注解即可
默认状态是开启，需要配置数据库连接信息

for example：
#默认开启，可不设置值
#spring.cloud.chiang.separation.enabled=true

spring.cloud.chiang.separation.read.url=jdbc:mysql://localhost:3306/test?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8
spring.cloud.chiang.separation.read.username=root
spring.cloud.chiang.separation.read.password=root


spring.cloud.chiang.separation.write.url=jdbc:mysql://localhost:3307/test?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8
spring.cloud.chiang.separation.write.username=root
spring.cloud.chiang.separation.write.password=root

只要对需要进行读写分离的业务方法加上对应注解即可，默认为读数据库
for example：
@Separation(dataSource = DataSourceEnum.write)
