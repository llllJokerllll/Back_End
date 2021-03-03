/*
 * Documento creado no 2020 por DAWDU10
 * CIFP A Carballeira. ExameJDBC en 19 mar. 2020
 * Contenido con licencia Creative Commons CC BY-NC-SA.
 */
package com.plexus.sabaris;

import java.util.List;

//import java.util.Optional;

/**
 * The Interface DAO.
 *
 * @author chanquinhas
 * @param <T> the generic type
 */
public interface DAO<T> {
    
    /**
     * Gets the.
     *
     * @param id the id
     * @return the t
     */
    T get(int id);    
    
    /**
     * Gets the all.
     *
     * @return the all
     */
    List<T> getAll();     
    
    /**
     * Save.
     *
     * @param t the t
     * @return true, if successful
     */
    public boolean insertar(T t);
    
    /**
     * Update.
     *
     * @param t the t
     * @return true, if successful
     */
    public boolean modificar(T t);
    
    /**
     * Delete.
     *
     * @param t the t
     * @return true, if successful
     */
    public boolean eliminar(T t);
}
