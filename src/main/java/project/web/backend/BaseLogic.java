package project.web.backend;

import java.util.Map;

import org.apache.mybatis.MybatisDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	protected Object txCurrent_time(Map<String, Object> pMap) throws Exception {
		logger.info("BaseLogic - current_time");
		int test1 = 0;
		int test2 = 0;
		test1 = MybatisDao.insert(sqlSessionTemplate, "test1", pMap);
		System.out.println("test1: " + test1);
		test2 = MybatisDao.insert(sqlSessionTemplate, "test2", pMap);
		System.out.println("test2: " + test2);
		return MybatisDao.selectObject(sqlSessionTemplate, "current_time", pMap);
	}

	private static final String UPLOADFOLDER = new java.io.File("src/main/resources/static/uploaded_files/base_files").getAbsolutePath();

	protected Object file_upload(Map<String, Object> pMap, MultipartFile[] files) throws Exception {
		logger.info("BaseLogic - file_upload, files: " + files.length);
		logger.info(UPLOADFOLDER);
		java.io.File saveFile;

		for (MultipartFile f : files) {
			saveFile = new java.io.File(UPLOADFOLDER, f.getOriginalFilename());
			f.transferTo(saveFile);
			pMap.put(f.getName(), f.getOriginalFilename());
			logger.info(f.getName() + ", " + f.getOriginalFilename());
		}
		return "redirect:/base/file_upload.jsp";
	}
}
