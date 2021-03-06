package com.asiainfo.authority.spring.service.exp;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.ApplicationContext;

import com.asiainfo.authority.constant.AuthorityModule;
import com.asiainfo.authority.hibernate.dao.TAuthorityModuleDAO;

import person.daizhongde.virtue.assemble.sql.SQLAssembleE;
import person.daizhongde.virtue.assemble.sql.SQLUtil;
import person.daizhongde.virtue.configutils.JSQLParser;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.EXPORT;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Progress;
import person.daizhongde.virtue.constant.Progresses;
import person.daizhongde.virtue.spring.BaseExportService;
import person.daizhongde.virtue.util.ie.HSSFWorkbookUtil4Export;
import person.daizhongde.virtue.util.ie.IESemaphore;
import person.daizhongde.virtue.util.ie.POICellStyle;
import person.daizhongde.virtue.util.ie.TXTUtil;
import net.sf.json.JSONObject;

/**
 * seven levels total include root. 
 * This is a compromise 
 * You can modify this class to extend for more levels.
 * gubusoft treeview use
 * @author dzd
 *
 */
public class TAuthorityModuleServiceImpl_EXP implements BaseExportService {
	private static final Log log = LogFactory.getLog(TAuthorityModuleServiceImpl_EXP.class);
	
	private TAuthorityModuleDAO dataDAO;
	
