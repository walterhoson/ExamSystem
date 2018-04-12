package com.wayne.exam.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.wayne.exam.entity.Question;

public class UpLoadExcelUtil {
	Logger logger = LoggerFactory.getLogger(UpLoadExcelUtil.class);

	// 总行数
	private int totalRows = 0;

	// 总条数
	private int totalCells = 0;

	// 错误信息接收器
	private String errorMsg;

	// 构造方法
	public UpLoadExcelUtil() {
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getTotalCells() {
		return totalCells;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 验证EXCEL文件
	 * 
	 * @param filePath
	 * @return boolean
	 * @author wayne
	 * @date 2018年4月9日下午5:30:52
	 */
	public boolean validateExcel(String filePath) {
		boolean msg = false;
		if (filePath != null) {
			if (isExcel2003(filePath) || isExcel2007(filePath)) {
				msg = true;
			}
		} else {
			logger.debug("errorMsg:文件不是excel格式");
		}
		return msg;
	}

	/**
	 * 读EXCEL文件
	 * 
	 * @param fileName
	 * @param mFile
	 * @param localFile
	 * @return List<Question>
	 * @author wayne
	 * @date 2018年4月9日下午5:41:24
	 */
	public List<Question> getExcelInfo(String fileName, MultipartFile mFile, String localFile) {
		// 新建文件
		File file = new File(localFile);
		// 转存文件到本地
		try {
			mFile.transferTo(file);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		List<Question> list = new ArrayList<Question>();
		// 初始化输入流
		InputStream is = null;
		try {
			// 验证文件名是否合格
			if (!validateExcel(fileName)) {
				logger.debug("不合格");
				return null;
			}
			// 根据文件名判断文件是2003版本还是2007版本
			boolean isExcel2003 = true;
			if (isExcel2007(fileName)) {
				isExcel2003 = false;
			}
			// 根据新建的文件实例化输入流
			is = new FileInputStream(file);
			// 根据excel里面的内容读取信息
			list = getExcelInfo(is, isExcel2003);
			logger.debug("list:" + list.toString());
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 根据excel里面的内容读取信息
	 * 
	 * @param is
	 * @param isExcel2003
	 * @return List<Object>
	 * @author wayne
	 * @date 2018年4月9日下午5:42:36
	 */
	public List<Question> getExcelInfo(InputStream is, boolean isExcel2003) {
		List<Question> list = null;
		try {
			/** 根据版本选择创建Workbook的方式 */
			Workbook wb = null;
			// 当excel是2003时
			if (isExcel2003) {
				wb = new HSSFWorkbook(is);
			} else {// 当excel是2007时
				wb = new XSSFWorkbook(is);
			}
			// 读取Excel里的信息
			list = readExcelValue(wb);
			logger.debug("list2:" + list.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 读取Excel里面的信息
	 * 
	 * @param wb
	 * @return List<Object>
	 * @author wayne
	 * @date 2018年4月9日下午5:43:35
	 */
	private List<Question> readExcelValue(Workbook wb) {
		// 得到第一个shell
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		this.totalRows = sheet.getPhysicalNumberOfRows();
		// 得到Excel的列数(前提是有行数)
		if (totalRows >= 1 && sheet.getRow(0) != null) {
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<Question> questions = new ArrayList<Question>();
		// 循环Excel行数,从第二行开始。标题不入库
		for (int r = 1; r < totalRows; r++) {
			Question question = new Question();
			Row row = sheet.getRow(r).getCell(1).getRow();
			if (row == null)
				continue;
			// 循环Excel的列,获取相关信息
			for (int c = 0; c < this.totalCells; c++) {
				Cell cell = row.getCell(c);
				if (null != cell) {
					//标题--title
					if (c == 0) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setTitle(cell.getStringCellValue());
						//年份--year
					} else if (c == 1) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setYear(cell.getStringCellValue());
						//题号--titleNum
					}else if (c == 2) {
						//由于题目上最前面有题号，此字段暂时不用
							/*cell.setCellType(Cell.CELL_TYPE_STRING);
							question.setTitleNum(Integer.parseInt(cell.getStringCellValue()));*/
						//提醒--type
					} else if (c == 3) {
						/*
						 * // 日期>>需要转换
						 * if (HSSFDateUtil.isCellDateFormatted(cell)) {
						 * //orderformDO.setStartdate(cell.getDateCellValue()); }
						 */
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if ("单选题".equals(cell.getStringCellValue())) {
							question.setType(1);
						} else if ("多选题".equals(cell.getStringCellValue())) {
							question.setType(2);
						} else if ("判断题".equals(cell.getStringCellValue())) {
							question.setType(3);
						} else if ("填空题".equals(cell.getStringCellValue())) {
							question.setType(4);
						} else {
							//type=5表示未知题
							question.setType(5);
						}
						//关键词--keyword
					} else if (c == 4) {
						/*
						 * if (HSSFDateUtil.isCellDateFormatted(cell)) {
						 * orderformDO.setEnddate(cell.getDateCellValue()); }
						 */
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setKeyword(cell.getStringCellValue());
						//考点--Examing_point
					} else if (c == 5) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setExamingPoint(cell.getStringCellValue());
						//题目内容--Content
					} else if (c == 6) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setContent(cell.getStringCellValue());
						//选项A
					} else if (c == 7) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setOptionA(cell.getStringCellValue());
						//选项B
					} else if (c == 8) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setOptionB(cell.getStringCellValue());
						//选项C
					} else if (c == 9) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setOptionC(cell.getStringCellValue());
						//选项D
					} else if (c == 10) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setOptionD(cell.getStringCellValue());
						//选项E
					} else if (c == 11) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setOptionE(cell.getStringCellValue());
						//选项F
					} else if (c == 12) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setOptionF(cell.getStringCellValue());
						//答案
					}else if(c==13) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setAnswer(cell.getStringCellValue());
						//解析
					}else if(c==14) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						question.setAnalysis(cell.getStringCellValue());
						//难度系数
					}else if(c==15) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if(!"".equals(cell.getStringCellValue())) {
							question.setDifficulty(Integer.parseInt(cell.getStringCellValue()));
						}
						//分值
					}else if(c==16) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if(!"".equals(cell.getStringCellValue())) {
							question.setScore(Integer.parseInt(cell.getStringCellValue()));
						}
					}
				}
			}
			// 添加
			questions.add(question);
		}
		return questions;
	}

	// 是否是2003的excel，返回true是2003
	public static boolean isExcel2003(String filePath) {
		// return filePath.matches("^.+\\.(?i)(xls)$");
		return filePath.endsWith("xls");
	}

	// 是否是2007的excel，返回true是2007
	public static boolean isExcel2007(String filePath) {
		// return filePath.matches("^.+\\.(?i)(xlsx)$");
		return filePath.endsWith("xlsx");
	}

}
