package com.vidasaudavel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.SugestaoComponente;
@Repository
public class SugestaoComponenteDAOImpl implements SugestaoComponenteDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(SugestaoComponenteDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addSugestaoComponente(SugestaoComponente c) {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.persist(c);
			logger.info(" Adicionado com sussesso, detalhes= " + c);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("Erro Ao Adicionar " + c);
		}
	}

	@Override
	public List<SugestaoComponente> listSugestaoComponente() {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<SugestaoComponente> sugestaoComponenteList = session.createQuery("from SugestaoComponente")
					.list();
			for (SugestaoComponente c : sugestaoComponenteList) {

				logger.info("lista= " +c);

			}
			return sugestaoComponenteList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;
	}

	@Override
	public void updateSugestaoComponente(SugestaoComponente c) {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.merge(c);

			logger.info("Atualizado com sucesso, detalhes = " + c);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("Erro Ao Alterar" + c);
		}
	}

	@Override
	public void removeSugestaoComponenteById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			SugestaoComponente c = (SugestaoComponente) session.load(SugestaoComponente.class,
					new Integer(id));
			if (null != c) {

				session.delete(c);
			}
			logger.info("Deletado com sussesso, detalhes = " + c);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("Erro Ao remover " + id);
		}
	}

}
