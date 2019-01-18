mvn clean package  -Dmaven.test.skip=true
nohup java -jar

jinfo -flags pid



nohup java -client -XX:CICompilerCount=3 -XX:InitialHeapSize=234881024 -XX:MaxHeapSize=3743416320 -XX:MaxNewSize=1247805440 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=78118912 -XX:OldSize=156762112 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:+UseParallelGC -jar *.jar

nohup java -client *.jar

启动顺序：
1.注册中心
2.网关
3.基础服务
4.权限管理
5.内容服务