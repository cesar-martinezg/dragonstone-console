/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISCesar
 */
@Entity
@Table(name = "dg_mobile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DgMobile.findAll", query = "SELECT d FROM DgMobile d")
    , @NamedQuery(name = "DgMobile.findByIdMobile", query = "SELECT d FROM DgMobile d WHERE d.idMobile = :idMobile")
    , @NamedQuery(name = "DgMobile.findByImei", query = "SELECT d FROM DgMobile d WHERE d.imei = :imei")
    , @NamedQuery(name = "DgMobile.findByTag", query = "SELECT d FROM DgMobile d WHERE d.tag = :tag")
    , @NamedQuery(name = "DgMobile.findByPhoneNumber", query = "SELECT d FROM DgMobile d WHERE d.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "DgMobile.findByGcmToken", query = "SELECT d FROM DgMobile d WHERE d.gcmToken = :gcmToken")
    , @NamedQuery(name = "DgMobile.findByCreateTimestamp", query = "SELECT d FROM DgMobile d WHERE d.createTimestamp = :createTimestamp")
    , @NamedQuery(name = "DgMobile.findByUpdateTimestamp", query = "SELECT d FROM DgMobile d WHERE d.updateTimestamp = :updateTimestamp")
    , @NamedQuery(name = "DgMobile.findByVersion", query = "SELECT d FROM DgMobile d WHERE d.version = :version")})
public class DgMobile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mobile", nullable = false)
    private Integer idMobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(nullable = false, length = 25)
    private String imei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String tag;
    @Size(max = 30)
    @Column(name = "phone_number", length = 30)
    private String phoneNumber;
    @Size(max = 512)
    @Column(name = "gcm_token", length = 512)
    private String gcmToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;
    @Column(name = "update_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int version;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idMobile")
    private DgMobileControl dgMobileControl;

    public DgMobile() {
    }

    public DgMobile(Integer idMobile) {
        this.idMobile = idMobile;
    }

    public DgMobile(Integer idMobile, String imei, String tag, Date createTimestamp, int version) {
        this.idMobile = idMobile;
        this.imei = imei;
        this.tag = tag;
        this.createTimestamp = createTimestamp;
        this.version = version;
    }

    public Integer getIdMobile() {
        return idMobile;
    }

    public void setIdMobile(Integer idMobile) {
        this.idMobile = idMobile;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGcmToken() {
        return gcmToken;
    }

    public void setGcmToken(String gcmToken) {
        this.gcmToken = gcmToken;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public DgMobileControl getDgMobileControl() {
        return dgMobileControl;
    }

    public void setDgMobileControl(DgMobileControl dgMobileControl) {
        this.dgMobileControl = dgMobileControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMobile != null ? idMobile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DgMobile)) {
            return false;
        }
        DgMobile other = (DgMobile) object;
        if ((this.idMobile == null && other.idMobile != null) || (this.idMobile != null && !this.idMobile.equals(other.idMobile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DgMobile{" + "idMobile=" + idMobile + ", imei=" + imei + ", tag=" + tag + ", phoneNumber=" + phoneNumber + ", gcmToken=" + gcmToken + ", createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp + ", version=" + version + ", dgMobileControl=" + dgMobileControl + '}';
    }
    
    
}
