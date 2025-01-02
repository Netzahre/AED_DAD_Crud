package CRUD;

import modelo.Categoria;
import modelo.Marcaje;
import modelo.Producto;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

public class CrudMarcajes {
    public void crearMarcajes(Marcaje marcaje) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            sesion.persist(marcaje);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Marcaje verMarcaje(int idMarcaje) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            return sesion.get(Marcaje.class, idMarcaje);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void borrarMarcaje(int idMarcaje) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Marcaje marcajeDB = sesion.get(Marcaje.class, idMarcaje);
            if (marcajeDB != null) {
                sesion.remove(marcajeDB);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Marcaje no encontrado para ID: " + idMarcaje);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Marcaje> verMarcajes() {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Marcaje";
            return sesion.createQuery(hql, Marcaje.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
