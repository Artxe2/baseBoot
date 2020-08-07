package project.web.backend;

import java.util.Map;

import org.apache.mybatis.GoogleChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("base")
public class BaseController {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseController.class);
	@Autowired
	private BaseLogic baseLogic;

	@ResponseBody
	@GetMapping("current_time")
	public Object current_time(@RequestParam Map<String, Object> pMap) {
		logger.info("BaseController - current_time");
		try {
			return baseLogic.current_time(pMap);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("file_upload")
	public Object file_upload(@RequestParam Map<String, Object> pMap, @RequestPart("i_file") MultipartFile[] files) {
		logger.info("BaseController - file_upload");
		try {
			return baseLogic.file_upload(pMap, files);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("file_download")
	public Object file_download() {
		logger.info("BaseController - file_upload");
		return "base/file_download";
	}

	@ResponseBody
	@GetMapping("core_chart")
	public Object core_chart() {
		logger.info("BaseController - core_chart");
		try {
			return GoogleChart.toChartDataTable("ROWNAME", baseLogic.core_chart(), null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@ResponseBody
	@GetMapping("org_chart")
	public Object org_chart() {
		logger.info("BaseController - org_chart");
		try {
			return GoogleChart.toChartDataTable("ENAME", baseLogic.org_chart(), new String[] {"MGR", "JOB"},
					//		null);
					new String[] {"<div style=\"color:red; font-style:italic\">", "#JOB", "</div>", "#ENAME"});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
