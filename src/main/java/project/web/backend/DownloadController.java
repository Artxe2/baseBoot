package project.web.backend;

import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("download")
public class DownloadController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DownloadController.class);
    private static final String ROOTPATH = new java.io.File("src/main/resources/static").getAbsolutePath();

    @GetMapping("")
    public void download(HttpServletRequest request, HttpServletResponse response, @RequestParam("filePath") String filePath) {
        logger.info("DownloadController - download");
        java.io.File file = new java.io.File(ROOTPATH, filePath);
        try (
                java.io.BufferedInputStream bis = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                java.io.OutputStream os = response.getOutputStream();
                ) {
            request.setCharacterEncoding("UTF-8");
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader ("Content-Length", String.valueOf(file.length()));
            String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1) + "\"");
            response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            int i = -1;
            while((i = bis.read()) > -1){
                os.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}