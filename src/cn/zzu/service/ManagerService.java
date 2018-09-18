package cn.zzu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.zzu.pojo.Manager;
import cn.zzu.pojo.Record;


public interface ManagerService {

	Manager checkLogin (String id,String pwd) throws IOException;

	List<Record> checkRecords() throws IOException;

	boolean sub_comment(Map m) throws IOException;
}
