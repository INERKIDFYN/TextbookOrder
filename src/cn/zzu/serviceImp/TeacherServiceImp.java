package cn.zzu.serviceImp;

import java.util.List;

import cn.zzu.dao.TeacherServiceDao;
import cn.zzu.daoImp.TeacherServiceDaoImp;
import cn.zzu.pojo.Book;
import cn.zzu.pojo.Record;
import cn.zzu.service.TeacherService;

public class TeacherServiceImp implements TeacherService{

	TeacherServiceDao td=new TeacherServiceDaoImp();
	@Override
	public List<Book> StockBooks() {
		// TODO Auto-generated method stub
		return td.StockBookDao();
	}
	@Override
	public boolean SubBooksOrder(String[] books, String id, String year,
			String major) {
		// TODO Auto-generated method stub
		return td.SubBooksOrderDao(books,id,year,major);
	}
	@Override
	public List<Record> checkSubRec(String id) {
		// TODO Auto-generated method stub
		return td.checkSubRecDao(id);
	}

}
