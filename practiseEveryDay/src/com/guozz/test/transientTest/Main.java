package com.guozz.test.transientTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;


/**
 * @author guozhizhong
 * @version 2016-11-24 09:46:33
 */
public class Main implements Serializable {

	private static final long serialVersionUID = -5836283489677344417L;
    private transient int classValue = 10;
    private transient Date date = new Date();
    private transient static int staticValue = 10;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.classValue = 11;
        Main.staticValue = 11;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                new File("0xjh000")));
        out.writeObject(m);

        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                new File("0xjh000")));
        Main m1 = (Main) in.readObject();
        in.close();

        System.out.println(m1.classValue);
        System.out.println((m1.date == null ? "date is null"
                : "date is not null"));
    }
}
