#基础镜像
FROM tomcat:7.0.92

#作者
LABEL maintainer="liyunjian"

#运行安装telnet和vim
RUN apt-get -y update && apt-get install -y vim telnet

#挂载点
VOLUME ["/tomcat/data"]

#TOMCAT环境变量
ENV CATALINA_BASE:   /usr/local/tomcat \
    CATALINA_HOME:   /usr/local/tomcat \
    CATALINA_TMPDIR: /usr/local/tomcat/temp \
    JRE_HOME:        /usr

#启动入口
ENTRYPOINT ["catalina.sh","run"]

#健康检查
# HEALTHCHECK --interval=10s --timeout=3s \
#   CMD nc -z localhost 5198 >/dev/null || exit 1

#拷贝war包到tomcat
COPY userTest/target/userTest.war ${CATALINA_HOME}/webapps/