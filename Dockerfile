FROM tomcat:8.5.82-jdk8-temurin
COPY /target/tFLSistemaGestionHotelera.war /usr/local/tomcat/webapps/tFLSistemaGestionHotelera.war

CMD ["catalina.sh","run"]