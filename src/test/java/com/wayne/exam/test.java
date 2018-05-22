package com.wayne.exam;

public class test {

	public static void main(String[] args) {
		double sum = 0;
		for (int i = 1; i < 20; i++) {
			int ji = 1;
			for (int j = 1; j <= i; j++) {
				ji = ji * j;
			}
			sum = sum + (double) 1 / (double) ji;
		}
		System.out.println(sum);
		
		
		
		/*// 先创建一个路径
		File folder = new File("D:\\resources");
		if (!folder.exists()) {
			folder.mkdirs(); /// 如果不存在，创建目录
		}

		File outFile = new File(folder, "newFile.xlsx");
		if(!outFile.exists()) {
			try {
				outFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	/*	String fileName = "sx";
		if (isExcel2003(fileName) || isExcel2007(fileName) ) {
			System.out.println("文件是excel格式");
		} else {
			System.out.println("文件不是excel格式");
		}*/
		
		
		
		
	}
	
	
/*	// 是否是2003的excel，返回true是2003
		public static boolean isExcel2003(String filePath) {
//			return filePath.matches("^.+\\.(?i)(xls)$");
			return filePath.endsWith(".xls");
		}

		// 是否是2007的excel，返回true是2007
		public static boolean isExcel2007(String filePath) {
//			return filePath.matches("^.+\\.(?i)(xlsx)$");
			return filePath.endsWith(".xlsx");
		}*/

}
