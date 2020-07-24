package project.web.backend;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("base")
public class BaseController {
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BaseController.class);
	@Autowired
	private BaseLogic baseLogic;

	@ResponseBody
	@GetMapping("current_time")
	public Object current_time(@RequestParam Map<String, Object> pMap) {
		logger.info("BaseController - current_time");
		try {
			return baseLogic.txCurrent_time(pMap);
		} catch (Exception e) {
			return null;
		}
	}

	public Object file_upload(@RequestParam Map<String, Object> pMap) {
		logger.info("BaseController - file_upload");
		try {
			return baseLogic.file_upload(pMap);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
