FROM  openjdk:21
EXPOSE 9988
ADD target/demo.jar demo.jar
ENTRYPOINT [ "java","-jar","demo.jar" ]
