package com.licly.obs;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.HeaderResponse;

import java.io.File;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/26
 */
public class ObsPractice {

	private static String accessKey = "Z7W7ABHZNMITKXBLJA7J";

	private static String secretKey = "wRnJZLxxFvUWhCRi5GH5nPAlgKMNDzGNJwNuMcjA";

	private static String bucket = "https://licly-bucket.obs.cn-north-4a";

	private static String endpoint = "obs.cn-north-4.myhuaweicloud.com";

	private static ObsClient obsClient = new ObsClient(accessKey, secretKey, endpoint);

	public static void main(String[] args) {

		// 创建桶
		try{
			// 创建桶成功
			HeaderResponse response = obsClient.createBucket("licly-bucket1");
			System.out.println(response.getRequestId());
		}
		catch (ObsException e)
		{
			// 创建桶失败
			System.out.println("HTTP Code: " + e.getResponseCode());
			System.out.println("Error Code:" + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());

			System.out.println("Request ID:" + e.getErrorRequestId());
			System.out.println("Host ID:" + e.getErrorHostId());
		}
		// 创建ObsClient实例

		obsClient.putObject("licly-bucket", "localfile", new File("C:\\c\\Project1\\Project1\\Project1.vcxproj"));
	}

}
