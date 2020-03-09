FROM openjdk:8
ADD build/libs/library.jar library.war
EXPOSE 8085
ENTRYPOINT ['java', '-jar', 'library.war']