/*
 * The MIT License
 *
 * Copyright 2012 Universidad de Montemorelos A. C.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mx.edu.um.mateo.activos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author J. David Mendoza <jdmendoza@um.edu.mx>
 */
@Entity
@Table(name = "xtipos_activo")
public class XTipoActivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    @NotBlank
    @Column(nullable = false, length = 64)
    private String nombre;
    @Column(length = 128)
    private String descripcion;
    @Column(nullable = false, scale = 2, precision = 8)
    private BigDecimal porciento;
    @Column(nullable = false)
    private Long vidaUtil;
    @Column(nullable = false)
    private Long cuentaId;
    @Column(nullable = false)
    private Long empresaId;
    @Column(nullable = false)
    private Long tipoActivoId;
    
    public XTipoActivo() {}

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the porciento
     */
    public BigDecimal getPorciento() {
        return porciento;
    }

    /**
     * @param porciento the porciento to set
     */
    public void setPorciento(BigDecimal porciento) {
        this.porciento = porciento;
    }

    /**
     * @return the vidaUtil
     */
    public Long getVidaUtil() {
        return vidaUtil;
    }

    /**
     * @param vidaUtil the vidaUtil to set
     */
    public void setVidaUtil(Long vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    /**
     * @return the cuentaId
     */
    public Long getCuentaId() {
        return cuentaId;
    }

    /**
     * @param cuentaId the cuentaId to set
     */
    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    /**
     * @return the empresaId
     */
    public Long getEmpresaId() {
        return empresaId;
    }

    /**
     * @param empresaId the empresaId to set
     */
    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    /**
     * @return the tipoActivoId
     */
    public Long getTipoActivoId() {
        return tipoActivoId;
    }

    /**
     * @param tipoActivoId the tipoActivoId to set
     */
    public void setTipoActivoId(Long tipoActivoId) {
        this.tipoActivoId = tipoActivoId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final XTipoActivo other = (XTipoActivo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.getId());
        hash = 61 * hash + Objects.hashCode(this.getVersion());
        hash = 61 * hash + Objects.hashCode(this.getNombre());
        return hash;
    }

    @Override
    public String toString() {
        return "TipoActivo{" + "nombre=" + getNombre() + '}';
    }
    
}