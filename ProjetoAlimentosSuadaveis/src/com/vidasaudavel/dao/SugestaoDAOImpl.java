package com.vidasaudavel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import com.vidasaudavel.model.Sugestao;

@Repository
public class SugestaoDAOImpl  implements SugestaoDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(SugestaoDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addSugestao(Sugestao c) {
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
	public List<Sugestao> listSugestao() {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<Sugestao> sugestaoList = session.createQuery("from Sugestao")
					.list();
			for (Sugestao c : sugestaoList) {

				logger.info("lista= " +c);

			}
			return sugestaoList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;
	}

	@Override
	public void updateSugestao(Sugestao c) {
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
	public void removeSugestaoById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Sugestao c = (Sugestao) session.load(Sugestao.class,
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
