package kr.or.pets.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	private static String ARTICLE_IMAGE_REPO = "C:\\workspace-sts\\article_image";
	
	@RequestMapping("/download.do")
	protected void download(@RequestParam("imageFileName") String imageFileName,
							@RequestParam("pro_boardNum") String pro_boardNum,
							HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = ARTICLE_IMAGE_REPO +"\\"+ pro_boardNum +"\\"+ imageFileName;			//값 할당안됨.
		File file = new File(downFile);				
		
	 	response.setHeader("Cache-Control", "no-chache");
	 	response.addHeader("Content-disposition", "attachment;filename=" + imageFileName);
	 	
	 	FileInputStream in = new FileInputStream(file);
	 	
	 	byte[] buffer = new byte[1024 * 8];
	 	while(true) {
	 		int count = in.read(buffer);
	 		if(count == -1) break;
	 		out.write(buffer, 0, count);
	 	}
	 	
	 	in.close();
	 	out.close();	 	
	}
	
}
