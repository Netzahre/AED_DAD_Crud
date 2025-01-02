package CRUD;

import modelo.Aula;
import modelo.Categoria;
import org.hibernate.Session;

import java.util.List;

public class CrudCategoria {
    public void crearCategoria(Categoria categoria) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            sesion.persist(categoria);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Categoria verCategoria(int idCategoria) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
        return sesion.get(Categoria.class, idCategoria);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarCategoria(int idCategoria, Categoria categoria) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Categoria categoriaDB = sesion.get(Categoria.class, idCategoria);
            if (categoriaDB != null) {
                categoriaDB.setNombre(categoria.getNombre());
                categoriaDB.setEstado(categoria.getEstado());
                categoriaDB.setDescripcion(categoria.getDescripcion());
                sesion.merge(categoriaDB);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Categoria no encontrada para ID: " + idCategoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrarCategoria(int idCategoria) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Categoria categoriaDB = sesion.get(Categoria.class, idCategoria);
            if (categoriaDB != null) {
                sesion.remove(categoriaDB);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Categoria no encontrada para ID: " + idCategoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> verCategorias() {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Categoria";
            return sesion.createQuery(hql, Categoria.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
