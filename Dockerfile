FROM heroku/jvm
ONBUILD COPY ["*.gradle", "gradlew", "*.properties", "/app/user/"]
ONBUILD COPY ["gradle/wrapper/*", "/app/user/gradle/wrapper/"]
ONBUILD RUN ./gradlew dependencies; true
ONBUILD RUN ./gradlew build; true
ONBUILD RUN ./gradlew stage