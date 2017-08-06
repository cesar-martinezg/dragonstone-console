/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nexti.dragonstone.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISCesar
 */
@Entity
@Table(name = "dg_mobile_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DgMobileControl.findAll", query = "SELECT d FROM DgMobileControl d")
    , @NamedQuery(name = "DgMobileControl.findByIdMobileControl", query = "SELECT d FROM DgMobileControl d WHERE d.idMobileControl = :idMobileControl")
    , @NamedQuery(name = "DgMobileControl.findByWifiEnabled", query = "SELECT d FROM DgMobileControl d WHERE d.wifiEnabled = :wifiEnabled")
    , @NamedQuery(name = "DgMobileControl.findByBluetoothEnabled", query = "SELECT d FROM DgMobileControl d WHERE d.bluetoothEnabled = :bluetoothEnabled")
    , @NamedQuery(name = "DgMobileControl.findByMobileDataEnabled", query = "SELECT d FROM DgMobileControl d WHERE d.mobileDataEnabled = :mobileDataEnabled")
    , @NamedQuery(name = "DgMobileControl.findByPhoneCallEnabled", query = "SELECT d FROM DgMobileControl d WHERE d.phoneCallEnabled = :phoneCallEnabled")
    , @NamedQuery(name = "DgMobileControl.findByAppsAccessEnabled", query = "SELECT d FROM DgMobileControl d WHERE d.appsAccessEnabled = :appsAccessEnabled")
    , @NamedQuery(name = "DgMobileControl.findByAppsList", query = "SELECT d FROM DgMobileControl d WHERE d.appsList = :appsList")
    , @NamedQuery(name = "DgMobileControl.findByCreateTimestamp", query = "SELECT d FROM DgMobileControl d WHERE d.createTimestamp = :createTimestamp")
    , @NamedQuery(name = "DgMobileControl.findByUpdateTimestamp", query = "SELECT d FROM DgMobileControl d WHERE d.updateTimestamp = :updateTimestamp")
    , @NamedQuery(name = "DgMobileControl.findByVersion", query = "SELECT d FROM DgMobileControl d WHERE d.version = :version")})
public class DgMobileControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mobile_control", nullable = false)
    private Integer idMobileControl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wifi_enabled", nullable = false)
    private boolean wifiEnabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bluetooth_enabled", nullable = false)
    private boolean bluetoothEnabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mobile_data_enabled", nullable = false)
    private boolean mobileDataEnabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phone_call_enabled", nullable = false)
    private boolean phoneCallEnabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apps_access_enabled", nullable = false)
    private int appsAccessEnabled;
    @Size(max = 512)
    @Column(name = "apps_list", length = 512)
    private String appsList;
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
    @JoinColumn(name = "id_mobile", referencedColumnName = "id_mobile", nullable = false)
    @OneToOne(optional = false)
    private DgMobile idMobile;

    public DgMobileControl() {
    }

    public DgMobileControl(Integer idMobileControl) {
        this.idMobileControl = idMobileControl;
    }

    public DgMobileControl(Integer idMobileControl, boolean wifiEnabled, boolean bluetoothEnabled, boolean mobileDataEnabled, boolean phoneCallEnabled, int appsAccessEnabled, Date createTimestamp, int version) {
        this.idMobileControl = idMobileControl;
        this.wifiEnabled = wifiEnabled;
        this.bluetoothEnabled = bluetoothEnabled;
        this.mobileDataEnabled = mobileDataEnabled;
        this.phoneCallEnabled = phoneCallEnabled;
        this.appsAccessEnabled = appsAccessEnabled;
        this.createTimestamp = createTimestamp;
        this.version = version;
    }

    public Integer getIdMobileControl() {
        return idMobileControl;
    }

    public void setIdMobileControl(Integer idMobileControl) {
        this.idMobileControl = idMobileControl;
    }

    public boolean getWifiEnabled() {
        return wifiEnabled;
    }

    public void setWifiEnabled(boolean wifiEnabled) {
        this.wifiEnabled = wifiEnabled;
    }

    public boolean getBluetoothEnabled() {
        return bluetoothEnabled;
    }

    public void setBluetoothEnabled(boolean bluetoothEnabled) {
        this.bluetoothEnabled = bluetoothEnabled;
    }

    public boolean getMobileDataEnabled() {
        return mobileDataEnabled;
    }

    public void setMobileDataEnabled(boolean mobileDataEnabled) {
        this.mobileDataEnabled = mobileDataEnabled;
    }

    public boolean getPhoneCallEnabled() {
        return phoneCallEnabled;
    }

    public void setPhoneCallEnabled(boolean phoneCallEnabled) {
        this.phoneCallEnabled = phoneCallEnabled;
    }

    public int getAppsAccessEnabled() {
        return appsAccessEnabled;
    }

    public void setAppsAccessEnabled(int appsAccessEnabled) {
        this.appsAccessEnabled = appsAccessEnabled;
    }

    public String getAppsList() {
        return appsList;
    }

    public void setAppsList(String appsList) {
        this.appsList = appsList;
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

    public DgMobile getIdMobile() {
        return idMobile;
    }

    public void setIdMobile(DgMobile idMobile) {
        this.idMobile = idMobile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMobileControl != null ? idMobileControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DgMobileControl)) {
            return false;
        }
        DgMobileControl other = (DgMobileControl) object;
        if ((this.idMobileControl == null && other.idMobileControl != null) || (this.idMobileControl != null && !this.idMobileControl.equals(other.idMobileControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DgMobileControl{" + "idMobileControl=" + idMobileControl + ", wifiEnabled=" + wifiEnabled + ", bluetoothEnabled=" + bluetoothEnabled + ", mobileDataEnabled=" + mobileDataEnabled + ", phoneCallEnabled=" + phoneCallEnabled + ", appsAccessEnabled=" + appsAccessEnabled + ", appsList=" + appsList + ", createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp + ", version=" + version + ", idMobile=" + idMobile + '}';
    }
    
}
