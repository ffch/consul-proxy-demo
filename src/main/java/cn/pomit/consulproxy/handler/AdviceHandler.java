package cn.pomit.consulproxy.handler;

import java.nio.charset.Charset;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cn.pomit.consul.annotation.Mapping;
import cn.pomit.consul.handler.resource.AbstractResourceHandler;
import cn.pomit.consul.http.HttpRequestMessage;
import cn.pomit.consul.http.HttpResponseMessage;
import cn.pomit.consulproxy.domain.advice.FAdviceInfo;
import cn.pomit.consulproxy.dto.ResultCode;
import cn.pomit.consulproxy.dto.ResultModel;
import cn.pomit.consulproxy.dto.advice.AdviceAuthReq;
import cn.pomit.consulproxy.service.advice.FAdviceInfoService;
import cn.pomit.mybatis.util.StringUtil;

public class AdviceHandler extends AbstractResourceHandler {

	@Mapping(value = "/advice/submit")
	public HttpResponseMessage submit(HttpRequestMessage httpRequestMessage) {
		try {
			String content = httpRequestMessage.getBody().toString(Charset.defaultCharset());
			FAdviceInfo fAdviceInfo = JSONObject.parseObject(content, FAdviceInfo.class);
			if (StringUtil.isEmpty(fAdviceInfo.getContent()) || StringUtil.isEmpty(fAdviceInfo.getSummary())) {
				return HttpResponseMessage.responeseBody(ResultModel.error("参数错误"));
			}
			fAdviceInfo.setStatus(1);
			FAdviceInfoService fAdviceInfoService = new FAdviceInfoService();
			fAdviceInfoService.save(fAdviceInfo);
			return HttpResponseMessage.responeseBody(ResultModel.ok());
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResponseMessage.responeseBody(new ResultModel(ResultCode.CODE_00004));
		}
	}

	@Mapping(value = "/advice/list")
	public HttpResponseMessage list(HttpRequestMessage httpRequestMessage) {
		FAdviceInfoService fAdviceInfoService = new FAdviceInfoService();
		List<FAdviceInfo> list = fAdviceInfoService.findByStatus(1);
		return HttpResponseMessage.responeseBody(new ResultModel(ResultCode.CODE_00000, list));
	}

	@Mapping(value = "/advice/auth")
	public HttpResponseMessage auth(HttpRequestMessage httpRequestMessage) {
		String content = httpRequestMessage.getBody().toString(Charset.defaultCharset());
		AdviceAuthReq adviceAuthReq = JSONObject.parseObject(content, AdviceAuthReq.class);
		FAdviceInfoService fAdviceInfoService = new FAdviceInfoService();
		FAdviceInfo fAdviceInfo = fAdviceInfoService.findById(adviceAuthReq.getId());
		if (fAdviceInfo == null)
			return HttpResponseMessage.responeseBody(ResultModel.error("留言信息不存在！"));
		if (adviceAuthReq.getType() == 0) {
			fAdviceInfo.setStatus(0);
			fAdviceInfoService.update(fAdviceInfo);
		} else {
			fAdviceInfoService.deleteById(adviceAuthReq.getId());
		}
		return HttpResponseMessage.responeseBody(new ResultModel(ResultCode.CODE_00000));
	}

}
