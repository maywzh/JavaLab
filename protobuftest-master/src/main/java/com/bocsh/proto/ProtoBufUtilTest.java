package com.bocsh.proto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class ProtoBufUtilTest {
	 
    public static void main(String[] args) throws Exception {
    	
    	int size=1000000;
    	boolean isPerformanceTest = true;
 
    	if(size>5) isPerformanceTest=false;
        User user = new User();
        user.setAge(300);
        user.setDesc("备注");
        user.setName("张三");
        user.setId("HO123");
        
        List<Role> list = new ArrayList<Role>();
        for(int i=1;i<=size;i++) {
        	Role role = new Role();
            role.setId("R" + Integer.toString(i));
            role.setName("经办");
            list.add(role);
        }
        
        user.setRoleList(list);
        
        //protobuf序列化
        long proto1 = (new Date()).getTime();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        Schema<User> schema = RuntimeSchema.getSchema(User.class);
        byte[] serializerResult = ProtobufIOUtil.toByteArray(user, schema, buffer);
        
        if(isPerformanceTest) {
        	System.out.println("protobuf序列化二进制:" + bytes2hex(serializerResult));
            System.out.println("protobuf序列化ascii:" + new String(serializerResult));
        }
        
        System.out.println("protobuf序列化字节长度:" + serializerResult.length);
        User protouser = new User();
        ProtobufIOUtil.mergeFrom(serializerResult, protouser, schema);
 
        long proto2 = (new Date()).getTime();
        System.out.println("protobuf反序列化结果:" + protouser);
        System.out.println("protobuf序列化耗时:" + (proto2 - proto1));

        System.out.println("");
        
        
        //xml序列化
        
        long xml1 = (new Date()).getTime();
        JAXBContext jc = JAXBContext.newInstance(User.class);
        Marshaller marshaller = jc.createMarshaller();
        Writer sw = new StringWriter();        
        marshaller.marshal(user, sw);
        String xml = sw.toString();
        
        if(isPerformanceTest) {
        	System.out.println("xml序列化二进制:" + bytes2hex(xml.getBytes()));
            System.out.println("xml序列化ascii:" + xml);
        }
        
        System.out.println("xml序列化字节长度:" + xml.getBytes().length);
        
        Unmarshaller um = jc.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        User xmluser = (User) um.unmarshal(sr);
        
        long xml2 = (new Date()).getTime();
        System.out.println("xml反序列化结果:" + xmluser);
        System.out.println("xml序列化耗时:" + (xml2 - xml1));

        System.out.println("");
        
        //json序列化
        long json1 = (new Date()).getTime();
        String jsonStr = JSON.toJSONString(user);
        
        if(isPerformanceTest) {
        	System.out.println("json序列化二进制:" + bytes2hex(jsonStr.getBytes()));
            System.out.println("json序列化ascii:" + jsonStr);
        }
        
        System.out.println("json序列化字节长度:" + jsonStr.getBytes().length);
        
        User jsonuser=(User)JSON.parseObject(jsonStr, User.class);
        long json2 = (new Date()).getTime();
        System.out.println("json反序列化结果:" + jsonuser);
        System.out.println("json序列化耗时:" + (json2 - json1));

        System.out.println("");
        
        //hessian2序列化
        long hessian1 = (new Date()).getTime();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
        hessianOutput.writeObject(user);
        byte[] hessianbyte = byteArrayOutputStream.toByteArray();
        
        if(isPerformanceTest) {
        	System.out.println("hessian2序列化二进制:" + bytes2hex(hessianbyte));
            System.out.println("hessian2序列化ascii:" + new String(hessianbyte));
        }
        
        System.out.println("hessian2序列化字节长度:" + hessianbyte.length);
        
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(hessianbyte);
        HessianInput hessianInput = new HessianInput(byteArrayInputStream);
        User hessianuser = (User) hessianInput.readObject();
        
        long hessian2 = (new Date()).getTime();
        System.out.println("hessian2反序列化结果:" + hessianuser);
        System.out.println("hessian2序列化耗时:" + (hessian2 - hessian1));
    }
    
    public static String bytes2hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {     
                tmp = "0" + tmp;
            }
            sb.append(tmp.toUpperCase()).append(" ");
        }
        return sb.toString();

    }
 
}
