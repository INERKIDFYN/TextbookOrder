package cn.zzu.service;

import java.util.List;

import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;

public interface TeacherService {

	List<Book> StockBooks();

	boolean SubBooksOrder(String[] books, String id, String year, String major);

	List<Record> checkSubRec(String id);
}
