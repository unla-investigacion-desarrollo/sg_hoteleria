FROM tomcat:8.5.82-jdk8-temurin-focal
COPY /target/tFLSistemaGestionHotelera.war /usr/local/tomcat/webapps/SGHPipinas.war


CMD ["catalina.sh","run"]
