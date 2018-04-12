package com.wayne.exam.web.question;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wayne.exam.entity.Question;
import com.wayne.exam.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/index")
	public String index() {
		return "upLoadExcel";
	}

	@RequestMapping(value = "/insertquestion", method = RequestMethod.POST)
	@ResponseBody
	private String insertQuestion(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file, Map<String, Object> map) {
		logger.info("---start upload---");
		long startTime = System.currentTimeMillis();
		String msg = "";
		String fileName = file.getOriginalFilename();// 获取文件名 ***.png ,大写会转为小写
		// 先创建一个路径
		File folder = new File("D:\\resources");
		if (!folder.exists()) {
			folder.mkdirs(); /// 如果不存在，创建目录
		}
		File localFile = new File(folder, "newFile.xlsx");
		// 定义一个本地文件副本(路径+文件名),用来接收前端上传的文件内容
		// String localFile = "/app/newFile.xlsx";// 需要修改文件路径
		// String localFile = "D:\\resources\\newFile.xlsx";

		try {
			if (!localFile.exists()) {
				localFile.createNewFile();
			}
			List<Question> questions = questionService.insertQuestion(fileName, file, localFile.toString());
			msg = "解析成功,总共" + questions.size() + "条!";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "导入失败......";
		}
		map.put("msg", msg);
		long endTime = System.currentTimeMillis();
		logger.debug("msg:" + msg);
		logger.debug("costTime:[{}ms]", endTime - startTime);
		logger.info("---end---");
		return msg.toString();
	}

}
