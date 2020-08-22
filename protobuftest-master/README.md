# 各大序列化框架性能测试
1. size=10
```
protobuf序列化字节长度:167
protobuf反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
protobuf序列化耗时:196

xml序列化字节长度:645
xml反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
xml序列化耗时:149

json序列化字节长度:350
json反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
json序列化耗时:223

hessian2序列化字节长度:690
hessian2反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
hessian2序列化耗时:63
```
可以看出在数据量很小的情况，几个框架的性能差别不大，hessian2最好，xml甚至比protobuf还要高一些。但是有一个地方需要注意，就是序列化后的字节长度，json是xml的大概1/2多一点，而protobuf只有xml的1/4，而hessian甚至比xml还要长。这在存储敏感或者带宽敏感的场景下是至关重要的。之后的所有测试存储所占空间的比例基本都是一样。

2. size=1000
```
protobuf序列化字节长度:15919
protobuf反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
protobuf序列化耗时:211

xml序列化字节长度:53027
xml反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
xml序列化耗时:256

json序列化字节长度:29962
json反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
json序列化耗时:249

hessian2序列化字节长度:60992
hessian2反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
hessian2序列化耗时:114
```
当数据量来到1000这个量级，仍然是hessian一马当先，可以看到protobuf已经反超xml了，这时候json的性能也已经超过xml，xml的劣势开始渐渐显现。

3. size=100000
```
protobuf序列化字节长度:1788921
protobuf反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
protobuf序列化耗时:333

xml序列化字节长度:5489029
xml反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
xml序列化耗时:1059

json序列化字节长度:3188964
json反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
json序列化耗时:726

hessian2序列化字节长度:6288994
hessian2反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
hessian2序列化耗时:785
```
来到10万这个量级，protobuf反超！而且优势非常明显，几乎是xml性能的3倍，hessian的2倍，序列化后的字节大小为1.7M左右，xml的1/4

4. size=1000000
```
protobuf序列化字节长度:18888922
protobuf反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
protobuf序列化耗时:2405

xml序列化字节长度:55889030
xml反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
xml序列化耗时:4087

json序列化字节长度:32888965
json反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
json序列化耗时:3063

hessian2序列化字节长度:63888995
hessian2反序列化结果:name=张三,id=HO123,age=300,role1=R1,role2=R2
hessian2序列化耗时:4747
```
数据量为100万条，此时protobuf的报文数据大小为18M，xml已经达到了55M，json也有33M，hessian更是到了64M，protobuf的速度仍然是xml的差不多两倍。这里比较诡异的是json在好几次测试中耗时只有1000多ms，但多测几次又会变回3000多ms，从生成的字节码来看，3000ms是比较合理的结果，不知道是做了什么样子的优化。
### 结论
在报文数据量很小的情况，几种格式差别不是很大，建议都可以选择。如果对于报文解析性能要求很高，报文体积小的情况下可以选择hessian，体积大选protobuf。如果需要文本格式，选择json。如果对于存储或者带宽敏感，建议选择protobuf，体积比其他几种格式小太多，传输或者存储都很方便。