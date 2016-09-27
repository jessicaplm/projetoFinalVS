package com.vidasaudavel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vidasaudavel.model.Componente;
import com.vidasaudavel.model.Questionario;

@Repository
public class QuestionarioDAOImpl implements QuestionarioDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(QuestionarioDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addQuestionario(Questionario c) {
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
	public List<Questionario> listQuestionario() {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<Questionario> questionarioList = session.createQuery(
					"from Questionario").list();
			for (Questionario c : questionarioList) {

				logger.info("lista= " + c);

			}
			return questionarioList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;
	}

	@Override
	public void updateQuestionario(Questionario c) {
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
	public void removeQuestionarioById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Questionario c = (Questionario) session.load(Questionario.class,
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
