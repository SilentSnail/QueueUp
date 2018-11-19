package com.queue.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liusong on 2018/5/2.
 */
public class ExcelUtils {

    /**
     *
     * @param path
     * @return
     * @throws IOException
     * @throws FileFormatException
     */
    public List<Map<String, String>> readExcel(String path, String[] keys) throws IOException, FileFormatException {
        List<Map<String, String>> list = null;
        Workbook book = readExcelByPath(path);
        FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
        for (Sheet sheet: book) {
            list = readSheet(sheet, evaluator, keys);
        }
        book.close();
        return list;
    }

    /**
     * int rowCount = sheet.getPhysicalNumberOfRows();//获取总行数
     * int columns = row.getPhysicalNumberOfCells();//获取总列数
     * @param sheet
     * @param evaluator
     * @return
     */
    private static List<Map<String, String>> readSheet(Sheet sheet, FormulaEvaluator evaluator, String[] keys){
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map;
        for (Row row : sheet) {
            map = new ConcurrentHashMap<String, String>();
            int columns = row.getLastCellNum();//获取最后一个不为空的列的位置
            for (int i = 0; i < columns; i++) {
                map.put(keys[i], getCellValue(row.getCell(i), evaluator));
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 获取Excel文件信息
     * @param path
     * @return
     * @throws IOException
     * @throws FileFormatException
     */
    private Workbook readExcelByPath(String path) throws IOException, FileFormatException {
        InputStream stream = ExcelUtils.class.getResourceAsStream(path);
        Asserts.isNull(stream,"读取文件失败，文件路径错误");
        String head = FileUtils.getFileHeader(stream);
        //这里应该关闭InputStream，未测试关闭后是否还能获取到Workbook,故此处未添加关闭代码
        if(FileUtils.FILE_HEAD_XLS.equals(head)) {
            return new HSSFWorkbook(stream);
        } else if (FileUtils.FILE_HEAD_XLSX.equals(head)) {
            return new XSSFWorkbook(stream);
        } else {
            throw new FileFormatException("文件类型不真确,Excel无法解析");
        }
    }

    /**
     * 获取Cell的值
     * @param cell
     * @param evaluator
     * @return
     */
    private static String getCellValue(Cell cell, FormulaEvaluator evaluator){
        switch (cell.getCellTypeEnum()){
            case STRING://字符串
                return cell.getStringCellValue();
            case NUMERIC://数字
                double dbl = cell.getNumericCellValue();
                int value = (int)dbl;
                if(dbl == value){
                    return String.valueOf(value);
                }else{
                    return String.valueOf(dbl);
                }
            case BOOLEAN://boolean值
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA://公式
                return getCellValue(evaluator.evaluate(cell));
        }
        return null;
    }

    /**
     * 获取CellValue的值
     * @param value
     * @return
     */
    private static String getCellValue(CellValue value){
        switch (value.getCellTypeEnum()){
            case STRING://字符串
                return value.getStringValue();
            case NUMERIC://数字
                double dbl = value.getNumberValue();
                int val = (int)dbl;
                if(dbl == val){
                    return String.valueOf(value);
                }else{
                    return String.valueOf(dbl);
                }
            case BOOLEAN://boolean值
                return String.valueOf(value.getBooleanValue());
        }
        return null;
    }

}
