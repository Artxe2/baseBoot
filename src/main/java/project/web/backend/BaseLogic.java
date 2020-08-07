package project.web.backend;

import java.util.List;
import java.util.Map;

import org.apache.mybatis.MybatisDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BaseLogic {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseLogic.class);
	private static final String ROOTPATH = new java.io.File("src/main/resources/static/uploaded_files").getAbsolutePath();

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

	protected Object file_upload(Map<String, Object> pMap, MultipartFile[] files) throws Exception {
		logger.info("BaseLogic - file_upload, files: " + files.length);
		java.io.File saveFile;
		String filePath;
		int j = 0;
		for (MultipartFile f : files) {
			filePath = "base_files/" + f.getOriginalFilename();
			saveFile = new java.io.File(ROOTPATH, filePath);
			int i = 0;
			while (saveFile.exists()) {
				saveFile = new java.io.File(ROOTPATH, filePath.substring(0, filePath.lastIndexOf('.')) + ++i + '.' + filePath.substring(filePath.lastIndexOf('.') + 1));
			}
			if (i > 0) {
				filePath = filePath.substring(0, filePath.lastIndexOf('.')) + ++i + '.' + filePath.substring(filePath.lastIndexOf('.') + 1);
			}
			f.transferTo(saveFile);
			String name = f.getName() + j++;
			pMap.put(name, filePath);
			logger.info(name + ": " + filePath + " - " + f.getSize());
		}
		return "redirect:/base/file_upload.jsp";
	}

	protected List<Map<String, Object>> core_chart() throws Exception {
		logger.info("BaseLogic - core_chart");
		return MybatisDao.selectList(sqlSessionTemplate, "core_chart", null);
	}

	protected List<Map<String, Object>> org_chart() throws Exception {
		logger.info("BaseLogic - org_chart");
		return MybatisDao.selectList(sqlSessionTemplate, "org_chart", null);
	}
}
