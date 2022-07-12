package com.alipay.config;

import java.io.FileWriter;

import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000118603480";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCM4sXnclVHaF/uzr4R6gnO9g7mVTbNdY0qRkxgVpqvTgme0E644GYRXRbSVucLPtfvrhOIxXNf7tZF14z7KqRyCGkAbX0Wf1X9xY00f+zeV0/BvxpdCBj06b5YtjlvqMBY5KRupSVfOJ3v8A48WVrQBcZ6R/QBBFM+Gf73m1NT/Bw9GScpcMUHnPIL6KfK6IC6OzQdBv1QUy/GnzyxNSm8j7epkYc/aLPvRjddeCagMM4gcbs8A7rK8nVo3snzL/pSWARoVqgAgUABOts0dAyHAU8EYQthUzGeUHXaArvP/8mUx5r9k5EDfwEUic35nx3929372FBKjiqi3uy6yU5LAgMBAAECggEANTC89SfmaIJQjdHCUvMgZuHhODb97M4v0MEfvtOTrRHyceJFhmk6P938asdijY1Za2U2fNHHQHXkshOyZ3VvBpqEQiQUMPU8WwZFzIdrv3oJY6Wp52vSOE0zjzylLLHyhN0184woMu4mOttQFJrLvXQgvjQCPIwMfYrFB2i+KhuaiI+WMMZzgrQQAYFdwyilWhBAEvegceTgNlKtfd2ZSP7PfeUFWWyI+nEvjM9IQyl0UBs3LBDrCNEjSY+QU0lGXMSIEwfiov7WVvwFCiUeRKMzqS44nwI7GwnLVUgrLl/vlBFdjR34bRO7/QdVgrdSnySoqtUC61vCrs/XMVuISQKBgQC//t58p0awsieCsXsDOlL7TqyZwJjhYuthTR2G0ygq5mWV5iE6xjH5orcDM7WB7tM4Ua+cavD4swDVVrkvoOoMNOkvGwmwKckJPX/HwWlUetLZWEhkgeowuypESD5rpCeMWD+3iMTRlkVDy4oIFO3rih+QfkKZMKJt4nVKRp/arwKBgQC72iMhckv4nURS5RYcHzRVIFfWmGaVQPWaMUJZ6eV7LElkv7LFhXRomBYMRyf0QxjUJiYFntHv65j6ASuIT1bEbdXqZxg0gtOOTpXmuGmfMBQYEzrj12dTgA2DgwShtzV9ztwnOE6aOyMceWAXkSWkUb6vL6jL52nJXkWhE109JQKBgCOKpt0kii2DjVTgTglW7q2e7sy3npV6nmAwylp/FFx8simBpH0g23d+66ooFF2tPGScmom2Mk2XtXvIxhdPDoSb9t7FfpGh6plPTSxJXZpJ8mZRtXUFp7jFrRle1k9O4BNW8tSi+OxjiQb30uGUHkcQFq/E78cz/Z2h4lyRnl35AoGBALd+yEw2ipFKhd/3WNaVgJgapNLBQYtPzdkVfvu3Zusfgn3AZ49b4i79SKQrqZKHLCynKwLYdbfHSkIDfJOE9Huh0pBKrjE1DhP3HaQmxT2zSB2QQzkmQw8kiY7KH28cOEsxEonZDabIV27L/RpoNP3Cv+H+SwMKhKInzRofgTdlAoGAS+1pa58H2WY/nGQydBJu6TdKCybPOWk94Bi2X715xusbqc4yOeDqIBN8B4XcI9Td6KVPCWJbW8sA1PS18y4qJUAZ5Acvn69FCOHvGKKuvoSkbKN9QatRcmIIQU4ywoVxguktGinL/1RNUjfCluFfGCzX0RBgVeNg/HhHAqZ+tHg=";
	
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA150MI5qr39TnhH+i+OFB56Vmv0vzfKlhUNRHZco5SXCqNdwXgY3zeWGItr/dHNrBgA9X0Ji8ezgp48EMjqnzqk9lTd6rIL+9tJhwkxyE9VfhF3VBJhfqIgCab4XsBrZI/56mJ3cSimTBInbS3HGOoec2FpBPxeQecevD+eqZD2X6y9gcwryZNKAiRgwNBbOG65FDZJdiCtIPZ1zyPPSQgihk0jeWIblEAuGbJeZhApYvyBfcGfWS+Hiy93Mfnwnqe3FJlvpDDFstWc/DHVcgSS1LLY4ABWZ7byz01NobcZC/uf+3IEMK+7SbpThhsOtpurP/fXpFjERVBUH+TtN2lwIDAQAB";
	
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:7700/order/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:7700/order/shoping-order.html";
	
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

