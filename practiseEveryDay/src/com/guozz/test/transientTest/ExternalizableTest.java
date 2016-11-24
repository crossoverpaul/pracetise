package com.guozz.test.transientTest;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author guozhizhong
 * @version 2016-11-24 09:48:23
 */
public class ExternalizableTest implements Externalizable {
	
	private transient String content = "哈哈~我将会被序列化，不管我是是否被transient关键字修饰";
	

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		 out.writeObject(content);
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		content = (String) in.readObject();
	}
	
	 public static void main(String[] args) throws Exception {
	        ExternalizableTest et = new ExternalizableTest();
	        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
	                new File("ext0000")));
	        out.writeObject(et);

	        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
	                "ext0000")));
	        ExternalizableTest et1 = (ExternalizableTest) in.readObject();
	        System.out.println(et1.content);

	        out.close();
	        in.close();
	    }

}
