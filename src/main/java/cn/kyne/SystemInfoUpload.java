package cn.kyne;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.kyne.util.HttpClientHelper;

import com.pi4j.system.SystemInfo;

public class SystemInfoUpload {
	private static final Logger logger = LoggerFactory.getLogger(SystemInfoUpload.class.getName());
	private static final String API_KEY = "a6cec93ce8ccbb2a52f852a1f9c1790d";
	private static final String URL = "http://api.yeelink.net/v1.0/device/71151/sensor/88583/datapoints";
	
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		float cpuTemperature = SystemInfo.getCpuTemperature();
		System.out.println(cpuTemperature);
		logger.debug("CPU Temperature   :  " + cpuTemperature);
		HttpClientHelper httpClient = HttpClientHelper.getInstance(null, 0);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("U-ApiKey", API_KEY);
		JSONObject body = new JSONObject();
		body.put("value", cpuTemperature);
		String result = httpClient.doPost(URL, body.toString(), null, headers);
		System.out.println(result);
	}
}
