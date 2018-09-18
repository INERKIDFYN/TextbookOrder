package cn.zzu.service;

import java.io.IOException;
import java.util.List;

import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;
import cn.zzu.pojo.Teacher;

public interface TeacherService {

	List<Book> StockBooks() throws IOException;
	List<Book> StockBooksById(String[] bookid) throws IOException;

	boolean SubBooksOrder(List<Book> books, String id, String year, String major) throws IOException;

	List<Record> checkSubRec(String id) throws IOException;
	Teacher checkLogin (String id,String pwd) throws IOException;
}
