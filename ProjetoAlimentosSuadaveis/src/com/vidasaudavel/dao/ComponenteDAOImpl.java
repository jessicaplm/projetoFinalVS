package com.vidasaudavel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vidasaudavel.model.Componente;

@Repository
public class ComponenteDAOImpl implements ComponenteDAO {

	private static final Logger logger = LoggerFactory.getLogger(ComponenteDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addComponente(Componente c) {
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
	public List<Componente> listComponente() {
		// TODO Auto-generated method stub
		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<Componente> componenteList = session.createQuery("from Componente").list();
			for (Componente c : componenteList) {

				logger.info("lista= " + c);

			}
			return componenteList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;
	}

	@Override
	public void updateComponente(Componente c) {
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
	public void removeComponenteById(int id) {
		// TODO Auto-generated method stub
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Componente c = (Componente) session.load(Componente.class, new Integer(id));
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

	@Override
	public void getByNameComponente(String n) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Componente> listByNameComponente(String n) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			List<Componente> componenteList = session
					.createQuery("Select a from Componente as a where a.nm_componente like'" + n + "%'").list();
			for (Componente a : componenteList) {

				logger.info("lista= " + a);

			}
			return componenteList;

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			logger.info("Erro Ao Listar");

		}
		return null;

	}

}
