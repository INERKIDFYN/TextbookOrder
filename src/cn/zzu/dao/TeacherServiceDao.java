package cn.zzu.dao;

import java.util.List;

import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;

public interface TeacherServiceDao {

	List<Book> StockBookDao();

	boolean SubBooksOrderDao(String[] books, String id, String year, String major);

	List<Record> checkSubRecDao(String id);
}
