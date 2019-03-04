package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class excel {
	//定义文件输入流
	FileInputStream input;
	//定义POIFSFileSystem
	POIFSFileSystem fs ;
	//定义工作簿
	HSSFWorkbook wb;
	//定义工作表
	HSSFSheet st;
	//定义行
	HSSFRow row;
	//定义单元格
	HSSFCell cell;
	//定义value
	String value;
	
	
	public List<List<String>> readExcelCell(String url,int sheet ) throws IOException{

		input =new FileInputStream(url);//"D:\\zexcel\\1.xls"
		fs=new POIFSFileSystem(input);
		wb=new HSSFWorkbook(fs);
		
		//找到第一个工作表
		st=wb.getSheetAt(sheet);
		List<List<String>> list=new ArrayList<>();
		for(int i=0;i<st.getLastRowNum();i++){
			row=st.getRow(i);
			if(row==null){
				continue;
			}
	
			List<String> listcell=new ArrayList<>();
			for(int j=0;j<row.getLastCellNum();j++){
				cell=row.getCell(j);
				if(cell==null){
					value="";
//					continue;
				}else{
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);  //转换为文本类型
				value=cell.getStringCellValue();

				}
				listcell.add(value);
			}
			
			list.add(listcell);
			}

		return list;
}

	//封装成一个方法
	//edit
public String  UseExcel(int row,int cell) throws IOException{
	excel  ex=new excel();
	List<List<String>> read=ex.readExcelCell("D:\\zexcel\\edit.xls", 1);
	return read.get(row).get(cell);
	}	

//add
public String  UseExcelAdd(int row,int cell) throws IOException{
	excel  ex=new excel();
	List<List<String>> read=ex.readExcelCell("D:\\zexcel\\edit.xls", 4);
	return read.get(row).get(cell);
	}	
//
public String  UseExcelSql(int row,int cell) throws IOException{
	excel  ex=new excel();
	List<List<String>> reada=ex.readExcelCell("D:\\zexcel\\edit.xls", 2);
	return reada.get(row).get(cell);
	}	



  

/*

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		excel ex=new excel();
		List<List<String>> read=ex.readExcelCell("D:\\zexcel\\edit.xls", 2);
		for(int i=0;i<read.size();i++){
			for(int j=0;j<read.get(i).size();j++){
				System.out.print(read.get(i).get(j)+"    ");
			}
			System.out.println();
		}

		}
	*/

}
