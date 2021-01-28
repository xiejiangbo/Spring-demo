
//加密文件
package cn.com.taiji.spring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 加密解密
 */
public class MyEncryptDecrypt {

    /**
     * 加密文件。
     *
     * @param source   要加密的文件
     * @param dest     加密后的文件
     * @param password 密码
     */
    public void encrypt(String source, String dest, int password) throws FileNotFoundException, IOException {

        // 构建输入输出流
        InputStream is = new FileInputStream(source);
        OutputStream os = new FileOutputStream(dest);
        // 每次读一个字节
        int buffer = 0;
        // 读一个字节。
        while ((buffer = is.read()) != -1) {
            // 写：需要加密就异或一次。
            os.write(buffer ^ password);
        }
        os.close();
        is.close();
    }

    /**
     * 解密文件，两次异常恢复原职。
     * @param source 要解密的文件
     * @param dest 解密以後的文件
     * @param password 密碼。
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void decrypt(String source, String dest, int password) throws FileNotFoundException, IOException {
        this.encrypt(source, dest, password);
    }

    public static void main(String[] args) throws Exception {
         MyEncryptDecrypt test = new MyEncryptDecrypt();
      String source = "D:\\jiamiqian\\1.jpeg";
       String dest = "D:\\jiamihou\\2.jpeg";
       int password = 38;
//        // 加密
    test.encrypt(source, dest, password);
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        source = "D:\\jiamihou\\MyEncryptDecrypt1.java";
        dest = "D:\\jiemihou\\MyEncryptDecrypt2.java";
        // 解密
      //  test.decrypt(source, dest, password);
    }
}
