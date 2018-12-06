import java.security.KeyFactory;  
import java.security.PrivateKey;  
import java.security.spec.PKCS8EncodedKeySpec;  
  
import org.apache.commons.codec.binary.Base64;  
  
public class SignUtil {  
      
    //#priKeyText  
    private  static String priKeyText;
      
    //#pubKeyText  
    private  static String pubKeyText;
      
    private final static String CHARACTER_ENCODING_UTF_8 = "UTF-8";  
      
    public static void main(String[] args) {  
          
        String signString = " {\"a\":\"123\"}";
        try {  
            // 加签  
            String localSignature = SignUtil.sign(priKeyText.getBytes(CHARACTER_ENCODING_UTF_8), signString);  
            System.out.println(localSignature);  
            //验签  
            boolean verifyResult = SignUtil.verify(pubKeyText.getBytes(CHARACTER_ENCODING_UTF_8), signString, localSignature);  
            System.out.println("verifyResult:" + verifyResult);  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * RSA私钥加签 
     * @param priKeyText经过base64处理后的私钥 
     * @param plainText明文内容 
     * @return 十六进制的签名字符串 
     * @throws Exception  
     */  
    public static String sign(byte[] priKeyText, String plainText) throws Exception {  
        try {  
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKeyText));  
            KeyFactory keyf = KeyFactory.getInstance("RSA");  
            PrivateKey prikey = keyf.generatePrivate(priPKCS8);  
  
            // 用私钥对信息生成数字签名  
            java.security.Signature signet = java.security.Signature.getInstance("SHA256withRSA");  
            signet.initSign(prikey);  
            signet.update(plainText.getBytes("UTF-8"));  
            return DigestUtil.byte2hex(signet.sign());  
        } catch (Exception e) {  
            throw e;   
        }  
    }  
      
    /** 
     * 公钥验签 
     * @param pubKeyText经过base64处理后的公钥 
     * @param plainText明文内容 
     * @param signText十六进制的签名字符串 
     * @return 验签结果 true验证一致 false验证不一致 
     */  
    public static boolean verify(byte[] pubKeyText, String plainText, String signText) {  
        try {  
            // 解密由base64编码的公钥,并构造X509EncodedKeySpec对象  
            java.security.spec.X509EncodedKeySpec bobPubKeySpec = new java.security.spec.X509EncodedKeySpec(  
                    Base64.decodeBase64(pubKeyText));  
            // RSA算法  
            java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");  
            // 取公钥匙对象  
            java.security.PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);  
            // 十六进制数字签名转为字节  
            byte[] signed = DigestUtil.hex2byte(signText.getBytes("UTF-8"));  
            java.security.Signature signatureChecker = java.security.Signature.getInstance("SHA256withRSA");  
            signatureChecker.initVerify(pubKey);  
            signatureChecker.update(plainText.getBytes("UTF-8"));  
            // 验证签名是否正常  
            return signatureChecker.verify(signed);  
        } catch (Throwable e) {  
            return false;  
        }  
    }  
}  