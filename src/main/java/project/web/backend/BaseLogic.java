package project.web.backend;

import java.util.Map;

import org.apache.mybatis.MybatisDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseLogic {
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseLogic.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	protected Object current_time(Map<String, Object> pMap) throws Exception {
		logger.info("BaseLogic - current_time");
		return MybatisDao.selectObject(sqlSessionTemplate, "current_time", pMap);
	}

	@Transactional
	protected Object txCurrent_time(Map<String, Object> pMap) {
		logger.info("BaseLogic - current_time");
		int test1 = 0;
		int test2 = 0;
		test1 = MybatisDao.insert(sqlSessionTemplate, "test1", pMap);
		System.out.println("test1: " + test1);
		test2 = MybatisDao.insert(sqlSessionTemplate, "test2", pMap);
		System.out.println("test2: " + test2);
		return MybatisDao.selectObject(sqlSessionTemplate, "current_time", pMap);
	}

	protected Object file_upload(Map<String, Object> pMap) throws Exception {
		logger.info("BaseLogic - file_upload");
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
