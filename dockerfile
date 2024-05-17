FROM  docker.io/tomcat:9-jdk17-openjdk

ADD ./target/ordersystem.war webapps/ordersystem.war

RUN cp /usr/share/zoneinfo/Asia/Shanghai    /etc/localtime

CMD ["catalina.sh","run"]
