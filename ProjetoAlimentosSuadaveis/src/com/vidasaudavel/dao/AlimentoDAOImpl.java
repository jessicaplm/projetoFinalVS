package com.vidasaudavel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vidasaudavel.model.Alimento;

@Repository
public class AlimentoDAOImpl implements AlimentoDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AlimentoDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAlimento(Alimento a) {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.persist(a);
			logger.info(" Adicionado com sussesso, detalhes= " + a);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("Erro Ao Adicionar " + a);
		}
	}

	@Override
	public List<Alimento> listAlimento() {
		// TODO Auto-generated method stub

		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<Alimento> alimentoList = session.createQuery("from Alimento")
					.list();
			for (Alimento a : alimentoList) {

				logger.info("lista= " + a);

			}
			return alimentoList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;

	}

	@Override
	public void updateAlimento(Alimento a) {
		// TODO Auto-generated method stub

		try {

			Session session = this.sessionFactory.getCurrentSession();
			session.merge(a);

			logger.info("Atualizado com sucesso, detalhes = " + a);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("Erro Ao Alterar" + a);
		}
	}

	@Override
	public void removeAlimentoById(int id) {
		// TODO Auto-generated method stub

		try {
			Session session = this.sessionFactory.getCurrentSession();
			Alimento a = (Alimento) session.load(Alimento.class,
					new Integer(id));
			if (null != a) {

				session.delete(a);
			}
			logger.info("Deletado com sussesso, detalhes = " + a);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			logger.info("Erro Ao remover " + id);
		}

	}

}
