package CRUD;

import modelo.Aula;
import modelo.Categoria;
import modelo.Producto;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

public class CrudProducto {
    public void crearProducto(Producto producto) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            sesion.persist(producto);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Producto verProducto(int idProducto) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            return sesion.get(Producto.class, idProducto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarProducto(int idProducto, Producto producto) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Producto productoDB = sesion.get(Producto.class, idProducto);
            if (productoDB != null) {
                productoDB.setDescripcion(producto.getDescripcion());
                productoDB.setKeyRFID(producto.getKeyRFID()); // Corregido
                productoDB.setEan(producto.getEan());
                sesion.merge(productoDB);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Producto no encontrado para ID: " + idProducto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrarProducto(int idProducto) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Producto producto = sesion.get(Producto.class, idProducto);
            if (producto != null) {
                sesion.remove(producto);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Producto no encontrado para ID: " + idProducto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Producto> verProductos() {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Producto";
            return sesion.createQuery(hql, Producto.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cambiarCategorias(int idProducto, Set<Categoria> categorias) {
        try (Session sesion = hibernateUtil.getSessionFactory().openSession()) {
            sesion.beginTransaction();
            Producto producto = sesion.get(Producto.class, idProducto);
            if (producto != null) {
                producto.setCategorias(categorias);
                sesion.merge(producto);
                sesion.getTransaction().commit();
            } else {
                System.out.println("Producto no encontrado para ID: " + idProducto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
