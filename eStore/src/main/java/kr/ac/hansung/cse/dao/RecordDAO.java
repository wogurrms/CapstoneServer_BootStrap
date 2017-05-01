package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Record;

@Repository
@Transactional
public class RecordDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Record getRecordById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Record record = (Record) session.get(Record.class, id);

		return record;
	}

	public List<Record> getRecords() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Record");
		List<Record> recordList = query.list();

		return recordList;
	}

	public void addRecord(Record record) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(record);
		session.flush();
	}

	public void deleteRecord(Record record) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(record);
		session.flush();
	}

	public void editRecord(Record record) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(record);
		session.flush();
	}

	public int getTodayAmount() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Record r where r.date > curdate()");
		Long todayAmount = (Long)query.uniqueResult();
		return todayAmount.intValue();
	}
}
