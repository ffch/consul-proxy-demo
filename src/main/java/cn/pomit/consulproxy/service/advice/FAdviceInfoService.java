package cn.pomit.consulproxy.service.advice;

import java.util.List;

import cn.pomit.consulproxy.domain.advice.FAdviceInfo;
import cn.pomit.consulproxy.mapper.advice.FAdviceInfoDao;
import cn.pomit.mybatis.ProxyHandlerFactory;

public class FAdviceInfoService {

	FAdviceInfoDao fAdviceInfoDao = ProxyHandlerFactory.getMapper(FAdviceInfoDao.class);;

	public void save(FAdviceInfo fAdviceInfo) {
		fAdviceInfoDao.save(fAdviceInfo);
	}

	public void deleteById(Integer id) {
		fAdviceInfoDao.deleteById(id);
	}

	public void update(FAdviceInfo fAdviceInfo) {
		fAdviceInfoDao.update(fAdviceInfo);
	}

	public List<FAdviceInfo> findByStatus(Integer status) {
		return fAdviceInfoDao.findByStatus(status);
	}

	public FAdviceInfo findById(int id) {
		return fAdviceInfoDao.findOne(id);
	}
}