	public String exportXLS(String jdata, String _ ) throws Exception{
		AbstractConstant absConstant = new AuthorityModule();
//		System.out.println("absConstant.getJSDOC().getExport().get(\"export\").getDefaultColumns():"+absConstant
//				.getJSDOC()
//				.getExport()
//				.get("export")
//				.getDefaultColumns());
		
		return this.exportXLS(jdata, _,
				absConstant
					.getJSDOC()
					.getExport()
					.get("export")
					.getDefaultColumns(),
				EXPORT.xlsExportOptions
			);
	}
	public String exportXLS(String jdata, String _, List customColumns ) throws Exception{
		
		return this.exportXLS(jdata, _, 
				customColumns,
				EXPORT.xlsExportOptions
			);
	}
	public String exportXLS(String jdata, String _, Map options ) throws Exception{
		AbstractConstant absConstant = new AuthorityModule();

		return this.exportXLS(jdata, _,
				absConstant
					.getJSDOC()
					.getExport()
					.get("export")
					.getDefaultColumns(),
				options
			);
	}
	@Override
	public String exportXLS(String jdata, String _, List customColumns, Map options )
			throws Exception {
		
		AbstractConstant absConstant = new AuthorityModule();
		String fileName= absConstant.getEXPfileName();

		Map<String, Object> session = new HashMap<String, Object>();
//		request.getSession().setAttribute("progress", 0);
//		request.getSession().setAttribute("msg", "正在初始化...");
		Progress  p = new Progress(0, "正在初始化..." );
		Progresses.map.put(_, p);
		/*1.查询记录总数
		 *2.查询第一个表单数据
		 *3.生成第一个表单
		 *查询第二个使单数据，生成第二个表单
		 *......
		 *查询最后一个使单数据，生成最后一个表单
		 *4.生成文件
		 * 
		 */
    	//总文件数量
//    	int fileCount = 0;
    	
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		int fileRecordSize = absConstant.getEXPsingleFileRecordSize();
    	int level1MinCount = absConstant.getEXPlevel1MinCount();
    	int level2MinCount = absConstant.getEXPlevel2MinCount();
    	int level3MinCount = absConstant.getEXPlevel3MinCount();
    	
    	SQLAssembleE sqlA = new SQLAssembleE(
				absConstant.getSQLDOC(),
				absConstant.getEXP_SQL(), 
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
    	
    	/* 如果不是默认的导出sql,下面这行需要修改  
    	 * 如：HashMap<String,String> allColumnSQLMap = JSQLParser.getSelectMap( queryDiff ); 
    	 * */
		HashMap<String,String> allColumnSQLMap = absConstant.getEXPAllColumnSQLMap();
		//customSelectSQL = customSelectCol+ from XX
		String customSelectSQL ="";
		String customSelectCol = "select ";
		
//		customColumns [N_MID, C_MNAME,N_Mlevel,level...]
		for(int i = 0, j = customColumns.size(); i<j; i++){
			if(i!=j-1){
				customSelectCol += allColumnSQLMap.get(customColumns.get(i))+",";
			}else{
				customSelectCol += allColumnSQLMap.get(customColumns.get(i))+" ";
			}
		}
		/* 像这样采用特殊的方式拼装的sql,下面这行就需成修改
		 如：String fromSQL = SQLUtil.getFromSQL(queryDiff);
		 customSelectSQL = customSelectCol + fromSQL;
		 */
		customSelectSQL = customSelectCol + sqlA.getFromSQL();
		sqlA.setSQL( customSelectSQL );
		
//		System.out.println("@sqlA.getCountSQL():"+sqlA.getCountSQL());
//		System.out.println("@sqlA.getSQL():"+sqlA.getSQL());
		
//		/** file absolute directory , end with '/' **/
//		private String tempFAbsDir;
//		/** 服务器临时文件名称（完整文件名） **/
//		private String tempFAbsName;
//		/** 服务器临时文件名称（不包括扩展名） **/
//		private String tempFName;
//		/** 服务器临时文件的扩展名（文件类型） **/
//		private String tempFExtName;
//		/** file absolute path **/
//		private String tempFAbsPath;
		
		/** 服务器临时文件名称（不包括扩展名） **/
//		this.tempFName = String.valueOf(new java.util.Date().getTime());
		/** 服务器临时文件名称（完整文件名） **/
		//String tempFAbsName = "代付签约信息" + String.valueOf(new java.util.Date().getTime()) + ".xls";
//		String tempFAbsName = absConstant.getEXPfileName() + String.valueOf(new java.util.Date().getTime()) + ".xls";
		SimpleDateFormat stm=new SimpleDateFormat("yyMMdd-HHmmss-S");
		String tempFAbsName = fileName + stm.format(new Date()) + ".xls";
		
		/** server file absolute directory , if config end with '/' INIT.java would delete it **/
		String tempFAbsDir = INIT.tempFileDirectory+"/export/excel/";
//		System.out.println("fileAbsDir:"+fileAbsDir);
		String fAbsPath = tempFAbsDir + tempFAbsName;
		
		java.io.File fold = new java.io.File(tempFAbsDir);
		if(!fold.exists())
			fold.mkdirs();

    	p.setProgress(1);
    	p.setMsg("初始化完成!|查询记录总数...");
		Progresses.map.put(_, p);
		
		int total = Integer.valueOf(
				dataDAO.sqlQueryfindaValueByMap(
						sqlA.getCountSQL(), 
						sqlA.getMap() 
					).toString()
			);
		//Aim to don't play server to die
		if( total > fileRecordSize ){
			log.info("记录超限！超过最大限制："+fileRecordSize+" 条.");
			throw new Exception("记录超限!超过："+fileRecordSize+" 条.");
		}else if( total > level3MinCount ){//total>10W
			
//			ExportSemaphore.level3.acquire();
//			ExportSemaphore.level3.release();
			
			if(IESemaphore.level3.tryAcquire()){
				try{
					exportXLS( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
				}catch(IOException e){
					throw e;
				}finally{
					IESemaphore.level3.release();
				}
			}else{
				log.info("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:三级)..");
				throw new Exception("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:三级)..");
			}
		}else if( total > level2MinCount ){//5W<total<=10W
//			ExportSemaphore.level2.acquire();
			if(IESemaphore.level2.tryAcquire()){
				try{
					exportXLS( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
				}catch(IOException e){
					throw e;
				}finally{
					IESemaphore.level2.release();
				}
			}else{
				log.info("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:二级)..");
				throw new Exception("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:二级)..");
			}
			
		}else if( total > level1MinCount ){//1W<total<=5W
//			ExportSemaphore.level1.acquire();
			if(IESemaphore.level1.tryAcquire()){
				try{
					exportXLS( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
				}catch(IOException e){
					throw e;
				}finally{
					IESemaphore.level1.release();
				}
			}else{
				log.info("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:一级).");
				throw new Exception("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:一级).");
			}
		}else{
			exportXLS( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
		}		
		return fAbsPath;
	}
	
	/**
	 * 
	 * @param fAbsPath
	 * @param absConstant
	 * @param total
	 * @param sqlA
	 * @param _
	 * @throws IOException
	 */
	private void exportXLS(String fAbsPath, 
			AbstractConstant absConstant, 
			int total, 
			SQLAssembleE sqlA,
			String _, List customColumns, Map options ) throws IOException {
    	
    	String sheetName = absConstant.getEXPsheetName();//Excel中的表单名
    	int pageSize = absConstant.getEXPsingleSheetRecordSize();
//    	String[] columnNames_zh = absConstant.getEXPcolumnNames_zh();
//    	int[] columnTypes = absConstant.getEXPcolumnTypes();
//    	int[] columnScales = absConstant.getEXPcolumnScales();
    	
    	int[] columnTypes;
    	int[] columnPrecisions;
    	int[] columnScales;
    	String[] columnNames_zh;
    	
//    	Map<String, List> ColumnMap = absConstant.getJSDOC().getExport().get("export").getColumnMap();
    	Map<String, List> ColumnMap = absConstant.getEXPcolumnMap();
    	
//    	System.out.println("ColumnMap:");
    	
//		Set set = ColumnMap.keySet();
		int size = customColumns.size();
		columnTypes = new int[size];
		columnPrecisions = new int[size];
		columnScales = new int[size];
		columnNames_zh = new String[size];

//		Iterator it = set.iterator();
		Object key;
		for( int i=0, j=size; i<j; i++ ) {
			key = customColumns.get(i);
			List list = (List)ColumnMap.get( key );
			columnTypes[i] = ((Integer)list.get(0)).intValue();
			columnPrecisions[i] = ((Integer)list.get(1)).intValue();
			columnScales[i] = ((Integer)list.get(2)).intValue();
			columnNames_zh[i] = (String)list.get(3);
		}
		
    	// current sheet record count
    	int currentSheetRecordCount = 0;
//   	 sql don't include rownum,sql不带序号.
//   	 if exported excel file need add rownum,add in program,rather than in sql 
		 
    	//起始记录的索引,start from 0
    	int offset = 0;
    	
    	HSSFWorkbook hwb = new HSSFWorkbook();
    	
		//计算总文件数量---这里不考虑分多个文件的情况
//      fileCount = (int) ( (total - 1) / fileRecordSize ) + 1;
    	
    	//A file new this class a time
    	POICellStyle cs = new POICellStyle(hwb);
		//A file new this class a time
		HSSFWorkbookUtil4Export hwbUtil = new HSSFWorkbookUtil4Export(hwb, cs, sheetName,
				columnTypes, 
				columnPrecisions,
				columnScales,
				columnNames_zh, 
				absConstant.getEXPfixColumnCount(), absConstant.isEXPsheetAutoSizeColumn(), 
				options );
		
		int sheetCount = (int) ( (total - 1) / pageSize ) + 1;
		
		Progress  p = new Progress(2, "查询记录总数完成!|查询第<0>个表单数据......" );
		Progresses.map.put(_, p);
    	//第三层：表单循环-- pay special attention
	    for ( int sheetNumber = 0; sheetNumber < sheetCount; sheetNumber ++ )
        {
	    	if( sheetNumber < sheetCount - 1 ){
	    		currentSheetRecordCount = pageSize;
	    	}else{
	    		//if sheetNumber start from 1
//	    		currentSheetRecordCount = total - (sheetNumber - 1) * pageSize;
	    		currentSheetRecordCount = total - sheetNumber * pageSize;
	    	}
	    	//if sheetNumber start from 1
//	    	int offset = (page - 1) * pageSize;// 第一条记录的索引,这个取自分页查询,因为这里sheetNumber是从零开始,所以不用减一;
	    	offset = sheetNumber * pageSize;// 第一条记录的索引;

	    	log.info("开始从数据库查询第<"+sheetNumber+">个表单的数据......");
	    	List list = dataDAO.sqlQueryfindRetArrayByPageByMap( sqlA.getSQL(), 
					sqlA.getMap(), offset, pageSize );
	    	log.info("从数据库查询第<"+sheetNumber+">个表单的数据完成！");
	    	p.setProgress( (int)(2+(90-2)*(sheetNumber+0.5)/sheetCount) );
	    	p.setMsg("查询第<"+sheetNumber+">个表单数据完成!|创建第<"+sheetNumber+">个sheet......");
			Progresses.map.put(_, p);
			
	    	//调用一次生成一个表单
			hwbUtil.generateASheet(sheetNumber,
	    			list,
	    			currentSheetRecordCount );
			//withRecordNo
//	    	hwbUtil.generateASheet(sheetNumber,
//	    			list,
//	    			currentSheetRecordCount, sheetNumber * pageSize );
	    	
	    	p.setProgress( (int)(2+(90-2)*(sheetNumber+1)/sheetCount) );
	    	if(sheetNumber<sheetCount){
	    		p.setMsg("创建第<"+sheetNumber+">个sheet完成!|查询第<"+(sheetNumber+1)+">个表单数据......");
				Progresses.map.put(_, p);
	    	}else{
	    		p.setMsg("创建第<"+sheetNumber+">个sheet(最后一个sheet)完成!|写入Excel文件......" );
				Progresses.map.put(_, p);
	    	}		
        }//第三层：表单循环 end of for pageNum
	    System.gc();
	    
    	OutputStream fileOut = new BufferedOutputStream(new FileOutputStream(new File( fAbsPath )), 1*1024*1024);
    	log.info("写入Excel文件......");
	    hwb.write(fileOut);
		// 关闭Excel工作薄对象
	    fileOut.flush();
		fileOut.close();
		log.info("写入完成!");
		p.setProgress( 100 );
    	p.setMsg("写入完成!");
		Progresses.map.put(_, p);
	}
	@Override
	public String exportTXT(String jdata, String _) throws Exception {
		AbstractConstant absConstant = new AuthorityModule();
		return this.exportTXT(jdata, _,
				absConstant
					.getJSDOC()
					.getExport()
					.get("export")
					.getDefaultColumns(),
				EXPORT.txtExportOptions
			);
	}
	@Override
	public String exportTXT(String jdata, String _, List customColumns ) throws Exception {
		AbstractConstant absConstant = new AuthorityModule();
		return this.exportTXT(jdata, _, 
				absConstant.getJSDOC()
					.getExport()
					.get("export")
					.getDefaultColumns(),
				EXPORT.txtExportOptions
			);
	}
	
	@Override
	public String exportTXT(String jdata, String _, Map options ) throws Exception {
		AbstractConstant absConstant = new AuthorityModule();
		return this.exportTXT(jdata, _,
				absConstant
					.getJSDOC()
					.getExport()
					.get("export")
					.getDefaultColumns(),
				options
			);
	}
	
	@Override
	public String exportTXT(String jdata, String _, List customColumns, Map options ) throws Exception {
		Progress  p = new Progress(0, "正在初始化..." );
		Progresses.map.put(_, p);
		/*1.查询记录总数
		 *2.查询第一个表单数据(文本文件是第一批数据)
		 *3.生成第一个表单(文本文件将第一批查询结果写入文本)
		 *查询第二个使单数据，生成第二个表单(文本文件查询第二批数据，将第二批数据写入文本)
		 *......
		 *查询最后一个使单数据，生成最后一个表单(文本文件查询最后一批数据，将最后一批数据写入文本)
		 *4.生成文件
		 * 
		 */
    	//总文件数量
//    	int fileCount = 0;
    	
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		int fileRecordSize = absConstant.getEXPsingleFileRecordSize()*INIT.IETxtMultiple;
    	int level1MinCount = absConstant.getEXPlevel1MinCount()*INIT.IETxtMultiple;
    	int level2MinCount = absConstant.getEXPlevel2MinCount()*INIT.IETxtMultiple;
    	int level3MinCount = absConstant.getEXPlevel3MinCount()*INIT.IETxtMultiple;
    	
    	SQLAssembleE sqlA = new SQLAssembleE(
				absConstant.getSQLDOC(),
				absConstant.getEXP_SQL(), 
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
    	
		HashMap<String,String> allColumnSQLMap = absConstant.getEXPAllColumnSQLMap();
		//customSelectSQL = customSelectCol+ from XX
		String customSelectSQL ="";
		String customSelectCol = "select ";
		
//		customColumns [N_MID, C_MNAME,N_Mlevel,level...]
		for(int i = 0, j = customColumns.size(); i<j; i++){
			if(i!=j-1){
				customSelectCol += allColumnSQLMap.get(customColumns.get(i))+",";
			}else{
				customSelectCol += allColumnSQLMap.get(customColumns.get(i))+" ";
			}
		}
		customSelectSQL = customSelectCol + sqlA.getFromSQL();
		sqlA.setSQL( customSelectSQL );
		
//		System.out.println("@sqlA.getCountSQL():"+sqlA.getCountSQL());
//		System.out.println("@sqlA.getSQL():"+sqlA.getSQL());
		
//		/** file absolute directory , end with '/' **/
//		private String tempFAbsDir;
//		/** 服务器临时文件名称（完整文件名） **/
//		private String tempFAbsName;
		
//		/** 服务器临时文件名称（不包括扩展名） **/
//		private String tempFName;
//		/** 服务器临时文件的扩展名（文件类型） **/
//		private String tempFExtName;
		
//		/** file absolute path **/
//		private String tempFAbsPath;
		
		/** server file name **/
		//String tempFAbsName = "代付签约信息" + String.valueOf(new java.util.Date().getTime()) + ".txt";
//		String tempFAbsName = absConstant.getEXPfileName() + String.valueOf(new java.util.Date().getTime()) + ".txt";
		SimpleDateFormat stm=new SimpleDateFormat("yyMMdd-HHmmss-S");
		String tempFAbsName = absConstant.getEXPfileName() + stm.format(new Date()) + ".txt";
		
		/** server file absolute directory ,if config end with '/' INIT.java would delete it **/
		String tempFAbsDir = INIT.tempFileDirectory+"/export/txt/";
//		System.out.println("tempFAbsDir:"+tempFAbsDir);
		String fAbsPath = tempFAbsDir + tempFAbsName;
		
		java.io.File fold = new java.io.File(tempFAbsDir);
		if(!fold.exists())
			fold.mkdirs();

    	p.setProgress(1);
    	p.setMsg("初始化完成!|查询记录总数...");
		Progresses.map.put(_, p);
		
		int total = Integer.valueOf(
				dataDAO.sqlQueryfindaValueByMap(
						sqlA.getCountSQL(), 
						sqlA.getMap() 
					).toString()
			);
		//Aim to don't play server to die
		if( total > fileRecordSize ){
			log.info("记录超限！超过最大限制："+fileRecordSize+" 条.");
			throw new Exception("记录超限!超过："+fileRecordSize+" 条.");
		}else if( total > level3MinCount ){//total>10W
			
//			ExportSemaphore.level3.acquire();
//			ExportSemaphore.level3.release();
			
			if(IESemaphore.level3.tryAcquire()){
				try{
					exportTXT( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
				}catch(IOException e){
					throw e;
				}finally{
					IESemaphore.level3.release();
				}
			}else{
				log.info("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:三级)..");
				throw new Exception("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:三级)..");
			}
		}else if( total > level2MinCount ){//5W<total<=10W
//			ExportSemaphore.level2.acquire();
			if(IESemaphore.level2.tryAcquire()){
				try{
					exportTXT( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
				}catch(IOException e){
					throw e;
				}finally{
					IESemaphore.level2.release();
				}
			}else{
				log.info("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:二级)..");
				throw new Exception("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:二级)..");
			}
			
		}else if( total > level1MinCount ){//1W<total<=5W
//			ExportSemaphore.level1.acquire();
			if(IESemaphore.level1.tryAcquire()){
				try{
					exportTXT( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
				}catch(IOException e){
					throw e;
				}finally{
					IESemaphore.level1.release();
				}
			}else{
				log.info("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:一级).");
				throw new Exception("导出业务过多,请稍后重试！请求导出总数量："+total+" 条(导出级别:一级).");
			}
		}else{
			exportTXT( fAbsPath, absConstant, total, sqlA, _, customColumns, options );
		}		
		return fAbsPath;
	}
	
	private void exportTXT(String fAbsPath, 
			AbstractConstant absConstant, 
			int total, 
			SQLAssembleE sqlA,
			String _, List customColumns, Map options ) throws IOException {
    	
    	int pageSize = absConstant.getEXPsingleSheetRecordSize();
//    	String[] columnNames_zh = absConstant.getEXPcolumnNames_zh();
//    	int[] columnTypes = absConstant.getEXPcolumnTypes();
//    	int[] columnScales = absConstant.getEXPcolumnScales();
    	 
    	int[] columnTypes;
    	int[] columnPrecisions;
    	int[] columnScales;
    	String[] columnNames_zh;
    	
//    	Map<String, List> ColumnMap = absConstant.getJSDOC().getExport().get("export").getColumnMap();
    	Map<String, List> ColumnMap = absConstant.getEXPcolumnMap();
//		Set set = ColumnMap.keySet();
		int size = customColumns.size();
		columnTypes = new int[size];
		columnPrecisions = new int[size];
		columnScales = new int[size];
		columnNames_zh = new String[size];

//		Iterator it = set.iterator();
		Object key;
		for( int i=0, j=size; i<j; i++ ) {
			key = customColumns.get(i);
			List list = (List)ColumnMap.get( key );
			columnTypes[i] = ((Integer)list.get(0)).intValue();
			columnPrecisions[i] = ((Integer)list.get(1)).intValue();
			columnScales[i] = ((Integer)list.get(2)).intValue();
			columnNames_zh[i] = (String)list.get(3);
		}
    	
    	// current sheet record count(txt is current batch record's count)
    	int currentSheetRecordCount = 0;
//   	 sql don't include rownum,sql不带序号.
//   	 if exported excel file need add rownum,add in program,rather than in sql 
		 
    	//起始记录的索引,start from 0
    	int offset = 0;
    	
    	FileWriter fw = new FileWriter(fAbsPath,true);// 创建FileWriter对象，用来写入字符流
		BufferedWriter bw = new BufferedWriter(fw, 1*1024*1024); // 将缓冲对文件的输出
		
		//计算总文件数量---这里不考虑分多个文件的情况
//      fileCount = (int) ( (total - 1) / fileRecordSize ) + 1;
    	
		TXTUtil txtUtil = new TXTUtil(
				columnTypes, 
				columnPrecisions,
				columnScales,
				columnNames_zh, 
				options );
		
		int sheetCount = (int) ( (total - 1) / pageSize ) + 1;//batch amount
		
		Progress  p = new Progress(2, "查询记录总数完成!|查询第<0>批数据......" );
		Progresses.map.put(_, p);
		
		//header
		for (int i = 0, j = columnNames_zh.length; i < j; i ++) 
		{
			if(i!=j-1)
			{
    			bw.write(options.get("TextQualifier").toString()+
    					columnNames_zh[i]+
    					options.get("TextQualifier").toString()+
    					options.get("FieldDelimiter").toString());
    		}
			else
    		{
    			bw.write(options.get("TextQualifier").toString()+
    					columnNames_zh[i]+
    					options.get("TextQualifier").toString());
    		}
		}
		bw.write(options.get("RecordDelimiter").toString());
    	
		
    	//第三层：表单循环-- pay special attention
	    for ( int sheetNumber = 0; sheetNumber < sheetCount; sheetNumber ++ )
        {
	    	if( sheetNumber < sheetCount - 1 ){
	    		currentSheetRecordCount = pageSize;
	    	}else{
	    		//if sheetNumber start from 1
//	    		currentSheetRecordCount = total - (sheetNumber - 1) * pageSize;
	    		currentSheetRecordCount = total - sheetNumber * pageSize;
	    	}
	    	//if sheetNumber start from 1
//	    	int offset = (page - 1) * pageSize;// 第一条记录的索引,这个取自分页查询,因为这里sheetNumber是从零开始,所以不用减一;
	    	offset = sheetNumber * pageSize;// 第一条记录的索引;

	    	log.info("开始从数据库查询第<"+sheetNumber+">批数据......");
	    	List list = dataDAO.sqlQueryfindRetArrayByPageByMap( sqlA.getSQL(), 
					sqlA.getMap(), offset, pageSize );
	    	log.info("从数据库查询第<"+sheetNumber+">批数据完成！");
	    	p.setProgress( (int)(2+(90-2)*(sheetNumber+0.5)/sheetCount) );
	    	p.setMsg("查询第<"+sheetNumber+">批数据完成!|写第<"+sheetNumber+">批数据......");
			Progresses.map.put(_, p);
			
	    	//调用一次向文本文件写一次数据writeABatchData
			txtUtil.generateASheet(
				sheetNumber,
				list,
				currentSheetRecordCount, bw );
			//withRecordNo
//			txtUtil.generateASheet(
//					sheetNumber,
//					list,
//					currentSheetRecordCount, bw, sheetNumber * pageSize );
			
	    	p.setProgress( (int)(2+(90-2)*(sheetNumber+1)/sheetCount) );
	    	if(sheetNumber<sheetCount){
	    		p.setMsg("写第<"+sheetNumber+">批数据完成!|查询第<"+(sheetNumber+1)+">批数据......");
				Progresses.map.put(_, p);
	    	}else{
	    		p.setMsg("写第<"+sheetNumber+">批数据(最后一批数据)完成!|保存txt文件......" );
				Progresses.map.put(_, p);
	    	}
        }//第三层：表单循环 end of for pageNum(文本文件为批次循环)
        
	    System.gc();
	    
		// 关闭txt对象
	    bw.flush(); // 刷新该流的缓冲
		bw.close();
		fw.close();
		log.info("写入完成!");
		p.setProgress( 100 );
    	p.setMsg("写入完成!");
		Progresses.map.put(_, p);
	}


	public void setDataDAO(TAuthorityModuleDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public static BaseExportService getFromApplicationContext(
			ApplicationContext ctx) {
		return (BaseExportService) ctx.getBean("tAuthorityModuleService_EXP");
	}
	@Override
	public String exportXLS1(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportXLS2(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportXLS3(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportXLS4(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportXLS5(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportXLS6(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportTXT1(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportTXT2(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportTXT3(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportTXT4(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportTXT5(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exportTXT6(String jdata, String _, List columnNames,
			Map options) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
