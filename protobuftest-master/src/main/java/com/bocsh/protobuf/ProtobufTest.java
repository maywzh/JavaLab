package com.bocsh.protobuf;

import java.util.Date;

public class ProtobufTest {
	
	public static void main(String[] args) throws Exception {
		
		int size=1000000;
		User.Builder build = User.newBuilder();
		build.setAge(300);
		build.setDesc("备注");
		build.setName("张三");
		build.setId("HO123");
		
		for(int i=1;i<=size;i++) {
        	User.Role.Builder role = User.Role.newBuilder();
        	role.setId("R" + Integer.toString(i));
            role.setName("经办");
            
            build.addRoles(role);
        }
		long proto1 = (new Date()).getTime();
		User user = build.build();
		
		byte[] data = user.toByteArray();
		//System.out.println((new Date()).getTime());
		//System.out.println(new String(data));
		//System.out.println(bytes2hex(data));
		
		//反序列化
		User user2 = User.parseFrom(data);
		long proto2 = (new Date()).getTime();
		//System.out.print(user2.getAge());
		//System.out.print(user2.getName());
		
		System.out.println("数据量大小:" + size);
        System.out.println("原生protobuf序列化字节长度:" + data.length);
        System.out.println("原生protobuf序列化耗时:" + (proto2 - proto1));

        System.out.println("");
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
