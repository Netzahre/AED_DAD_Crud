package CRUD;

import modelo.Aula;
import org.hibernate.Session;

import java.util.List;

public class CrudAula {
    public void crearAula(Aula aula) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            sesion.persist(aula);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Aula verAula(int idAula) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
        return sesion.get(Aula.class, idAula);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarAula(int idAula, Aula aula) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Aula aulaDB = sesion.get(Aula.class, idAula);
            if (aulaDB != null) {
                aulaDB.setNumeracion(aula.getNumeracion());
                aulaDB.setDescripcion(aula.getDescripcion());
                aulaDB.setIp(aula.getIp());
                sesion.merge(aulaDB);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Aula no encontrada para ID: " + idAula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrarAula(int idAula) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Aula aula = sesion.get(Aula.class, idAula);
            if (aula != null) {
                sesion.remove(aula);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Aula no encontrada para ID: " + idAula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Aula> verAulas() {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Aula";
            return sesion.createQuery(hql, Aula.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
