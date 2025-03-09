package com.springboot.demo.mybbq;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelPinyinConverter {

    // 设置桌面文件路径
    private static final String DESKTOP_PATH = "C:/Users/15067/Desktop/";
    private static final String FILENAME = "汉语转拼音.xlsx";

    public static void main(String[] args) {
        try {
            // 1. 读取Excel文件
            FileInputStream file = new FileInputStream(new File(DESKTOP_PATH + FILENAME));
            Workbook workbook = new XSSFWorkbook(file);

            // 获取第一个工作表
            Sheet sheet = workbook.getSheetAt(0);

            // 2. 遍历所有数据行（跳过表头）
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                // 3. 获取第一列内容
                Cell chineseCell = row.getCell(0);
                if (chineseCell == null) continue;

                String chinese = chineseCell.getStringCellValue();
                System.out.println(chinese+"========chinese=======");
                // 4. 转换为不带声调的拼音
                String pinyin = convertToPinyin(chinese);
                System.out.println(pinyin+"=========pinyin=========");

                // 5. 写入第二列（如列不存在则创建）
                Cell pinyinCell = row.createCell(1);
                pinyinCell.setCellValue(pinyin);
            }

            // 6. 保存修改
            FileOutputStream outFile = new FileOutputStream(DESKTOP_PATH + FILENAME);
            workbook.write(outFile);
            outFile.close();
            workbook.close();

            System.out.println("转换完成！文件已保存至桌面");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 汉字转拼音核心方法
     * @param chinese 中文字符串
     * @return 不带声调的拼音字符串
     */
    private static String convertToPinyin(String chinese) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); // 设置不带声调

        StringBuilder pinyin = new StringBuilder();

        // 遍历每个字符
        for (char c : chinese.toCharArray()) {
            // 处理汉字字符
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]")) {
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (pinyinArray != null && pinyinArray.length > 0) {
                    pinyin.append(pinyinArray[0]); // 取第一个读音
                }
            } else {
                // 保留非汉字字符
                pinyin.append(c);
            }
        }
        System.out.println(pinyin.toString()+"==========pinyin.toString()==================");
        String pinyinC = pinyin.substring(0, 1).toUpperCase() + pinyin.substring(1);
        return pinyinC.toString();
    }
}
