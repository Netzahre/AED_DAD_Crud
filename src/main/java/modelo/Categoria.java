package modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria", nullable = false)
    private Integer id;

    //TextField
    @Column(name = "Nombre", nullable = false)
    private String nombre;

    //TextArea
    @Lob
    @Column(name = "Descripcion")
    private String descripcion;

    //Radio button
    @Column(name = "Estado", nullable = false, length = 20)
    private String estado;

    @ManyToMany
    @JoinTable(name = "productoporcategoria",
            joinColumns = @JoinColumn(name = "idCategoria"),
            inverseJoinColumns = @JoinColumn(name = "idProducto"))
    private Set<Producto> productos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

}