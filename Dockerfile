FROM openjdk:8
ADD build/libs/library.jar library.jar
EXPOSE 8085
ENTRYPOINT ['java', '-jar', 'library.jar']