

config-server集成spring-cloud-bus
    1.add dependency
    2.add properties：
    spring:
      cloud:
        bus:
          trace:
            enabled: true        #开启cloud bus 跟踪
      rabbitmq:
        host: localhost
        port: 5672
        username: springcloud
        password: 123456

ms-questionnaire添加spring-cloud-bus
    1.add dependency
    2.add properties in bootstrap.yml:
        rabbitmq:
            host: localhost
            port: 5672
            username: springcloud
            password: 123456

测试步骤:
    1.修改配置文件spring-boot-init/config-repo/ms-questionnaire-dev.yml中属性内容
    2.localhost:8013/profile 查看属性内容
    3.localhost:8030/bus/refresh {post}刷新配置
    4.localhost:8013/profile 查看属性是否变化
----------------------------------------------------------------------------