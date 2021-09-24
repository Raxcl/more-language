package raxcl;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoreLanguageExport {
    public static void main(String[] args) {
        String fileName = "D:\\IdeaProjects\\my\\more-language\\src\\main\\resources\\easyexcel.xlsx";
        String templateName = "D:\\IdeaProjects\\my\\more-language\\src\\main\\resources\\模板.xlsx";
        List list = new ArrayList();
        List list1 = new ArrayList();
        Collections.addAll(list1,1,2,3,4,5,6,7,"lisi","张三");
        list.add(list1);
        EasyExcel.write(fileName).withTemplate(templateName).sheet("平台多语言导入").doWrite(list);
        System.out.println(list);
    }
}
