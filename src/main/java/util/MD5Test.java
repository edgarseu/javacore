package util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.common.hash.Hashing;

/**
 * Created by caozy on 2017/7/12.
 */
public class MD5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "asjdhfadghfasjfdtiubnv12432";
        Charset charset = Charset.defaultCharset();
        //byte[] strByte = str.getBytes(Charset.defaultCharset());
        MessageDigest md5 =MessageDigest.getInstance("MD5");
        md5.update(str.getBytes(Charset.defaultCharset()));
        byte b[] = md5.digest();
        long value = byteToLong(b);
//        long shardValue = Math.abs(
//            Hashing.md5().newHasher().putString(str, Charset.defaultCharset()).hash().asLong());
        System.out.println();

    }
    //byte数组转成long
    public static long byteToLong(byte[] b) {
        long s = 0;
        long s0 = b[0] & 0xff;// 最低位
        long s1 = b[1] & 0xff;
        long s2 = b[2] & 0xff;
        long s3 = b[3] & 0xff;
        long s4 = b[4] & 0xff;// 最低位
        long s5 = b[5] & 0xff;
        long s6 = b[6] & 0xff;
        long s7 = b[7] & 0xff;

        // s0不变
        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }

}
