package com.vidasaudavel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.SugestaoAlimento;

@Repository
public class SugestaoAlimentoDAOImpl  implements SugestaoAlimentoDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(SugestaoAlimentoDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addSugestaoAlimento(SugestaoAlimento c) {
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
	public List<SugestaoAlimento> listSugestaoAlimento() {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<SugestaoAlimento> sugestaoAlimentoList = session.createQuery("from SugestaoAlimento")
					.list();
			for (SugestaoAlimento c : sugestaoAlimentoList) {

				logger.info("lista= " +c);

			}
			return sugestaoAlimentoList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;
	}

	@Override
	public void updateSugestaoAlimento(SugestaoAlimento c) {
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
	public void removeSugestaoAlimentoById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			SugestaoAlimento c = (SugestaoAlimento) session.load(SugestaoAlimento.class,
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
