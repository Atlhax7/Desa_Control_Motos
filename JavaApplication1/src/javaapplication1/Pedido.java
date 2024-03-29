/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Erick
 */
public class Pedido {
    private String cod_pedido;
    private String concesionario  ;
    private LocalDate fecha  ;
    private String estado  ;
    private Consecionario concesionario1 ;
    private ArrayList<Moto> lista_Motos=new ArrayList<Moto>(); 

    public Pedido(String cod_pedido, String concesionario, LocalDate fecha, String estado, Consecionario concesionario1) {
        this.cod_pedido = cod_pedido;
        this.concesionario = concesionario;
        this.fecha = fecha;
        this.estado = estado;
        this.concesionario1 = concesionario1;
    }

    public Pedido() {
    }

    public String getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(String cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public String getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(String concesionario) {
        this.concesionario = concesionario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Consecionario getConcesionario1() {
        return concesionario1;
    }

    public void setConcesionario1(Consecionario concesionario1) {
        this.concesionario1 = concesionario1;
    }

    public ArrayList<Moto> getLista_Motos() {
        return lista_Motos;
    }

    public void setLista_Motos(ArrayList<Moto> lista_Motos) {
        this.lista_Motos = lista_Motos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cod_pedido=" + cod_pedido + ", concesionario=" + concesionario + ", fecha=" + fecha + ", estado=" + estado + ", concesionario1=" + concesionario1 + ", lista_Motos=" + lista_Motos + '}';
    }
    
}
